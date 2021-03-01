/**
 * 
 */
package com.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.model.dto.LectureList;
import com.project.util.*;

/**
 * @author 이종찬
 * @since jdk 1.8
 * @version 1.0
 */
public class LectureDao {
	private static LectureDao instance = new LectureDao();
	
	private LectureDao() {}
	
	public static LectureDao getInstance() {
		return instance;
	}
	
	private MySqlFactoryDao factory = MySqlFactoryDao.getInstance();
	/**
	 * 현재 강의 목록 조회
	 * @return true = list / false=null
	 */
	public ArrayList<LectureList> selectList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.getConnection();
			String sql = "select * from lecture_list";
			pstmt = conn.prepareStatement(sql
					);
			rs = pstmt.executeQuery();
			
			ArrayList<LectureList> list = new ArrayList<LectureList>();
			while(rs.next()) {
				String lectureNo = rs.getString("lecture_no");
				String lectureName = rs.getString("lecture_name");
				String lectureTeacher = rs.getString("lecture_teacher");
				int lecturePrice = rs.getInt("lecture_price");
				
				LectureList dto = new LectureList(lectureNo, lectureName, lectureTeacher, lecturePrice);
				list.add(dto);
			}
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	
	/**
	 * 수강신청하기
	 * @return true  / false
	 */
	public boolean acceptLecture(String memberId, String lectureNo, String lectureName, String lectureTeacher) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.getConnection();
			
			String sql = "insert into my_lecture values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, lectureNo);
			pstmt.setString(3, lectureName);
			pstmt.setString(4, lectureTeacher);
			pstmt.setString(5, Utility.getCurrentDate());
			
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
	/**
	 * 현재 내 강의 목록 조회
	 * @return true = list / false=null
	 */
	public ArrayList<LectureList> selectMyLectureList(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.getConnection();
			
			String sql = "select * from my_lecture where member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			ArrayList<LectureList> list = new ArrayList<LectureList>();
			while(rs.next()) {
				String lectureNo = rs.getString("lecture_no");
				String lectureName = rs.getString("lecture_name");
				String lectureTeacher = rs.getString("lecture_teacher");
				String lectureSignDate = rs.getString("lecture_sign_date");
				
				LectureList dto = new LectureList(lectureNo, lectureName, lectureTeacher, lectureSignDate);
				list.add(dto);
			}
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	/**
	 * 장바구니에 담기
	 * @return true / false
	 */
	public boolean acceptBasket(String memberId, String lectureNo, String lectureName, String lectureTeacher,
			int lecturePrice) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.getConnection();
			
			String sql = "insert into basket values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, lectureNo);
			pstmt.setString(3, lectureName);
			pstmt.setString(4, lectureTeacher);
			pstmt.setInt(5, lecturePrice);
			
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
	/**
	 * 내 장부바구니 목록 조회
	 * @return true = list / false=null
	 */
	public ArrayList<LectureList> selectMyBasketList(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.getConnection();
			
			String sql = "select * from basket where member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			ArrayList<LectureList> list = new ArrayList<LectureList>();
			while(rs.next()) {
				String lectureNo = rs.getString("lecture_no");
				String lectureName = rs.getString("lecture_name");
				String lectureTeacher = rs.getString("lecture_teacher");
				int lecturePrice = rs.getInt("lecture_price");
				
				LectureList dto = new LectureList(lectureNo, lectureName, lectureTeacher, lecturePrice);
				list.add(dto);
			}
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	/**
	 * 상세정보
	 * @param lectureNo
	 * @return
	 */
	public ArrayList<LectureList> selectLectureInformation(String lectureNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			
			String sql = "select * from lecture_list where lecture_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lectureNo);
			
			rs = pstmt.executeQuery();
			ArrayList<LectureList> list = new ArrayList<LectureList>();
			if (rs.next()) {
				String lectureNo1 = rs.getString("lecture_no");
				String lectureName = rs.getString("lecture_name");
				String lectureTeacher = rs.getString("lecture_teacher");
				int lecturePrice = rs.getInt("lecture_price");
				String lectureRegDate = rs.getString("lecture_reg_date");
				String lectureInfo = rs.getString("lecture_info");
				
				LectureList dto = new LectureList(lectureNo, lectureName, lectureTeacher, lecturePrice,lectureRegDate, lectureInfo);
				list.add(dto);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}

	/**
	 * 강의듣기
	 * @param lectureNo
	 * @return
	 */
	public ArrayList<LectureList> selectListenLecture(String lectureNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			
			String sql = "select * from lecture_list where lecture_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lectureNo);
			
			rs = pstmt.executeQuery();
			ArrayList<LectureList> list = new ArrayList<LectureList>();
			if (rs.next()) {
				String lectureNo1 = rs.getString("lecture_no");
				String lectureName = rs.getString("lecture_name");
				String lectureTeacher = rs.getString("lecture_teacher");
				String lectureVideo = rs.getString("lecture_video");
				String lectureRegDate = rs.getString("lecture_reg_date");
				
				LectureList dto = new LectureList(lectureNo1, lectureName, lectureTeacher,lectureRegDate  ,lectureVideo);
				list.add(dto);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	/**
	 * 수강신청확인(중복처리)
	 * @param memberId 아이디
	 * @param lectureNo 강의번호
	 * @return 없으면 0 // 있으면 1
	 */
	public String selectLectureExist(String memberId, String lectureNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			
			String sql = "select exists (select * from my_lecture where member_id=? and lecture_no=?) as exist";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, lectureNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getString("exist");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	/**
	 * 장바구니확인(중복처리)
	 * @param memberId 아이디
	 * @param lectureNo 강의번호
	 * @return 없으면 0 // 있으면 1
	 */
	public String selectBasketExist(String memberId, String lectureNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			
			String sql = "select exists (select * from basket where member_id=? and lecture_no=?) as exist";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, lectureNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getString("exist");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	/**
	 * 새로운 강의 등록하기
	 * @param list 등록할 강의 정보
	 * @return 등록이 되면 true/ 안되면 false
	 */
	public boolean addNewLecture(LectureList list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			
			String sql = "insert into lecture_list values(?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, list.getLectureNo());
			pstmt.setString(2, list.getLectureName());
			pstmt.setString(3, list.getLectureTeacher());
			pstmt.setInt(4, list.getLecturePrice());
			pstmt.setString(5, list.getLectureRegDate());
			pstmt.setString(6, list.getLectureInfo());
			pstmt.setString(7, list.getLectureVideo());
			
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				return true;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return false;
	}
	
	
	
}
