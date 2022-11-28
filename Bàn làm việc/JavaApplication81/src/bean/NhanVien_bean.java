package bean;

import java.util.Date;

public class NhanVien_bean {
         private String manv;
         private String hoten;
         private Date ngaysinh;
         private String email;
         private String avatar;
	
         public NhanVien_bean(String manv, String hoten, Date ngaysinh, String email, String avatar) {
			super();
			this.manv = manv;
			this.hoten = hoten;
			this.ngaysinh = ngaysinh;
			this.email = email;
			this.avatar = avatar;
		}
         public NhanVien_bean(String manv) {
			this.manv=manv;
		}

		public String getManv() {
			return manv;
		}

		public void setManv(String manv) {
			this.manv = manv;
		}

		public String getHoten() {
			return hoten;
		}

		public void setHoten(String hoten) {
			this.hoten = hoten;
		}

		public Date getNgaysinh() {
			return ngaysinh;
		}

		public void setNgaysinh(Date ngaysinh) {
			this.ngaysinh = ngaysinh;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avata) {
			this.avatar = avata;
		}

		@Override
        public String toString() {
        // TODO Auto-generated method stub
        return manv;
        }
         
}
