package com.zirong.tool;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
/**
 * 将界面置于屏幕中央
 * @author ZirongHuang
 *
 */
public class UiUtil {
	/**
	 * 将JInternalFrame子窗口置于屏幕中央
	 * @param jif
	 */
	public static void setFrameCenter(JInternalFrame jif) {
		Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
		Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
		int screenWidth = screenSize.width; //获取屏幕的宽
		int screenHeight = screenSize.height; //获取屏幕的高
		int x=(screenWidth-jif.getWidth())/2;
		int y=(screenHeight-jif.getHeight())/2;
		jif.setLocation(x+10, y-105);
	}
	/**
	 * 将JFrame界面置于屏幕中央
	 * @param jf
	 */
	public static void setFrameCenter(JFrame jf) {
		Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
		Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
		int screenWidth = screenSize.width; //获取屏幕的宽
		int screenHeight = screenSize.height; //获取屏幕的高
		int x=(screenWidth-jf.getWidth())/2;
		int y=(screenHeight-jf.getHeight())/2;
		jf.setLocation(x+10, y-65);
	}
}
