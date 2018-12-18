package com.lfy.python;
 
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
 
import com.lfy.python.Java爬虫_资源网站爬取实战bean;
 
/**
 * 从  http://m.qqba.com/ 爬取美女图片
 * @author Administrator
 *
 */
public class Java爬虫_资源网站爬取实战 {
 
	public final static int STARTPAGE = 1;
	public final static int ENDPAGE = 10;//爬取的页面数量
	
	/**
	 * 获取图片的src和alt属性值
	 * @return
	 * @throws IOException
	 */
	public static List<Java爬虫_资源网站爬取实战bean> getPictureUrl() throws IOException{
		int number = 1;
		List<Java爬虫_资源网站爬取实战bean> pics = new ArrayList<Java爬虫_资源网站爬取实战bean>();//存储获取到的所有图片的URL地址
		for (int i = STARTPAGE; i < ENDPAGE; i++) {
			String url = "http://www.27270.com/beautiful/beijingtupian/2016/16622"+i+".html";
			Document doc = null;
			doc = Jsoup.connect(url).get();		//获取页面文档
			Elements divList = doc.body().select("div");
			System.out.println(divList.size());
			for (int j = 0; j < divList.size(); j++) {
				Elements imgList = divList.get(j).select("img");//一个网页内所有的img标签
				for (int k = 0; k < imgList.size(); k++) {
					Java爬虫_资源网站爬取实战bean pic = new Java爬虫_资源网站爬取实战bean();
					pic.setId(number++);
					pic.setSrc(imgList.get(k).attr("src"));
					pic.setAlt(imgList.get(k).attr("alt"));
					
					pics.add(pic);
				}
			}
		}
		return pics;
	}

	
	/**
	 * 获取图片输入流
	 * @param picUrl  图片的URL地址
	 * @return
	 * @throws IOException 
	 */
	public static InputStream getPictureInputStream(String picUrl) throws IOException{
		URL url = new URL(picUrl);
		DataInputStream dis = new DataInputStream(url.openStream());//获取图片的输入流
		return dis;
	}
	
	/**
	 * 保存图片到本地磁盘中
	 * @param number 图片编号
	 * @throws IOException 
	 */
	public static void savePicture(InputStream in, Java爬虫_资源网站爬取实战bean pic) throws IOException{
		String newImgUrl = "E:/桌面/picture/"+pic.getAlt()+"--"+pic.getId()+".jpg";//图片在磁盘上的存储路径
		System.out.println(newImgUrl);
		FileOutputStream fos = new FileOutputStream(new File(newImgUrl));
		byte[] buf = new byte[1024];
		int len = -1;
		while( (len = in.read(buf)) >0){
			fos.write(buf, 0, len);
		}
		fos.close();
	}
	

	/**
	 * 获取图片的src和alt属性值
	 * @return
	 * @throws IOException
	 */
	public static List<Java爬虫_资源网站爬取实战bean> getWebImg(String url, String bodySelect,String childSelect) throws IOException{
		int number = 1;
		List<Java爬虫_资源网站爬取实战bean> pics = new ArrayList<Java爬虫_资源网站爬取实战bean>();//存储获取到的所有图片的URL地址
			Document doc = null;
			doc = Jsoup.connect(url).get();		//获取页面文档
			Elements divList = doc.body().select(bodySelect);
			System.out.println(divList.size());
			for (int j = 0; j < divList.size(); j++) {
				Elements imgList = divList.get(j).select(childSelect);//一个网页内所有的img标签
				for (int k = 0; k < imgList.size(); k++) {
					Java爬虫_资源网站爬取实战bean pic = new Java爬虫_资源网站爬取实战bean();
					pic.setId(number++);
					pic.setSrc(imgList.get(k).attr("src"));
					pic.setAlt(imgList.get(k).attr("alt"));
					
					pics.add(pic);
			}
		}
		return pics;
	}

	
	
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
//		try {
//			获取多个网站
//			List<图片bin> pics = getPictureUrl();
//			System.out.println("图片正在下载...");
//			for (int i = 0; i < pics.size(); i++) {
//				图片bin pic = pics.get(i);
//				String picUrl = pic.getSrc();
//				InputStream in = getPictureInputStream(picUrl);
//				System.out.println(picUrl);
//				savePicture(in, pic);
//				in.close();
//			}
//			System.out.println("下载完成！");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try {
//			获取单个网站
			List<Java爬虫_资源网站爬取实战bean> pics = getWebImg(
//					"http://localhost:8080/lfy/index.jsp",
					"https://www.cnblogs.com/LexMoon/p/JavaP.html",
					"div",
					"img");
			System.out.println("图片正在下载...");
			int num = 0;
			for (int i = 0; i < pics.size(); i++) {
				Java爬虫_资源网站爬取实战bean pic = pics.get(i);
				String picUrl = pic.getSrc();
				InputStream in = getPictureInputStream(picUrl);
				System.out.println(picUrl);
				savePicture(in, pic);
				in.close();
				num++;
				}
			System.out.println("下载完成！共下载"+num+"个");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}