package kr.co.domain;

import java.io.Serializable;
import java.util.Date;

public class BoardVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bno;
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
	private int bcount;
	private String goods;
	private String[] files;
	private Date regdate;
	private Date updateDate;
	private int replyCnt;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int bno, String title, String writer, String content, int viewCnt, int bcount, String goods,
			String[] files, Date regdate, Date updatedate,int replyCnt ) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.viewCnt = viewCnt;
		this.bcount = bcount;
		this.goods = goods;
		this.files = files;
		this.regdate = regdate;
		this.updateDate = updatedate;
		this.replyCnt = replyCnt;
	}
	
	

	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
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

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updatedate) {
		this.updateDate = updatedate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bno;
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
		BoardVO other = (BoardVO) obj;
		if (bno != other.bno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardVO [title=" + title + ", writer=" + writer + ", content=" + content + "]";
	}
	
	
	
}
