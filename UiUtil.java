package com.zirong.tool;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
/**
 * ������������Ļ����
 * @author ZirongHuang
 *
 */
public class UiUtil {
	/**
	 * ��JInternalFrame�Ӵ���������Ļ����
	 * @param jif
	 */
	public static void setFrameCenter(JInternalFrame jif) {
		Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
		Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
		int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�
		int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�
		int x=(screenWidth-jif.getWidth())/2;
		int y=(screenHeight-jif.getHeight())/2;
		jif.setLocation(x+10, y-105);
	}
	/**
	 * ��JFrame����������Ļ����
	 * @param jf
	 */
	public static void setFrameCenter(JFrame jf) {
		Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
		Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
		int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�
		int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�
		int x=(screenWidth-jf.getWidth())/2;
		int y=(screenHeight-jf.getHeight())/2;
		jf.setLocation(x+10, y-65);
	}
}
