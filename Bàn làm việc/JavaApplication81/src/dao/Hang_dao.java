package dao;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;

import bean.ChiNhanh_bean;
import bean.Hang_bean;
import connectsql.connect_all;


public class Hang_dao {
	private static final int MYSQL_DUPLICATE_PK = 2627;
	public ArrayList<Hang_bean> dshang;
	public ArrayList<ChiNhanh_bean> dscn;
	public ArrayList<Hang_bean> dsfile;

	connect_all cn=new connect_all();
	public int tkhang() throws Exception{
 		Connection kn = cn.ketnoi();
 		int count;
 		String sql="SELECT count(*) FROM Hang";
 		PreparedStatement  cmd=kn.prepareStatement(sql);
 		ResultSet rs=cmd.executeQuery();
 		rs.next();
 		return count = rs.getInt(1);
 

	}
	public ArrayList<Hang_bean> getHang() throws Exception{
		Connection kn = cn.ketnoi();
		
 		dshang=new ArrayList<Hang_bean>();
 		String sql="SELECT * FROM Hang";
 		PreparedStatement  cmd=kn.prepareStatement(sql);
 		ResultSet rs=cmd.executeQuery();
 		Hang_bean hang;
 	while (rs.next()) {
		hang=new Hang_bean(rs.getString("MaHang"), rs.getString("TenHang"), rs.getLong("SoLuong"), rs.getLong("Gia"), rs.getDate("NgayNhap"), rs.getBoolean("TinhTrang"), rs.getString("MaChiNhanh"),rs.getString("HinhAnh"));
		dshang.add(hang);
		
	}
		return dshang;
	}
	public ArrayList<ChiNhanh_bean> getmacn() throws Exception{
		Connection kn = cn.ketnoi();
		dscn=new ArrayList<ChiNhanh_bean>();
		String sql="SELECT DISTINCT MaChiNhanh FROM ChiNhanh";
		String t=null;
		PreparedStatement  cmd=kn.prepareStatement(sql);
 		ResultSet rs=cmd.executeQuery();
 		ChiNhanh_bean cn;
 		while(rs.next()) {
 			cn=new ChiNhanh_bean(rs.getString("MaChiNhanh"));
 			dscn.add(cn);
 			
 		}
 		return dscn;
		
	}

	public int Them(String mahang,String tenhang,long soluong,long gia, Date ngaynhap,boolean trangthai,String machinhanh,String file)throws Exception{
		Connection kn = cn.ketnoi();
		 InputStream is = new FileInputStream(new File(file));
		java.sql.Date nn=new java.sql.Date(ngaynhap.getTime());
		 String sql="insert into Hang(MaHang,TenHang,SoLuong,Gia,NgayNhap,TinhTrang,MaChiNhanh,HinhAnh) values(?,?,?,?,?,?,?,?)";
		
	 		PreparedStatement  cmd=kn.prepareStatement(sql);
	 		cmd.setString(1, mahang);
	 		cmd.setString(2, tenhang);
	 		cmd.setLong(3, soluong);
	 	    cmd.setLong(4, gia);
	 		cmd.setDate(5, nn);
	 		cmd.setBoolean(6, trangthai);
	 		cmd.setString(7, machinhanh);
	 		cmd.setBlob(8, is);
	 		int kt=cmd.executeUpdate();
	 		cmd.close();
	 		return kt;
	 		
		
		
		
	}
	public int  xoa(String mahang) throws Exception{
		Connection kn=cn.ketnoi();
		String sql="delete from Hang where MaHang=?";
		PreparedStatement cmd=kn.prepareStatement(sql);
		cmd.setString(1, mahang);
		int kt=cmd.executeUpdate();
		cmd.close();
 		return kt;
	}
	public int  bosung(String mahang,String tenhang,long soluong,long gia, Date ngaynhap,boolean trangthai,String machinhanh,String file)throws Exception {
		Connection kn = cn.ketnoi();
		java.sql.Date nn=new java.sql.Date(ngaynhap.getTime());
		 InputStream is = new FileInputStream(new File(file));
		String sql="update Hang set TenHang=?,SoLuong=?,Gia=?,NgayNhap=?,TinhTrang=?,MaChiNhanh=?,HinhAnh=? where MaHang=?";
		PreparedStatement  cmd=kn.prepareStatement(sql);
		cmd.setString(8, mahang);
 		cmd.setString(1, tenhang);
 		cmd.setLong(2, soluong);
 	    cmd.setLong(3, gia);
 		cmd.setDate(4, nn);
 		cmd.setBoolean(5, trangthai);
 		cmd.setString(6, machinhanh);
 		cmd.setBlob(7, is);
 		int kt=cmd.executeUpdate();
 		cmd.close();
 		return kt;
		
	}
	public ArrayList<Hang_bean> timkiem(String mah)throws Exception {
 		ArrayList<Hang_bean> ds=new ArrayList<Hang_bean>();
			Connection kn=cn.ketnoi();
			
			String sql="select * from Hang where MaHang LIKE '%"+mah+"%'";// tương đối
			PreparedStatement  cmd=kn.prepareStatement(sql);
			
	 		ResultSet rs=cmd.executeQuery();
				
	 		Hang_bean hang;
			 	while (rs.next()) {
			 		hang=new Hang_bean(rs.getString("MaHang"), rs.getString("TenHang"), rs.getLong("SoLuong"), rs.getLong("Gia"), rs.getDate("NgayNhap"), rs.getBoolean("TinhTrang"), rs.getString("MaChiNhanh"),rs.getString("HinhAnh"));
					ds.add(hang);
					
				}
					return ds;
	}
	public byte[] selectIMG(String ma) throws Exception{
		Connection kn=cn.ketnoi();
		
       
		String sql="select HinhAnh from Hang where MaHang='"+ma+"'";
		PreparedStatement  cmd=kn.prepareStatement(sql);
 		ResultSet rs=cmd.executeQuery();
 	       rs.next();
 	      Blob buffer = rs.getBlob("HinhAnh");
 	    byte[] kq=buffer.getBytes(1, (int) buffer.length());
 	     return kq;
 		
 		
 		
 
 		
	}
	// Bổ Sung Khi không có ảnh
	public int  bosungkhongcoIMG(String mahang,String tenhang,long soluong,long gia, Date ngaynhap,boolean trangthai,String machinhanh)throws Exception {
		Connection kn = cn.ketnoi();
		java.sql.Date nn=new java.sql.Date(ngaynhap.getTime());
		
		String sql="update Hang set TenHang=?,SoLuong=?,Gia=?,NgayNhap=?,TinhTrang=?,MaChiNhanh=? where MaHang=?";
		PreparedStatement  cmd=kn.prepareStatement(sql);
		cmd.setString(7, mahang);
 		cmd.setString(1, tenhang);
 		cmd.setLong(2, soluong);
 	    cmd.setLong(3, gia);
 		cmd.setDate(4, nn);
 		cmd.setBoolean(5, trangthai);
 		cmd.setString(6, machinhanh);
 		
 		int kt=cmd.executeUpdate();
 		cmd.close();
 		return kt;
		
	}
	
}
