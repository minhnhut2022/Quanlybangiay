package bo;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;

import bean.HoaDon_bean;
import bean.NhanVien_bean;
import dao.NhanVien_dao;

public class NhanVien_bo {
           private static final int MYSQL_DUPLICATE_PK = 2627;
		NhanVien_dao dao=new NhanVien_dao();
           ArrayList<NhanVien_bean> dsnv;
           public int tknhanvien() throws Exception {
   			return dao.tknhanvien();
   		}
           public ArrayList<NhanVien_bean> getdsnv() throws Exception{
			return dao.getdsnv();
		}
           public String geterr(String st) {
           	String nn="^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$";
           	Pattern pt=Pattern.compile(nn);
           	Matcher ngay=pt.matcher(st);
   			if(ngay.matches()) {
   				return null;
   			}else {
   				return "Định dạng ngày sai";
   			}
   		}
           public DefaultTableModel hienthihang() throws Exception {
           	
       		String cot[]=new String[] {"Mã Nhân Viên","Họ Tên","Ngày Sinh","Email"};
       		
       		
       	       dsnv=new ArrayList<NhanVien_bean>();
       	       dsnv=getdsnv();
       		DefaultTableModel model =new DefaultTableModel(cot, 0);
       		Object[] dong;
       		int dssize = dsnv.size();
       		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
       		for (int i = 0; i < dssize; i++) {
       			dong =new Object[4];
       		                   
       			dong[0]=dsnv.get(i).getManv();
       			dong[1]=dsnv.get(i).getHoten();
       			dong[2]=format.format(dsnv.get(i).getNgaysinh());
       			dong[3]=dsnv.get(i).getEmail();
       			
       			
       			model.addRow(dong);
       		}
       		return model;
   			
   	}
           public int them(String manv, String hoten, Date ngaysinh, String email,String avatar) throws Exception  {
          	
          	try {
          	   int k= dao.Them(manv,hoten,ngaysinh,email,avatar);
          	 return k;
  			} catch (SQLException e) {
  				if(e.getErrorCode()==MYSQL_DUPLICATE_PK)
  				       return 0;
  			}
			return 1;
          	
  			
  		}
           public int  xoa(String ma) throws Exception{
   			int k=dao.xoa(ma);
   			return k;
   		}
            public int sua(String manv, String hoten, Date ngaysinh, String email,String avatar)throws Exception{
           	 
            
            	  int k= dao.bosung(manv, hoten, ngaysinh, email,avatar);
            	 return k;	
            	
   		}
            public byte[] selectIMG(String ma) throws Exception{
           	 byte[] k=dao.selectIMG(ma);
           	 return k;
   			
   		}
           
           
}
