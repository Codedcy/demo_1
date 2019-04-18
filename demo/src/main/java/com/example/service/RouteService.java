package com.example.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.bean.Gra;
import com.example.bean.PSO;
import com.example.bean.Spot;
import com.example.mapper.CommentMapper;
import com.example.mapper.RouteMapper;
import com.example.mapper.SpotInfoMapper;

@Service
public class RouteService {
	
	@Autowired
	private RouteMapper routeMapper;
	@Autowired
	private SpotInfoMapper spotInfoMapper;
	@Autowired
	private CommentMapper commentMapper;
	
	public List<Gra> getGra(){
		return routeMapper.getGra();
	}
	
	public Gra getGraByGraId(int graId){
		return routeMapper.getGraByGraId(graId);
	}
	
	public Gra getGraNameByGraId(int graId) {
		return routeMapper.getGraNameByGraId(graId);
	}
	
	public List<Integer> getMostPopularGra(){
		return commentMapper.getMostPopularGra();			
	}
	
	@SuppressWarnings("null")
	public ArrayList<Spot> getRoute(int graId, int[] spots) throws IOException, CloneNotSupportedException{
		String tempString;
		String[][] spotsArray;
		int i=0,spotNum=0;
		File graFile = ResourceUtils.getFile("classpath:"+"graMatrix"+graId+".txt");
		@SuppressWarnings("resource")
		BufferedReader graReader = new BufferedReader(new FileReader(graFile));
		spotNum = Integer.parseInt(graReader.readLine());
		spotsArray = new String[spotNum][spotNum];
		while((tempString = graReader.readLine()) != null) {
			spotsArray[i] = tempString.split(",");
			i++;
		}
		double[][] gra = new double[spotNum][spotNum];
		for(int j=0;j<spotsArray.length;j++) {
			for(int k=0;k<spotsArray.length;k++) {
				gra[j][k] = Double.parseDouble(spotsArray[j][k]);
			}
		}
		PSO pso = new PSO(1000, 500, 0.7f);
        //pso.floyd(gra);
		pso.setD(gra);
        pso.init(spots);
        pso.solve();
   
        ArrayList<Integer> u = pso.getPgd().getnnn();
        //ArrayList<Integer> finalpath = pso.getFinalPath(u);
        ArrayList<Spot> spotList = new ArrayList<>();
        for (Integer spotId : u) {
        	Spot spot = spotInfoMapper.getSpotBygraIdAndSpotId(graId, spotId).get(0);
        	spotList.add(spot);
		}
        for (Integer integer : u) {
			System.out.print(integer+"->");
		}
		return spotList;
	}
	
	
	
}
