package kr.co.domain;

import java.io.Serializable;
import java.util.Date;

public class SellBoardVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private	int bnum;
	private String title;
	private String writer;
	private String content;
	private int veiwcnt;
	private int bcount;
	private String goods;
	private Date regdate;
	private Date updatedate;
	private int gnum;
	private String name;
	private int cost;
	private int price;
	
	public SellBoardVO() {
		
	}

	public SellBoardVO(int bnum, String title, String writer, String content, int veiwcnt, int bcount, String goods,
			Date regdate, Date updatedate, int gnum, String name, int cost, int price) {
		super();
		this.bnum = bnum;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.veiwcnt = veiwcnt;
		this.bcount = bcount;
		this.goods = goods;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.gnum = gnum;
		this.name = name;
		this.cost = cost;
		this.price = price;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
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

	public int getVeiwcnt() {
		return veiwcnt;
	}

	public void setVeiwcnt(int veiwcnt) {
		this.veiwcnt = veiwcnt;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public int getGnum() {
		return gnum;
	}

	public void setGnum(int gnum) {
		this.gnum = gnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
