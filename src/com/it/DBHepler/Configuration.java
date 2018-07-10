package com.it.DBHepler;

import java.util.ResourceBundle;
public class Configuration {

	/**
	 * SynOLAT消息文件的名??
	 */
	private static final String ADMIN_MESSAGE = "messages_admin";// 管理消息
	private static final String GLOBAL_MESSAGE = "jdbc";// 全局消息

	/**
	 * 用于载入消息的ResourceBundle
	 */
	private static ResourceBundle adminRb = null;
	private static ResourceBundle globalRb = null;

	/**
	 * 将构造函数设置成private，防止被实例??
	 */
	public Configuration() {
	}

	/**
	 * 从消息配置文件中载入与key对应的消息字符串
	 * 
	 * @param key
	 *            配置信息key
	 * @return 配置信息字符??
	 */
	public static String getUserMsg(final String key) {
		if (adminRb == null) {
			adminRb = ResourceBundle.getBundle(ADMIN_MESSAGE);
		}
		return adminRb.getString(key);
	}

	public static String getGlobalMsg(final String key) {
		if (globalRb == null) {
			globalRb = ResourceBundle.getBundle(GLOBAL_MESSAGE);
		}
		return globalRb.getString(key);
	}
}
