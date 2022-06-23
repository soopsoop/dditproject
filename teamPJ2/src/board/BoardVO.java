package board;

public class BoardVO {

	private int bdNo;
	private String bdTtl;
	private String bdWtr;
	private String bdDate;
	private String bdCnt;

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	public String getBdTtl() {
		return bdTtl;
	}

	public void setBdTtl(String bdTtl) {
		this.bdTtl = bdTtl;
	}

	public String getBdWtr() {
		return bdWtr;
	}

	public void setBdWtr(String bdWtr) {
		this.bdWtr = bdWtr;
	}

	public String getBdDate() {
		return bdDate;
	}

	public void setBdDate(String bdDate) {
		this.bdDate = bdDate;
	}

	public String getBdCnt() {
		return bdCnt;
	}

	public void setBdCnt(String bdCnt) {
		this.bdCnt = bdCnt;
	}

	@Override
	public String toString() {
		return "BoardVO [bdNo=" + bdNo + ", bdTtl=" + bdTtl + ", bdWtr=" + bdWtr + ", bdDate=" + bdDate + ", bdCnt="
				+ bdCnt + "]";
	}

}
