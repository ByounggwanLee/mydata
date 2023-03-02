/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : Mybatis - 통계 데이터 추출를 위한 DAO Interface(IStatisticDAO)
 * Class Name : IStatisticDAO.java
 * Description : 통계 데이터 추출를 위한 DAO Interface
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

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 통계 데이터 추출를 위한 DAO Interface
 * 
 * @name_ko 통계 데이터 추출를 위한 DAO Interface
 * @author 이병관
 **/
@Mapper
public interface IStatisticDAO {
	/*
	 * 정보제공자 통계자료 중 시간대별 통계목록 조회 한다.
	 * 
	 * name_ko : 정보제공자 통계자료 중 시간대별 통계목록 조회
	 * IStatisticDAO.getTmSlotList(tmSlotListDTO)
	 * @param tmSlotListDTO.requestDate 요청일자
	 * @param tmSlotListDTO.apiCode Api코드
 	 * 
	 * @return TmSlotList 시간대별 통계목록
	 */
	public List<TmSlotList> getTmSlotList(TmSlotListDTO tmSlotListDTO);
}
