package bo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;

import javax.swing.table.DefaultTableModel;


import bean.ChiNhanh_bean;
import bean.Hang_bean;
import bean.Loi_bean;
import dao.Hang_dao;

public class Hang_bo {
        private static final int MYSQL_DUPLICATE_PK = 2627;
		Hang_dao dao=new Hang_dao();
		public ArrayList<Loi_bean> mloi= new ArrayList<Loi_bean>();
        public int tkhang() throws Exception {
   			return dao.tkhang();
   		}
        public ArrayList<ChiNhanh_bean> getmacn() throws Exception{
			return dao.getmacn();
		}
        ArrayList<Hang_bean> dshang=dao.dshang;
    
        public ArrayList<ChiNhanh_bean> dscn;
        public ArrayList<Hang_bean> dsmahang;
        public ArrayList<Hang_bean> getHang() throws Exception{
    	   dshang=dao.getHang();
    	   return dshang;
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
        String kiemtrangay(String st) {
        	String nn="^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$";
        	Pattern pt=Pattern.compile(nn);
        	Matcher ngay=pt.matcher(st);
			if(ngay.matches()) {
				return null;
			}else {
				return "Định dạng ngày sai";
			}
        }
        String KiemTraMa(String st) {
    		if(st.length()<3)
    			return "Lỗi độ dài mã";
    			else 
    				return null;
    	}
        String ktemail(String email) {
        	String nn="^[a-z][A-Z][0-9]\\@[a-z]\\.[a-z] {3}$";
        	Pattern pt=Pattern.compile(nn);
        	Matcher ngay=pt.matcher(email);
			if(ngay.matches()) {
				return null;
			}else {
				return "email khong dung dinh dang";
			}
        	
        }
    	String KiemTraSl(Long so) {
    		if(so <=0)
    			return "Lỗi nhập số lượng ";
    			else 
    				return null;
    	}
         public DefaultTableModel hienthihang() throws Exception {
        	
        		String cot[]=new String[] {"Mã Hàng","Tên hàng","Số Lượng","Giá","Ngày Nhập","Tình Trạng","Mã Chi Nhánh"};
        		
        		
        	       dshang=dao.getHang();
        		DefaultTableModel model =new DefaultTableModel(cot, 0);
        		Object[] dong;
        		int dssize = dshang.size();
        		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        		for (int i = 0; i < dssize; i++) {
        			dong =new Object[7];
        		                   
        			dong[0]=dshang.get(i).getMaHang();
        			dong[1]=dshang.get(i).getTenHang();
        			dong[2]=dshang.get(i).getSoLuong();
        			dong[3]=dshang.get(i).getGia();
        			dong[4]=format.format(dshang.get(i).getNgayNhap());
        			dong[5]=dshang.get(i).getTinhTrang();
        			dong[6]=dshang.get(i).getMaChiNhanh();
        			
        			model.addRow(dong);
        		}
        		return model;
    			
    	}
         public DefaultComboBoxModel<ChiNhanh_bean> hienthibox() throws Exception{
        	 DefaultComboBoxModel<ChiNhanh_bean> box =new DefaultComboBoxModel<ChiNhanh_bean>();
        	 dscn=dao.getmacn();
			for (ChiNhanh_bean t : dscn) {
				box.addElement(t);				
				}
				return box;
				
		}
         public DefaultComboBoxModel<Hang_bean> hienthibanhang() throws Exception{
        	 DefaultComboBoxModel<Hang_bean> box =new DefaultComboBoxModel<Hang_bean>();
        	 dsmahang=dao.getHang();
			for (Hang_bean t : dsmahang) {
				box.addElement(t);				
				}
				return box;
				
		}
         public int them(String mahang,String tenhang,long soluong,long gia, Date ngaynhap,boolean tinhtrang,String machinhanh,String file) throws Exception  {
        	 int k=0;
        	try {
        	   k= dao.Them(mahang, tenhang, soluong, gia, ngaynhap, tinhtrang, machinhanh,file);
			} catch (SQLException e) {
				if(e.getErrorCode()==MYSQL_DUPLICATE_PK)
				       return 0;
			}
        	return k;
			
		}
         public void ThemTuFile() throws Exception{
 
     		try {
     		FileReader f= new FileReader("Hang.txt");
     		BufferedReader r= new BufferedReader(f);
     		int d = 0;
     		while(true) {
     		d++;
     			String st= r.readLine();
     			if(st==""||st==null) 
     				break;
     			String[] ds= st.split("[;]");
     			String mahang=ds[0];
     			String tenhang= ds[1];
     			long soluong=Long.parseLong(ds[2]);
     			long gia= Long.parseLong(ds[3]);
     			SimpleDateFormat dd= new SimpleDateFormat("dd/MM/yyyy");
     			Date ngaynhap= dd.parse(ds[4]);
     			Boolean tinhtrang=ds[5].equals("0")? false:true;
     			String machinhanh=ds[6];
     			Loi_bean loi=new Loi_bean();
     			String ktma=KiemTraMa(mahang);
     			String ktsl=KiemTraSl(soluong);
     			String ktngay=kiemtrangay(ds[4]);
     			
     			if(ktma!=null) {
    				loi.setLoi(ktma);loi.setDong(d);
    				mloi.add(loi);
    			}
    			else
    				if(ktsl!=null) {
    					loi.setLoi(ktsl);loi.setDong(d);
    					mloi.add(loi);
    				}else 
    					if(ktngay!=null) {
    					loi.setLoi(ktngay);loi.setDong(d);
    					mloi.add(loi);
    				}
						
					String file=null;
     			if (ktma==null&&ktsl==null) {
     				
					them(mahang, tenhang, soluong, gia, ngaynhap, tinhtrang, machinhanh,file);
				}
     				}
     		   f.close();
     		   } catch(Exception tt){
     			
     		}
     	
     	}
         public int  xoa(String ma) throws Exception{
			int k=dao.xoa(ma);
			return k;
		}
         public byte[] selectIMG(String ma) throws Exception{
        	 byte[] k=dao.selectIMG(ma);
        	 return k;
			
		}
         public int sua(String mahang,String tenhang,long soluong,long gia, Date ngaynhap,boolean tinhtrang,String machinhanh,String file)throws Exception{
        	 
         
         	  int k= dao.bosung(mahang, tenhang, soluong, gia, ngaynhap, tinhtrang, machinhanh,file);
         	 return k;
 		
 				
         	
		}
         public int suakhongcoIMG(String mahang,String tenhang,long soluong,long gia, Date ngaynhap,boolean tinhtrang,String machinhanh)throws Exception{
        	 
             
        	  int k= dao.bosungkhongcoIMG(mahang, tenhang, soluong, gia, ngaynhap, tinhtrang, machinhanh);
        	 return k;
		
				
        	
		}
         public DefaultTableModel timkiem(String mah) throws Exception {
         	
     		String cot[]=new String[] {"Mã Hàng","Tên hàng","Số Lượng","Giá","Ngày Nhập","Tình Trạng","Mã Chi Nhánh"};
     		
     		
     	       dshang=dao.timkiem(mah);
     		DefaultTableModel model =new DefaultTableModel(cot, 0);
     		Object[] dong;
     		int dssize = dshang.size();
     		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
     		for (int i = 0; i < dssize; i++) {
     			dong =new Object[7];
     		                   
     			dong[0]=dshang.get(i).getMaHang();
     			dong[1]=dshang.get(i).getTenHang();
     			dong[2]=dshang.get(i).getSoLuong();
     			dong[3]=dshang.get(i).getGia();
     			dong[4]=format.format(dshang.get(i).getNgayNhap());
     			dong[5]=dshang.get(i).getTinhTrang();
     			dong[6]=dshang.get(i).getMaChiNhanh();
     			
     			model.addRow(dong);
     		}
     		return model;
 			
 	}
  
}
