/**
 * 
 */
package com.project.model.dto;

/**
 * 강의정보 모델링 클래스
 * 
 * @author 이종찬
 * @version 1.0
 * @since jdk 1.8
 *
 */
public class LectureList {
	/** 강의번호 */
	private String lectureNo;
	/** 강의이름 */
	private String lectureName;
	/** 강사이름 */
	private String lectureTeacher;
	/** 강의가격 */
	private int lecturePrice;
	/** 강의등록일 */
	private String lectureRegDate;
	/** 강의 결제일*/
	private String lectureSignDate;
	/** 강의 상세정보*/
	private String lectureInfo;
	/** 강의 영상*/
	private String lectureVideo;
	/**
	 * @return the lectureNo
	 */
	public String getLectureNo() {
		return lectureNo;
	}
	/**
	 * @return the lectureVideo
	 */
	public String getLectureVideo() {
		return lectureVideo;
	}
	/**
	 * @param lectureVideo the lectureVideo to set
	 */
	public void setLectureVideo(String lectureVideo) {
		this.lectureVideo = lectureVideo;
	}
	/**
	 * @param lectureNo the lectureNo to set
	 */
	public void setLectureNo(String lectureNo) {
		this.lectureNo = lectureNo;
	}
	/**
	 * @return the lectureInfo String
	 */
	public String getLectureInfo() {
		return lectureInfo;
	}
	/**
	 * @param lectureInfo the lectureInfo to set
	 */
	public void setLectureInfo(String lectureInfo) {
		this.lectureInfo = lectureInfo;
	}
	/**
	 * @return the lectureName String
	 */
	public String getLectureName() {
		return lectureName;
	}
	/**
	 * @param lectureName the lectureName to set
	 */
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	/** 
	 * @return the lectureTeacher String
	 */
	public String getLectureTeacher() {
		return lectureTeacher;
	}
	/**
	 * @param lectureTeacher the lectureTeacher to set
	 */
	public void setLectureTeacher(String lectureTeacher) {
		lectureTeacher = lectureTeacher;
	}
	/**
	 * @return the lecturePrice Int
	 */
	public int getLecturePrice() {
		return lecturePrice;
	}
	/**
	 * @param lecturePrice the lecturePrice to set
	 */
	public void setLecturePrice(int lecturePrice) {
		lecturePrice = lecturePrice;
	}
	/**
	 * @return the lectureRegDate String
	 */
	public String getLectureRegDate() {
		return lectureRegDate;
	}
	/**
	 * @param lectureRegDate the lectureRegDate to set
	 */
	public void setLectureRegDate(String lectureRegDate) {
		this.lectureRegDate = lectureRegDate;
	}
	/**
	 * @return the lectureSignDate String
	 */
	public String getLectureSignDate() {
		return lectureSignDate;
	}
	/**
	 * @param lectureSignDate the lectureSignDate to set
	 */
	public void setLectureSignDate(String lectureSignDate) {
		this.lectureSignDate = lectureSignDate;
	}
	/** 기본 생성자 */
	public LectureList() {}
	
	/**
	 * 강의 표시 생성자 / 장바구니목록표시 생성자
	 * @param lectureNo 강의 번호
	 * @param lectureName 강의이름
	 * @param lectureTeacher 강사이름
	 * @param lecturePrice 강의가격
	 */
	public LectureList(String lectureNo, String lectureName, String lectureTeacher, int lecturePrice) {
		this.lectureNo = lectureNo;
		this.lectureName = lectureName;
		this.lectureTeacher = lectureTeacher;
		this.lecturePrice = lecturePrice;
	}
	/**
	 * 강의등록 생성자
	 * @param lectureNo 강의번호
	 * @param lectureName 강의이름
	 * @param lectureTeacher 강사이름
	 * @param lecturePrice 강의가격
	 * @param lectureRegDate 강의등록일
	 * @param lectureInfo 강의 상세정보
	 * @param lectureVideo 강의영상 링크
	 */
	public LectureList(String lectureNo, String lectureName, String lectureTeacher, int lecturePrice,
			String lectureRegDate, String lectureInfo, String lectureVideo) {
		this.lectureNo = lectureNo;
		this.lectureName = lectureName;
		this.lectureTeacher = lectureTeacher;
		this.lecturePrice = lecturePrice;
		this.lectureRegDate = lectureRegDate;
		this.lectureInfo = lectureInfo;
		this.lectureVideo = lectureVideo;
	}
	/**
	 * 내 강의목록 생성자
	 * @param lectureNo 강의번호
	 * @param lectureName 강의이름
	 * @param lectureTeacher 강사이름
	 * @param lecturePrice 강의가격
	 * @param lectureRegDate 강의등록일
	 */
	public LectureList(String lectureNo, String lectureName, String lectureTeacher,	String lectureSignDate) {
		this.lectureNo = lectureNo;
		this.lectureName = lectureName;
		this.lectureTeacher = lectureTeacher;
		this.lectureSignDate = lectureSignDate;
	}

	
	/**
	 * 강의 기본 정보 생성자
	 * @param lectureNo
	 * @param lectureName
	 * @param lectureTeacher
	 * @param lecturePrice
	 * @param lectureRegDate
	 * @param lectureSignDate
	 * @param lectureInfo
	 */
	public LectureList(String lectureNo, String lectureName, String lectureTeacher, int lecturePrice,
			String lectureRegDate, String lectureInfo) {
		super();
		this.lectureNo = lectureNo;
		this.lectureName = lectureName;
		this.lectureTeacher = lectureTeacher;
		this.lecturePrice = lecturePrice;
		this.lectureRegDate = lectureRegDate;
		this.lectureInfo = lectureInfo;
	}
	
	
	
	/**
	 * 강의 영상 시청
	 * @param lectureNo
	 * @param lectureName
	 * @param lectureTeacher
	 * @param lectureSignDate
	 * @param lectureVideo
	 */
	public LectureList(String lectureNo, String lectureName, String lectureTeacher, String lectureSignDate,
			String lectureVideo) {
		super();
		this.lectureNo = lectureNo;
		this.lectureName = lectureName;
		this.lectureTeacher = lectureTeacher;
		this.lectureVideo = lectureVideo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(lectureNo);
		builder.append(", ");
		builder.append(lectureName);
		builder.append(", ");
		builder.append(lectureTeacher);
		builder.append(", ");
		builder.append(lecturePrice);
		builder.append(", ");
		builder.append(lectureRegDate);
		return builder.toString();
	}
	
	
	
	
	
}
