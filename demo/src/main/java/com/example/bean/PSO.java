package com.example.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 粒子群求解TSP旅行商问题
 * 更新公式：Vii=wVi+ra(Pid-Xid)+rb(Pgd-Xid)
 */
public class PSO {
    private int scale; //种群规模
    private ArrayList<Unit> mUnits = new ArrayList<>();   //粒子群

    private int MAX_GEN;// 迭代次数
    private float w;    //惯性权重
    private int spotNum = 0;    //景点数量

    private HashMap<Integer, Unit> Pd = new HashMap<>();    //一颗粒子历代中出现最好的解
    private Unit Pgd;   // 整个粒子群经历过的的最好的解，每个粒子都能记住自己搜索到的最好解
    private int bestT;// 最佳出现代数

    private static int[] spots;
    private static double[][] D;
    private int[][] path;
    private ArrayList<Integer> pathout;
    
    
    private ArrayList<ArrayList<SO>> listV = new ArrayList<>();    //自身交换序列，即所谓的惯性因子

    Random random = new Random();

    /**
     * 构造方法
     *
     * @param scale
     * @param MAX_GEN
     * @param w
     */
    public PSO(int scale, int MAX_GEN, float w) {
        this.scale = scale;
        this.MAX_GEN = MAX_GEN;
        this.w = w;
    }

    /**
     * 初始化参数配置
     */
    public void init(int[] s) {
    	spots = s;
        spotNum = s.length;
        random = new Random(System.currentTimeMillis());
    }

    
    
    public static double[][] getD() {
		return D;
	}

	public static void setD(double[][] d) {
		D = d;
	}

	/**
     * 初始化种群
     */
    private void initGroup() {
        for (int k = 0; k < scale; k++) {
            int[] path = new int[spotNum];
            path[0] = spots[0];
            path[spotNum-1] = spots[spotNum-1];
            for (int i = 1; i < spotNum - 1; ) {
                //随机生成一个路径
                int s = random.nextInt(65535) % (spotNum-2) + 1;
                int j;
                for (j = 0; j < i; j++) {
                    if (spots[s] == path[j]) {
                        break;
                    }
                }
                if (i == j) {
                    path[i] = spots[s];
                    i++;
                }
            }
            Unit unit = new Unit(path, D);
            mUnits.add(unit);
        }
    }

    /**
     * 初始化自身的交换序列即惯性因子
     */
    private void initListV() {
        for (int i = 0; i < scale; i++) {
            ArrayList<SO> list = new ArrayList<>();
            int n = random.nextInt(spotNum - 1) % (spotNum);    //随机生成一个数，表示当前粒子需要交换的对数
            for (int j = 0; j < n; j++) {
                //生成两个不相等的景点下标：x,y
                int x = (random.nextInt(spotNum - 2) % (spotNum)+1);
                int y = (random.nextInt(spotNum - 2) % (spotNum)+1);
                while (x == y) {
                    y = (random.nextInt(spotNum - 2) % (spotNum)+1);
                }

                //x不等于y
                SO so = new SO(x, y);
                list.add(so);
            }
            listV.add(list);
        }
    }

    public void solve() throws CloneNotSupportedException{
        initGroup();
        initListV();
        //挑选最好的个体
        for (int i = 0; i < scale; i++) {
            Pd.put(i, mUnits.get(i));
        }
        Pgd = (Unit) Pd.get(0).clone();
        for (int i = 0; i < scale; i++) {
            if (Pgd.getFitness() > Pd.get(i).getFitness()) {
                Pgd = (Unit) Pd.get(i).clone();
            }
        }
        System.out.println("初始化最好结果为：" + Pgd.getFitness());
        Pgd.printPath();
        
        // 进化
        evolution();
        // 打印
        System.out.println("==================最后粒子群=====================");

        System.out.println("最佳长度出现代数：");
        System.out.println(bestT);
        System.out.println("最佳长度");
        System.out.println(Pgd.getFitness());
        System.out.println("最佳路径：");
        Pgd.printPath();

    }

    /**
     * 进化
     * @throws CloneNotSupportedException 
     */
    private void evolution() throws CloneNotSupportedException {
        for (int t = 0; t < MAX_GEN; t++) {
            for (int k = 0; k < scale; k++) {
                ArrayList<SO> vii = new ArrayList<>();
                //更新公式：Vii=wVi+ra(Pid-Xid)+rb(Pgd-Xid)
                //第一部分，自身交换对
                int len = (int) (w * listV.get(k).size());
                for (int i = 0; i < len; i++) {
                    vii.add(listV.get(k).get(i));
                }

                //第二部分，和当前粒子中出现最好的结果比较，得出交换序列
                //ra(Pid-Xid)
                ArrayList<SO> a = minus(mUnits.get(k).getPath(), Pd.get(k).getPath());
                float ra = random.nextFloat();
                len = (int) (ra * a.size());
                for (int i = 0; i < len; i++) {
                    vii.add(a.get(i));
                }

                //第三部分，和全局最优的结果比较，得出交换序列
                //rb(Pgd-Xid)
                ArrayList<SO> b = minus(mUnits.get(k).getPath(), Pgd.getPath());
                float rb = random.nextFloat();
                len = (int) (rb * b.size());
                for (int i = 0; i < len; i++) {
                    vii.add(b.get(i));
                }

                listV.remove(0);    //移除当前，加入新的
                listV.add(vii);

                //执行交换，生成下一个粒子
                exchange(mUnits.get(k).getPath(), vii);
            }

            //更新适应度的值，并挑选最好的个体
            for (int i = 0; i < scale; i++) {
                mUnits.get(i).upDateFitness();
                if (Pd.get(i).getFitness() > mUnits.get(i).getFitness()) {
                    Pd.put(i, mUnits.get(i));
                }
                if (Pgd.getFitness() > Pd.get(i).getFitness()) {
                    Pgd = (Unit) Pd.get(i).clone();
                    bestT = t;
                }
            }
            //打印当前代的结果
            if (t % 100 == 0) {
                // 打印
                System.out.println("--------第"+t+"代的最佳结果为-----------");
                System.out.println(Pgd.getFitness());
                System.out.println("最佳路径：");
                Pgd.printPath();
            }
        }
    }

