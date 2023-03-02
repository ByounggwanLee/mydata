/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : 공통 - 응답전문 공통클래스(BaseReply)
 * Class Name : BaseReply.java
 * Description : 응답전문 공통클래스
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
package com.mydata.base;

import org.springframework.http.HttpHeaders;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Mydata 응답전문 공통 클래스 모든 응답전문은 상속하여 사용한다. 오류(Exception)는 바로 사용한다.
 * 
 * @name_ko 응답전문 공통 클래스
 * @author 이병관
 **/
@SuperBuilder
@Getter
@NoArgsConstructor
@Schema(description = "응답전문 공통")
public class BaseReply {
	// @Schema(description = "", nullable = true , defaultValue = "" , example = ""
	// , allowableValues = {"", ""})
	@Schema(description = "세부응답코드  aN (5)", nullable = false)
	String rspCode; // -- 세부 응답코드 Y aN (5)
	@Schema(description = "세부 응답메시지 AH (450)", nullable = false)
	String rspMsg; // -- 세부 응답메시지 Y AH (450)

	/*
	 * 요청메세지의 거래고유번호(x-api-tran-id)를 이용 전송 Header를 생성한다.
	 * 
	 * @name_ko 응답 Header 생성
	 * 
	 * BaseReply.getHeaders(xApiTranId)
	 * 
	 * @param xApiTranId 거래고유번호
	 * 
	 * @return HttpHeaders
	 */
	public static HttpHeaders getHeaders(String xApiTranId) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("x-api-tran-id", xApiTranId);
		return headers;
	}
}
