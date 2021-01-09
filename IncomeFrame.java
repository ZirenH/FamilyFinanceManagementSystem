package com.zirong.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.zirong.DAO.ExpenditureShow;
import com.zirong.DAO.IncomeShow;
import com.zirong.DAO.PersonalInformation;
import com.zirong.tool.UiUtil;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IncomeFrame extends JFrame {
	private static String id; 
	private JPanel contentPane;
	private static JTable table;
	private JTextField searchtxt;
	private static IncomeFrame iframe;
	private static DefaultTableModel model;
	private static JScrollPane scrollPane;
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					IncomeFrame frame = new IncomeFrame();
//					frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

/**
 * 带参数的构造方法，该构造方法生成账号为id的收入界面
 * @param id
 * @return
 */
	public static synchronized IncomeFrame getInstance(String id) {
		if(iframe==null) {
			setId(id);
			iframe=new IncomeFrame();	
		}
		return iframe;
			
	}
	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		IncomeFrame.id = id;
	}

	private IncomeFrame() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel titlelbl = new JLabel("\u5BB6\u5EAD\u6536\u5165\u60C5\u51B5");
		titlelbl.setHorizontalAlignment(SwingConstants.CENTER);
		titlelbl.setBounds(208, 72, 166, 38);
		desktopPane.add(titlelbl);
		

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 119, 452, 360);
		//scrollPane.setViewportView(table);
		desktopPane.add(scrollPane);
		//System.out.println(rows);

		refresh();
		
		table.setAutoCreateRowSorter(true);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 653, 27);
		desktopPane.add(toolBar);
		
		JButton addbtn = new JButton("\u589E\u52A0");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddIncomeFrame aif=new AddIncomeFrame(id);
				aif.setVisible(true);
				UiUtil.setFrameCenter(aif);
			}
		});
		addbtn.setIcon(new ImageIcon("C:\\Users\\ZirongHuang\\Desktop\\\u5BB6\u5EAD\u7406\u8D22\u7CFB\u7EDF\u56FE\u6807\\+ (1).png"));
		toolBar.add(addbtn);
		
		JButton deletebtn = new JButton("\u5220\u9664");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(e.getSource()==deletebtn) {
					int row=table.getSelectedRow();
					if(row!=-1) {	
						IncomeShow is=new IncomeShow();
						is.delete((int)model.getValueAt(row, 0));
						model.removeRow(row);
						//System.out.println(model.getValueAt(0, 0).toString());
					}
				}
				}catch(Exception e1) {
				}
				
			}
		});
		
		JButton updatebtn = new JButton("\u4FEE\u6539");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(e.getSource()==updatebtn) {
					int row=table.getSelectedRow();
					if(row!=-1) {	
						UpdateIncomeFrame uif=new UpdateIncomeFrame((int)model.getValueAt(row, 0),(String)model.getValueAt(row, 1),
								(String)model.getValueAt(row, 2),(String)model.getValueAt(row, 3),(String)model.getValueAt(row, 4),
								(float)model.getValueAt(row, 5),(String)model.getValueAt(row, 6));
						//System.out.println(model.getValueAt(0, 0).toString());
						uif.setVisible(true);
						UiUtil.setFrameCenter(uif);
					}}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}});
		updatebtn.setIcon(new ImageIcon("C:\\Users\\ZirongHuang\\Desktop\\\u5BB6\u5EAD\u7406\u8D22\u7CFB\u7EDF\u56FE\u6807\\\u4FEE\u6539.png"));
		toolBar.add(updatebtn);
		deletebtn.setIcon(new ImageIcon("C:\\Users\\ZirongHuang\\Desktop\\\u5BB6\u5EAD\u7406\u8D22\u7CFB\u7EDF\u56FE\u6807\\\u5220\u9664.png"));
		toolBar.add(deletebtn);
		
		JButton searchbtn = new JButton("\u641C\u7D22");
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncomeShow is=new IncomeShow();
				Vector<Vector> v=is.search(searchtxt.getText());
				Vector<String> titles=new Vector<String>();
				Collections.addAll(titles, "id","类型", "收入人", "地点","日期","金额","备注");
				model = new DefaultTableModel(v,titles);
				table.setModel(model);
			}
		});
		searchbtn.setBounds(411, 40, 97, 32);
		desktopPane.add(searchbtn);
		
		searchtxt = new JTextField();
		searchtxt.setBounds(167, 41, 220, 31);
		desktopPane.add(searchtxt);
		searchtxt.setColumns(10);
		
		JLabel searchlbl = new JLabel("");
		searchlbl.setHorizontalAlignment(SwingConstants.CENTER);
		searchlbl.setIcon(new ImageIcon("C:\\Users\\ZirongHuang\\Desktop\\\u5BB6\u5EAD\u7406\u8D22\u7CFB\u7EDF\u56FE\u6807\\\u641C\u7D22.png"));
		searchlbl.setBounds(94, 43, 73, 27);
		desktopPane.add(searchlbl);
	}
	/**
	 * 更新表格数据，及时展现
	 */
	public static void refresh() {
		Vector<String> titles=new Vector<String>();
		Collections.addAll(titles, "id","类型", "收入人", "地点","日期","金额","备注");
		Vector<Vector> rows=new IncomeShow().showIncome(id);
		model=new DefaultTableModel(rows,titles);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);
	}
}
