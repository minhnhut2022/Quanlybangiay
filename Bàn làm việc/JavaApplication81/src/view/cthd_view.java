package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.MixCthd_bean;
import bean.NhanVien_bean;
import bo.Cthd_Hd_bo;
import dao.Cthd_Hd_dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;

public class cthd_view extends JFrame {

	private JPanel contentPane;

	private final JPanel panel_1 = new JPanel();
	protected static cthd_view frame2=new cthd_view();
	protected static banhang_view banhang=new banhang_view();
	private JTextField tongtien;
	JLabel donhang = new JLabel("");
	JLabel soluongmua = new JLabel("");
	JLabel tenhanh = new JLabel("");
	JLabel gia = new JLabel("");
	JLabel macthd = new JLabel("");	JLabel nhanvien = new JLabel("");
	JLabel tenhang = new JLabel("");
	int px,py,x,y;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame2 = new cthd_view();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */

	
	public cthd_view() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				
				Cthd_Hd_bo n=new Cthd_Hd_bo();
				
				try {
					if(donhang.getText().isEmpty()) {
						 JOptionPane.showMessageDialog(rootPane, "Không có hoá Đơn");
					     
					}else {
						  
						 
							long mahd=Long.parseLong(donhang.getText());
							for (MixCthd_bean t : n.xuatcthd(mahd)) {
								tenhang.setText(t.getTenhang());
								soluongmua.setText(String.valueOf(t.getSlmua()));
								tongtien.setText(String.valueOf(t.getThanhtien()));
								gia.setText(String.valueOf(t.getGia()));
							       nhanvien.setText(n.gettennv(t.getManv()));
								
								macthd.setText(String.valueOf(t.getMahd()));
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
		setUndecorated(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.WHITE));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(41, 56, 70));
		panel.setBounds(0, 34, 438, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chi Ti\u1EBFt Ho\u00E1 \u0110\u01A1n B\u00E1n H\u00E0ng");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(91, 11, 275, 56);
		panel.add(lblNewLabel);
		tenhanh.setBounds(139, 160, 166, 35);
		panel.add(tenhanh);
		
		
		tenhanh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		tenhanh.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				x=e.getXOnScreen();
				y=e.getYOnScreen();
				
			
				
				frame2.setLocation(x-px,y-py);
			}
		});
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				px=e.getX();
				py=e.getY();
			}
		});
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(0, 0, 438, 35);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(153, 204, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\icon\\Close Window_32px.png"));
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
                       banhang_view f=new banhang_view();
                       f.setVisible(true);
                       cthd_view f2=new cthd_view();
                       f.setVisible(false);
                       dispose();
                     
			}

			
		});
		btnNewButton.setBounds(383, 1, 32, 32);
		panel_1.add(btnNewButton);
		
		JLabel lblnHng = new JLabel("\u0110\u01A1n H\u00E0ng :");
		lblnHng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnHng.setBounds(27, 124, 88, 35);
		contentPane.add(lblnHng);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn H\u00E0ng :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(27, 195, 88, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3 M\u00E3 :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(253, 122, 73, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("S\u1ED1 L\u01B0\u1EE3ng Mua :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(27, 268, 116, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gi\u00E1 : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(27, 332, 96, 47);
		contentPane.add(lblNewLabel_4);
		
		JLabel label = new JLabel(".......................................................................................................");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(0, 377, 438, 20);
		contentPane.add(label);
		
		JLabel lblNewLabel_5 = new JLabel("T\u1ED5ng Ti\u1EC1n :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(27, 408, 181, 68);
		contentPane.add(lblNewLabel_5);
		
		tongtien = new JTextField();
		tongtien.setEditable(false);
		tongtien.setHorizontalAlignment(SwingConstants.CENTER);
		tongtien.setBorder(new BevelBorder(BevelBorder.LOWERED, UIManager.getColor("CheckBox.foreground"), UIManager.getColor("CheckBox.focus"), UIManager.getColor("CheckBox.focus"), UIManager.getColor("CheckBox.foreground")));
		tongtien.setBackground(UIManager.getColor("Button.background"));
		tongtien.setFont(new Font("Tahoma", Font.BOLD, 20));
		tongtien.setBounds(201, 410, 217, 68);
		contentPane.add(tongtien);
		tongtien.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nh\u00E2n Vi\u00EAn B\u00E1n H\u00E0ng :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(33, 508, 166, 29);
		contentPane.add(lblNewLabel_6);
		
		
		donhang.setHorizontalAlignment(SwingConstants.CENTER);
		donhang.setFont(new Font("Tahoma", Font.BOLD, 12));
		donhang.setBounds(102, 124, 83, 35);
		contentPane.add(donhang);
		
	
		macthd.setForeground(Color.RED);
		macthd.setFont(new Font("Tahoma", Font.ITALIC, 12));
		macthd.setBounds(348, 122, 70, 29);
		contentPane.add(macthd);
		
		
		soluongmua.setFont(new Font("Tahoma", Font.BOLD, 15));
		soluongmua.setHorizontalAlignment(SwingConstants.RIGHT);
		soluongmua.setBounds(187, 266, 205, 35);
		contentPane.add(soluongmua);
		
		
		gia.setFont(new Font("Tahoma", Font.BOLD, 15));
		gia.setHorizontalAlignment(SwingConstants.RIGHT);
		gia.setBounds(201, 337, 191, 34);
		contentPane.add(gia);
		
	
		nhanvien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		nhanvien.setBounds(237, 508, 155, 29);
		contentPane.add(nhanvien);
		
		
		tenhang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		tenhang.setBounds(112, 190, 214, 47);
		contentPane.add(tenhang);
	}
}
