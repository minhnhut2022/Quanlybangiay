package bean;

import java.util.Date;

public class HoaDon_bean {
            private Date ngaymua;
            private String nv;
            private long id;
			public HoaDon_bean(Date ngaymua, String nv, long id) {
				super();
				this.ngaymua = ngaymua;
				this.nv = nv;
				this.id = id;
			}
			public Date getNgaymua() {
				return ngaymua;
			}
			public void setNgaymua(Date ngaymua) {
				this.ngaymua = ngaymua;
			}
			public String getNv() {
				return nv;
			}
			public void setNv(String nv) {
				this.nv = nv;
			}
			public long getId() {
				return id;
			}
			public void setId(long id) {
				this.id = id;
			}
            
            
}
