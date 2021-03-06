package com.it.DBHepler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.sql.RowSet;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.it.DBHepler.Configuration;

import sun.jdbc.rowset.CachedRowSet;

/**
 * ����comm
 * 
 * @author hht
 * @date 2017��10��16��
 */
public class DBDownMysql {
	private static DataSource dataSource;

	// ���һ����ݿ� Connection
	public static Connection getConnection() throws SQLException {
		if (dataSource == null)
			dataSource = setupDataSource();
		Connection conn = dataSource.getConnection();
		conn.setAutoCommit(false);
		return conn;
	}

	// ����ݿ�Ͽ�����
	public static void closeDataSource() {
		if (dataSource != null)
			try {
				((BasicDataSource) dataSource).close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	// ִ�� query
	public static RowSet execQuery(String sql) {
		Connection conn = null;
		Statement stmt = null;
		CachedRowSet crs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			crs = new CachedRowSet();
			crs.populate(stmt.executeQuery(sql));
		} catch (SQLException e) {
			e.printStackTrace();
			// �д��󷵻�null
			crs = null;
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

		return crs;
	}

	public static List<Map<String, Object>> query(String sql) {
		Connection conn =null;
		try {
			conn= getConnection();
			List<Map<String, Object>> map = (List<Map<String, Object>>) new QueryRunner().query(conn, sql,
					new MapListHandler());
			return map;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}finally{
			close(conn);
		}
	}

	// ִ��update �� insert
	public static int execUpdate(String sql) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();

		try {
			int rtn = stmt.executeUpdate(sql);
			if (!conn.getAutoCommit())
				conn.commit();
			return rtn;
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * ���Զ��ύ�� ִ�з���
	 * 
	 * @param sql
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	public static int execUpdateNoCommit(String sql, Connection conn, Statement stmt) throws SQLException {
		conn.setAutoCommit(false);
		int rtn = -1;
		rtn = stmt.executeUpdate(sql);

		return rtn;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				conn = null;
			}
		}

	}

	static String driver = Configuration.getGlobalMsg("jdbc.driverClass");
	static String url = Configuration.getGlobalMsg("jdbc.url1");
	static String usr = Configuration.getGlobalMsg("jdbc.username");
	static String pwd = Configuration.getGlobalMsg("jdbc.password");
	static int maxActive = Integer.parseInt(Configuration.getGlobalMsg("jdbc.maxactive"));
	static int maxIdle = Integer.parseInt(Configuration.getGlobalMsg("jdbc.maxidle"));
	public static String validationQuary = "select count(*) from test";
	static String isValiable = "false";
	static int messageCount = 0;

	public static BasicDataSource setupDataSource() {

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		// ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUsername(usr);
		ds.setPassword(pwd);
		ds.setUrl(url);
		ds.setTestOnBorrow(true);
		ds.setValidationQuery(validationQuary);
		ds.setMaxActive(maxActive);
		ds.setMaxIdle(maxIdle);
		// dataSource = ds;
		return ds;
	}

	public static void setDataSource(DataSource ds) {
		dataSource = ds;
	}

	public static String getIsValiable() {
		return isValiable;
	}

	public static String getUrl() {
		return url;
	}

	public static int getMessageCount() {
		return messageCount;
	}

	public static void setMessageCount(int msgCount) {
		messageCount = msgCount;
	}
}
