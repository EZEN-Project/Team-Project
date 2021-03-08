package kr.co.domain;

import java.io.Serializable;
import java.util.Date;

public class SellVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int sellnum;
	private	int goodsnum;
	private int buynum;
	private Date selldate;

	
	public SellVO() {
		// TODO Auto-generated constructor stub
	}


	public SellVO(int sellnum, int goodsnum, int buynum, Date sellDate) {
		super();
		this.sellnum = sellnum;
		this.goodsnum = goodsnum;
		this.buynum = buynum;
		this.selldate = sellDate;
	}


	public int getSellnum() {
		return sellnum;
	}


	public void setSellnum(int sellnum) {
		this.sellnum = sellnum;
	}


	public int getGoodsnum() {
		return goodsnum;
	}


	public void setGoodsnum(int goodsnum) {
		this.goodsnum = goodsnum;
	}


	public int getBuynum() {
		return buynum;
	}


	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}


	public Date getSellDate() {
		return selldate;
	}


	public void setSellDate(Date sellDate) {
		this.selldate = sellDate;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sellnum;
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
		SellVO other = (SellVO) obj;
		if (sellnum != other.sellnum)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SellVO [sellnum=" + sellnum + ", goodsnum=" + goodsnum + ", buynum=" + buynum + ", selldate=" + selldate
				+ "]";
	}
	
	
}
