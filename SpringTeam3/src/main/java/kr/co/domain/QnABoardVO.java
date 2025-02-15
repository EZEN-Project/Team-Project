package kr.co.domain;

import java.io.Serializable;
import java.util.Date;

public class QnABoardVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int bnum;
	private String title;
	private String	writer;
	private String	content;
	private int viewcnt;
	private Date regdate;
	private Date updatedate;
	private int replyCnt;
	
	public QnABoardVO() {
		// TODO Auto-generated constructor stub
	}

	public QnABoardVO(int bnum, String title, String writer, String content, int viewcnt, Date regdate,
			Date updatedate) {
		super();
		this.bnum = bnum;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.viewcnt = viewcnt;
		this.regdate = regdate;
		this.updatedate = updatedate;
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

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
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

	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

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
		QnABoardVO other = (QnABoardVO) obj;
		if (bnum != other.bnum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QnABoardVO [title=" + title + ", writer=" + writer + "]";
	}
	
	
}
