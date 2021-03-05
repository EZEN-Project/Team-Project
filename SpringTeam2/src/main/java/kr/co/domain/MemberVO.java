package kr.co.domain;

import java.io.Serializable;
import java.util.Date;




public class MemberVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userPw;
	private String userName;
	private String email;
	private Date regDate;
	private Date updateDate;
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String userId, String userPw, String userName, String email, Date regDate, Date updateDate) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.email = email;
		this.regDate = regDate;
		this.updateDate = updateDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", userName=" + userName + "]";
	}
	
}
