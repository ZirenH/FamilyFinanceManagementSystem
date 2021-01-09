package com.zirong.frm;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import com.zirong.DAO.Login;
import com.zirong.tool.UiUtil;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class LoginFrame {

	private JFrame frame;
	private JTextField idtxt;
	private JDesktopPane desktopPane;
	private JPasswordField passwordtxt;
	private String id;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginFrame window = new LoginFrame();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	 
	public String getId() {
		return id;
	}
	/**
	 * 构造方法，产生登录界面实例
	 */
	public LoginFrame() {
		initialize();
		frame.setVisible(true);
	}
	/**
	 * 成员方法，生成登录界面
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ZirongHuang\\Desktop\\\u5BB6\u5EAD\u7406\u8D22\u7CFB\u7EDF\u56FE\u6807\\\u767B\u5F55.png"));
		frame.setTitle("\u767B\u5F55");
		frame.setBounds(100, 100, 571, 333);
		UiUtil.setFrameCenter(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		desktopPane = new JDesktopPane() {//设置一个面板容器
			
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("source\\all.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel idlbl = new JLabel("\u8D26\u53F7");
		idlbl.setFont(new Font("宋体", Font.PLAIN, 14));
		idlbl.setHorizontalAlignment(SwingConstants.CENTER);
		idlbl.setBounds(117, 73, 87, 36);
		desktopPane.add(idlbl);
		
		JLabel passwordlbl = new JLabel("\u5BC6\u7801");
		passwordlbl.setFont(new Font("宋体", Font.PLAIN, 14));
		passwordlbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordlbl.setBounds(117, 133, 87, 36);
		desktopPane.add(passwordlbl);
		
		idtxt = new JTextField();
		idtxt.setBounds(214, 78, 159, 28);
		desktopPane.add(idtxt);
		idtxt.setColumns(10);
		
		JButton logonbtn = new JButton("登录");
		logonbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Login logon=new Login();
					logon.getConnectionToLogin(idtxt.getText(), passwordtxt.getText());
					if(idtxt.getText().equals(logon.getId())&&passwordtxt.getText().equals(logon.getPassword())) {
						id=idtxt.getText();
						//System.out.println(id);
						JOptionPane.showMessageDialog(null, "登陆成功!");
						frame.setVisible(false);
						MainWindow mw=new MainWindow(id);
						
					}else if(idtxt.getText().equals(logon.getId())&&!(passwordtxt.getText().equals(logon.getPassword()))) {
						JOptionPane.showMessageDialog(null, "密码错误,可能您并未注册该用户/管理员账号");
					}else if(!(idtxt.getText().equals(logon.getId()))&&!(passwordtxt.getText().equals(logon.getPassword())))
						JOptionPane.showMessageDialog(null, "没有此账号信息，快去注册吧");
				}
				catch(Exception e1) {
					
				}
			}
		});
		logonbtn.setBounds(142, 194, 105, 36);
		desktopPane.add(logonbtn);
		
		JButton loginbtn = new JButton("注册");	
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame register=new RegisterFrame();
				register.setVisible(true);
				frame.setVisible(false);
			}
		});
		loginbtn.setBounds(285, 194, 105, 36);
		desktopPane.add(loginbtn);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(214, 138, 159, 28);
		desktopPane.add(passwordtxt);
	}
	/**
	 * 控制界面的出现与消失
	 * @param flag
	 */
	public void setVisible(boolean flag) {
		frame.setVisible(flag);
	}
}
