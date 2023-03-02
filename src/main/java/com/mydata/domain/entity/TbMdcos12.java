/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : Entity - 정보제공자별 시간대별 통계생성를 위한 Log테이블 클래스(TbMdcos12)
 * Class Name : TbMdcos12.java
 * Description : 정보제공자별 시간대별 통계생성를 위한 Log테이블 클래스
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
package com.mydata.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TbMdcos12 Entity 클래스 정보제공자별 시간대별 통계생성를 위한 Log테이블
 * 
 * @name_ko 보험 기본정보 조회 Legacy 클래스
 * @author 이병관
 */
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC
@Entity
@Table(name = "TB_MDCOS12") // --정보제공자별 시간대별 통계생성를 위한 Log(Table)
@Schema(description = "정보제공자별 시간대별 통계(Table)")
@IdClass(TbMdcos12PK.class)
public class TbMdcos12 implements Serializable {
	@Id
	@Column(name = "REQUEST_DATE", nullable = false)
	@Schema(description = "요청일자", nullable = false)
	private Integer requestDate; // -- 요청일자

	@Id
	@Column(name = "REQUEST_HOUR", nullable = false)
	@Schema(description = "요청시간", nullable = false)
	private Integer requestHour; // -- 요청시간

	@Id
	@Column(name = "API_CODE", length = 4, nullable = false)
	@Schema(description = "API 구분코드", nullable = false)
	private String apiCode; // -- API 구분코드

	@Id
	@Column(name = "RSP_CODE", length = 30, nullable = false)
	@Schema(description = "세부응답코드", nullable = false)
	private String rspCode; // 세부응답코드

	@Column(name = "OCCURE_COUNT", nullable = false)
	@Schema(description = "발생횟수", nullable = false)
	private Integer occureCount; // 발생횟수

	@Builder
	public TbMdcos12(TbMdcos12PK tbMdcos12PK) {
		this.requestDate = tbMdcos12PK.getRequestDate();
		this.requestHour = tbMdcos12PK.getRequestHour();
		this.apiCode = tbMdcos12PK.getApiCode();
		this.rspCode = tbMdcos12PK.getRspCode();
		this.occureCount = 1;
	}
}
