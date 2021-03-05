package kr.co.domain;

public class UserVO {
	private String mid;
	private String mpw;
	private String mname;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public UserVO(String mid, String mpw, String mname) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
		result = prime * result + ((mpw == null) ? 0 : mpw.hashCode());
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
		UserVO other = (UserVO) obj;
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		if (mpw == null) {
			if (other.mpw != null)
				return false;
		} else if (!mpw.equals(other.mpw))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserVO [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + "]";
	}
	
	

}
