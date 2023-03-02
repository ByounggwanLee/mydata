
/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : Service - 요청 및 응답에 대한 로그 Service  클래스(StatisticService)
 * Class Name : TransationLogService.java
 * Description : 요청 및 응답에 대한 로그 Service 클래스
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

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mydata.domain.entity.TbMdcos12;
import com.mydata.domain.entity.TbMdcos12PK;
import com.mydata.domain.repository.TbMdcos12Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 요청 및 응답에 대한 로그 Service 클래스 요청 및 응답에 대한 로그 서비스
 * 
 * @name_ko 요청 및 응답에 대한 로그 서비스 클래스
 * @author 이병관
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TransationLogService {
	final TbMdcos12Repository repository;

	/*
	 * 요청 및 응답에 대한 로그처리
	 * 
	 * TransationLogService.setApiCodeRspCode(apiCode,rspCode)
	 * 
	 * @Param apiCode API 구분 코드W
	 * 
	 * @Param rspCode 응답코드
	 */
	@Transactional
	public void setApiCodeRspCode(String apiCode, String rspCode) {
		TbMdcos12PK tbMdcos12PK = TbMdcos12PK.builder().apiCode(apiCode).rspCode(rspCode)
				.localDateTime(LocalDateTime.now()).build();
		TbMdcos12 newData = TbMdcos12.builder().tbMdcos12PK(tbMdcos12PK).build();
		Optional<TbMdcos12> oldData = repository.findById(tbMdcos12PK);

		log.debug(tbMdcos12PK.toString());
		if (oldData.isPresent()) {
			newData.setOccureCount(oldData.get().getOccureCount() + 1);
			log.debug("oldData");
		}
		log.debug(newData.toString());
		repository.save(newData);
	}
}
