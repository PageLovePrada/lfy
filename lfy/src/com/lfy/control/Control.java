package com.lfy.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Control {

	MyTool tool = new MyTool();

	@RequestMapping("login.do")
	public String login(HttpServletRequest request,
			HttpServletResponse response, String name) {
		System.out.println(111);
		return "index.html";
	}

	// 插入新链接
	@RequestMapping("insertURL.do")
	public String insertURL(HttpServletResponse response, String key,
			String value) throws IOException {
		PrintWriter out = response.getWriter();
		// 插,
		boolean msg1 = tool.appendTxt(tool.readPriperties("kingPath"), ",\r\n");
		// 插入key value
		boolean msg2 = tool.appendTxt(tool.readPriperties("kingPath"), "\""
				+ key + "\"" + ":" + "\"" + value + "\"");
		// 插入成功
		if (msg1 && msg2) {
			out.print("1");
			out.close();
		}
		// 追加到tomcat文件 用于显示
		String path = ("" + Control.class.getResource("/")).substring(6,
				("" + Control.class.getResource("/")).indexOf("WEB-INF"))
				+ "dataSource/King.map";
		tool.appendTxt(path, ",\r\n");
		tool.appendTxt(path, "\"" + key + "\"" + ":" + "\"" + value + "\"");
		return "";
	}

	// 愤怒的小鸟
	@RequestMapping("playAngryBirds.do")
	public String playAngryBirds(ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) {
		return "view/game/AngryBirds.jsp";
	}

	@RequestMapping("test.do")
	public void test(ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response,String param,String a) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.getWriter().print("[{\"a\":\"楼风格\"}]");
		
	}

	@RequestMapping("submit.json")
	public String submit(HttpServletRequest request,
			HttpServletResponse response, String a) {

		Map map1 = new HashMap();
		Map map2 = new HashMap();
		map2.put("str1", "撒点粉");
		map2.put("str2", "s爱仕达");
		map2.put("a", "a富商大贾d");
		map1.put("obj", map2);
		map1.put("obj2", "ssdfg暗示法s");
		JSONObject json = JSONObject.fromObject(map1);
		try {
	        response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
			out.flush();
			out.close();
			out = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
	}
}
