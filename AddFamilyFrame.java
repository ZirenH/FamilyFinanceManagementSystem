package com.zirong.frm;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.print.attribute.SetOfIntegerSyntax;
import javax.swing.JButton;
/**
 * ��ͥ��Ա��ӽ���
 * @author ZirongHuang
 *
 */
public class AddFamilyFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtxm;
	private JTextField txtid;
	private JLabel lblts1;
	private JLabel lblts2;
	private JLabel lblts3;
	private static String id;
	private JButton btnadd; 
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddFamilyFrame frame = new AddFamilyFrame(id);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

/**
 * ʵ������ͥ��Ա��ӽ���
 * ͬʱ���ɽ���
 * �����˺ţ����ڴ洢��������
 * @param id
 */
	public AddFamilyFrame(String id) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setId(id);
		setBounds(100, 100, 420, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		JLabel lblxm = new JLabel("\u59D3\u540D");				//ѧ��
		lblxm.setFont(new Font("����", Font.PLAIN, 13));
		lblxm.setHorizontalAlignment(SwingConstants.CENTER);
		lblxm.setBounds(44, 62, 70, 30);
		contentPane.add(lblxm);
		
		txtxm = new JTextField();
		txtxm.setBounds(138, 63, 150, 30);
		contentPane.add(txtxm);
		txtxm.setColumns(10);
		
		JLabel lblid = new JLabel("\u5BB6\u5EAD\u8EAB\u4EFD");				//����
		lblid.setHorizontalAlignment(SwingConstants.CENTER);
		lblid.setFont(new Font("����", Font.PLAIN, 13));
		lblid.setBounds(44, 143, 70, 30);
		contentPane.add(lblid);
		
		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(138, 144, 150, 30);
		contentPane.add(txtid);
		
		btnadd = new JButton("\u6DFB\u52A0");
		btnadd.setBounds(138, 234, 129, 45);
		contentPane.add(btnadd);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(324, 34, 58, 15);
		//contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(324, 96, 58, 15);
		//contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(324, 153, 58, 15);
		//contentPane.add(lblNewLabel_2);
		
		lblts1 = new JLabel("New label");
		lblts1.setEnabled(false);
		lblts1.setBounds(280, 29, 80, 25);
		//contentPane.add(lblts1);
		
		lblts2 = new JLabel("New label");
		lblts2.setBounds(280, 91, 80, 25);
		//contentPane.add(lblts2);
		
		lblts3 = new JLabel("New label");
		lblts3.setBounds(280, 148, 80, 25);
		//contentPane.add(lblts3);
		
		//����ѧ�ţ��ж��Ƿ�ƥ��
		/*if(txtxh.getText().length()==0){
			lblts1.setText("ѧ�Ų���Ϊ��");
			contentPane.add(lblts1);
		//	return;
		}else if(txtxh.getText().length()!=0) {
			lblts1.setText(null);
			contentPane.add(lblts1);
		}*/
		
		txtxm.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				checkInputXh();
			}
		});
		
		//���ѧ�ż��̼��������¼�
		txtxm.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER) {
					txtid.requestFocus();
				}
			}
		});
		
		//������������¼�
		txtid.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				checkInputXm();
			}
		});
		
		
		//��Ӱ�ť�¼�
		btnadd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				add(e);
				ShowFamilyFrame.refresh();
			}
		});
	}
	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		AddFamilyFrame.id = id;
	}
/**
 * ��Ӳ���������ͥ��Ա��ӽ����ϵ�����������ӵ��ı��ļ���
 * @param e
 */
	public void add(ActionEvent e) {
		File f=new File("F:\\homefinance\\"+id+".txt");
		try(FileWriter fw=new FileWriter(f,true);){
			if(!(f.exists())) {
				f.createNewFile();
			}
			if(e.getSource()==btnadd&&checkInputXh()&&checkInputXm()) {
				JOptionPane.showMessageDialog(null, "��ӳɹ���");
				fw.write(txtxm.getText()+"\t"+txtid.getText()+"\r\n");
				
				setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "���ʧ��");
			}
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * �������������Ƿ�淶
	 * @return
	 */
	public boolean checkInputXh() {
		if(txtxm.getText().length()==0) {
			lblts1.setText("��������Ϊ��");
			//txtxh.requestFocus();
			contentPane.add(lblts1);
			return false;
		}else {
			lblts2.setText("");
			contentPane.add(lblts1);
			return true;
		}
			
	}
	/**
	 * ���������ͥ����Ƿ�淶
	 * @return
	 */
	public boolean checkInputXm() {
		if(txtid.getText().length()==0) {
			//txtxm.requestFocus();
			lblts2.setText("��ͥ��ݲ���Ϊ��");
			contentPane.add(lblts2);
			return false;
		}else {
			lblts2.setText("");
			contentPane.add(lblts2);
			return true;
		}
			
	}
}
