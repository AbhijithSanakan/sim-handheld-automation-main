package com.framework.automation.utils;

import java.sql.*;
import java.util.*;

/**
 * The DBUtil class provides all required methods for Database scripting
 * Readily available methods to use
 * @since 09-19-2019
 * @version 1.4
 *
 */
public class DBUtils {

	enum DBType {OracleDriver,DB2Driver };
	private Connection connection;
	private static Statement statement;
	private static ResultSet rs;

	//The jdbc class name./
	private String jdbcClassName = "";

	/**
	 * The DButils constructor method used to decide wat type of connection is required
	 *
	 * @param -String DBType
	 * @return webdriver
	 * @throws Exception
	 * @see -
	 * @since 08-05-2019
	 * @version 1.0
	 *
	 */
	public DBUtils(String DbType){
		DBType db = DBType.valueOf(DbType);
			switch (db) {
				case OracleDriver:
					this.jdbcClassName = "oracle.jdbc.driver.OracleDriver";
					break;
				case DB2Driver:
					this.jdbcClassName = "com.ibm.db2.jcc.DB2Driver";
					break;
			}
	}

	/**
	 * The connect_to_DB method is used to connect to the DB
	 *
	 * @param -String DBString/dbURL, username, password
	 * @return
	 * @throws Exception
	 * @since 09-19-2019
	 * @version 1.2
	 *
	 */
	public void connect_to_DB(String databaseURL,String user,String password){
		connection = null;
		try {
			System.out.println("Connections is "+ jdbcClassName);
			Class.forName(jdbcClassName);
			System.out.println("Connecting to Database...");
			connection = DriverManager.getConnection(databaseURL, user, password);
			if (connection != null) {
				System.out.println("Connected to the Database...");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * The number of data available or rows available is exactly the expected
	 *
	 * @param -String query, integer number of row expected
	 * @return
	 * @throws Exception
	 * @since 09-19-2019
	 * @version 1.2
	 *
	 */
	public boolean number_of_data_available(String query, int icount) {
		try {
			rs=null;
			boolean flag = false;
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			try {
				rs.next();
				int table_count = rs.getInt("rowcount");
				if (table_count == icount) {
					flag = true;
				}
				rs.close();
			}
			catch (Exception e){
				//do nothing
			}
			return flag;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * Return number of row fetched from the query
	 *
	 * @param -String query
	 * @return
	 * @throws Exception
	 * @since 09-19-2019
	 * @version 1.2
	 *
	 */
	public int return_row_count(String query) {
		try {
			rs=null;
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			try {
				rs.next();
				int table_count = rs.getInt("rowcount");
				rs.close();
				return table_count;
			}
			catch (Exception e)
			{
				return 0;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	/**
	 * Retrieve the entire table data using the query
	 *
	 * @param -String query
	 * @return -Hashmap
	 * @throws
	 * @since 09-19-2019
	 * @version 1.2
	 *
	 */
	public List<HashMap<String,Object>> get_table(String query){
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		try {
			rs=null;
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			try{
				ResultSetMetaData rsMetaData = rs.getMetaData();
				int columns = rsMetaData.getColumnCount();
				while (rs.next()) {
					HashMap<String,Object> row = new HashMap<String, Object>(columns);
					for(int i=1; i<=columns; ++i) {
						row.put(rsMetaData.getColumnName(i),rs.getObject(i));
					}
					list.add(row);
				}
				rs.next();
				int table_count = rs.getInt("rowcount");
				rs.close();
				return list;
			}
			catch (Exception e)
			{
				return list;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			return list;
		}
	}

	/**
	 * Return the Result set from the ran query
	 *
	 * @param -String query
	 * @return Resultset
	 * @throws
	 * @since 09-19-2019
	 * @version 1.2
	 *
	 */
	public ResultSet retrieve_ResultSet(String query){
		try {
			rs=null;
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			try{
				ResultSetMetaData rsMetaData = rs.getMetaData();
				rs.close();
				return rs;
			}
			catch (Exception e)
			{
				return rs;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			return rs;
		}
	}

	/**
	 * Close connection to DB
	 *
	 * @param -
	 * @return
	 * @throws
	 * @since 09-19-2019
	 * @version 1.2
	 *
	 */
	public void close_db_connection() {
		if (connection != null) {
			try {
				System.out.println("Closing Database Connection...");
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
