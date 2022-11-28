package bo;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;

import bean.MixCthd_bean;
import bean.NhanVien_bean;
import dao.Cthd_Hd_dao;
import dao.MixCthd_dao;

public class Cthd_Hd_bo {
                Cthd_Hd_dao bo=new Cthd_Hd_dao();
                MixCthd_dao bomix=new MixCthd_dao();
                ArrayList<NhanVien_bean> dsnv=new ArrayList<NhanVien_bean>();
                ArrayList<MixCthd_bean> dscthd;
public int Themcthd(String mahang,long slm,long thanhtien,Date ngaymua, String manv)throws Exception{
	
	if(bo.themHDkhiban(ngaymua, manv)==1) {
		bo.themCTHDkhiban(mahang, slm, thanhtien);
		return 1;
	}
	return 0;
}
                public DefaultComboBoxModel<NhanVien_bean> hienthimanvbox() throws Exception{
               	 DefaultComboBoxModel<NhanVien_bean> box =new DefaultComboBoxModel<NhanVien_bean>();
               	 dsnv=bo.getmanv();
       			for (NhanVien_bean t : dsnv) {
       				box.addElement(t);				
       				}
       				return box;
       				
       		}
               
                public ArrayList<MixCthd_bean> xuatcthd(long mahd) throws Exception{
                	dscthd=new ArrayList<MixCthd_bean>();
                	dscthd=bomix.getcthd(mahd);
					return dscthd;
				}
                public String gettennv(String manv) throws Exception{
					String ten = null;
					for (NhanVien_bean t : bo.getTennv(manv)) {
						ten=t.getHoten();
					}
					return ten;
				}
                public int updatesl(String ma,long slmnew) throws Exception{
					return bo.upsoluong(ma, slmnew);
				}
//                public void ghivaofile(String k,long mahd) throws Exception{
//					FileOutputStream f=new FileOutputStream(k);
//					OutputStreamWriter o= new OutputStreamWriter(f);
//					PrintWriter w=new PrintWriter(o);
//					dscthd=new ArrayList<MixCthd_bean>();
//				        dscthd=bomix.getcthd(mahd);
//				        for (MixCthd_bean t : dscthd) {
//				        	
//				        	w.println("***********************************************");
//				        	w.println("**\t\tCHI TIẾT HOÁ ĐƠN\t\t**");
//				        	w.println("***********************************************");
//							w.printf("** Đơn Hàng: %58s   **",t.getMahd());w.print("\r\n");
//							w.printf("** Tên hàng: %58s   **",t.getTenhang());w.print("\r\n");
//							w.printf("** GIÁ%13s: %58s   **","",t.getGia());w.print("\r\n");
//							w.printf("** Số Lượng%13s: %58s   **","",t.getSlmua());w.print("\r\n");
//							w.println("-----------------------------------------------");w.print("\r\n");
//							w.printf("** Tổng    : %58s   **",t.getThanhtien());w.print("\r\n");
//							w.printf("** Nhân Viên : %56s   **",t.getManv());w.print("\r\n");
//							w.println("********************************************");
//							w.println("********************************************");
//							
//						}
//					
//						
//					
//                      w.close();
//					 
//				}
                
}
