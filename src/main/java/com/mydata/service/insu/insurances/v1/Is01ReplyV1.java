/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : 보험 기본정보 조회 - 보험 기본정보 조회 응답 클래스(Is01Reply)
 * Class Name : Is01ReplyV1.java
 * Description : 보험 기본정보 조회 응답 클래스
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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mydata.base.BaseReply;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 보험 기본정보 조회 응답 클래스
 * 
 * @name_ko 보험 기본정보 조회 응답 클래스
 * @author 이병관
 */
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class) // Camel응답을 Snake응답으로
@JsonInclude(JsonInclude.Include.NON_NULL) // Null 값은 제외한다.
@Schema(description = "보험 기본정보 조회 응답")
public class Is01ReplyV1 extends BaseReply {
	// @Schema(description = "", nullable = true , defaultValue = "" , example = ""
	// , allowableValues = {"", ""})
	@Schema(description = "조회 타임스탬프 N (14)", nullable = true)
	String searchTimestamp; // -- 조회 타임스탬프 N N (14)
	@Schema(description = "다음 페이지 기준개체 N aNS (1000)", nullable = true)
	String nextPage; // -- 다음 페이지 기준개체 N aNS (1000)
	@Schema(description = "보유계약수 N (5)", nullable = false)
	String insuCnt; // -- 보유계약수 Y N (5)
	@Schema(description = "보유계약목록　Object", nullable = false)
	List<InsuListV1> insuList; // -- 보유계약목록 Y Object
}