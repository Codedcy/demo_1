package com.example.bean;

import java.util.ArrayList;

public class Unit implements Cloneable {
	private int[] mPath;  //经过的景点路径
    private int mFitness; //适应度值，为当前粒子走这个路径的总距离。越小越好。
    private double[][] D; //任意两个点之间的最短距离
    private ArrayList<Integer> nnn ; 
    
    @SuppressWarnings("unchecked")
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
    	Unit u = null;
    	u = (Unit) super.clone();
    	u.mPath = mPath.clone();
		return u;
	}
    
	public Unit(int[] path , double[][] Dd) {
        mPath = path;
        this.D = Dd;
        mFitness = calculateFitness();
       
    }
        public void printPath() {
        if (mPath == null) {
            System.out.println("mPath为null,当前个体的路径为空");
        } else {
        	nnn = new ArrayList<Integer>();
            for (int i = 0; i < mPath.length - 1; i++) {
                System.out.print(mPath[i]+"——》");
            }
            System.out.println(mPath[mPath.length-1]);
        }
    }

    public ArrayList<Integer> getnnn(){
    	for(int i=0;i<mPath.length;i++) {
    		nnn.add(mPath[i]);
    	}
    	return nnn;
    }
        
    public void upDateFitness() {
        this.mFitness = calculateFitness();
    }

    /**
     * 计算当前路径的适应值，即为路径长度
     */
    public int calculateFitness() {
        
        int distance = 0;  
        int n = mPath.length;
        for (int i = 1; i < n; i++) {
            distance += D[mPath[i-1]][mPath[i]];
        }
        return distance;
    }
	public int getFitness() {
		return mFitness;
	}
	public int[] getPath() {
		return mPath;
	}

}
