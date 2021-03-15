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
<<<<<<< HEAD
	private String name;
	private int cost;
	private int price;
	private int veiwcnt;
	private int bcount;
	private Date regdate;
	private Date updatedate;
	private int gnum;
	private String[] files;
	
	
	public SellBoardVO() {
		// TODO Auto-generated constructor stub
	}


	public SellBoardVO(int bnum, String title, String writer, String content, String name, int cost, int price,
			int veiwcnt, int bcount, Date regdate, Date updatedate, int gnum) {
=======
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
>>>>>>> rmh6363
		super();
		this.bnum = bnum;
		this.title = title;
		this.writer = writer;
		this.content = content;
<<<<<<< HEAD
		this.name = name;
		this.cost = cost;
		this.price = price;
		this.veiwcnt = veiwcnt;
		this.bcount = bcount;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.gnum = gnum;
	}

	
	

	public SellBoardVO(int bnum, String title, String writer, String content, String name, int cost, int price,
			int veiwcnt, int bcount, Date regdate, Date updatedate, int gnum, String[] files) {
		super();
		this.bnum = bnum;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.name = name;
		this.cost = cost;
		this.price = price;
		this.veiwcnt = veiwcnt;
		this.bcount = bcount;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.gnum = gnum;
		this.files = files;
	}

	
	

	public String[] getFiles() {
		return files;
	}


	public void setFiles(String[] files) {
		this.files = files;
	}


=======
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

>>>>>>> rmh6363
	public int getBnum() {
		return bnum;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public String getTitle() {
		return title;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public void setTitle(String title) {
		this.title = title;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public String getWriter() {
		return writer;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public void setWriter(String writer) {
		this.writer = writer;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public String getContent() {
		return content;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public void setContent(String content) {
		this.content = content;
	}

<<<<<<< HEAD

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


=======
>>>>>>> rmh6363
	public int getVeiwcnt() {
		return veiwcnt;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public void setVeiwcnt(int veiwcnt) {
		this.veiwcnt = veiwcnt;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public int getBcount() {
		return bcount;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

<<<<<<< HEAD
=======
	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}
>>>>>>> rmh6363

	public Date getRegdate() {
		return regdate;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public Date getUpdatedate() {
		return updatedate;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public int getGnum() {
		return gnum;
	}

<<<<<<< HEAD

=======
>>>>>>> rmh6363
	public void setGnum(int gnum) {
		this.gnum = gnum;
	}

<<<<<<< HEAD

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bnum;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SellBoardVO other = (SellBoardVO) obj;
		if (bnum != other.bnum)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SellBoardVO [title=" + title + ", writer=" + writer + ", content=" + content + "]";
	}

	

=======
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
	
>>>>>>> rmh6363
	
}
