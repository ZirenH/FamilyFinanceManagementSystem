package com.zirong.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zirong.DAO.IncomeShow;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 收入添加界面
 * @author ZirongHuang
 *
 */
public class AddIncomeFrame extends JFrame {
	private JPanel contentPane;
	private JTextField typetxt;
	private JTextField persontxt;
	private JTextField placetxt;
	private JTextField datetxt;
	private JTextField acounttxt;
	private JTextField remarkstxt;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddIncomeFrame frame = new AddIncomeFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * 收入添加界面实例化，传递账号便于存储数据库
	 * @param id
	 */
	public AddIncomeFrame(String id) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 483);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		JPanel  panel = new JPanel(){
		    public void paintComponent(Graphics g) {
		     super.paintComponent(g);
		     ImageIcon img = new ImageIcon("source\\收入背景图2.jpg");
		     g.drawImage(img.getImage(),0,0,null);
		      }
		   };
		panel.setBounds(0, 0, 605, 121);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("\u7C7B\u578B");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 135, 88, 31);
		contentPane.add(lblNewLabel);
		
		typetxt = new JTextField();
		typetxt.setColumns(10);
		typetxt.setBounds(109, 135, 111, 31);
		contentPane.add(typetxt);
		
		JLabel personlbl = new JLabel("\u6536\u5165\u4EBA");
		personlbl.setHorizontalAlignment(SwingConstants.CENTER);
		personlbl.setBounds(296, 135, 88, 31);
		contentPane.add(personlbl);
		
		persontxt = new JTextField();
		persontxt.setColumns(10);
		persontxt.setBounds(394, 135, 111, 31);
		contentPane.add(persontxt);
		
		JLabel placelbl = new JLabel("\u5730\u70B9");
		placelbl.setHorizontalAlignment(SwingConstants.CENTER);
		placelbl.setBounds(21, 196, 88, 31);
		contentPane.add(placelbl);
		
		placetxt = new JTextField();
		placetxt.setColumns(10);
		placetxt.setBounds(109, 196, 111, 31);
		contentPane.add(placetxt);
		
		JLabel datellbl = new JLabel("\u65E5\u671F");
		datellbl.setHorizontalAlignment(SwingConstants.CENTER);
		datellbl.setBounds(296, 196, 88, 31);
		contentPane.add(datellbl);
		
		datetxt = new JTextField();
		datetxt.setColumns(10);
		datetxt.setBounds(394, 196, 111, 31);
		contentPane.add(datetxt);
		
		CalendarPanel p = new CalendarPanel(datetxt, "yyyy-MM-dd");
		p.initCalendarPanel();

		JLabel l = new JLabel("日历面板");
		p.add(l);
		this.getContentPane().add(p);
		
		JLabel acountlbl = new JLabel("\u91D1\u989D");
		acountlbl.setHorizontalAlignment(SwingConstants.CENTER);
		acountlbl.setBounds(21, 257, 88, 31);
		contentPane.add(acountlbl);
		
		acounttxt = new JTextField();
		acounttxt.setColumns(10);
		acounttxt.setBounds(109, 257, 111, 31);
		contentPane.add(acounttxt);
		
		JLabel remarklbl = new JLabel("\u5907\u6CE8");
		remarklbl.setHorizontalAlignment(SwingConstants.CENTER);
		remarklbl.setBounds(296, 257, 88, 31);
		contentPane.add(remarklbl);
		
		remarkstxt = new JTextField();
		remarkstxt.setColumns(10);
		remarkstxt.setBounds(394, 257, 111, 31);
		contentPane.add(remarkstxt);
		
		JButton confirmtxt = new JButton("\u786E\u8BA4");
		confirmtxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncomeShow is=new IncomeShow();
				is.add(typetxt.getText(), persontxt.getText(), placetxt.getText(), datetxt.getText(), Float.parseFloat(acounttxt.getText()), remarkstxt.getText(), id);
				IncomeFrame.refresh();
				JOptionPane.showMessageDialog(null, "添加成功");
				setVisible(false);
			}
		});
		confirmtxt.setBounds(220, 331, 111, 40);
		contentPane.add(confirmtxt);
		
		JComboBox comboBox = new JComboBox(new String[] {"工资","股票","基金","银行储蓄"});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item=comboBox.getSelectedItem().toString();
				typetxt.setText(item);
			}
		});
		
		comboBox.setBounds(230, 143, 56, 23);
		contentPane.add(comboBox);
	}
}
