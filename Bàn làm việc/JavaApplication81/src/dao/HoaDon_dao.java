package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Hang_bean;
import bean.HoaDon_bean;
import bean.NhanVien_bean;
import connectsql.connect_all;

public class HoaDon_dao {
	connect_all cn=new connect_all();
	ArrayList<HoaDon_bean> dshd;
	public int tkhoadon() throws Exception{
 		Connection kn = cn.ketnoi();
 		int count;
 		String sql="SELECT count(*) FROM HoaDon";
 		PreparedStatement  cmd=kn.prepareStatement(sql);
 		ResultSet rs=cmd.executeQuery();
 		rs.next();
 		return count = rs.getInt(1);
 

	}
	public ArrayList<HoaDon_bean> getdshd() throws Exception{
		Connection kn = cn.ketnoi();
		 dshd = new ArrayList<HoaDon_bean>();
		String sql="SELECT * FROM HoaDon";
	
		PreparedStatement  cmd=kn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		HoaDon_bean hd;
		while(rs.next()) {
			hd=new HoaDon_bean(rs.getDate("NgayMua"), rs.getString("MaNV"), rs.getLong("MaHD"));
			dshd.add(hd);
			
		}
		return dshd;
	}
	public int xoacthd(long ma)throws Exception{
		Connection kn = cn.ketnoi();
		String sql="delete from CTHD where MaHD=?";
		

		PreparedStatement cmd=kn.prepareStatement(sql);
		cmd.setLong(1,ma);
	
		int kt=cmd.executeUpdate();
	
		cmd.close();
		return kt;
	}
	public int xoahd(long ma)throws Exception{
		Connection kn = cn.ketnoi();
		String sql="delete from HoaDon where MaHD=?";
		

		PreparedStatement cmd=kn.prepareStatement(sql);
		cmd.setLong(1,ma);
	
		int kt=cmd.executeUpdate();
	
		cmd.close();
		return kt;
	}
	public ArrayList<HoaDon_bean> timkiem(long mah)throws Exception {
 		ArrayList<HoaDon_bean> ds=new ArrayList<HoaDon_bean>();
			Connection kn=cn.ketnoi();
			
			String sql="select MaHD,NgayMua,MaNV from HoaDon where MaHD ="+mah+"";// tương đối
			PreparedStatement  cmd=kn.prepareStatement(sql);
			
	 		ResultSet rs=cmd.executeQuery();
				
	 		HoaDon_bean hd;
			while(rs.next()) {
				hd=new HoaDon_bean(rs.getDate("NgayMua"), rs.getString("MaNV"), rs.getLong("MaHD"));
				dshd.add(hd);
				
			}
					return ds;
	}
}
