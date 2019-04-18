package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.Apriori;
import com.example.bean.Gra;
import com.example.bean.User;
import com.example.service.CommentService;
import com.example.service.RouteService;
import com.example.service.SpotInfoService;

import io.goeasy.GoEasy;

@Controller
@RequestMapping("/spot")
public class SpotInfoController {
	@Autowired
	private SpotInfoService spotInfoService;
	@Autowired
	private RouteService routeService;
	@Autowired
	private CommentService commentService;
	
//	@RequestMapping("/channelTest")
//	@ResponseBody
//	public Map<String, Object> pushChannel(){
//		Map<String, Object> m = new HashMap<>();
//	    GoEasy goEasy = new GoEasy( "http(s)://<REST Host>", "BC-9c088edbd6ca4ca6b34e2d20033f727d");
//	    goEasy.publish("my_channel", "Hello, GoEasy!");
//	    return m;
//	}
//	
	@RequestMapping("/channelTest")
	public String pushChannel(){
		
	    return "test";
	}
	
	@RequestMapping("/spotInfo")
	public String getGraClass(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		int userId = ((User)session.getAttribute("user")).getUserId();
		List<Integer> tempList = commentService.getGraIdByUserId(userId);
		ArrayList<Gra> graAprioriList = new ArrayList<>();
		if(tempList != null) {
			String inputString = "";
			for (Integer integer : tempList) {
				inputString+=integer+";";
			}
			System.out.println("inputString:"+inputString);
			ArrayList<String> dataList = spotInfoService.getAprioriGraId(userId);
			Apriori apriori = new Apriori();
			
			System.out.println("=数据集合==========");
			for(String string:dataList)
			{
				System.out.println(string);
			}

			System.out.println("=频繁项集==========");
			
			Map<String, Integer> frequentSetMap = apriori.apriori(dataList);
			Set<String> keySet1 = frequentSetMap.keySet();
			TreeSet<String> keySet = new TreeSet<String>();
			keySet.addAll(keySet1);
			for(String key:keySet)
			{
				//if(key.length()>=6)
					System.out.println(key+" : "+frequentSetMap.get(key));
			}
			
			System.out.println("=关联规则==========");
			Map<String, Double> relationRulesMap = apriori.getRelationRules(frequentSetMap);
			Set<String> rrKeySet = relationRulesMap.keySet();
			for (String rrKey : rrKeySet)
			{
				if(rrKey.substring(0, (rrKey.indexOf("->"))).split(";").length>=2)
					System.out.println(rrKey + "  :  " + relationRulesMap.get(rrKey));
			}

			ArrayList<Integer> graIdList = apriori.getAnswer(inputString, rrKeySet);
			for (Integer gid : graIdList) {
				Gra g = routeService.getGraNameByGraId(gid);
				graAprioriList.add(g);
			}
			if(graAprioriList.isEmpty()) {
				ArrayList<Integer> mpglist = (ArrayList<Integer>) routeService.getMostPopularGra();
				for (Integer mpg : mpglist) {
					graAprioriList.add(routeService.getGraByGraId(mpg));
				}
			}
		}else {
			ArrayList<Integer> mpglist = (ArrayList<Integer>) routeService.getMostPopularGra();
			for (Integer mpg : mpglist) {
				graAprioriList.add(routeService.getGraByGraId(mpg));
			}
		}
		model.addAttribute("graClass", spotInfoService.getGraClass());
		model.addAttribute("graList",routeService.getGra());	
		model.addAttribute("graAprioriList", graAprioriList);
		return "spotInfo";
	}
	
	@RequestMapping("/spotInfoByClass")
	@ResponseBody
	public Map<String,List<Gra>> getGraByClass(String graClass){
		Map<String,List<Gra>> resMap = new HashMap<String,List<Gra>>(); 
		resMap.put("graList", spotInfoService.getGraByClass(graClass));
		return resMap;
	}
	
	@RequestMapping("/spotInfoHtml")
	@ResponseBody
	public Map<String,String> spotInfoHtml(int graId){
		Map<String,String> resMap = new HashMap<String,String>(); 
		resMap.put("spotHtml", spotInfoService.getSpotInfo(graId));
		return resMap;
	}
	
}
