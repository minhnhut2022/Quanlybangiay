package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.MixCthd_bean;
import connectsql.connect_all;

public class MixCthd_dao {
	public ArrayList<MixCthd_bean> dscthd;
	connect_all cn=new connect_all();
	
	public ArrayList<MixCthd_bean> getcthd(long mahd) throws Exception{
		Connection kn = cn.ketnoi();
		dscthd=new ArrayList<MixCthd_bean>();
		String sql="select hd.MaHD,h.MaHang,TenHang,Gia,NgayNhap,NgayMua,MaNV,SoLuongMua,ct.thanhtien from Hang as h join CTHD as ct on h.MaHang=ct.MaHang join HoaDon as hd on ct.MaHD=hd.MaHD where hd.MaHD='"+mahd+"'";
		PreparedStatement  cmd=kn.prepareStatement(sql);
 		ResultSet rs=cmd.executeQuery();
 		MixCthd_bean cthd;
 		while (rs.next()) {
			cthd=new MixCthd_bean(rs.getLong("MaHD"), rs.getString("MaHang"), rs.getString("TenHang"), rs.getLong("Gia"),rs.getDate("NgayMua"),rs.getString("MaNV"), rs.getLong("SoLuongMua"), rs.getLong("ThanhTien"));
			dscthd.add(cthd);
		}
		return dscthd;
	}
}
