/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : Entity - 정보제공자별 시간대별 통계생성를 위한 Log테이블 Primary Key 클래스(TbMdcos12PK)
 * * Class Name : TbMdcos12PK.java
 * Description : 정보제공자별 시간대별 통계생성를 위한 Log테이블 Primary Key 클래스
 * Modification History
 * 수정일	       수정자 요청자  수정내용
 * -------------------------------------
 * 2023.02.01  이병관 천민희  최초작성   
 * 2023.03.02  이병관 천민희  주석작업
 * </PRE>
 * @version 1.0
 * @author 정/부 담당자(천민희/육지혜)
 * Copyright (C) 2023 by SK co.,Ltd. All right reserved.
**/package com.mydata.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TbMdcos12 Entity 클래스 정보제공자별 시간대별 통계생성를 위한 Log테이블 Primary Key 클래스
 * 
 * @name_ko 보험 기본정보 조회 Legacy Primary Key 클래스
 * @author 이병관
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
public class TbMdcos12PK implements Serializable {
	private Integer requestDate; // -- 요청일자
	private Integer requestHour; // -- 요청시간
	private String apiCode; // -- API 구분코드
	private String rspCode; // -- 세부응답코드
	
	@Builder
	public TbMdcos12PK(LocalDateTime localDateTime, String apiCode, String rspCode) {
		this.requestDate = Integer.parseInt(localDateTime.format((DateTimeFormatter.ofPattern("yyyyMMdd"))));
		this.requestHour = localDateTime.getHour();
		this.apiCode = apiCode;
		this.rspCode = rspCode;
	}
}
