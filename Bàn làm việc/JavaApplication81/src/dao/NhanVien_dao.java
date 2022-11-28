package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.HoaDon_bean;
import bean.NhanVien_bean;
import connectsql.connect_all;

public class NhanVien_dao {
	connect_all cn=new connect_all();
	ArrayList<NhanVien_bean> dsnv;
	public int tknhanvien() throws Exception{
 		Connection kn = cn.ketnoi();
 		int count;
 		String sql="SELECT count(*) FROM NhanVien";
 		PreparedStatement  cmd=kn.prepareStatement(sql);
 		ResultSet rs=cmd.executeQuery();
 		rs.next();
 		return count = rs.getInt(1);
 

	}
	public ArrayList<NhanVien_bean> getdsnv() throws Exception{
		Connection kn = cn.ketnoi();
		 dsnv = new ArrayList<NhanVien_bean>();
		String sql="SELECT * FROM NhanVien";
	
		PreparedStatement  cmd=kn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		NhanVien_bean nv;
		while(rs.next()) {
			nv=new NhanVien_bean(rs.getString("MaNV"), rs.getString("HoTen"), rs.getDate("NgaySinh"), rs.getString("Email"),rs.getString("Avatar"));
			dsnv.add(nv);
			
		}
		return dsnv;
	}
	public int Them(String manv, String hoten, Date ngaysinh, String email,String avatar)throws Exception{
		Connection kn = cn.ketnoi();
		InputStream is = new FileInputStream(new File(avatar));
		java.sql.Date nn=new java.sql.Date(ngaysinh.getTime());
		 String sql="insert into NhanVien(MaNV,HoTen,NgaySinh,Email,Avatar) values(?,?,?,?,?)";
		
	 		PreparedStatement  cmd=kn.prepareStatement(sql);
	 		cmd.setString(1, manv);
	 		cmd.setString(2, hoten);
	 		cmd.setDate(3, nn);
	 	    cmd.setString(4, email);
	 	    cmd.setBlob(5, is);
	 		
	 		int kt=cmd.executeUpdate();
	 		cmd.close();
	 		return kt;
	 		
		
		
		
	}
	public int  xoa(String manv) throws Exception{
		Connection kn=cn.ketnoi();
		String sql="delete from NhanVien where MaNV=?";
		PreparedStatement cmd=kn.prepareStatement(sql);
		cmd.setString(1, manv);
		int kt=cmd.executeUpdate();
		cmd.close();
 		return kt;
	}
	public int  bosung(String manv, String hoten, Date ngaysinh, String email,String avatar)throws Exception {
		Connection kn = cn.ketnoi();
		java.sql.Date nn=new java.sql.Date(ngaysinh.getTime());
		InputStream is = new FileInputStream(new File(avatar));
		String sql="update NhanVien set HoTen=?,NgaySinh=?,Email=?,Avatar=? where MaNV=?";
		PreparedStatement  cmd=kn.prepareStatement(sql);
		cmd.setString(5, manv);
 		cmd.setString(1, hoten);
 		cmd.setDate(2, nn);
 	    cmd.setString(3, email);
 	    cmd.setBlob(4, is);
 		
 		
 		int kt=cmd.executeUpdate();
 		cmd.close();
 		return kt;
		
	}
	public byte[] selectIMG(String ma) throws Exception{
		Connection kn=cn.ketnoi();
		
       
		String sql="select Avatar from NhanVien where MaNV='"+ma+"'";
		PreparedStatement  cmd=kn.prepareStatement(sql);
 		ResultSet rs=cmd.executeQuery();
 	       rs.next();
 	      byte[] buffer = rs.getBytes("Avatar");
 	    
 	   

 		return buffer;
 		
 
 		
	}

	
}
