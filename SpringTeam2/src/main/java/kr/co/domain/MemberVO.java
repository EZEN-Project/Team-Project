package kr.co.domain;

import java.io.Serializable;
import java.util.Date;





public class MemberVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mnum;
	private String id;
	private String email;
	private String pw;
	private String name;
	private int phone;
	private String address;
	private Date regDate;
	private Date updateDate;
	private Date date;
	private int point;
	private int type;
	private String memo;
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	public MemberVO(int mnum, String id, String email, String pw, String name, int phone, String address, Date regDate,
			Date updateDate, Date date, int point, int type) {
		super();
		this.mnum = mnum;
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.date = date;
		this.point = point;
		this.type = type;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
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
		MemberVO other = (MemberVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}
	
}
