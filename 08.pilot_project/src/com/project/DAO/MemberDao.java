/**
 * 
 */
package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.model.dto.Member;

/**
 * 회원 관련 DAO 
 * @author 이종찬
 * @since jdk 1.8
 * @version 1.0
 */

public class MemberDao {
	/** Singleton pattern Dao */
	private static MemberDao instance = new MemberDao();
	
	private MemberDao() {}

	public static MemberDao getInstance() {
		return instance;
	}
	/** mysql 객체 불러오기 */
	private MySqlFactoryDao factory = MySqlFactoryDao.getInstance();
	
	/** 
	 * 로그인 정보 확인 
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @return 성공하면 grade String, 실패하면 null  
	 */
	public String login(String memberId, String memberPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.getConnection();
			String sql = "select * from member where member_id=? and member_pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString("grade");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	/** 
	 * 회원가입  
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 번호
	 * @param email 이메일
	 * @param entryDate (현재 날짜로 고정)
	 * @param grade (일반화원은 C 고정)
	 * @return 성공하면 true, 실패하면 false 
	 */
	public boolean insertMember(Member dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.getConnection();
			
			String sql = "insert into member values	(?,?,?,?,?,?,?)"; 
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getMobile());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getEntryDate());
			pstmt.setString(7, dto.getGrade());

			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			factory.close(conn, pstmt, rs);
		}
		return false;
	}
	
	
	
	
}
