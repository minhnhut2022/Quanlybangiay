package bo;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


import bean.ChiNhanh_bean;
import dao.ChiNhanh_dao;

public class ChiNhanh_bo {
	ChiNhanh_dao dao=new ChiNhanh_dao();
                  public int tkcn() throws Exception {
					return dao.tkchinhanh();
				}
              	private static final int MYSQL_DUPLICATE_PK = 2627;
            	
            	public ArrayList<ChiNhanh_bean> ds;
                public ArrayList<ChiNhanh_bean> getChiNhanh() throws Exception{
            	   ds=dao.getdscn();
            	   return ds;
            	}
                 public DefaultTableModel hienthirabang() throws Exception {
                	
                		String cot[]=new String[] {"Mã Chi Nhánh","Tên Chi Nhánh","Địa Chỉ"};
                	         ds=dao.getdscn();
                		DefaultTableModel model =new DefaultTableModel(cot, 0);
                		Object[] dong;
                		int dssize = ds.size();
                		for (int i = 0; i < dssize; i++) {
                			dong =new Object[3];
                		
                			dong[0]=ds.get(i).getMaChiNhanh();
                			dong[1]=ds.get(i).getTenChiNhanh();
                			dong[2]=ds.get(i).getDiaChi();
                			
                			model.addRow(dong);
                		}
                		return model;
            			
            	}
            public int them(String ma,String ten,String dc) throws Exception{
             	
              	try {
              	   int k= dao.Them(ma,ten,dc);
              	 return k;
      			} catch (SQLException e) {
      				if(e.getErrorCode()==MYSQL_DUPLICATE_PK)
      				       return 0;
      			}
    			return 1;
            }
            public int xoa(String ma) throws Exception {
            	return dao.xoa(ma);
            }
            public int bosung(String ma,String ten,String dc) throws Exception{
            	return dao.bosung(ma, ten, dc);
            }
            public DefaultTableModel timkiem(String macn) throws Exception{
            	String cot[]=new String[] {"Mã Chi Nhánh","Tên Chi Nhánh","Địa Chỉ"};
            	ds=dao.timkiem(macn);
            	
            	DefaultTableModel model =new DefaultTableModel(cot, 0);
            	Object[] dong;
            	int dssize = ds.size();
            	for (int i = 0; i < dssize; i++) {
            		dong =new Object[3];
            	
            		dong[0]=ds.get(i).getMaChiNhanh();
            		dong[1]=ds.get(i).getTenChiNhanh();
            		dong[2]=ds.get(i).getDiaChi();
            		
            		model.addRow(dong);
            	}
            	return model;
            }
}
