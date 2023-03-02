/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : Exception - Mydata RuntimeException 클래스(ApiCodeException)
 * Class Name : ApiCodeException.java
 * Description : Mydata RuntimeException 클래스
 * Modification History
 * 수정일	       수정자 요청자  수정내용
 * -------------------------------------
 * 2023.02.01  이병관 천민희  최초작성   
 * 2023.03.02  이병관 천민희  주석작업
 * </PRE>
 * @version 1.0
 * @author 정/부 담당자(천민희/육지혜)
 * Copyright (C) 2023 by SK co.,Ltd. All right reserved.
**/
package com.mydata.exception;

import com.mydata.base.ApiCode;

/**
 * Mydata RuntimeException 클래스
 * 
 * @name_ko Mydata RuntimeException 클래스
 * @author 이병관
 */
public class ApiCodeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ApiCode apiCode;
	
	public ApiCodeException(String message, ApiCode apiCode ) {
		super(message);
		this.apiCode = apiCode;
	}
	
	public ApiCodeException(ApiCode apiCode ) {
		super(apiCode.getRspMsg());
		this.apiCode = apiCode;
	}
	
	public ApiCode getApiCode() {
		return this.apiCode;
	}
}
