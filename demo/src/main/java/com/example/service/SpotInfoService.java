package com.example.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.bean.Gra;
import com.example.bean.Spot;
import com.example.mapper.CommentMapper;
import com.example.mapper.RouteMapper;
import com.example.mapper.SpotInfoMapper;
import com.example.mapper.UserMapper;

@Service
public class SpotInfoService {
	@Autowired
	private RouteMapper routeMapper;
	@Autowired
	private SpotInfoMapper spotInfoMapper;
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private UserMapper userMapper;
	
	public List<Spot> getSpotInfoByGraId(int graId){
		return spotInfoMapper.getSpotBygraId(graId);
	}
	
	public List<Gra> getGraByClass(String graClass){
		return routeMapper.getGraByClass(graClass);
	}
	
	public List<String> getGraClass(){
		return routeMapper.getGraClass();
	}
	
	public ArrayList<String> getAprioriGraId(int userId){
		ArrayList<String> dataList = new ArrayList<>();
		List<Integer> userIdList = userMapper.getAllIdWithoutOne(userId);
		String tempStr="";
		for (Integer uid : userIdList) {
			tempStr="";
			ArrayList<Integer> graIdList = (ArrayList<Integer>) commentMapper.getGraIdByUserId(uid);
			for (Integer integer : graIdList) {
				tempStr+=integer+";";
			}
			if(!tempStr.equals(""))
				dataList.add(tempStr);
			System.out.println("tempStr:"+tempStr);
		}
		return dataList;
	}
	
	public String getSpotInfo(int graId){
		
		String str="",html="";
		int flag=0;
		html+="<div id=\"spotInfoShow\" class=\"panel-body bk-bg-white bk-padding-top-10 bk-padding-bottom-10\">";
		try {
			File spotFile = ResourceUtils.getFile("classpath:"+"spot"+graId+".txt");
			BufferedReader spotReader = new BufferedReader(new FileReader(spotFile));
			
			while((str = spotReader.readLine())!=null){
				if(str.equals("")) {
					continue;
				}
				System.out.println(str+":"+str.charAt(0));
				if(str.charAt(0) == 'T'){
					
					if(flag!=0) {
						html+="<hr class=\"bk-margin-off\"/>";
						flag=1;
					}
					html+="<h2>"+str.substring(1)+"</h2>";
					flag=2;
				}else if(str.charAt(0) == 'H'){
					html+="<h4>"+str.substring(1)+"</h4>";
				}else{
					
					html+="<p class=\"text-primary lead\" style=\"text-indent:2em\">";
					html+=str;
					html+="</p>";
				}
			}
			html+="</div>";
			System.out.println("----------------------------================--------------");
			System.out.println(html);
		}catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			return html;
		}
		
	}
}
