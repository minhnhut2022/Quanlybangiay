package bean;

import java.sql.Blob;
import java.util.Date;

public class Hang_bean {
 private String MaHang;
 private String TenHang;
 
 private long SoLuong;
 
 private long Gia;
 private Date NgayNhap;
 private Boolean TinhTrang;
 private String MaChiNhanh;
 private String File;


public Hang_bean(String maHang, String tenHang, long soLuong, long gia, Date ngayNhap, Boolean tinhTrang,
		String maChiNhanh, String file) {
	super();
	MaHang = maHang;
	TenHang = tenHang;
	SoLuong = soLuong;
	Gia = gia;
	NgayNhap = ngayNhap;
	TinhTrang = tinhTrang;
	MaChiNhanh = maChiNhanh;
	File = file;
}
public String getMaHang() {
	return MaHang;
}
public void setMaHang(String maHang) {
	MaHang = maHang;
}
public String getTenHang() {
	return TenHang;
}
public void setTenHang(String tenHang) {
	TenHang = tenHang;
}
public long getSoLuong() {
	return SoLuong;
}
public void setSoLuong(long soLuong) {
	SoLuong = soLuong;
}
public long getGia() {
	return Gia;
}
public void setGia(long gia) {
	Gia = gia;
}
public Date getNgayNhap() {
	return NgayNhap;
}
public void setNgayNhap(Date ngayNhap) {
	NgayNhap = ngayNhap;
}
public Boolean getTinhTrang() {
	return TinhTrang;
}
public void setTinhTrang(Boolean tinhTrang) {
	TinhTrang = tinhTrang;
}
public String getMaChiNhanh() {
	return MaChiNhanh;
}
public void setMaChiNhanh(String maChiNhanh) {
	MaChiNhanh = maChiNhanh;
}
public String getFile() {
	return File;
}
public void setFile(String file) {
	File = file;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return MaHang;
}
public long Thanhtien(long t) {
	long tien=getGia()*(getSoLuong()-t);
	return tien;
	
}
 
 



 
}

