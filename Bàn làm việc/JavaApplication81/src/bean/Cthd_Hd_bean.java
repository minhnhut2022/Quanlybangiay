package bean;

import java.util.Date;

public class Cthd_Hd_bean {
      
       private String mahang;
       private long slm;
       private long mahd;
       private Date ngaymua;
       private String manv;
       private long thanhtien;
	public Cthd_Hd_bean(String mahang, long slm, long mahd, Date ngaymua, String manv, long thanhtien) {
		super();
	
		this.mahang = mahang;
		this.slm = slm;
		this.mahd = mahd;
		this.ngaymua = ngaymua;
		this.manv = manv;
		this.thanhtien = thanhtien;
	}
	
	public String getMahang() {
		return mahang;
	}
	public void setMahang(String mahang) {
		this.mahang = mahang;
	}
	public long getSlm() {
		return slm;
	}
	public void setSlm(long slm) {
		this.slm = slm;
	}
	public long getMahd() {
		return mahd;
	}
	public void setMahd(long mahd) {
		this.mahd = mahd;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
       
       
       
}
