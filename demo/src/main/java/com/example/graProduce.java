package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.springframework.util.ResourceUtils;

public class graProduce {
	
	
	
	public int[][] graPro(int graId) throws NumberFormatException, IOException{
		String tempString;
		String[][] tempArray;
		int[][] graArray;
		int NumX,NumY,pointNum,k=0;
		File graFile = ResourceUtils.getFile("classpath:"+"graPro"+graId+".txt");
		BufferedReader graReader = new BufferedReader(new FileReader(graFile));
		NumX = Integer.parseInt(graReader.readLine());
		NumY = Integer.parseInt(graReader.readLine());
		pointNum = Integer.parseInt(graReader.readLine());
		tempArray = new String[NumX][NumY];
		graArray = new int[pointNum][pointNum];
		while((tempString = graReader.readLine()) != null) {
			System.out.println(tempString);
			tempArray[k] = tempString.split(" ");
			k++;
		}
		for(int i=0;i<pointNum;i++)
			for(int j=0;j<pointNum;j++)
				graArray[i][j] = Integer.MAX_VALUE;
		System.out.println(NumX);
		System.out.println(NumY);
		System.out.println(pointNum);
		for(int i=0;i<NumX;i++) {
			for(int j=0;j<NumY;j++) {
				System.out.print(tempArray[i][j]+"    ");
			}
			System.out.println();
		}
		for(int i=0;i<NumX;i++) {
			for(int j=0;j<NumY;j++) {
				if(Integer.parseInt(tempArray[i][j])!=-1) {
					if(i+1<NumX && Integer.parseInt(tempArray[i+1][j])!=-1) {
						graArray[Integer.parseInt(tempArray[i][j])][Integer.parseInt(tempArray[i+1][j])] = 1;
					}
					if(i-1>=0 && Integer.parseInt(tempArray[i-1][j])!=-1) {
						graArray[Integer.parseInt(tempArray[i][j])][Integer.parseInt(tempArray[i-1][j])] = 1;
					}
					if(j+1<NumY && Integer.parseInt(tempArray[i][j+1])!=-1) {
						graArray[Integer.parseInt(tempArray[i][j])][Integer.parseInt(tempArray[i][j+1])] = 1;
					}
					if(j-1>=0 && Integer.parseInt(tempArray[i][j-1])!=-1) {
						graArray[Integer.parseInt(tempArray[i][j])][Integer.parseInt(tempArray[i][j-1])] = 1;
					}
				}else {
					continue;
				}
			}
		}
		return graArray;
	}
	
	public void graWrite(int graId , int[][] graMatrix) throws FileNotFoundException, IOException {
		File f = ResourceUtils.getFile("classpath:"+"gra"+graId+".txt");
		System.out.println(f.getPath());
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
			
		bw.write(graMatrix.length+"\r\n");
		for(int i=0;i<graMatrix.length;i++) {
			for(int j=0;j<graMatrix[0].length;j++) {
				if(j == graMatrix[0].length-1) {
					bw.write(graMatrix[i][j]+"\r\n");
				}else {
					bw.write(graMatrix[i][j]+",");
				}
			}
		}
		bw.flush();
		fw.close();
		bw.close();
	}
	
	public Integer[][] getGraArray(int graId) throws IOException{
		Integer[][] g;
		File graFile = ResourceUtils.getFile("classpath:"+"graPro"+graId+".txt");
		BufferedReader graReader = new BufferedReader(new FileReader(graFile));
		int NumX = Integer.parseInt(graReader.readLine());
		int NumY = Integer.parseInt(graReader.readLine());
		int pointNum = Integer.parseInt(graReader.readLine());
		String[][] tempArray = new String[NumX][NumY];
		g = new Integer[NumX][NumY];
		String tempString;
		int k=0;
		while((tempString = graReader.readLine()) != null) {
			System.out.println(tempString);
			tempArray[k] = tempString.split(" ");
			k++;
		}
		for(int i=0;i<NumX;i++) {
			for(int j=0;j<NumY;j++) {
				g[i][j] = Integer.parseInt(tempArray[i][j]);
			}
		}
		return g;
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		graProduce g = new graProduce();
		int[][] a = g.graPro(2);
		
		g.graWrite(2,a);
		
//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<a[0].length;j++) {
//				if(j == a[0].length-1) {
//					System.out.print(a[i][j]);
//				}
//				System.out.print(a[i][j]+",");
//			}
//			System.out.println();
//		}
	}
}
