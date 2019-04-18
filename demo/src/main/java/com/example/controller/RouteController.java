package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.graProduce;
import com.example.bean.Spot;
import com.example.service.RouteService;
import com.example.service.SpotInfoService;

@Controller
@RequestMapping("/route")
public class RouteController {
	
	@Autowired
	private RouteService routeService;
	@Autowired
	private SpotInfoService spotInfoService;
	
	@RequestMapping("")
	public String routePage() {
		return "routePage";
	}
	
	//测试用
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/")
	@ResponseBody
	public Map<String, Object> getRoute(int graId, int[] spots) throws IOException, CloneNotSupportedException{
		System.out.println(spots);
		Map<String, Object> route = new HashMap<String,Object>();
		ArrayList<Spot> spotsArray = routeService.getRoute(graId, spots);
		route.put("spotsArray", spotsArray);
		route.put("gra", routeService.getGraByGraId(graId));
		return route;
	}
	
	@RequestMapping("/getGraByGraId")
	@ResponseBody
	public Map<String, Object> getRoute(int graId){
		Map<String, Object> gra = new HashMap<String,Object>();
		gra.put("gra", routeService.getGraByGraId(graId));
		return gra;
	}
	
	@RequestMapping("/routePage")
	public String routePage(Model model) {
		model.addAttribute("graList", routeService.getGra());
		return "routePage";
	}
	
	@RequestMapping("/routeSelect")
	@ResponseBody
	public Map<String,Integer[][]> routeSelect(int graId) throws IOException {
		graProduce graPro = new graProduce();
		Map<String,Integer[][]> m = new HashMap<String,Integer[][]>();
		Integer[][] graArray;
		graArray = graPro.getGraArray(graId);
		
		m.put("graArray", graArray);
		return m;
	}
	
	@RequestMapping("/routePageTests")
	public String routePageTests(Model model) {
		model.addAttribute("graList", routeService.getGra());
		return "testRoutePage";
	}
	
	@RequestMapping("/routePageTest")
	@ResponseBody
	public Map<String, List<Spot>> getSpotInfoByGraId(int graId){
		Map<String, List<Spot>> resMap = new HashMap<>();
		resMap.put("spotInfoList", spotInfoService.getSpotInfoByGraId(graId));
		return resMap;
	}
}
