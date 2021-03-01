/**
 * 
 */
package com.project.Service;

import java.util.ArrayList;

import com.project.DAO.LectureDao;
import com.project.model.dto.LectureList;
/**
 * 강의 관련 서비스 클래스 
 * @author 이종찬
 * @since jdk 1.8
 * @version 1.0
 */
public class LectureService {
	private LectureDao dao = LectureDao.getInstance();
	/**
	 * 강의목록 조회
	 * @return list 
	 */
	public ArrayList<LectureList> getLectureList() {
		
		return dao.selectList();
	}
	/**
	 * 수강신청하기 
	 * @param memberId String
	 * @param lectureNo String
	 * @param lectureName String
	 * @param lectureTeacher String
	 * @return list
	 */
	public boolean insertMyLecture(String memberId, String lectureNo, String lectureName, String lectureTeacher) {
		
		return dao.acceptLecture(memberId, lectureNo,lectureName, lectureTeacher);
	}
	/**
	 * 내 수강목록 조회
	 * @param memberId 아이디 String
	 * @return list
	 */
	public ArrayList<LectureList> getMyLectureList(String memberId) {
		
		return dao.selectMyLectureList(memberId);
	}
	
	/**
	 * 장바구니에 담기
	 * @param memberId String
	 * @param lectureNo String
	 * @param lectureName String
	 * @param lectureTeacher String
	 * @param lecturePrice Int
	 * @return boolean
	 */
	public boolean insertMyBasket(String memberId, String lectureNo, String lectureName, String lectureTeacher,
			int lecturePrice) {
		
		return dao.acceptBasket(memberId, lectureNo, lectureName, lectureTeacher,lecturePrice);
	}
	
	/**
	 * 내 장바구니 조회
	 * @param memberId 아이디 String
	 * @return list
	 */
	public ArrayList<LectureList> getMyBasketList(String memberId) {
		return dao.selectMyBasketList(memberId);
	}
	/**
	 * 강의 상세정보
	 * @param lectureNo
	 * @return
	 */
	public ArrayList<LectureList> getLectureInformation(String lectureNo) {
		
		return dao.selectLectureInformation(lectureNo);
	}
	/**
	 * 강의목록 확인
	 * @param lectureNo
	 * @return
	 */
	public ArrayList<LectureList> getListenLecture(String lectureNo) {
		
		return dao.selectListenLecture(lectureNo);
	}
	/**
	 * 강의목록에 이미 있는지 확인
	 * @param memberId
	 * @param lectureNo
	 * @return
	 */
	public String existLecture(String memberId, String lectureNo) {
		
		return dao.selectLectureExist(memberId, lectureNo);
	}
	/**
	 * 장바구니에 이미 있늕지 확인
	 * @param memberId
	 * @param lectureNo
	 * @return
	 */
	public String existBasket(String memberId, String lectureNo) {
		
		return dao.selectBasketExist(memberId, lectureNo);
	}
	public boolean addLecture(LectureList list) {
		
		return dao.addNewLecture(list);
	}

}
