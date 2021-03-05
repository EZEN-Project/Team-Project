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
	private String content;
	private String writer;
	private Date regDate;
	private Date updateDate;
	private int viewCnt;
	private int replyCnt;
	
	private String[] files;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int bno, String title, String content, String writer, Date regDate, Date updateDate, int viewCnt) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.viewCnt = viewCnt;
	}
	
	
	

	public BoardVO(int bno, String title, String content, String writer, Date regDate, Date updateDate, int viewCnt,
			int replyCnt) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.viewCnt = viewCnt;
		this.replyCnt = replyCnt;
	}
	
	
	
	

	public BoardVO(int bno, String title, String content, String writer, Date regDate, Date updateDate, int viewCnt,
			int replyCnt, String[] files) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.viewCnt = viewCnt;
		this.replyCnt = replyCnt;
		this.files = files;
	}
	
	
	

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", updateDate=" + updateDate
				+ ", viewCnt=" + viewCnt + "]";
	}
	
	
	
	
}
