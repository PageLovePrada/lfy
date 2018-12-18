package com.lfy.test;

import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

public class java读取json {

	public static void main(String[] args){
		String json = "{\"body\":{\"address\":\"\",\"areaName\":\"\",\"artifPriceDate\":\"\",\"buildCompleteTime\":\"\",\"buildingName\":\"\",\"caseAvgPrice\":0,\"caseMonthFloatingPercentage\":\"\",\"caseMonthFloatingPrice\":0,\"casePresentationPeriod\":\"\",\"caseYearFloatingPercentage\":\"\",\"caseYearFloatingPrice\":0,\"cityName\":\"\",\"estimable\":1,\"estimableStatus\":0,\"evaluateType\":0,\"evaluatedReportUrl\":null,\"houseName\":\"\",\"housePurposeType\":\"0\",\"isHousePrice\":0,\"landType\":\"\",\"otherName\":\"\",\"projectAvgPrice\":0,\"projectName\":\"\",\"provinceName\":\"\",\"refusalCause\":\"\",\"serialNo\":\"106c0a57e40145a6a79453414269f9b5\",\"totalPrice\":0,\"totalnum\":0,\"unitPrice\":63321},\"code\":0,\"errmsg\":\"请求成功\",\"signature\":\"05896d516c8111f578962d95b3d90b3d\",\"timestamp\":1544063375713}";
		readJson(json);
		System.out.println(getJsonVal(json,"body"));
	}
	public static String getJsonVal(String json, String key){

        JSONObject jsonObject = JSONObject.fromObject(json);
        Map<String, Object> mapJson = JSONObject.fromObject(jsonObject);
        String unitPrice = null;
        for(Entry<String,Object> entry : mapJson.entrySet()){
        	if(key.equals(entry.getKey().toString())){
        		return entry.getValue().toString();
        	}
    	}
		return "{}";
	}
	public static void readJson(String json){
		
		JSONObject jsonObject = JSONObject.fromObject(json);
		Map<String, Object> mapJson = JSONObject.fromObject(jsonObject);
		String unitPrice = null;
		for(Entry<String,Object> entry : mapJson.entrySet()){
			System.out.println(entry.getKey().toString());
			System.out.println(entry.getValue().toString());
		}
	}
}
