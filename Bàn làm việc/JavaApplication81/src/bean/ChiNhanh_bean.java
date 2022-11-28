package bean;

public class ChiNhanh_bean {
   private String MaChiNhanh;
   private String TenChiNhanh;
   private String DiaChi;
public ChiNhanh_bean(String maChiNhanh, String tenChiNhanh, String diaChi) {
	super();
	MaChiNhanh = maChiNhanh;
	TenChiNhanh = tenChiNhanh;
	DiaChi = diaChi;
}
public ChiNhanh_bean(String macn) {
    this.MaChiNhanh = macn;
}
public String getMaChiNhanh() {
	return MaChiNhanh;
}
public void setMaChiNhanh(String maChiNhanh) {
	MaChiNhanh = maChiNhanh;
}
public String getTenChiNhanh() {
	return TenChiNhanh;
}
public void setTenChiNhanh(String tenChiNhanh) {
	TenChiNhanh = tenChiNhanh;
}
public String getDiaChi() {
	return DiaChi;
}
public void setDiaChi(String diaChi) {
	DiaChi = diaChi;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MaChiNhanh;
	}
   
}
