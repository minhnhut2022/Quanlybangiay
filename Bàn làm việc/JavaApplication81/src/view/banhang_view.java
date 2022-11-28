package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



import bean.ChiNhanh_bean;
import bean.Hang_bean;
import bean.Loi_bean;
import bean.NhanVien_bean;
import bo.ChiNhanh_bo;
import bo.Cthd_Hd_bo;
import bo.Hang_bo;
import bo.HoaDon_bo;
import bo.NhanVien_bo;
import dao.Cthd_Hd_dao;
import dao.Hang_dao;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;

public class banhang_view extends JFrame {
	DefaultTableModel model=new DefaultTableModel();
	ChiNhanh_bo cn=new ChiNhanh_bo();
	HoaDon_bo hd=new HoaDon_bo();
	NhanVien_bo nv=new NhanVien_bo();
	Hang_bo hg=new Hang_bo();
	Cthd_Hd_bo cthd=new Cthd_Hd_bo();JLabel txtima = new JLabel("");
	
	private JPanel contentPane;
	JPanel psanpham = new JPanel();
	JPanel pnhanvien = new JPanel();
	JPanel pchinhanh = new JPanel();
	JPanel phoadon = new JPanel();
	JLabel lblHon = new JLabel("Ho\u00E1 \u0110\u01A1n");
	JLabel lblSnPhm = new JLabel("S\u1EA3n Ph\u1EA9m");
	JLabel lblNhnVin = new JLabel("Nh\u00E2n Vi\u00EAn");
	JLabel lblChiNhnh = new JLabel("Chi Nh\u00E1nh");
	private final JLabel lblQunLBn = new JLabel("Qu\u1EA3n L\u00FD B\u00E1n H\u00E0ng");
	JPanel body = new JPanel();
	JPanel bdsp = new JPanel();
	JPanel bdhd = new JPanel();
	JPanel bdcn = new JPanel();
	JPanel bdnv = new JPanel();
	private final JLabel lblSnPhm_1 = new JLabel("S\u1EA3n Ph\u1EA9m");
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JLabel label = new JLabel("");
	private final JPanel panel_5 = new JPanel();
	private final JLabel lblNewLabel = new JLabel("Mã hàng");
	private final JTextField txtmah = new JTextField();
	private final JLabel lblNewLabel_1 = new JLabel("Tên");
	private final JTextField txttenh = new JTextField();
	private final JLabel lblNewLabel_2 = new JLabel("Ngày Nhập");
	private final JTextField txtngayh = new JTextField();
	private final JLabel lblNewLabel_3 = new JLabel("Tình Trạng");
	private final JTextField txttinhh = new JTextField();
	private final JLabel lblNewLabel_4 = new JLabel("Mã CN");
	private final JLabel lblNewLabel_5 = new JLabel("Số Lượng");
	private final JTextField txtslh = new JTextField();
	private final JLabel lblNewLabel_6 = new JLabel("Giá");
	JLabel err = new JLabel("");
	private final JTextField txtgiah = new JTextField();
	private final JPanel panel_6 = new JPanel();
	private final JTable tablehang = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JPanel panel_7 = new JPanel();
	private final JButton btnNewButton = new JButton("Add");
	private final JButton btnNewButton_1 = new JButton("Edit");
	private final JButton btnNewButton_2 = new JButton("Delete");
	private final JButton btnNewButton_3 = new JButton("Search");
	private final JButton btnNewButton_4 = new JButton("Import");
	int x, y, px,py;
	JLabel txtimg = new JLabel("");
	protected static banhang_view frame;
	protected static cthd_view hoadon;
	private JTextField txttienbh;
	private JTextField txtgiabh;
	private JTextField txtslbh;
	private JTextField slmua;
	private final JButton buttonadd = new JButton("");
	private final JButton buttonsub = new JButton("");
	private final JComboBox<ChiNhanh_bean> comboBox_hang = new JComboBox<ChiNhanh_bean>();
	private final JLabel lbldash = new JLabel("Dashboard");
	JPanel pdash = new JPanel();
	private final JPanel bdtk = new JPanel();
	private final JPanel panel_9 = new JPanel();
	private final JLabel lblNewLabel_12 = new JLabel("Thống Kê Bán Hàng");
	JLabel lblNewLabel_15 = new JLabel("");
	private final JPanel panel_10 = new JPanel();
	private final JLabel tkhg = new JLabel("");
	private final JLabel lblNewLabel_13 = new JLabel("Sản Phẩm");
	private final JLabel lblNewLabel_14 = new JLabel("");
	private final JPanel panel_11 = new JPanel();
	private final JPanel panel_12 = new JPanel();
	private final JPanel panel_13 = new JPanel();
	private final JLabel tknv = new JLabel("");
	private final JLabel lblNewLabel_16 = new JLabel("Nhân Viên");
	private final JLabel label_2 = new JLabel("");
	private final JLabel tkhd = new JLabel("");
	private final JLabel lblNewLabel_17 = new JLabel("Hoá Đơn");
	private final JLabel label_4 = new JLabel("");
	private final JLabel lblChiNhnh_2 = new JLabel("Chi Nhánh");
	private final JLabel tkcn = new JLabel("");
	private final JLabel label_6 = new JLabel("");
	private final JPanel panel_19 = new JPanel();
	private final JLabel lblNhnVin_1 = new JLabel("Nhân Viên");
	private final JPanel panel_20 = new JPanel();
	private final JPanel panel_21 = new JPanel();
	private final JLabel lblMNhnVin = new JLabel("Mã Nhân Viên");
	private final JLabel lblHTn = new JLabel("Họ Tên");
	private final JTextField txthoten = new JTextField();
	private final JLabel lblEmail = new JLabel("Email");
	private final JTextField txtemail = new JTextField();
	private final JLabel lblNgySinh = new JLabel("Ngày Sinh ");
	private final JPanel panel_22 = new JPanel();
	private final JPanel panel_23 = new JPanel();
	private final JButton button_5 = new JButton("Add");
	private final JButton button_6 = new JButton("Edit");
	private final JButton button_7 = new JButton("Delete");
	private final JButton button_8 = new JButton("Search");
	private final JTextField txtngaysinh = new JTextField();
	private final JPanel panel_24 = new JPanel();
	private final JPanel panel_25 = new JPanel();
	private final JLabel lblMChiNhnh = new JLabel("Mã Chi Nhánh");
	private final JLabel lblTnChiNhnh = new JLabel("Tên Chi Nhánh");
	private final JTextField txttencn = new JTextField();
	private final JLabel lblaCh = new JLabel("Địa Chỉ");
	private final JTextField txtdccn = new JTextField();
	private final JPanel panel_26 = new JPanel();
	private final JPanel panel_27 = new JPanel();
	private final JButton button_9 = new JButton("Add");
	private final JButton button_10 = new JButton("Edit");
	private final JButton button_11 = new JButton("Delete");
	private final JButton button_12 = new JButton("Search");
	private final JPanel panel_28 = new JPanel();
	private final JLabel lblChiNhnh_1 = new JLabel("Chi Nhánh");
	private JTextField txttenbh;
	private JComboBox<Hang_bean> comboBoxmahang = new JComboBox<Hang_bean>();
	JComboBox<NhanVien_bean> comboBoxnv = new JComboBox<NhanVien_bean>();
	long coutslm=1;
	private final JLabel status = new JLabel("");
	String v;
	private JTable tbhd;
	private JTextField txtmanv;
	private final JTable tbnv = new JTable();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JLabel errnv = new JLabel("");
	JLabel errhd = new JLabel("");
	private JTextField txtmacn;
	private JTable table;
	private final JLabel errcn = new JLabel("");
	String urlImgSp;
	String urlImgNv;
	private final JLabel txtimgnv = new JLabel("");
	private final JLabel lblTrungHiuKa = new JLabel("Trung Hiếu K40A   -Gmail: dauxanhrauma000@gmail.com");
	/**
	 * 
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				frame = new banhang_view();
				
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public banhang_view() {
		setBackground(new Color(255, 255, 255));
		txtngaysinh.setBounds(138, 124, 158, 28);
		txtngaysinh.setColumns(10);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				setbgin(pdash);
				setlbin(lbldash);
			
				
				try {
					
					
					
					
					tkcn.setText(String.valueOf(cn.tkcn()));
					tkhd.setText(String.valueOf(hd.tkhoadon()));
					tknv.setText(String.valueOf(nv.tknhanvien()));
					tkhg.setText(String.valueOf(hg.tkhang()));
					Font f = new Font("Tahoma", Font.BOLD, 12);
			        tablehang.setModel(hg.hienthihang());	
			       
			         JTableHeader header = tablehang.getTableHeader();
   	                  header.setFont(f);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
			}
		});
		txtgiah.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		txtgiah.setBounds(65, 182, 158, 28);
		txtgiah.setColumns(10);
		txtslh.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		txtslh.setBounds(313, 133, 70, 28);
		txtslh.setColumns(10);
		txttinhh.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		txttinhh.setBounds(313, 78, 155, 28);
		txttinhh.setColumns(10);
		txtngayh.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		txtngayh.setBounds(313, 33, 158, 28);
		txtngayh.setColumns(10);
		txttenh.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		txttenh.setBounds(65, 78, 158, 28);
		txttenh.setColumns(10);
		txtmah.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		txtmah.setBounds(65, 33, 158, 28);
		txtmah.setColumns(10);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				px=e.getX();
				py=e.getY();
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				x=e.getXOnScreen();
				y=e.getYOnScreen();
				
			
				
				frame.setLocation(x-px,y-py);
				
				
			}

			
		
		});
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(153, 204, 204));
		panel.setBounds(0, 0, 1016, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		lblQunLBn.setForeground(new Color(0, 0, 0));
		lblQunLBn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQunLBn.setBounds(73, 11, 349, 26);
		
		panel.add(lblQunLBn);
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setBackground(new Color(255, 255, 255));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setBackground(new Color(153, 204, 204));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		panel_4.setBorder(null);
		panel_4.setBackground(new Color(153, 204, 204));
		panel_4.setBounds(928, 11, 31, 31);
		
		panel.add(panel_4);
		panel_4.setLayout(null);
		label.setBounds(0, 0, 31, 31);
		panel_4.add(label);
		label.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Delete_33px.png"));
		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(41, 56, 70));
		menu.setBounds(0, 46, 199, 513);
		contentPane.add(menu);
		menu.setLayout(null);
		
		
		
		phoadon.addMouseListener(new MouseAdapter() {
			Action xem = new AbstractAction()
			{
			    public void actionPerformed(ActionEvent e)
			    { int row = tbhd.getSelectedRow();
			      cthd_view nd=new cthd_view(); 
				   nd.frame2=new cthd_view();
				   nd.frame2 =new cthd_view();
				   nd.frame2.setVisible(true);
					
					nd.frame2.donhang.setText(String.valueOf(tbhd.getValueAt(row, 0)));
			    
			         
			    }
			};
		
			@Override
			public void mousePressed(MouseEvent arg0) {
				showhide(bdhd);
				setbgin(phoadon);
				setlbin(lblHon);
				setbgout(pnhanvien);
				setlbout(lblNhnVin);
				setbgout(psanpham);
				setlbout(lblSnPhm);
				setbgout(pchinhanh);
				setlbout(lblChiNhnh);
				setbgout(pdash);
				setlbout(lbldash);
				try {
					tbhd.setModel(hd.hienthihang());
					ButtonColumn buttonColumn = new ButtonColumn(tbhd, xem, 3);
					buttonColumn.setMnemonic(KeyEvent.VK_D);
					
					
					
				} catch (Exception e) {
					// 
					e.printStackTrace();
				}
		
			}
		});
		phoadon.setBorder(null);
		phoadon.setBackground(new Color(41, 56, 70));
		phoadon.setBounds(0, 206, 199, 62);
		menu.add(phoadon);
		phoadon.setLayout(null);
		
		
		
		lblHon.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Test Passed_40px.png"));
		lblHon.setForeground(UIManager.getColor("Button.shadow"));
		lblHon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHon.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblHon.setBounds(23, 11, 169, 42);
		phoadon.add(lblHon);
		psanpham.addMouseListener(new MouseAdapter() {
		
		
			@Override
			public void mousePressed(MouseEvent e) {
				showhide(bdsp);
				
				setbgin(psanpham);
				setlbin(lblSnPhm);
				setbgout(phoadon);
				setlbout(lblHon);
				setbgout(pnhanvien);
				setlbout(lblNhnVin);
				setbgout(pchinhanh);
				setlbout(lblChiNhnh);
				setbgout(pdash);
				setlbout(lbldash);
				try {
				comboBox_hang.setModel(hg.hienthibox());
			     comboBoxmahang.setModel(hg.hienthibanhang());
			   comboBoxnv.setModel(cthd.hienthimanvbox());
			     
			     
				err.setText("");
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
				
							}
			
		
			
		});
		
		
		psanpham.setBorder(null);
		psanpham.setBackground(new Color(41, 56, 70));
		psanpham.setBounds(0, 119, 199, 62);
		menu.add(psanpham);
		psanpham.setLayout(null);
		
		
		lblSnPhm.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Shopping Cart Loaded_40px.png"));
		lblSnPhm.setForeground(UIManager.getColor("Button.shadow"));
		lblSnPhm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSnPhm.setBounds(23, 11, 132, 40);
		psanpham.add(lblSnPhm);
		pnhanvien.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				showhide(bdnv);
				setbgin(pnhanvien);
				setlbin(lblNhnVin);
				setbgout(phoadon);
				setlbout(lblHon);
				setbgout(psanpham);
				setlbout(lblSnPhm);
				setbgout(pchinhanh);
				setlbout(lblChiNhnh);
				setbgout(pdash);
				setlbout(lbldash);
				try {
					tbnv.setModel(nv.hienthihang());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		
		pnhanvien.setBorder(null);
		pnhanvien.setBackground(new Color(41, 56, 70));
		pnhanvien.setBounds(0, 295, 199, 62);
		menu.add(pnhanvien);
		pnhanvien.setLayout(null);
		
		
		lblNhnVin.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Online Support_40px.png"));
		lblNhnVin.setForeground(UIManager.getColor("Button.shadow"));
		lblNhnVin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNhnVin.setBounds(23, 11, 147, 44);
		pnhanvien.add(lblNhnVin);
		pchinhanh.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				showhide(bdcn);
				setbgin(pchinhanh);
				setlbin(lblChiNhnh);
				setbgout(phoadon);
				setlbout(lblHon);
				setbgout(psanpham);
				setlbout(lblSnPhm);
				setbgout(pnhanvien);
				setlbout(lblNhnVin);
				setbgout(pdash);
				setlbout(lbldash);
				try {
					table.setModel(cn.hienthirabang());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		
		
		pchinhanh.setBorder(null);
		pchinhanh.setBackground(new Color(41, 56, 70));
		pchinhanh.setBounds(0, 382, 199, 62);
		menu.add(pchinhanh);
		pchinhanh.setLayout(null);
		
		
		lblChiNhnh.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Link Company Parent_40px_2.png"));
		lblChiNhnh.setForeground(UIManager.getColor("Button.shadow"));
		lblChiNhnh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChiNhnh.setBounds(20, 11, 169, 45);
		pchinhanh.add(lblChiNhnh);
		
		
		pdash.addMouseListener(new MouseAdapter() {
			/// thông kê
			@Override
			public void mousePressed(MouseEvent e) {
				showhide(bdtk);
				setbgin(pdash);
				setlbin(lbldash);
				
				setbgout(phoadon);
				setlbout(lblHon);
				setbgout(psanpham);
				setlbout(lblSnPhm);
				setbgout(pnhanvien);
				setlbout(lblNhnVin);
				setbgout(pchinhanh);
				setlbout(lblChiNhnh);
				try {
					tkcn.setText(String.valueOf(cn.tkcn()));
                    tkhd.setText(String.valueOf(hd.tkhoadon()));
                    tknv.setText(String.valueOf(nv.tknhanvien()));
                    tkhg.setText(String.valueOf(hg.tkhang()));
                    
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		pdash.setBackground(new Color(41, 56, 70));
		pdash.setBounds(0, 34, 199, 62);
		menu.add(pdash);
		pdash.setLayout(null);
		lbldash.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Speed_35px.png"));
		lbldash.setForeground(UIManager.getColor("Button.shadow"));
		lbldash.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldash.setBounds(23, 11, 136, 40);
		
		pdash.add(lbldash);
		
		
		body.setBackground(new Color(255, 255, 255));
		body.setBounds(199, 47, 817, 512);
		contentPane.add(body);
		body.setLayout(new CardLayout(0, 0));
		bdtk.setBackground(Color.WHITE);
		
		body.add(bdtk, "name_26530972087686");
		bdtk.setLayout(null);
		panel_9.setBackground(new Color(41, 56, 70));
		panel_9.setBounds(0, 0, 817, 35);
		
		bdtk.add(panel_9);
		panel_9.setLayout(null);
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_12.setBounds(323, 0, 351, 35);
		
		panel_9.add(lblNewLabel_12);
	
		panel_10.setBorder(null);
		panel_10.setBackground(new Color(26, 179, 148));
		panel_10.setBounds(30, 89, 777, 172);
		
		bdtk.add(panel_10);
		panel_10.setLayout(null);
		tkhg.setForeground(Color.WHITE);
		tkhg.setFont(new Font("Tahoma", Font.BOLD, 40));
		tkhg.setBounds(374, 23, 102, 81);
		
		panel_10.add(tkhg);
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_13.setBounds(259, 98, 217, 74);
		
		panel_10.add(lblNewLabel_13);
		lblNewLabel_14.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Shopping Cart Loaded_100px.png"));
		lblNewLabel_14.setBounds(141, 54, 108, 107);
		
		panel_10.add(lblNewLabel_14);
		panel_11.setBackground(new Color(26, 179, 148));
		panel_11.setBounds(30, 300, 238, 125);
		
		bdtk.add(panel_11);
		panel_11.setLayout(null);
		tknv.setForeground(Color.WHITE);
		tknv.setFont(new Font("Tahoma", Font.BOLD, 23));
		tknv.setBounds(132, 28, 100, 40);
		
		panel_11.add(tknv);
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_16.setBounds(111, 79, 121, 46);
		
		panel_11.add(lblNewLabel_16);
		label_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\User_73px.png"));
		label_2.setBounds(10, 11, 74, 73);
		
		panel_11.add(label_2);
		panel_12.setBackground(new Color(26, 179, 148));
		panel_12.setBounds(315, 300, 232, 125);
		
		bdtk.add(panel_12);
		panel_12.setLayout(null);
		tkhd.setForeground(Color.WHITE);
		tkhd.setFont(new Font("Tahoma", Font.BOLD, 23));
		tkhd.setBounds(136, 26, 92, 37);
		
		panel_12.add(tkhd);
		lblNewLabel_17.setForeground(Color.WHITE);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_17.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_17.setBounds(100, 74, 128, 51);
		
		panel_12.add(lblNewLabel_17);
		label_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Shopping Bag_73px.png"));
		label_4.setBounds(17, 11, 73, 73);
		
		panel_12.add(label_4);
		panel_13.setBackground(new Color(26, 179, 148));
		panel_13.setBounds(581, 300, 226, 125);
		
		bdtk.add(panel_13);
		panel_13.setLayout(null);
		lblChiNhnh_2.setForeground(Color.WHITE);
		lblChiNhnh_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblChiNhnh_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblChiNhnh_2.setBounds(78, 81, 138, 33);
		
		panel_13.add(lblChiNhnh_2);
		tkcn.setForeground(Color.WHITE);
		tkcn.setFont(new Font("Tahoma", Font.BOLD, 23));
		tkcn.setBounds(130, 28, 75, 42);
		
		panel_13.add(tkcn);
		label_6.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Client Company_73px.png"));
		label_6.setBounds(10, 11, 73, 73);
		
		panel_13.add(label_6);
		lblTrungHiuKa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTrungHiuKa.setBounds(458, 487, 349, 25);
		
		bdtk.add(lblTrungHiuKa);
		
		
		body.add(bdhd, "name_35004724572021");
		bdhd.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(41, 56, 70));
		panel_14.setBounds(0, 0, 817, 34);
		bdhd.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel lblNewLabel_18 = new JLabel("Hoá Đơn Bán Hàng");
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_18.setBounds(367, 0, 182, 34);
		panel_14.add(lblNewLabel_18);
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(0, 0, 817, 512);
		bdhd.add(panel_15);
		
		JPanel panel_17 = new JPanel();
		panel_17.setLayout(null);
		panel_17.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh S\u00E1ch Ho\u00E1 \u0110\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_17.setBackground(Color.WHITE);
		panel_17.setBounds(10, 52, 745, 356);
		panel_15.add(panel_17);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 22, 725, 323);
		panel_17.add(scrollPane_1);
		
		tbhd = new JTable();
		scrollPane_1.setViewportView(tbhd);
		
		JButton button_3 = new JButton("Delete");
		
		button_3.addActionListener(new ActionListener() {
			Action delete = new AbstractAction()
			{
			    public void actionPerformed(ActionEvent e)
			    { int row = tbhd.getSelectedRow();
			    cthd_view nd=new cthd_view(); 
				   nd.frame2=new cthd_view();
				   nd.frame2 =new cthd_view();
				   nd.frame2.setVisible(true);
					Cthd_Hd_dao test=new Cthd_Hd_dao();
					nd.frame2.donhang.setText(String.valueOf(tbhd.getValueAt(row, 0)));
			    
			         
			    }
			};
			
			public void actionPerformed(ActionEvent arg0) {
				int i=tbhd.getSelectedRow();
				if(i==-1) {
                    JOptionPane.showMessageDialog(rootPane, "Lựa chọn để xoá");
		                }
				else {

                    try {
                    	
                    	int t=JOptionPane.showConfirmDialog(rootPane, "Bạn Có Muốn xoá không","Thông báo", JOptionPane.YES_NO_OPTION);
    					if(t==JOptionPane.YES_OPTION) {
    						String d=(String) tbhd.getValueAt(tbhd.getSelectedRow(), 0).toString();
    					
    					     hd.xoa(Long.parseLong(d));
    						errhd.setText("Xoá Thành Công");
    						  errhd.setForeground(SystemColor.textHighlight);
    					}
    					
    					tbhd.setModel(hd.hienthihang());
    				
    					
    					
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
				}
			}
		});
		button_3.setBounds(560, 419, 79, 58);
		panel_15.add(button_3);
		button_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Delete_25px.png"));
		button_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setBorder(null);
		button_3.setBackground(new Color(176, 224, 230));
		
		JButton button_4 = new JButton("Search");
		button_4.addActionListener(new ActionListener() {
			Action delete = new AbstractAction()
			{
			    public void actionPerformed(ActionEvent e)
			    { int row = tbhd.getSelectedRow();
			    cthd_view nd=new cthd_view(); 
				   nd.frame2=new cthd_view();
				   nd.frame2 =new cthd_view();
				   nd.frame2.setVisible(true);
					Cthd_Hd_dao test=new Cthd_Hd_dao();
					nd.frame2.donhang.setText(String.valueOf(tbhd.getValueAt(row, 0)));
			    
			         
			    }
			};
			public void actionPerformed(ActionEvent e) {
				errhd.setText("");
				
				try {
				
					String n =  JOptionPane.showInputDialog(rootPane, "Nhập Mã Hoá Đơn");
					 ButtonColumn buttonColumn = new ButtonColumn(tbhd, delete, 3);
						buttonColumn.setMnemonic(KeyEvent.VK_D);
					
					if(n.isEmpty()) {
						 errhd.setText("Nhập đầy đủ");
						 errhd.setForeground(Color.RED);
					}else {
						    tbhd.setModel(hd.TimKiem(Long.parseLong(n)));
							 ButtonColumn buttonColumn1 = new ButtonColumn(tbhd, delete, 3);
							buttonColumn1.setMnemonic(KeyEvent.VK_D);
						    int m=0;
						    int cout=tbhd.getRowCount();
						    for (int i = 0; i < cout; i++) {
								m++;
							}
							 errhd.setText("Đã Tìm Thấy: "+m+" Kết Quả");
							 errhd.setForeground(SystemColor.RED);
					}
				} catch (Exception e1) {
				
				}
			}
		});
		button_4.setBounds(665, 419, 79, 58);
		panel_15.add(button_4);
		button_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Search_25px.png"));
		button_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_4.setBorder(null);
		button_4.setBackground(new Color(176, 224, 230));
		
		
		errhd.setBounds(132, 430, 270, 30);
		panel_15.add(errhd);
		bdsp.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(47, 79, 79), new Color(47, 79, 79), new Color(47, 79, 79), new Color(47, 79, 79)));
		bdsp.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		bdsp.setBackground(new Color(255, 255, 255));
		
		
		body.add(bdsp, "name_34995252313965");
		bdsp.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(41, 56, 70));
		panel_1.setBounds(0, 0, 817, 35);
		bdsp.add(panel_1);
		panel_1.setLayout(null);
		lblSnPhm_1.setBounds(354, 0, 257, 36);
		lblSnPhm_1.setForeground(Color.WHITE);
		lblSnPhm_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSnPhm_1.setBackground(Color.WHITE);
		panel_1.add(lblSnPhm_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(0, 33, 817, 479);
		bdsp.add(tabbedPane);
		panel_2.setBackground(new Color(255, 255, 255));
		
		tabbedPane.addTab("Thông Tin Sản Phẩm", null, panel_2, null);
		panel_2.setLayout(null);
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 14), new Color(0, 0, 0)));
		panel_5.setBounds(10, 0, 701, 213);
		
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 28, 58, 39);
		
		panel_5.add(lblNewLabel);
		
		panel_5.add(txtmah);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 73, 58, 39);
		
		panel_5.add(lblNewLabel_1);
		
		panel_5.add(txttenh);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(245, 31, 70, 32);
		
		panel_5.add(lblNewLabel_2);
		
		panel_5.add(txtngayh);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(245, 85, 70, 14);
		
		panel_5.add(lblNewLabel_3);
		
		panel_5.add(txttinhh);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 133, 46, 28);
		
		panel_5.add(lblNewLabel_4);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(245, 133, 58, 28);
		
		panel_5.add(lblNewLabel_5);
		
		panel_5.add(txtslh);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(10, 182, 64, 28);
		
		panel_5.add(lblNewLabel_6);
		
		panel_5.add(txtgiah);
		comboBox_hang.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		comboBox_hang.setBounds(65, 136, 158, 25);
		
		panel_5.add(comboBox_hang);
		
		JButton btnChnnh = new JButton("Chọn Ảnh");
		btnChnnh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChnnh.setBorder(null);
		btnChnnh.setBackground(new Color(135, 206, 235));
		btnChnnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFileChooser fileChooser = new JFileChooser();
		         //fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		         FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg","gif","png");
		         fileChooser.addChoosableFileFilter(filter);
		         int result = fileChooser.showSaveDialog(null);
		         if(result == JFileChooser.APPROVE_OPTION){
		             File selectedFile = fileChooser.getSelectedFile();
		             String path = selectedFile.getAbsolutePath();
		             txtima.setIcon(ResizeImage(path));
		             urlImgSp = path;
		              }
		         else if(result == JFileChooser.CANCEL_OPTION){
		             System.out.println("Chưa Có Ảnh");
		         }
			  
				
				
			}
		});
		btnChnnh.setBounds(532, 168, 122, 28);
		panel_5.add(btnChnnh);
		
		
		txtima.setBounds(497, 28, 194, 115);
		panel_5.add(txtima);
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBorder(new TitledBorder(null, "Danh S\u00E1ch S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 13), new Color(0, 0, 0)));
		panel_6.setBounds(10, 243, 685, 202);
		
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 21, 616, 170);
		
		panel_6.add(scrollPane);
		tablehang.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int n=tablehang.getSelectedRow();
				err.setText("");
				txtmah.setText((String) tablehang.getValueAt(n, 0));
				txttenh.setText((String) tablehang.getValueAt(n, 1));
				txtslh.setText(String.valueOf(tablehang.getValueAt(n, 2)));
				txtgiah.setText(String.valueOf(tablehang.getValueAt(n, 3)));
				txtngayh.setText(String.valueOf(tablehang.getValueAt(n, 4)));
				txttinhh.setText(String.valueOf(tablehang.getValueAt(n, 5)));
				 comboBox_hang.setSelectedItem(tablehang.getValueAt(n, 6));
			    
				 String main=tablehang.getValueAt(tablehang.getSelectedRow(), 0).toString();
				 try {
					
					
					txtima.setIcon(testicon(hg.selectIMG(main),txtima));
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				}
				
			}
		});
		tablehang.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(tablehang);
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBorder(new TitledBorder(null, "Th\u1EF1c Hi\u1EC7n", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 13), new Color(0, 0, 0)));
		panel_7.setBounds(713, 12, 99, 332);
		
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				try {
//				       Hang_dao test=new Hang_dao();
//				      System.out.println();
//				     txtima.setIcon(testicon(test.selectIMG("SP09")));
				       
				       
					if((txtmah.getText().isEmpty()||txttenh.getText().isEmpty()||txtslh.getText().isEmpty()||txtgiah.getText().isEmpty()||txtngayh.getText().isEmpty()||txttinhh.getText().isEmpty()||urlImgSp.isEmpty())==false) {
						if(hg.geterr(txtngayh.getText())==null) {
						int them=hg.them(txtmah.getText(), txttenh.getText(), Long.parseLong(txtslh.getText()), Long.parseLong(txtgiah.getText()), sdf.parse(txtngayh.getText()),Boolean.parseBoolean(txttinhh.getText()), comboBox_hang.getSelectedItem().toString(),urlImgSp);
						  if(them==1) {
							hg.them(txtmah.getText(), txttenh.getText(), Long.parseLong(txtslh.getText()), Long.parseLong(txtgiah.getText()), sdf.parse(txtngayh.getText()),Boolean.parseBoolean(txttinhh.getText()), comboBox_hang.getSelectedItem().toString(),urlImgSp);
							err.setText("Thêm Thành Công");
							victory();
							tablehang.setModel(hg.hienthihang());
							
						        }
						     else {
							err.setText("Mã Hàng không được trùng, Vui Lòng thay đổi!!!");
							fail();
						          }
						    }else {
							err.setText(hg.geterr(txtngayh.getText()));
							fail();
						}
					}
					else {
						err.setText("Vui Lòng Nhập đầy đủ");
						fail();
					}
				tablehang.setModel(hg.hienthihang());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\BanHang\\Image\\Add Shopping Cart_25px.png"));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(10, 36, 79, 58);
		
		panel_7.add(btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try {
				   if(urlImgSp==null) {
					   //System.out.println("không có ảnh");
					   if((txtmah.getText().isEmpty()||txttenh.getText().isEmpty()||txtslh.getText().isEmpty()||txtgiah.getText().isEmpty()||txtngayh.getText().isEmpty()||txttinhh.getText().isEmpty())==false) {
							if(hg.geterr(txtngayh.getText())==null) {
						int n = hg.suakhongcoIMG(txtmah.getText(), txttenh.getText(), Long.parseLong(txtslh.getText()), Long.parseLong(txtgiah.getText()), sdf.parse(txtngayh.getText()),Boolean.parseBoolean(txttinhh.getText()), comboBox_hang.getSelectedItem().toString());
						
						      err.setText("");
						if(n==1) {
							
							//hg.sua(txtmah.getText(), txttenh.getText(), Long.parseLong(txtslh.getText()), Long.parseLong(txtgiah.getText()), sdf.parse(txtngayh.getText()),Boolean.parseBoolean(txttinhh.getText()), comboBox_hang.getSelectedItem().toString(),txtima.getIcon().toString());
							  err.setText("Bổ Sung Thành công!!!");
							  victory();
						tablehang.setModel(hg.hienthihang());
							
						}else
						{
							 err.setText("Bổ Sung Không Thành công!!!");
							fail();
						}
							}else {
								err.setText(hg.geterr(txtngayh.getText()));
								fail();
							}
						}else {
							err.setText("Nhập đầy Đủ các Thông tin trên !!!");
						fail();
							
						tablehang.setModel(hg.hienthihang());
						}     
					   
				   }else {
						if((txtmah.getText().isEmpty()||txttenh.getText().isEmpty()||txtslh.getText().isEmpty()||txtgiah.getText().isEmpty()||txtngayh.getText().isEmpty()||txttinhh.getText().isEmpty())==false) {
							if(hg.geterr(txtngayh.getText())==null) {
						int n = hg.sua(txtmah.getText(), txttenh.getText(), Long.parseLong(txtslh.getText()), Long.parseLong(txtgiah.getText()), sdf.parse(txtngayh.getText()),Boolean.parseBoolean(txttinhh.getText()), comboBox_hang.getSelectedItem().toString(),urlImgSp);
						
						      err.setText("");
						if(n==1) {
							
							//hg.sua(txtmah.getText(), txttenh.getText(), Long.parseLong(txtslh.getText()), Long.parseLong(txtgiah.getText()), sdf.parse(txtngayh.getText()),Boolean.parseBoolean(txttinhh.getText()), comboBox_hang.getSelectedItem().toString(),txtima.getIcon().toString());
							  err.setText("Bổ Sung Thành công!!!");
							  victory();
						tablehang.setModel(hg.hienthihang());
							
						}else
						{
							 err.setText("Bổ Sung Không Thành công!!!");
							fail();
						}
							}else {
								err.setText(hg.geterr(txtngayh.getText()));
								fail();
							}
						}else {
							err.setText("Nhập đầy Đủ các Thông tin trên !!!");
						fail();
							
						tablehang.setModel(hg.hienthihang());
						}
					
				   }
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnNewButton_1.setBackground(new Color(176, 224, 230));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Edit Property_25px.png"));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(10, 93, 79, 58);
		
		panel_7.add(btnNewButton_1);
		btnNewButton_2.setBackground(new Color(176, 224, 230));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Delete_25px.png"));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int k=tablehang.getSelectedRow();
				if(k==-1) {
                    JOptionPane.showMessageDialog(rootPane, "Lựa chọn để xoá");
		                }
				else {

                    try {
                    	
                    	int t=JOptionPane.showConfirmDialog(rootPane, "Bạn Có Muốn xoá không","Thông báo", JOptionPane.YES_NO_OPTION);
    					if(t==JOptionPane.YES_OPTION) {
    						
    						hg.xoa(tablehang.getValueAt(k, 0).toString());
    						err.setText("Xoá Thành Công");
    						victory();
    					}
    					
    				tablehang.setModel(hg.hienthihang());
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
				
			}
			}
		});
		btnNewButton_2.setBounds(10, 150, 79, 58);
		
		panel_7.add(btnNewButton_2);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				err.setText("");
				try {
					tablehang.setModel(hg.hienthihang());
					String n =  JOptionPane.showInputDialog(rootPane, "Nhập Mã CN");
					
					
					if(n.isEmpty()) {
						 err.setText("Nhập đầy đủ");
						 err.setForeground(Color.RED);
					}else {
						tablehang.setModel(hg.timkiem(n));
						    int m=0;
						    int cout=tablehang.getRowCount();
						    for (int i = 0; i < cout; i++) {
								m++;
							}
							 err.setText("Đã Tìm Thấy: "+m+" Kết Quả");
							 err.setForeground(SystemColor.RED);
					}
				} catch (Exception e1) {
				
				}
			}
		});
		btnNewButton_3.setBackground(new Color(176, 224, 230));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Search_25px.png"));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBounds(10, 205, 79, 58);
		
		panel_7.add(btnNewButton_3);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					err.setText("");
					hg.ThemTuFile();
					tablehang.setModel(hg.hienthihang());
					for(Loi_bean l: hg.mloi)
						System.out.println("Dòng: "+l.getDong()+":"+l.getLoi());
					 
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBackground(new Color(176, 224, 230));
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Add File_25px_1.png"));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBounds(10, 263, 79, 58);
		
		panel_7.add(btnNewButton_4);
		
		
		err.setFont(new Font("Tahoma", Font.BOLD, 12));
		err.setBounds(164, 216, 394, 30);
		panel_2.add(err);
		panel_3.setBackground(new Color(255, 255, 255));
		
		tabbedPane.addTab("  Bán Sản Phẩm   ", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton buttonsell = new JButton("Bán");
		buttonsell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					
					Date n=new Date();
					
					String dateString  = sdf.format(n);
					int kt=cthd.Themcthd(comboBoxmahang.getSelectedItem().toString(), Long.parseLong(slmua.getText()), Long.parseLong(txttienbh.getText()), sdf.parse(dateString), comboBoxnv.getSelectedItem().toString());
				   if(kt==1) {
					   cthd_view nd=new cthd_view(); 
					   nd.frame2=new cthd_view();
					 
					   nd.frame2.setVisible(true);
						Cthd_Hd_dao test=new Cthd_Hd_dao();
						nd.frame2.donhang.setText(String.valueOf(test.laymahd()));
						
						long s2=Long.parseLong(slmua.getText().toString());
					
						long s3=Long.parseLong(txtslbh.getText().toString())-s2;
				     test.upsoluong(comboBoxmahang.getSelectedItem().toString(), s3);
				   
				     tablehang.setModel(hg.hienthihang());
				     showhide(bdsp);
				   
				   }
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		buttonsell.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Shopping Cart Loaded_64px.png"));
		buttonsell.setBackground(new Color(176, 224, 230));
		buttonsell.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192)));
		buttonsell.setFont(new Font("Tahoma", Font.BOLD, 15));
		buttonsell.setBounds(607, 337, 152, 87);
		panel_3.add(buttonsell);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(33, 11, 511, 427);
		panel_3.add(panel_8);
		panel_8.setLayout(null);
		comboBoxmahang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				 Hang_bean hagbean=(Hang_bean) comboBoxmahang.getSelectedItem();
				 // Set Hình Cho Sản Phẩm
				 try {
					txtimg.setIcon(testicon(hg.selectIMG(hagbean.getMaHang()),txtimg));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				}
				  
				 if((String.valueOf(hagbean.getTinhTrang()))=="true") {
					 lblNewLabel_15.setText("");
					    buttonadd.setEnabled(true);
					   buttonsub.setEnabled(true);
					   buttonsell.setEnabled(true);
					  
					                
					    txttenbh.setText(hagbean.getTenHang());    
					    if(hagbean.getSoLuong()==0) {
					    	 buttonsell.setEnabled(false);
					    	 long coutslm=0;
					    	 txtslbh.setText(String.valueOf(hagbean.getSoLuong()));
							 
						       slmua.setText(String.valueOf(coutslm));
						       long j=Long.parseLong(slmua.getText());
					           long sub=Long.parseLong(txtslbh.getText());
					           long hieu=sub-j;
					           status.setText("(Còn "+hieu+" Sản phẩm)");
						     long tien=(hagbean.getGia())*(coutslm);
						     txttienbh.setText(String.valueOf(tien));
						     buttonadd.setEnabled(false);
						     buttonsub.setEnabled(false);
					    	
					     }else {
					    	  txtgiabh.setText(String.valueOf(hagbean.getGia()));
							    
							     txtslbh.setText(String.valueOf(hagbean.getSoLuong()));
							 
							       slmua.setText(String.valueOf(coutslm));
							       long j=Long.parseLong(slmua.getText());
						           long sub=Long.parseLong(txtslbh.getText());
						           long hieu=sub-j;
						           status.setText("(Còn "+hieu+" Sản phẩm)");
							     long tien=(hagbean.getGia())*(coutslm);
							     txttienbh.setText(String.valueOf(tien));
						}
					   
					   
			}else {
				lblNewLabel_15.setText("*Hàng có tình trạng không tốt vui lòng lựa chọn mặt hàng khác*");
				buttonsell.setEnabled(false);
			}
			}
			
		});

	
		
		
		comboBoxmahang.setBounds(188, 15, 166, 30);
		panel_8.add(comboBoxmahang);
		comboBoxmahang.setBorder(null);
		
		txtgiabh = new JTextField();
		txtgiabh.setHorizontalAlignment(SwingConstants.CENTER);
		txtgiabh.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtgiabh.setDisabledTextColor(Color.WHITE);
		txtgiabh.setEditable(false);
		txtgiabh.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtgiabh.setBackground(Color.WHITE);
		txtgiabh.setBounds(188, 150, 133, 30);
		panel_8.add(txtgiabh);
		txtgiabh.setColumns(10);
		
		txtslbh = new JTextField();
		txtslbh.setHorizontalAlignment(SwingConstants.CENTER);
		txtslbh.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtslbh.setEditable(false);
		txtslbh.setBackground(Color.WHITE);
		txtslbh.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtslbh.setBounds(190, 204, 131, 29);
		panel_8.add(txtslbh);
		txtslbh.setColumns(10);
		
		slmua = new JTextField();
		slmua.setHorizontalAlignment(SwingConstants.CENTER);
		slmua.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		slmua.setEditable(false);
		slmua.setFont(new Font("Tahoma", Font.BOLD, 12));
		slmua.setBackground(Color.WHITE);
		slmua.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
			}
		});
	
		slmua.setBounds(260, 261, 109, 30);
		panel_8.add(slmua);
		slmua.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Chọn Mã Hàng");
		lblNewLabel_7.setBounds(59, 11, 102, 37);
		panel_8.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_8 = new JLabel("Giá");
		lblNewLabel_8.setBounds(59, 153, 102, 22);
		panel_8.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txttienbh = new JTextField();
		txttienbh.setHorizontalAlignment(SwingConstants.CENTER);
		txttienbh.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
	
	
		txttienbh.setEditable(false);
		txttienbh.setFont(new Font("Tahoma", Font.BOLD, 12));
		txttienbh.setForeground(Color.BLACK);
		txttienbh.setBackground(Color.WHITE);
		txttienbh.setBounds(188, 327, 135, 30);
		panel_8.add(txttienbh);
		txttienbh.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Số Lượng");
		lblNewLabel_9.setBounds(59, 218, 60, 15);
		panel_8.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_10 = new JLabel("Nhập Số Lượng Mua");
		lblNewLabel_10.setBounds(59, 267, 127, 16);
		panel_8.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_11 = new JLabel("Thành Tiền");
		lblNewLabel_11.setBounds(59, 326, 93, 30);
		panel_8.add(lblNewLabel_11);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonadd.setEnabled(false);
		buttonadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			long getslm=Long.parseLong(slmua.getText());
			long slbanra=Long.parseLong(txtslbh.getText());
			long giaban=Long.parseLong(txtgiabh.getText());
			getslm=getslm+1;
			buttonsell.setEnabled(true);
			if(getslm==slbanra) {
				buttonadd.setEnabled(false);
			}
			if(getslm<slbanra) {
				buttonsub.setEnabled(true);
			}
			long hieu=slbanra-getslm;
			  status.setText("(Còn "+hieu+" Sản phẩm)");
              slmua.setText(String.valueOf(getslm));
              txttienbh.setText(String.valueOf(giaban*getslm));
			}
		});
		buttonadd.setBackground(new Color(255, 255, 255));
		buttonadd.setBorder(null);
		buttonadd.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Plus_33px_1.png"));
		buttonadd.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonadd.setBounds(380, 261, 33, 30);
		
		panel_8.add(buttonadd);
		buttonsub.setEnabled(false);
		buttonsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				long getslm=Long.parseLong(slmua.getText());
				long slbanra=Long.parseLong(txtslbh.getText());
				long giaban=Long.parseLong(txtgiabh.getText());
				getslm=getslm-1;
				long hieu=slbanra-getslm;
				
					if(getslm==0) {
						buttonsell.setEnabled(false);
					}
						if(hieu==slbanra) {
							buttonsub.setEnabled(false);
						}
						if(hieu<slbanra) {
							buttonadd.setEnabled(true);
						}
				
				
				  status.setText("(Còn "+hieu+" Sản phẩm)");
	              slmua.setText(String.valueOf(getslm));
	              txttienbh.setText(String.valueOf(giaban*getslm));
			}
		});
		buttonsub.setBorder(null);
		buttonsub.setBackground(new Color(255, 255, 255));
		buttonsub.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Minus_33px.png"));
		buttonsub.setBounds(214, 261, 33, 33);
		
		panel_8.add(buttonsub);
		
		JLabel lblTnHng = new JLabel("Tên Hàng");
		lblTnHng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTnHng.setBounds(59, 80, 102, 30);
		panel_8.add(lblTnHng);
		
		txttenbh = new JTextField();
		txttenbh.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(64, 64, 64), new Color(64, 64, 64), new Color(64, 64, 64), new Color(64, 64, 64)));
		txttenbh.setBackground(Color.WHITE);
		txttenbh.setDisabledTextColor(Color.WHITE);
		txttenbh.setEditable(false);
		txttenbh.setFont(new Font("Tahoma", Font.BOLD, 12));
		txttenbh.setBounds(188, 81, 171, 30);
		panel_8.add(txttenbh);
		txttenbh.setColumns(10);
		status.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		status.setForeground(Color.RED);
		status.setBounds(343, 211, 111, 14);
		
		panel_8.add(status);
		
		JLabel lblMNvBn = new JLabel("Mã NV Bán Hàng");
		lblMNvBn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMNvBn.setBounds(59, 394, 119, 22);
		panel_8.add(lblMNvBn);
		
		
		comboBoxnv.setBounds(188, 386, 140, 30);
		panel_8.add(comboBoxnv);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_15.setForeground(Color.RED);
		
		
		lblNewLabel_15.setBounds(103, 55, 367, 14);
		panel_8.add(lblNewLabel_15);
		
		
		txtimg.setBounds(585, 78, 217, 128);
		panel_3.add(txtimg);
		
		JLabel lblnhSnPhm = new JLabel("Ảnh Sản Phẩm");
		lblnhSnPhm.setForeground(Color.BLACK);
		lblnhSnPhm.setBackground(Color.WHITE);
		lblnhSnPhm.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblnhSnPhm.setBounds(650, 21, 109, 35);
		panel_3.add(lblnhSnPhm);
		tabbedPane.setFont( new Font( "Tahoma", Font.BOLD, 13 ) );
		
		
		body.add(bdcn, "name_35006531120342");
		bdcn.setLayout(null);
		panel_24.setLayout(null);
		panel_24.setBackground(Color.WHITE);
		panel_24.setBounds(0, 0, 817, 512);
		
		bdcn.add(panel_24);
		panel_25.setLayout(null);
		panel_25.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi Nh\u00E1nh", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_25.setBackground(Color.WHITE);
		panel_25.setBounds(10, 40, 636, 202);
		
		panel_24.add(panel_25);
		lblMChiNhnh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMChiNhnh.setBounds(10, 28, 118, 39);
		
		panel_25.add(lblMChiNhnh);
		lblTnChiNhnh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTnChiNhnh.setBounds(10, 84, 118, 39);
		
		panel_25.add(lblTnChiNhnh);
		txttencn.setColumns(10);
		txttencn.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		txttencn.setBounds(138, 89, 158, 28);
		
		panel_25.add(txttencn);
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblaCh.setBounds(20, 146, 118, 28);
		
		panel_25.add(lblaCh);
		txtdccn.setColumns(10);
		txtdccn.setBounds(138, 146, 158, 28);
		
		panel_25.add(txtdccn);
		
		txtmacn = new JTextField();
		txtmacn.setBounds(138, 37, 158, 30);
		panel_25.add(txtmacn);
		txtmacn.setColumns(10);
		panel_26.setLayout(null);
		panel_26.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh S\u00E1ch Chi Nh\u00E1nh", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_26.setBackground(Color.WHITE);
		panel_26.setBounds(10, 293, 636, 202);
		
		panel_24.add(panel_26);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 25, 616, 166);
		panel_26.add(scrollPane_3);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int i=table.getSelectedRow();
				txtmacn.setText((String) table.getValueAt(i, 0));
				txttencn.setText((String) table.getValueAt(i, 1));
				txtdccn.setText((String) table.getValueAt(i, 2));
				
				
			}
		});
		scrollPane_3.setViewportView(table);
		panel_27.setLayout(null);
		panel_27.setBorder(new TitledBorder(null, "Th\u1EF1c Hi\u1EC7n", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 13), new Color(0, 0, 0)));
		panel_27.setBackground(Color.WHITE);
		panel_27.setBounds(656, 50, 99, 277);
		
		panel_24.add(panel_27);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                       try {
					
					if((txtmacn.getText().isEmpty()||txttencn.getText().isEmpty()||txtdccn.getText().isEmpty())==false) {
						
						
						int deo=cn.them(txtmacn.getText(), txttencn.getText(), txtdccn.getText());
						
						  if(deo==1) {
							  cn.them(txtmacn.getText(), txttencn.getText(), txtdccn.getText());
							   errcn.setText("Thêm Thành Công");
							    victory();
							   table.setModel(cn.hienthirabang());
							
						        }
						     else {
							 errcn.setText("Mã ChiNhanh không được trùng, Vui Lòng thay đổi!!!");
							  fail();
						          }
						
					}
					else {
						errnv.setText("Vui Lòng Nhập đầy đủ");
						fail();
					}
					table.setModel(cn.hienthirabang());
				} catch (Exception cc) {
					cc.printStackTrace();
				}

				
			}
		});
		button_9.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Add File_25px_1.png"));
		button_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_9.setBorder(null);
		button_9.setBackground(new Color(176, 224, 230));
		button_9.setBounds(10, 36, 79, 58);
		
		panel_27.add(button_9);
		button_10.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Edit Property_25px.png"));
		button_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_10.setBorder(null);
		button_10.setBackground(new Color(176, 224, 230));
		button_10.setBounds(10, 93, 79, 58);
		
		panel_27.add(button_10);
		button_11.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Delete_25px.png"));
		button_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_11.setBorder(null);
		button_11.setBackground(new Color(176, 224, 230));
		button_11.setBounds(10, 150, 79, 58);
		
		panel_27.add(button_11);
		button_12.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Search_25px.png"));
		button_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_12.setBorder(null);
		button_12.setBackground(new Color(176, 224, 230));
		button_12.setBounds(10, 205, 79, 58);
		
		panel_27.add(button_12);
		panel_28.setLayout(null);
		panel_28.setBackground(new Color(41, 56, 70));
		panel_28.setBounds(0, 0, 817, 34);
		
		panel_24.add(panel_28);
		lblChiNhnh_1.setForeground(Color.WHITE);
		lblChiNhnh_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChiNhnh_1.setBounds(367, 0, 182, 34);
		
		panel_28.add(lblChiNhnh_1);
		errcn.setForeground(Color.RED);
		errcn.setBounds(192, 253, 282, 22);
		
		panel_24.add(errcn);
		
		
		body.add(bdnv, "name_35008041024297");
		bdnv.setLayout(null);
		panel_20.setLayout(null);
		panel_20.setBackground(Color.WHITE);
		panel_20.setBounds(0, 0, 817, 512);
		
		bdnv.add(panel_20);
		panel_21.setLayout(null);
		panel_21.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nh\u00E2n Vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_21.setBackground(Color.WHITE);
		panel_21.setBounds(10, 40, 636, 226);
		
		panel_20.add(panel_21);
		lblMNhnVin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMNhnVin.setBounds(10, 28, 118, 39);
		
		panel_21.add(lblMNhnVin);
		lblHTn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHTn.setBounds(10, 73, 118, 39);
		
		panel_21.add(lblHTn);
		txthoten.setColumns(10);
		txthoten.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128), new Color(128, 128, 128)));
		txthoten.setBounds(138, 78, 158, 28);
		
		panel_21.add(txthoten);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(10, 183, 70, 32);
		
		panel_21.add(lblEmail);
		txtemail.setColumns(10);
		txtemail.setBounds(138, 185, 158, 28);
		
		panel_21.add(txtemail);
		lblNgySinh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgySinh.setBounds(10, 133, 118, 28);
		
		panel_21.add(lblNgySinh);
		
		panel_21.add(txtngaysinh);
		
		txtmanv = new JTextField();
		txtmanv.setBounds(138, 37, 158, 26);
		panel_21.add(txtmanv);
		txtmanv.setColumns(10);
		txtimgnv.setBounds(434, 28, 158, 145);
		
		panel_21.add(txtimgnv);
		
		JButton btnChnnh_1 = new JButton("Chọn Ảnh");
		btnChnnh_1.setForeground(new Color(0, 0, 0));
		btnChnnh_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChnnh_1.setBorder(null);
		btnChnnh_1.setBackground(new Color(135, 206, 235));
		btnChnnh_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFileChooser fileChooser = new JFileChooser();
		         //fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		         FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg","gif","png");
		         fileChooser.addChoosableFileFilter(filter);
		         int result = fileChooser.showSaveDialog(null);
		         if(result == JFileChooser.APPROVE_OPTION){
		             File selectedFile = fileChooser.getSelectedFile();
		             String path = selectedFile.getAbsolutePath();
		             txtimgnv.setIcon(ResizeImage(path));
		             urlImgNv = path;
		              }
		         else if(result == JFileChooser.CANCEL_OPTION){
		             System.out.println("Chưa Có Ảnh");
		         }
			}
		});
		btnChnnh_1.setBounds(447, 183, 136, 32);
		panel_21.add(btnChnnh_1);
		panel_22.setLayout(null);
		panel_22.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh S\u00E1ch Nh\u00E2n Vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_22.setBackground(Color.WHITE);
		panel_22.setBounds(10, 293, 636, 202);
		
		panel_20.add(panel_22);
		scrollPane_2.setBounds(10, 26, 616, 165);
		
		panel_22.add(scrollPane_2);
		tbnv.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int i=tbnv.getSelectedRow();
				err.setText("");
				 String main=tbnv.getValueAt(tbnv.getSelectedRow(), 0).toString();
				 try {
					txtimgnv.setIcon(testicon(nv.selectIMG(main),txtimgnv));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				}
				
				txtmanv.setText((String) tbnv.getValueAt(i, 0));
				txthoten.setText((String) tbnv.getValueAt(i, 1));
				txtngaysinh.setText((String) tbnv.getValueAt(i, 2));
				txtemail.setText((String) tbnv.getValueAt(i, 3));
				
				
			}
		});
		scrollPane_2.setViewportView(tbnv);
		panel_23.setLayout(null);
		panel_23.setBorder(new TitledBorder(null, "Th\u1EF1c Hi\u1EC7n", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 13), new Color(0, 0, 0)));
		panel_23.setBackground(Color.WHITE);
		panel_23.setBounds(708, 58, 99, 277);
		
		panel_20.add(panel_23);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
				try {
					
					if((txtmanv.getText().isEmpty()||txthoten.getText().isEmpty()||txtngaysinh.getText().isEmpty()||txtemail.getText().isEmpty()||urlImgNv.isEmpty())==false) {
						
						if(nv.geterr(txtngaysinh.getText())==null) {
						int deo=nv.them(txtmanv.getText(), txthoten.getText(), sdf.parse(txtngaysinh.getText()), txtemail.getText(),urlImgNv);
						
						  if(deo==1) {
							  nv.them(txtmanv.getText(), txthoten.getText(), sdf.parse(txtngaysinh.getText()), txtemail.getText(),urlImgNv);
							   errnv.setText("Thêm Thành Công");
							    victory();
							   tbnv.setModel(nv.hienthihang());
							
						        }
						     else {
							 errnv.setText("Mã Nhân Viên không được trùng, Vui Lòng thay đổi!!!");
							  fail();
						          }
						    }else {
							errnv.setText(hg.geterr(txtngaysinh.getText()));
							fail();
						}
					}
					else {
						errnv.setText("Vui Lòng Nhập đầy đủ");
						fail();
					}
					tbnv.setModel(nv.hienthihang());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		button_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Add File_25px_1.png"));
		button_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_5.setBorder(null);
		button_5.setBackground(new Color(176, 224, 230));
		button_5.setBounds(10, 36, 79, 58);
		
		panel_23.add(button_5);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try {
					if((txtmanv.getText().isEmpty()||txthoten.getText().isEmpty()||txtngaysinh.getText().isEmpty()||txtemail.getText().isEmpty()||urlImgNv.isEmpty())==false) {
						if(nv.geterr(txtngaysinh.getText())==null) {
					int n = nv.sua(txtmanv.getText(), txthoten.getText(), sdf.parse(txtngaysinh.getText()), txtemail.getText(),urlImgNv);
					
					      errnv.setText("");
					if(n==1) {
						nv.sua(txtmanv.getText(), txthoten.getText(), sdf.parse(txtngaysinh.getText()), txtemail.getText(),urlImgNv);
						  errnv.setText("Bổ Sung Thành công!!!");
						  victory();
					tbnv.setModel(nv.hienthihang());
						
					}else
					{
						 errnv.setText("Bổ Sung Không Thành công!!!");
						fail();
					}
						}else {
							errnv.setText(nv.geterr(txtngaysinh.getText()));
							fail();
						}
					}else {
						errnv.setText("Nhập đầy Đủ các Thông tin trên !!!");
					fail();
						
					tbnv.setModel(nv.hienthihang());
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		button_6.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Edit Property_25px.png"));
		button_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_6.setBorder(null);
		button_6.setBackground(new Color(176, 224, 230));
		button_6.setBounds(10, 93, 79, 58);
		
		panel_23.add(button_6);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k=tbnv.getSelectedRow();
				if(k==-1) {
                    JOptionPane.showMessageDialog(rootPane, "Lựa chọn để xoá");
		                }
				else {

                    try {
                    	
                    	int t=JOptionPane.showConfirmDialog(rootPane, "Bạn Có Muốn xoá không","Thông báo", JOptionPane.YES_NO_OPTION);
    					if(t==JOptionPane.YES_OPTION) {
    						
    						nv.xoa(tbnv.getValueAt(k, 0).toString());
    						errnv.setText("Xoá Thành Công");
    						victory();
    					}
    					
    				tbnv.setModel(nv.hienthihang());
    				} catch (Exception t) {
    					t.printStackTrace();
    				}
				
				}
			}
		  });
		button_7.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Delete_25px.png"));
		button_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_7.setBorder(null);
		button_7.setBackground(new Color(176, 224, 230));
		button_7.setBounds(10, 150, 79, 58);
		
		panel_23.add(button_7);
		button_8.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Search_25px.png"));
		button_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_8.setBorder(null);
		button_8.setBackground(new Color(176, 224, 230));
		button_8.setBounds(10, 205, 79, 58);
		
		panel_23.add(button_8);
		panel_19.setBounds(0, 0, 817, 34);
		panel_20.add(panel_19);
		panel_19.setLayout(null);
		panel_19.setBackground(new Color(41, 56, 70));
		lblNhnVin_1.setForeground(Color.WHITE);
		lblNhnVin_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNhnVin_1.setBounds(367, 0, 182, 34);
		
		panel_19.add(lblNhnVin_1);
		errnv.setBounds(315, 267, 272, 26);
		
		panel_20.add(errnv);
	}
	public void setbgin(JPanel p) {
		
		p.setBackground(new Color(27, 37, 46));
	}
      public void setbgout(JPanel p) {
		
		p.setBackground(new Color(41, 56, 70));
	}
      public void setlbin(JLabel p) {
    	  p.setForeground(UIManager.getColor("Button.highlight"));
    	
		
	}
      public void setlbout(JLabel p) {
    	  p.setForeground(UIManager.getColor("Button.shadow"));
	}
      public void showhide(JPanel p) {
    	    body.removeAll();
			body.add(p);
			body.repaint();
			body.revalidate();
		
	}
      public void victory() {
    	  err.setForeground(SystemColor.textHighlight);
    	  errnv.setForeground(SystemColor.textHighlight);
    	  errhd.setForeground(SystemColor.textHighlight);
	}
      public void fail() {
    	  err.setForeground(Color.red);
    	  errnv.setForeground(Color.red);
    	  errhd.setForeground(Color.red);
	}
    
      public long sub(long i) {
		return i--;
	}
      // Hình Ảnh Cho String : Link fordel chứa ảnh
      public ImageIcon ResizeImage(String imgPath){
          ImageIcon MyImage = new ImageIcon(imgPath);
          Image img = MyImage.getImage();
          Image newImage = img.getScaledInstance(txtima.getWidth(), txtima.getHeight(),Image.SCALE_SMOOTH);
          ImageIcon image = new ImageIcon(newImage);
          return image;
      }
      // Hình Ảnh Dạng byte Của SQL 
      public ImageIcon testicon(byte[] imgPath,JLabel txt){
          ImageIcon MyImage = new ImageIcon(imgPath);
          Image img = MyImage.getImage();
          Image newImage = img.getScaledInstance(txt.getWidth(), txt.getHeight(),Image.SCALE_SMOOTH);
          ImageIcon image = new ImageIcon(newImage);
          return image;
      }
}
