package com.zirong.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zirong.DAO.MoneyManagementShow;
import com.zirong.DAO.WageShow;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
/**
 * ��ƹ������
 * @author ZirongHuang
 *
 */
public class MoneyManagementFrame extends JFrame {
	private static String id;
	private JPanel contentPane;
	private JTable table;
	private static MoneyManagementFrame mmf=null;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MoneyManagementFrame frame = new MoneyManagementFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * ��Ա�������õ���ƹ���ʵ��
	 * @param id
	 * @return
	 */
	
	public static synchronized MoneyManagementFrame getInstance(String id) {
		if(mmf==null) {
			setId(id);
			mmf=new MoneyManagementFrame();
		}
		return mmf;
	}
	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		MoneyManagementFrame.id = id;
	}

	private MoneyManagementFrame() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u7406\u8D22\u6295\u8D44\u6536\u5165");
		lblNewLabel.setBounds(253, 26, 82, 28);
		desktopPane.add(lblNewLabel);
		
		Vector<String> titles=new Vector<String>();
		Collections.addAll(titles, "����", "������", "�ص�","����","���","��ע");
		Vector rows=new MoneyManagementShow().showWage(id,"��Ʊ");
		
		table = new JTable(rows,titles);
		table.setBounds(107, 77, 378, 299);
		desktopPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 77, 379, 299);
		scrollPane.setViewportView(table);
		desktopPane.add(scrollPane);
		
		table.setAutoCreateRowSorter(true);
	}
}
