package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.ChiNhanh_bean;
import bean.Cthd_Hd_bean;
import bean.MixCthd_bean;
import bean.NhanVien_bean;
import connectsql.connect_all;

public class Cthd_Hd_dao {
	ArrayList<NhanVien_bean> dsnv;
	ArrayList<NhanVien_bean> dstennv;
	      connect_all cn=new connect_all();
          public int themHDkhiban(Date ngaymua, String manv) throws Exception{
			Connection kn=cn.ketnoi();
			java.sql.Date nm=new java.sql.Date(ngaymua.getTime());
			 String sql="insert into HoaDon(NgayMua,MaNV) values(?,?)";
			 PreparedStatement  cmd=kn.prepareStatement(sql);
			
			 cmd.setDate(1, nm);
			 cmd.setString(2, manv);
			 int kt=cmd.executeUpdate();
		 	cmd.close();
		 	return kt;
			 
		}
          public int themCTHDkhiban(String mahang,long slm,long thanhtien) throws Exception{
  			Connection kn=cn.ketnoi();
  			
  			 String sql="insert into CTHD(MaHang,SoLuongMua,MaHD,ThanhTien) values(?,?,?,?)";
  			 PreparedStatement  cmd=kn.prepareStatement(sql);
  			
  			 cmd.setString(1, mahang);
  			 cmd.setLong(2, slm);
  			 cmd.setLong(3,laymahd());
  			 cmd.setLong(4, thanhtien);
  			 int kt=cmd.executeUpdate();
  		 	cmd.close();
  		 	return kt;
  			 
  		}
          
          
      	public ArrayList<NhanVien_bean> getmanv() throws Exception{
    		Connection kn = cn.ketnoi();
    		 dsnv = new ArrayList<NhanVien_bean>();
    		String sql="SELECT DISTINCT MaNV FROM NhanVien";
    		String t=null;
    		PreparedStatement  cmd=kn.prepareStatement(sql);
     		ResultSet rs=cmd.executeQuery();
     		NhanVien_bean nv;
     		while(rs.next()) {
     			nv=new NhanVien_bean(rs.getString("MaNV"));
     			dsnv.add(nv);
     			
     		}
     		return dsnv;
    		
    	}
    	public long laymahd() throws Exception{
     		Connection kn = cn.ketnoi();
     		int count;
     		String sql="SELECT MAX(MaHD) FROM HoaDon";
     		PreparedStatement  cmd=kn.prepareStatement(sql);
     		ResultSet rs=cmd.executeQuery();
     		rs.next();
     		return rs.getInt(1);
     

    	}
    	public ArrayList<NhanVien_bean> getTennv(String manv)throws Exception{
    		Connection kn = cn.ketnoi();
    		dstennv=new ArrayList<NhanVien_bean>();
    		String sql="select * from NhanVien where MaNV='"+manv+"'";
    		PreparedStatement  cmd=kn.prepareStatement(sql);
     		ResultSet rs=cmd.executeQuery();
     		NhanVien_bean nv;
     		while (rs.next()) {
    			nv=new NhanVien_bean(rs.getString("MaNV"), rs.getString("HoTen"), rs.getDate("NgaySinh"), rs.getString("Email"),rs.getString("Avatar"));
    			dstennv.add(nv);
    		}
    		return dstennv;
     		
		}
    	public int upsoluong(String ma,long slmnew)throws Exception {
    		Connection kn = cn.ketnoi();
    		
    		String sql="update Hang set SoLuong=? where MaHang=?";
    		PreparedStatement  cmd=kn.prepareStatement(sql);
    		cmd.setString(2, ma);
     		cmd.setLong(1,slmnew);
     		
     		
     		int kt=cmd.executeUpdate();
     		cmd.close();
     		return kt;
    		
    	}
    	
}
