package com.example.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.ApiResult;
import com.example.bean.Spot;
import com.example.mapper.SpotInfoMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
public class SpotInfoProduce {
	@Autowired
	private SpotInfoMapper spotInfoMapper;
	
	@RequestMapping("spotInfoPage")
	public String spotInfoPage() {
		return "spotInfoProduce";
	}
	
	@RequestMapping("/spotInfoProduce")
	@ResponseBody
	public int spotInfoTransfer(String inputPath) {
		Gson gson = new Gson();
		File inputFile = new File(inputPath);
		int res=0;
		try {
			
			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			int graId = Integer.parseInt(str);
			str = br.readLine();
			int i=0;
			while((str = br.readLine())!=null) {
				System.out.println(str);
				Spot spot = new Spot();
				spot = gson.fromJson(str,Spot.class);
				spot.setGraId(graId);
				spot.setSpotId(i++);
				System.out.println(11);
				res = spotInfoMapper.addSpotInfo(spot);
				System.out.println(spot.toString());
			}
			fr.close();
			br.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}finally {
			return res;
		}
	}
	
	@RequestMapping("/spotInfoMatrix")
	@ResponseBody
	public String graTransferToMatrix(int graId) {
		StringBuffer result = new StringBuffer();
		String urlStr = "https://api.map.baidu.com/routematrix/v2/walking?output=json&ak=pGcmVPay1pK0pmg0t8aDl5ir0VL2gxBS";
		String outputPath = "C:\\Users\\10176\\Documents\\workspace-spring-tool-suite-4-4.1.2.RELEASE\\demo\\target\\classes\\spotInfo\\graMatrix"+graId+".txt"; 
		String res = null;
		File f = new File(outputPath);
		Gson gson = new Gson();
		FileWriter fw;
		BufferedWriter bw;
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			int i = 0;
			List<Spot> spotList = spotInfoMapper.getSpotBygraId(graId);
			bw.write(spotList.size());
			bw.write("\r\n");
			for (Spot spot : spotList) {
				for (Spot spot2 : spotList) {
					urlStr+="&origins="+spot.getLat()+","+spot.getLng()+"&destinations="+spot2.getLat()+","+spot2.getLng();
					URL url = new URL(urlStr);
					URLConnection conn = url.openConnection();
					BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
					String line;
		            while((line = in.readLine()) != null){
		                result.append(line);
		            }
		            in.close();
		            
		            JsonObject jsonObject = (JsonObject) new JsonParser().parse(result.toString()).getAsJsonObject();
		            
		            bw.write(jsonObject.getAsJsonArray("result").get(0).getAsJsonObject().get("distance").getAsJsonObject().get("value").getAsString()+",");
		            System.out.print(jsonObject.getAsJsonArray("result").get(0).getAsJsonObject().get("distance").getAsJsonObject().get("value").getAsString()+",");
		            result.setLength(0);
					urlStr="https://api.map.baidu.com/routematrix/v2/walking?output=json&ak=pGcmVPay1pK0pmg0t8aDl5ir0VL2gxBS";
				}
				bw.write("\r\n");
				System.out.println();
	
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
	
		return res;
	}
	
	@RequestMapping("/spotInfoMatrixTest")
	@ResponseBody
	public void test(int graId) {
		String urlStr = "https://api.map.baidu.com/routematrix/v2/walking?output=json&ak=pGcmVPay1pK0pmg0t8aDl5ir0VL2gxBS";
		String res = null;
		String tempStr1="&origins=";
		String tempStr2="&destinations=";
		Gson gson = new Gson();
		
		try {
			
			
			int i = 0;
			List<Spot> spotList = spotInfoMapper.getSpotBygraId(graId);
			for (Spot spot : spotList) {
				for (Spot spot2 : spotList) {
					tempStr1+=spot.getLat()+","+spot.getLng()+"|";
					tempStr2+=spot2.getLat()+","+spot2.getLng()+"|";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			e.toString();
		}
		System.out.println(tempStr1);
		System.out.println(tempStr2);
	
	}
    
}
