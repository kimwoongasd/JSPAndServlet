package com.sist.vo;

import java.util.Date;

public class BoardVO {
	private int no;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private String ip;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public BoardVO(int no, String title, String writer, String content, Date regdate, String ip) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.ip = ip;
	}
	public BoardVO() {
		super();
	}
	public BoardVO(String title, String writer, String content, String ip) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.ip = ip;
	}
	
	
}