    //Floyd求解任意图中任意两点的最短距离
    public void floyd(double[][] C){
    	int n = C.length;
    	path=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				path[i][j]=-1;
			}
		}
		for(int k=0;k<n;k++)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(C[i][k]!=Integer.MAX_VALUE&&C[k][j]!=Integer.MAX_VALUE&&C[i][k]+C[k][j]<C[i][j])
					{
						C[i][j]=C[i][k]+C[k][j];
						path[i][j]=k;
					}
					
				}
			}
		}
		D = C;
    }
    
    //最短路径输出
    public void pathprint(int i , int j) {
		if(path[i][j] != -1) {
			pathprint(i,path[i][j]);
			pathout.add(path[i][j]);
			pathprint(path[i][j],j);
		}
	}
    
    //完整路径获取
    public ArrayList<Integer> getFinalPath(ArrayList<Integer> a) {
    	ArrayList<Integer> finalpath = new ArrayList<Integer>();
    	finalpath.add(a.get(0));
    	for(int i=0;i<a.size()-1;i++) {
    		pathout = new ArrayList<Integer>();
    		pathout.clear();
    		pathprint(a.get(i), a.get(i+1));
    		finalpath.addAll(pathout);
    		finalpath.add(a.get(i+1));
    	}
		return finalpath;
    	
    }
    
    /**
     * 执行交换，更新粒子
     *
     * @param path
     * @param vii  存储的是需要交换的下标对
     */
    private void exchange(int[] path, ArrayList<SO> vii) {
        int tmp;
        for (SO so : vii) {
            tmp = path[so.getX()];
            path[so.getX()] = path[so.getY()];
            path[so.getY()] = tmp;
        }
    }


    /**
     * 生成交换对，把a变成和b一样，返回需要交换的下标对列表
     *
     * @param a
     * @param b
     * @return
     */
    private ArrayList<SO> minus(int[] a, int[] b) {
        int[] tmp = a.clone();
        ArrayList<SO> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < b.length; i++) {
            if (tmp[i] != b[i]) {
                //在tmp中找到和b[i]相等的值，将下标存储起来
                for (int j = i + 1; j < tmp.length; j++) {
                    if (tmp[j] == b[i]) {
                        index = j;
                        break;
                    }
                }
                SO so = new SO(i, index);
                list.add(so);
            }
        }
        return list;
    }

    public Unit getPgd() {
    	return this.Pgd;
    }
    
    
//    public static void main(String[] args) {
//    	int gra[][] = new int[36][36];
//    	for(int i=0;i<36;i++) {
//    		for(int j =0;j<36;j++) {
//    			if(i == j)
//    				gra[i][j] = 0;
//    			else
//    				gra[i][j] = Integer.MAX_VALUE;
//    		}
//    	}
//    	for(int i =0;i<36;i++) {
//    		if(i>5)
//    			gra[i][i-6] = 1;
//    		if(i<29)
//    			gra[i][i+6] = 1;
//    		if(i%6 > 0)
//    			gra[i][i-1] = 1;
//    		if(i%6 < 5)
//    			gra[i][i+1] = 1;
//    	}
//    	for(int i=0;i<36;i++) {
//    		for(int j =0;j<36;j++) {
//    			System.out.printf("%12d",gra[i][j]);
//    		}
//    		System.out.println();
//    	}
//    	
//    	//gra赋值
//        PSO pso = new PSO(1000, 500, 0.7f);
//        
//        pso.floyd(gra);
//        System.out.println("-------------------------------------------------------------------------------------------------");
//        for(int i=0;i<36;i++) {
//    		for(int j =0;j<36;j++) {
//    			System.out.printf("%12d",D[i][j]);
//    		}
//    		System.out.println();
//    	}
//        int[] a = {2,5,11,28,30};
//        pso.init(a);
//        
//        pso.solve();
//        ArrayList<Integer> u = pso.getPgd().getnnn();
//        ArrayList<Integer> finalpath = pso.getFinalPath(u);
//        for (Integer integer : finalpath) {
//			System.out.print((integer+1)+"->");
//		}
//    }
}

