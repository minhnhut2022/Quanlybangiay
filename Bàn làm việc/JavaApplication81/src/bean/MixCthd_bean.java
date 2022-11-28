package bean;

import java.util.Date;

public class MixCthd_bean {
      private long mahd;
      private String mahang;
      private String tenhang;
     
      private long gia;

      private Date ngaymua;
      private String manv;
      private long slmua;
      private long thanhtien;
	public MixCthd_bean(long mahd, String mahang, String tenhang, long gia, Date ngaymua, String manv, long slmua,
			long thanhtien) {
		super();
		this.mahd = mahd;
		this.mahang = mahang;
		this.tenhang = tenhang;
		this.gia = gia;
		this.ngaymua = ngaymua;
		this.manv = manv;
		this.slmua = slmua;
		this.thanhtien = thanhtien;
	}
	public long getMahd() {
		return mahd;
	}
	public void setMahd(long mahd) {
		this.mahd = mahd;
	}
	public String getMahang() {
		return mahang;
	}
	public void setMahang(String mahang) {
		this.mahang = mahang;
	}
	public String getTenhang() {
		return tenhang;
	}
	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
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
	public long getSlmua() {
		return slmua;
	}
	public void setSlmua(long slmua) {
		this.slmua = slmua;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
      
      
}
