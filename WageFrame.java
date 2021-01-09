package com.zirong.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.zirong.DAO.IncomeShow;
import com.zirong.DAO.WageShow;


import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class WageFrame extends JFrame {
	private static String id;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Vector<String> titles;
	private static WageFrame wf=null;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					WageFrame frame = new WageFrame();
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
	
	public static synchronized WageFrame getInstance(String id) {
		if(wf==null) {
			setId(id);
			wf=new WageFrame();
		}
		return wf;
	}
	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		WageFrame.id = id;
	}

	private WageFrame() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel wagelbl = new JLabel("\u5DE5\u8D44\u8868");
		wagelbl.setHorizontalAlignment(SwingConstants.CENTER);
		wagelbl.setBounds(193, 31, 140, 40);
		desktopPane.add(wagelbl);
		
		Vector<String> titles=new Vector<String>();
		Collections.addAll(titles, "����", "������", "�ص�","����","���","��ע");
		Vector rows=new WageShow().showWage(id);
		
		
		model = new DefaultTableModel(rows, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {//��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);
		table.setBounds(87, 79, 383, 316);
		desktopPane.add(table);
		table.setAutoCreateRowSorter(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setBounds(86, 79, 384, 316);
		desktopPane.add(scrollPane);
		
		JButton befbtn = new JButton("\u4E0A\u4E00\u9875");
		befbtn.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageTable().prePage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
				
			}
		});
		befbtn.setBounds(71, 417, 106, 37);
		desktopPane.add(befbtn);
		
		JButton nextbtn = new JButton("\u4E0B\u4E00\u9875");
		nextbtn.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageTable().nextPage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
			}
		});
		nextbtn.setBounds(215, 417, 106, 37);
		desktopPane.add(nextbtn);
		
		JComboBox comboBox = new JComboBox(new Integer[] {10,15,20});
		comboBox.addItemListener(new ItemListener() {//ҳ��������ѡ��ı��¼�
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//��ȡ��������ѡ��ֵ
				PageTable pcl=new PageTable();
				pcl.setCountPerpage(pageSize);//����ÿҳ��ʾ��¼����
				model=new DefaultTableModel(pcl.getPaegData(),titles);//��������ģ��
				table.setModel(model);//���ñ������ģ��
			}
		});
		comboBox.setBounds(416, 420, 80, 30);
		desktopPane.add(comboBox);
		
		JLabel pagelbl = new JLabel("\u6BCF\u9875\u663E\u793A");
		pagelbl.setBounds(341, 422, 65, 26);
		desktopPane.add(pagelbl);
	}
}
