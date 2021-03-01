/**
 * 
 */
package com.project.Service;

import com.project.DAO.MemberDao;
import com.project.model.dto.Member;

/**
 * 회원 관련 서비스 클래스 
 * @author 이종찬
 * @since jdk 1.8
 * @version 1.0
 */
public class MemberService {
	private MemberDao dao = MemberDao.getInstance();
	
	/** 로그인
	 * 
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @return grade String 
	 */
	public String login(String memberId, String memberPw) {
		return dao.login(memberId, memberPw);
	}
	/**
	 *  회원가입
	 * @param dto 회원정보 객체
	 * @return true, false
	 */
	public boolean addMember(Member dto) {
		
		return dao.insertMember(dto);
	}
}
