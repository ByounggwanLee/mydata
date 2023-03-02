/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : DTO - 시간대별 통계목록 조회를 위한 DTO 클래스(BaseReply)
 * Class Name : TmSlotListDTO.java
 * Description : 시간대별 통계목록 조회를 위한 DTO 클래스
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
package com.mydata.domain.mybatis;

import lombok.Builder;

import lombok.Data;
/**
 * 시간대별 통계목록 조회를 위한 DTO 클래스
 * 
 * @name_ko 시간대별 통계목록 조회를 위한 DTO 클래스
 * @author 이병관
 **/
@Data
@Builder
public class TmSlotListDTO {
	String requestDate;    // 요청일자
	String apiCode;        // Api코드
}
