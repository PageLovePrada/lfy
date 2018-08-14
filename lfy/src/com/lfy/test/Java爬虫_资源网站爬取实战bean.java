package com.lfy.test;
 
public class Java爬虫_资源网站爬取实战bean {
 
	/**
	 * 图片编号
	 */
	private int id;
	/**
	 * 图片地址
	 */
	private String src;
	/**
	 * 图片说明信息
	 */
	private String alt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	@Override
	public String toString() {
		return "Picture [id=" + id + ", src=" + src + ", alt=" + alt + "]";
	}
	
}