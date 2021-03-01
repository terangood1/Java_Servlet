/**
 * 
 */
package com.project.util;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.lang.StringBuilder;

/**
 * utility 클래스
 * @author 이종찬
 * @version ver1.0
 * @since jdk1.8
 */
public class Utility {
	/**
	 * 현재 날짜 반환 함수
	 * @param pattern SimpleDateFormat의 패턴
	 * @param locale  Locale의 국가별 시간
	 * @return String 타입의 현재 날짜(년-월-일) 
	 */
	public static String getCurrentDate() {

		return getCurrentDate("yyyy-MM-dd",Locale.KOREA);
	}
	public static String getCurrentDate(String pattern) {
		return getCurrentDate(pattern, Locale.KOREA);
	}
	public static String getCurrentDate(String pattern, Locale locale){
		return new SimpleDateFormat(pattern, locale).format(new Date());
	}
	
	/**
	 * 임의의 숫자(0~9)6개 반환 함수
	 * @param length 임의의 숫자 갯수를 지정
	 * @return String 임의의 숫자6개 
	 */
	public static String getSecureNumber() {
		return getSecureNumber(6);
	}
	
	public static String getSecureNumber(int length) {
		StringBuilder secureNumber = new StringBuilder();
		Random random = new Random((long)(System.nanoTime() * Math.random()));
		for (int index = 0; index < length; index++) {
			secureNumber.append(random.nextInt(10));
		}
		return secureNumber.toString();
	}
	/**
	 * 임의의 대문자 알파벳과 숫자(0~9) 중 3개 반환 함수
	 * @param length 임의의 숫자 및 알파벳의 숫자
	 * @param isUpper  true = 대문자, false = 소문자
	 * @return String 알파벳, 숫자 반환 
	 */
	public static String getSecureNumberAndString() {
		return getSecureNumberAndString(6, true);
	}
	
	public static String getSecureNumberAndString(int length) {
		return getSecureNumberAndString(length, true);
	}

	public static String getSecureNumberAndString(int length, boolean isUpper) {
		StringBuilder secureNumber = new StringBuilder();
		Random random = new Random((long)(System.nanoTime() * Math.random()));
		for (int index = 0; index < length; index++) {
			if (random.nextBoolean()) {
				secureNumber.append(random.nextInt(10));
			} else {
				if (isUpper) {
					secureNumber.append((char)(random.nextInt(26) + 65));
				} else {
					secureNumber.append((char)(random.nextInt(26) + 97));
				}
			}
		}
		return secureNumber.toString();
	}	

}

