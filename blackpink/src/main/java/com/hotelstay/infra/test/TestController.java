package com.hotelstay.infra.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class TestController {
	
	@RequestMapping(value = "/test")
	public String test(Model model) throws Exception{
		
		String apiUrl = "http://api.kcisa.kr/openapi/API_CNV_061/request?serviceKey=19efceae-25a1-4ba8-a9fd-be28977b79c5&numOfRows=10&pageNo=1&";
		
		
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		httpURLConnection.setRequestProperty("Accept", "application/json");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuilder.append(line);
		}

		bufferedReader.close();
		httpURLConnection.disconnect();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node = objectMapper.readTree(stringBuilder.toString());
		
		
		model.addAttribute("item", node);
		
//		model.addAttribute(node);
		
		
		return "adm/infra/test/tourism"; //
		
	}
	
	@RequestMapping(value = "/test2")
	public String test2(Model model) throws Exception{
		
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getMmCovidDagnsRgntExprtStusInq?serviceKey=tR4050In/V39UwZVcQ9bGxrq0hqmf2vs6x/V8kOBnedR4jD90tcCNJ6RcpQnqKtiEcZ1zNA2NPcYTxSwjQT9CQ==&numOfRows=3&pageNo=1&type=json";
		
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}

		bufferedReader.close();
		httpURLConnection.disconnect();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node = objectMapper.readTree(stringBuilder.toString());
		
		System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("body").get("items").get(0).get("KIT_EXPRT_QTY").asText());
		
		model.addAttribute("node", node);
		
//		model.addAttribute(node);
		
		
		return "adm/infra/test/publicCorona2.JsonNedeList"; //
		
	}
	
	
	@RequestMapping(value = "/publicCorona1List")
	public String publicCorona1List(Model model) throws Exception {
		System.out.println("asdasdasdf");
		
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq?serviceKey=tR4050In%2FV39UwZVcQ9bGxrq0hqmf2vs6x%2FV8kOBnedR4jD90tcCNJ6RcpQnqKtiEcZ1zNA2NPcYTxSwjQT9CQ%3D%3D&numOfRows=3&pageNo=1&type=json";
		
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}
		
		bufferedReader.close();
		httpURLConnection.disconnect();
		
      ObjectMapper objectMapper = new ObjectMapper();
      
      Map<String, Object> map = objectMapper.readValue(stringBuilder.toString(), Map.class);
      
      System.out.println("######## Map");
		for (String key : map.keySet()) {
			String value = String.valueOf(map.get(key));	// ok
			System.out.println("[key]:" + key + ", [value]:" + value);
		}
		
		
		Map<String, Object> header = new HashMap<String, Object>();
		header = (Map<String, Object>) map.get("header");
		
		System.out.println("######## Header");
		for (String key : header.keySet()) {
			String value = String.valueOf(header.get(key));	// ok
			System.out.println("[key]:" + key + ", [value]:" + value);
		}
		
		String aaa = (String) header.get("resultCode");
		
		System.out.println("header.get(\"resultCode\"): " + header.get("resultCode"));
		System.out.println("header.get(\"resultMsg\"): " + header.get("resultMsg"));
		
		Map<String, Object> body = new HashMap<String, Object>();
		body = (Map<String, Object>) map.get("body");
		
//		List<Home> items = new ArrayList<Home>();
//		items = (List<Home>) body.get("items");
//		
//		System.out.println("items.size(): " + items.size());
//		
//		System.out.println("items.toString(): " + items.toString());
		
//		model.addAllAttributes(map);
		model.addAllAttributes(header);
		model.addAllAttributes(body);
		
//		model.addAttribute("header", header);
//		model.addAttribute("body", body);
		
		return "adm/infra/test/publicCorona1List";
	}
	
	@RequestMapping(value = "/publicCorona2List")
	public String publicCorona2List(Model model) throws Exception {
		System.out.println("asdasdasdf");
		
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getMmCovidDagnsRgntExprtStusInq?serviceKey=tR4050In/V39UwZVcQ9bGxrq0hqmf2vs6x/V8kOBnedR4jD90tcCNJ6RcpQnqKtiEcZ1zNA2NPcYTxSwjQT9CQ==&numOfRows=3&pageNo=1&type=json";
		
		
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}
		
		bufferedReader.close();
		httpURLConnection.disconnect();
		
      ObjectMapper objectMapper = new ObjectMapper();
      
      Map<String, Object> map = objectMapper.readValue(stringBuilder.toString(), Map.class);
      
      System.out.println("######## Map");
		for (String key : map.keySet()) {
			String value = String.valueOf(map.get(key));	// ok
			System.out.println("[key]:" + key + ", [value]:" + value);
		}
		
		
		Map<String, Object> header = new HashMap<String, Object>();
		header = (Map<String, Object>) map.get("header");
		
		System.out.println("######## Header");
		for (String key : header.keySet()) {
			String value = String.valueOf(header.get(key));	// ok
			System.out.println("[key]:" + key + ", [value]:" + value);
		}
		
		String aaa = (String) header.get("resultCode");
		
		System.out.println("header.get(\"resultCode\"): " + header.get("resultCode"));
		System.out.println("header.get(\"resultMsg\"): " + header.get("resultMsg"));
		
		Map<String, Object> body = new HashMap<String, Object>();
		body = (Map<String, Object>) map.get("body");
		
//		List<Home> items = new ArrayList<Home>();
//		items = (List<Home>) body.get("items");
//		
//		System.out.println("items.size(): " + items.size());
//		
//		System.out.println("items.toString(): " + items.toString());
		
//		model.addAllAttributes(map);
		model.addAllAttributes(header);
		model.addAllAttributes(body);
		
//		model.addAttribute("header", header);
//		model.addAttribute("body", body);
		
		return "adm/infra/test/publicCorona2List";
	}
}
