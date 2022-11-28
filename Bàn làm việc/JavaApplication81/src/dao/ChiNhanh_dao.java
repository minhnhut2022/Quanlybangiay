package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


import bean.ChiNhanh_bean;
import bean.NhanVien_bean;
import connectsql.connect_all;

public class ChiNhanh_dao {
	private static final int MYSQL_DUPLICATE_PK = 0;
	connect_all cn=new connect_all();
	ArrayList<ChiNhanh_bean> dscn;
	public int tkchinhanh() throws Exception{
 		Connection kn = cn.ketnoi();
 		int count;
 		String sql="SELECT count(*) FROM ChiNhanh";
 		PreparedStatement  cmd=kn.prepareStatement(sql);
 		ResultSet rs=cmd.executeQuery();
 		rs.next();
 		return count = rs.getInt(1);
 

	}
	public ArrayList<ChiNhanh_bean> getdscn() throws Exception{
		Connection kn = cn.ketnoi();
		 dscn = new ArrayList<ChiNhanh_bean>();
		String sql="SELECT * FROM ChiNhanh";
	
		PreparedStatement  cmd=kn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		ChiNhanh_bean cn;
		while(rs.next()) {
			cn=new ChiNhanh_bean(rs.getString("MaChiNhanh"), rs.getString("TenChiNhanh"), rs.getString("DiaChi"));
			dscn.add(cn);
			
		}
		return dscn;
	}
	public int Them(String macn, String tencn,String diachi)throws Exception{
		Connection kn = cn.ketnoi();
		
	
		 String sql="insert into ChiNhanh(MaChiNhanh,TenChiNhanh,DiaChi) values(?,?,?)";
		
	 		PreparedStatement  cmd=kn.prepareStatement(sql);
	 		cmd.setString(1, macn);
	 		cmd.setString(2, tencn);
	 	    cmd.setString(3, diachi);
	 		
	 		int kt=cmd.executeUpdate();
	 		cmd.close();
	 		return kt;
	    
		
		
		
		
	}
	public int  xoa(String manv) throws Exception{
		Connection kn=cn.ketnoi();
		String sql="delete from ChiNhanh where MaChiNhanh=?";
		PreparedStatement cmd=kn.prepareStatement(sql);
		cmd.setString(1, manv);
		int kt=cmd.executeUpdate();
		cmd.close();
 		return kt;
	}
	public int  bosung(String macn, String tencn,String dc)throws Exception {
		Connection kn = cn.ketnoi();
		
		String sql="update ChiNhanh set TenChiNhanh=?,DiaChi=? where MaChiNhanh=?";
		PreparedStatement  cmd=kn.prepareStatement(sql);
	
 		cmd.setString(1,macn);
 		cmd.setString(2, tencn);
 	    cmd.setString(3, dc);
 		
 		
 		int kt=cmd.executeUpdate();
 		cmd.close();
 		return kt;
		
	}
	public ArrayList<ChiNhanh_bean> timkiem(String macn)throws Exception {
 		ArrayList<ChiNhanh_bean> ds=new ArrayList<ChiNhanh_bean>();
			Connection kn=cn.ketnoi();
			
			String sql="select * from ChiNhanh where MaChiNhanh LIKE '%"+macn+"%'";// tương đối
			PreparedStatement  cmd=kn.prepareStatement(sql);
			
	 		ResultSet rs=cmd.executeQuery();
				
	 		ChiNhanh_bean chinhanh;
			 	while (rs.next()) {
					chinhanh =new ChiNhanh_bean(rs.getString("MaChiNhanh"), rs.getString("TenChiNhanh"), rs.getString("DiaChi"));
					ds.add(chinhanh);
					
				}
					return ds;
	}
                 
                  
}
