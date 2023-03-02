/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : 보험 기본정보 조회 - 보험 기본정보 클래스(StatisticService)
 * Class Name : InsuListV1.java
 * Description : 보험 기본정보 클래스
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
package com.mydata.service.insu.insurances.v1;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 보험 기본정보 클래스
 * 
 * @name_ko 보험 기본정보 클래스
 * @author 이병관
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // Camel응답을 Snake응답으로
@Schema(description = "보험 기본정보")
public class InsuListV1 {
	// @Schema(description = "", nullable = true , defaultValue = "" , example = ""
	// , allowableValues = {"", ""})
	@Schema(description = "증권번호 aN (20)", nullable = false)
	String insuNum; // -- 증권번호 aN (20)
	@Schema(description = "전송요구 여부 Boolean", nullable = false)
	String isConsent; // -- 전송요구 여부 Y Boolean
	@Schema(description = "상품명 AH (300)", nullable = false)
	String prodName; // -- 상품명 AH (300)
	@Schema(description = "계약상태 (코드) aN (2)", nullable = false)
	String insuType; // -- 보험종류 구분 (코드) Y aN (2)
	@Schema(description = "계약상태 (코드) aN (2)", nullable = false)
	String insuStatus; // -- 계약상태 (코드) Y aN (2)
}
