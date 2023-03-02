/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : 공통 - 요청전문 공통클래스(BaseRequest)
 * Class Name : BaseRequest.java
 * Description : 요청전문 공통클래스
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

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Mydata 수신전문 공통 클래스 모든 수신전문은 상속하여 사용한다.
 * 
 * @name_ko 수신전문 공통 클래스
 * @author 이병관
 **/
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "수신전문 공통")
public class BaseRequest {
	// @Schema(description = "", nullable = true , defaultValue = "" , example = ""
	// , allowableValues = {"", ""})
	@Schema(description = "Header :  접근토큰	aNS (1500)", nullable = false)
	String authorization; // Header : 접근토큰 Y aNS (1500)
	@Schema(description = "Header :  거래고유번호	AN (25)", nullable = false)
	String xApiTranId; // Header : 거래고유번호 Y AN (25)
	@Schema(description = "Header :  API 유형		aNS (12)", nullable = false)
	String xApiType; // Header : API 유형 Y aNS (12)
	@Schema(description = " 기관코드		aN (10)", nullable = false)
	String orgCode; // Body : 기관코드 Y aN (10)
	@Schema(description = "조회 타임스탬프	N (14)", nullable = true)
	String searchTimestamp; // Body : 조회 타임스탬프 N N (14)
}
