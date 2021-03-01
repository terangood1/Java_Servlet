/**
 * 
 */
package com.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


/**
 * <pre>
 * Factory Pattern
 * Singleton Pattern
 * </pre>
 * mysql 생성 및 삭제 클래스 
 * @author 이종찬
 * @since jdk 1.8
 * @version 1.0
 */
public class MySqlFactoryDao {
private static MySqlFactoryDao instance = new MySqlFactoryDao();
	
    private MySqlFactoryDao() {}

    public static MySqlFactoryDao getInstance() {
    	return instance;
    }
    /** db연결 connection 반환 객체 : jndi api*/
    public Connection getConnection() {
    	Connection conn = null;
        
        try {
            Context context = new InitialContext();
        	DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/MySQL8");
            conn = ds.getConnection();
        } catch (Exception e) {
            System.out.println("[오류] : " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    /** db자원해제
     * 
     * @param conn Connection
     * @param stmt Statement, PreparedStatement, CallbleStatement
     * @param rs ResultSet
     */
    public void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null && !conn.isClosed()) {
                rs.close();
            }
            if (stmt != null && !conn.isClosed()) {
                stmt.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
        	System.out.println("[오류] : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
