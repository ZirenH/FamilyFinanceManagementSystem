package com.zirong.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import com.zirong.DAO.ExpenditureShow;
import com.zirong.DAO.IncomeShow;
import com.zirong.tool.UiUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 支出界面，产生支出表格
 * @author ZirongHuang
 *
 */
public class ExpenditureFrame extends JFrame {
	private static String id;
	private static ExpenditureFrame ef=null;
	private JPanel contentPane;
	private static JTable table;
	private JTextField searchtxt;
	private static DefaultTableModel model;
	private static JScrollPane scrollPane;
	private TableRowSorter sorter;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ExpenditureFrame frame = new ExpenditureFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * 带参数的构造方法，该构造方法生产一个支出界面
	 * @param id
	 * @return
	 */
	public static synchronized ExpenditureFrame getInstance(String id) {
		if(ef==null) {
			setId(id);
			ef=new ExpenditureFrame();	
		}
		return ef;
			
	}
	
	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		ExpenditureFrame.id = id;
	}

	private ExpenditureFrame() {
		setBounds(100, 100, 716, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel titlelbl = new JLabel("\u5BB6\u5EAD\u652F\u51FA\u60C5\u51B5");
		titlelbl.setHorizontalAlignment(SwingConstants.CENTER);
		titlelbl.setBounds(237, 72, 166, 38);
		desktopPane.add(titlelbl);

		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 120, 541, 433);
		desktopPane.add(scrollPane);
		//System.out.println(rows);
		
		refresh();
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 692, 27);
		desktopPane.add(toolBar);
		
		JButton addbtn = new JButton("\u589E\u52A0");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddExpendituresFrame aef=AddExpendituresFrame.getInstance(id);
				aef.setVisible(true);
				UiUtil.setFrameCenter(aef);
			}
		});
		addbtn.setIcon(new ImageIcon("C:\\Users\\ZirongHuang\\Desktop\\\u5BB6\u5EAD\u7406\u8D22\u7CFB\u7EDF\u56FE\u6807\\+ (1).png"));
		toolBar.add(addbtn);
		
		JButton deletebtn = new JButton("\u5220\u9664");
		deletebtn.addActionListener(new ActionListener() {
			public void  actionPerformed(ActionEvent e) {
				try {
					if(e.getSource()==deletebtn) {
					int row=table.getSelectedRow();
					if(row!=-1) {	
						ExpenditureShow es=new ExpenditureShow();
						es.delete((int)model.getValueAt(row, 0));
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
						UpdateExpenditureFrame uef=new UpdateExpenditureFrame((int)model.getValueAt(row, 0),(String)model.getValueAt(row, 1),
								(String)model.getValueAt(row, 2),(String)model.getValueAt(row, 3),(float)model.getValueAt(row, 4),(String)model.getValueAt(row, 5));
						//System.out.println(model.getValueAt(0, 0).toString());						
						uef.setVisible(true);
						UiUtil.setFrameCenter(uef);
					}
				}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		updatebtn.setIcon(new ImageIcon("C:\\Users\\ZirongHuang\\Desktop\\\u5BB6\u5EAD\u7406\u8D22\u7CFB\u7EDF\u56FE\u6807\\\u4FEE\u6539.png"));
		toolBar.add(updatebtn);
		deletebtn.setIcon(new ImageIcon("C:\\Users\\ZirongHuang\\Desktop\\\u5BB6\u5EAD\u7406\u8D22\u7CFB\u7EDF\u56FE\u6807\\\u5220\u9664.png"));
		toolBar.add(deletebtn);
		
		JButton searchbtn = new JButton("\u641C\u7D22");
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExpenditureShow es=new ExpenditureShow();
				Vector<String> titles=new Vector<String>();
				Collections.addAll(titles, "id","用途", "支出人","日期","金额","备注");
				Vector<Vector> v=es.search(searchtxt.getText());
			
				model = new DefaultTableModel(v,titles);
				table.setModel(model);
			}
		});
		searchbtn.setBounds(463, 37, 97, 32);
		desktopPane.add(searchbtn);
		
		searchtxt = new JTextField();
		searchtxt.setBounds(206, 37, 220, 31);
		desktopPane.add(searchtxt);
		searchtxt.setColumns(10);
		
		JLabel searchlbl = new JLabel("");
		searchlbl.setHorizontalAlignment(SwingConstants.CENTER);
		searchlbl.setIcon(new ImageIcon("C:\\Users\\ZirongHuang\\Desktop\\\u5BB6\u5EAD\u7406\u8D22\u7CFB\u7EDF\u56FE\u6807\\\u641C\u7D22.png"));
		searchlbl.setBounds(123, 42, 73, 27);
		desktopPane.add(searchlbl);
	}
	/**
	 * 更新，将修改过的数据及时的展现在支出界面上
	 */
	public static void refresh() {
		Vector<String> titles=new Vector<String>();
		Collections.addAll(titles, "id","类型", "收入人", "地点","日期","金额","备注");
		Vector<Vector> rows=new ExpenditureShow().showExpenditure(id);
		model=new DefaultTableModel(rows,titles);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);
	}
	
}
