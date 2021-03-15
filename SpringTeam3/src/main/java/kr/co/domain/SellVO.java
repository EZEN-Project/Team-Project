package kr.co.domain;

import java.io.Serializable;
import java.util.Date;

public class SellVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int sellnum;
	private	int sellboardno;
	private int buynum;
	private int amount;
	private int aprice;
	private int groupnum;
	private Date selldate;
	private String img;
	public SellVO() {
		// TODO Auto-generated constructor stub
	}
	public SellVO(int sellnum, int sellboardno, int buynum, int amount, int aprice, int groupnum, Date selldate,
			String img) {
		super();
		this.sellnum = sellnum;
		this.sellboardno = sellboardno;
		this.buynum = buynum;
		this.amount = amount;
		this.aprice = aprice;
		this.groupnum = groupnum;
		this.selldate = selldate;
		this.img = img;
	}
	public int getSellnum() {
		return sellnum;
	}
	public void setSellnum(int sellnum) {
		this.sellnum = sellnum;
	}
	public int getSellboardno() {
		return sellboardno;
	}
	public void setSellboardno(int sellboardno) {
		this.sellboardno = sellboardno;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAprice() {
		return aprice;
	}
	public void setAprice(int aprice) {
		this.aprice = aprice;
	}
	public int getGroupnum() {
		return groupnum;
	}
	public void setGroupnum(int groupnum) {
		this.groupnum = groupnum;
	}
	public Date getSelldate() {
		return selldate;
	}
	public void setSelldate(Date selldate) {
		this.selldate = selldate;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SellVO [sellnum=" + sellnum + ", sellboardno=" + sellboardno + ", buynum=" + buynum + ", amount="
				+ amount + ", aprice=" + aprice + ", groupnum=" + groupnum + ", selldate=" + selldate + ", img=" + img
				+ "]";
	}
	
	
}
