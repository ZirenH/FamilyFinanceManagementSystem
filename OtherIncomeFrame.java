package com.zirong.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zirong.DAO.MoneyManagementShow;
import com.zirong.DAO.OtherIncomeShow;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class OtherIncomeFrame extends JFrame {
	
	private static String id;
	private JPanel contentPane;
	private JTable table;
	private static OtherIncomeFrame oif=null;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OtherIncomeFrame frame = new OtherIncomeFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public static synchronized OtherIncomeFrame getInstance(String id) {
		if(oif==null) {
			setId(id);
			oif=new OtherIncomeFrame();
		}
		return oif;
	}
	
	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		OtherIncomeFrame.id = id;
	}

	private OtherIncomeFrame() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u5176\u4ED6\u6536\u5165");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(235, 34, 102, 38);
		desktopPane.add(lblNewLabel);
		
		Vector<String> titles=new Vector<String>();
		Collections.addAll(titles, "类型", "收入人", "地点","日期","金额","备注");
		Vector rows=new OtherIncomeShow().showIncome(id);
		
		table = new JTable(rows,titles);
		table.setBounds(78, 82, 434, 323);
		desktopPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 82, 434, 323);
		scrollPane.setViewportView(table);
		desktopPane.add(scrollPane);
		
		table.setAutoCreateRowSorter(true);
	}
}
