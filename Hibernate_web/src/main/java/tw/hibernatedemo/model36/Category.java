package tw.hibernatedemo.model36;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//商品列表
@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Pdid")
	private Integer pdid;
	// 產品編號(pk)
	@Column(name = "userID")
	private String userID;
	// 會員 ID(fk)
	@Column(name = "Pdname")
	private String pdname;
	// 產品名稱
	@Column(name = "Pdtitle")
	private String pdtitle;
	// 品牌名稱
	@Column(name = "Pdcontent")
	private String pdcontent;
	// 產品規格
	@Column(name = "Pdtype")
	private String pdtype;
	// 產品類型
	@Column(name = "Pdpicture")
	private Blob pdpicture;
	// 照片 vinbinary
	@Column(name = "Pdprice")
	private int pdprice;
	// 價位
	@Column(name = "Pdinventory")
	private int pdinventory;
	// 庫存數量
	@Column(name = "Pddate")
	private Date pddate;
	// 商品建立日期
	@Column(name = "Pdlastupdate")
	private Date pdlastupdate;
	// 商品更新日期
	
	public Category() {
	}
	
	public Integer getPdid() {
		return pdid;
	}
	public void setPdid(Integer pdid) {
		this.pdid = pdid;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPdname() {
		return pdname;
	}
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}
	public String getPdtitle() {
		return pdtitle;
	}
	public void setPdtitle(String pdtitle) {
		this.pdtitle = pdtitle;
	}
	public String getPdcontent() {
		return pdcontent;
	}
	public void setPdcontent(String pdcontent) {
		this.pdcontent = pdcontent;
	}
	public String getPdtype() {
		return pdtype;
	}
	public void setPdtype(String pdtype) {
		this.pdtype = pdtype;
	}
	public Blob getPdpicture() {
		return pdpicture;
	}
	public void setPdpicture(Blob pdpicture) {
		this.pdpicture = pdpicture;
	}
	public int getPdprice() {
		return pdprice;
	}
	public void setPdprice(int pdprice) {
		this.pdprice = pdprice;
	}
	public int getPdinventory() {
		return pdinventory;
	}
	public void setPdinventory(int pdinventory) {
		this.pdinventory = pdinventory;
	}
	public Date getPddate() {
		return pddate;
	}
	public void setPddate(Date pddate) {
		this.pddate = pddate;
	}
	public Date getPdlastupdate() {
		return pdlastupdate;
	}
	public void setPdlastupdate(Date pdlastupdate) {
		this.pdlastupdate = pdlastupdate;
	}
	public Category(Integer pdid, String userID, String pdname, String pdtitle, String pdcontent, String pdtype,
			Blob pdpicture, int pdprice, int pdinventory, Date pddate, Date pdlastupdate) {
		super();
		this.pdid = pdid;
		this.userID = userID;
		this.pdname = pdname;
		this.pdtitle = pdtitle;
		this.pdcontent = pdcontent;
		this.pdtype = pdtype;
		this.pdpicture = pdpicture;
		this.pdprice = pdprice;
		this.pdinventory = pdinventory;
		this.pddate = pddate;
		this.pdlastupdate = pdlastupdate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [pdid=");
		builder.append(pdid);
		builder.append(", userID=");
		builder.append(userID);
		builder.append(", pdname=");
		builder.append(pdname);
		builder.append(", pdtitle=");
		builder.append(pdtitle);
		builder.append(", pdcontent=");
		builder.append(pdcontent);
		builder.append(", pdtype=");
		builder.append(pdtype);
		builder.append(", pdpicture=");
		builder.append(pdpicture);
		builder.append(", pdprice=");
		builder.append(pdprice);
		builder.append(", pdinventory=");
		builder.append(pdinventory);
		builder.append(", pddate=");
		builder.append(pddate);
		builder.append(", pdlastupdate=");
		builder.append(pdlastupdate);
		builder.append("]");
		return builder.toString();
	}


}
