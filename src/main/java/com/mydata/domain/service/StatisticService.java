/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : Service - 통계 Service 클래스(StatisticService)
 * Class Name : StatisticService.java
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
package com.mydata.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mydata.domain.mybatis.IStatisticDAO;
import com.mydata.domain.mybatis.TmSlotList;
import com.mydata.domain.mybatis.TmSlotListDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 통계 Service 클래스 통계 서비스
 * 
 * @name_ko 정보제공자 통계자료 서비스 클래스
 * @author 이병관
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class StatisticService {
	final IStatisticDAO statisticDAO;

	/*
	 * 정보제공자 통계자료 중 시간대별 통계목록 조회한다.
	 * 
	 * @name_ko 정보제공자 통계자료 중 시간대별 통계목록 조회
	 * 
	 * StatisticService.getTmSlotList(apiCode,requestDate)
	 * 
	 * @Param apiCode API 구분 코드
	 * 
	 * @Param requestDate 통계일자
	 * 
	 * @Return List<TmSlotList>> 시간대별 통계목록
	 */
	public List<TmSlotList> getTmSlotList(String ApiCode, String RequestDate) {
		List<TmSlotList> tmSlotList = statisticDAO
				.getTmSlotList(TmSlotListDTO.builder().apiCode(ApiCode).requestDate(RequestDate).build());

		return tmSlotList;
	}
}
