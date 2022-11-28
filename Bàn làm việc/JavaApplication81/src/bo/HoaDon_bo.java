package bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import bean.HoaDon_bean;
import dao.HoaDon_dao;

public class HoaDon_bo {
        HoaDon_dao dao=new HoaDon_dao();
        ArrayList<HoaDon_bean> dshd;
        public int tkhoadon() throws Exception {
			return dao.tkhoadon();
		}
        public ArrayList<HoaDon_bean> getdshd() throws Exception{
			return dao.getdshd();
		}
        public DefaultTableModel hienthihang() throws Exception {
        	
    		String cot[]=new String[] {"Mã Hoá Đơn","Ngày Mua","Mã Nhân Viên","Thực Hiện"};
    		
    		
    	       dshd=new ArrayList<HoaDon_bean>();
    	       dshd=getdshd();
    		DefaultTableModel model =new DefaultTableModel(cot, 0);
    		Object[] dong;
    		int dssize = dshd.size();
    		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    		for (int i = 0; i < dssize; i++) {
    			dong =new Object[4];
    		                   
    			dong[0]=dshd.get(i).getId();
    			dong[1]=format.format(dshd.get(i).getNgaymua());
    			dong[2]=dshd.get(i).getNv();
    			dong[3]="Xem Chi Tiết >";
    			
    			
    			model.addRow(dong);
    		}
    		return model;
			
	}
        public int xoa(long ma) throws Exception{
			if(dao.xoacthd(ma)==1) {
				dao.xoahd(ma);
			}
			return 1;
		}
        public DefaultTableModel TimKiem(long ma) throws Exception {
        	
    		String cot[]=new String[] {"Mã Hoá Đơn","Ngày Mua","Mã Nhân Viên","Thực Hiện"};
    		
    		
    	       dshd=new ArrayList<HoaDon_bean>();
    	       dshd=dao.timkiem(ma);
    		DefaultTableModel model =new DefaultTableModel(cot, 0);
    		Object[] dong;
    		int dssize = dshd.size();
    		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    		for (int i = 0; i < dssize; i++) {
    			dong =new Object[4];
    		                   
    			dong[0]=dshd.get(i).getId();
    			dong[1]=format.format(dshd.get(i).getNgaymua());
    			dong[2]=dshd.get(i).getNv();
    			dong[3]="Xem Chi Tiết >";
    			
    			
    			model.addRow(dong);
    		}
    		return model;
			
	}
}
