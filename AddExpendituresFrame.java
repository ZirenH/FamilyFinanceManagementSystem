package com.zirong.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zirong.DAO.ExpenditureShow;
import com.zirong.vo.Expenditure;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
/**
 * ���֧�����ݽ���
 * ������������ݽ���
 * @author ZirongHuang
 *
 */
public class AddExpendituresFrame extends JFrame {
	/**
	 * �������
	 */
	private static AddExpendituresFrame af=null;
	private JPanel contentPane;
	private JTextField purposetxt;
	private JTextField datetxt;
	private JTextField persontxt;
	private JTextField remarktxt;
	private JTextField acounttxt;
	private static String id;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddExpendituresFrame frame = new AddExpendituresFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 *����ģʽ���õ����֧�������ʵ�� ��
	 *�����˺ţ����ڴ洢��������
	 * @param id
	 * @return
	 */
	public static synchronized AddExpendituresFrame getInstance(String id) {
		if(af==null) {
			setId(id);
			af=new AddExpendituresFrame();	
		}
		return af;
	}
		
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		AddExpendituresFrame.id = id;
	}
	/**
	 * ˽�л����췽��
	 */
	private AddExpendituresFrame() {
		setTitle("\u589E\u52A0");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel purposelbl = new JLabel("\u7528\u9014");
		purposelbl.setHorizontalAlignment(SwingConstants.CENTER);
		purposelbl.setBounds(28, 113, 75, 25);
		desktopPane.add(purposelbl);
		
		purposetxt = new JTextField();
		purposetxt.setBounds(96, 113, 131, 25);
		desktopPane.add(purposetxt);
		purposetxt.setColumns(10);
		
		JLabel datelbl = new JLabel("\u65E5\u671F");
		datelbl.setHorizontalAlignment(SwingConstants.CENTER);
		datelbl.setBounds(253, 167, 75, 25);
		desktopPane.add(datelbl);
		
		datetxt = new JTextField();
		datetxt.setColumns(10);
		datetxt.setBounds(338, 167, 131, 25);
		desktopPane.add(datetxt);
		
		
		JLabel personlbl = new JLabel("\u652F\u51FA\u4EBA");
		personlbl.setHorizontalAlignment(SwingConstants.CENTER);
		personlbl.setBounds(253, 113, 75, 25);
		desktopPane.add(personlbl);
		
		JLabel remarklbl = new JLabel("\u5907\u6CE8");
		remarklbl.setHorizontalAlignment(SwingConstants.CENTER);
		remarklbl.setBounds(28, 225, 75, 25);
		desktopPane.add(remarklbl);
		
		persontxt = new JTextField();
		persontxt.setColumns(10);
		persontxt.setBounds(338, 113, 131, 25);
		desktopPane.add(persontxt);
		
		remarktxt = new JTextField();
		remarktxt.setColumns(10);
		remarktxt.setBounds(96, 225, 131, 25);
		desktopPane.add(remarktxt);
		
		JButton addbtn = new JButton("\u589E\u52A0");
		addbtn.setIcon(new ImageIcon("C:\\Users\\ZirongHuang\\Desktop\\\u5BB6\u5EAD\u7406\u8D22\u7CFB\u7EDF\u56FE\u6807\\+ (1).png"));
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExpenditureShow es=new ExpenditureShow();
				es.add(purposetxt.getText(), persontxt.getText(),  datetxt.getText(),Float.valueOf(acounttxt.getText()) ,remarktxt.getText(), id);
				JOptionPane.showMessageDialog(null, "��ӳɹ�");
				ExpenditureFrame.refresh();
				setVisible(false);
			}
		});
		addbtn.setBounds(195, 279, 109, 40);
		desktopPane.add(addbtn);
		
		JLabel acountlbl = new JLabel("\u91D1\u989D");
		acountlbl.setHorizontalAlignment(SwingConstants.CENTER);
		acountlbl.setBounds(28, 167, 75, 25);
		desktopPane.add(acountlbl);
		
		acounttxt = new JTextField();
		acounttxt.setColumns(10);
		acounttxt.setBounds(96, 167, 131, 25);
		desktopPane.add(acounttxt);
		
		JDesktopPane desktopPaneOne = new JDesktopPane() {//����һ���������
			
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("source\\��.jpg");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
	}
}
