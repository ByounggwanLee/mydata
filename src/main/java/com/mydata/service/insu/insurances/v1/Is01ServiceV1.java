/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : 보험 기본정보 조회 - 보험 기본정보 조회 Service 클래스(Is01Service)
 * Class Name : Is01ServiceV1.java
 * Description : 보험 기본정보 조회 Service 클래스
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

import org.springframework.stereotype.Service;

import com.mydata.base.ApiCode;
import com.mydata.exception.ApiCodeException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 보험 기본정보 조회 Service 클래스
 * 
 * 정보주체가 계약한 금융회사별 보험 목록 조회(POJO) • Pagination, 보험종류구분(코드) 기준 오름차순 • 계약자가 정보주체
 * 본인인 상품 회신 (계피상이건도 포함계약자 조회시 계피상이 포함) • 2006년 이전 가입 건도 현재 계약상태가 ‘정상’일 경우 회신 •
 * 계약상태가 ‘만기’인 경우, 조회일 기준 5년 이내 만기 계약일 경우에만 회신 • 일부 기관의 경우 아래와 같은 계약 존재 시
 * 계약상태(주계약)를 ‘소멸’로 회신 1) 표준화 갱신 상품의 경우 주계약이 ‘소멸’ 상태이나, 특약은 ‘정상’인 계약 존재 2)
 * ‘주계약만기일 < 특약만기일‘ 상품의 경우 주계약이 ‘소멸’ 상태이나, 특약은 ‘정상’인 계약 존재 3) 연금전환 처리되는 계약중 주계약만
 * 전환 시 주계약은 ‘해지’ 또는 ‘소멸’ 상태이나, 특약은 ‘정상’인 계약 존재 → 이 경우 계약상태를 ‘소멸’로 회신 ⇒ 세 가지 케이스
 * 모두 해당 상품에 대한 기본정보(보험-002)와 특약정보(보험-003)를 제공 ⇒ 다만, 3)의 경우 주계약이 전환된 신규 연금상품의7경우
 * 기본정보만 제공하고 특약정보는 미제공
 * 
 * @name_ko 보험 기본정보 조회 Service 클래스
 * @author 이병관
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class Is01ServiceV1 {
	final Is01LegacyV1 is01Legacy;

	/*
	 * 정보주체가 계약한 보험별 기본정보(주계약정보) 조회
	 * 
	 * @name_ko 보험별 기본정보(주계약정보) 조회
	 * 
	 * is01Legacy.getInsurances(Authorization, xApiTranId, xApiType, orgCode,
	 * nextPage, limit)
	 * 
	 * @Param Authorization 접근토큰
	 * 
	 * @Param xApiTranId 거래고유번호
	 * 
	 * @Param xApiType API 유형
	 * 
	 * @Param orgCode 기관코드
	 * 
	 * @Param nextPage 조회 타임스탬프
	 * 
	 * @Param limit 최대조회갯수
	 * 
	 * @Return is01Reply 보험 기본정보 조회 응답
	 */
	public Is01ReplyV1 getInsurances(String authorization, // 접근토큰
			String xApiTranId, // 거래고유번호
			String xApiType, // API 유형
			String orgCode, // 기관코드
			String searchTimestamp, // 조회 타임스탬프
			String nextPage, // 조회 타임스탬프
			String limit) {

		Is01ReplyV1 is01Reply;

		Is01RequestV1 is01Request = Is01RequestV1.builder().authorization(authorization).xApiTranId(xApiTranId)
				.xApiType(xApiType).orgCode(orgCode).searchTimestamp(searchTimestamp).nextPage(nextPage).limit(limit)
				.build();

		log.debug(is01Request.toString());

		try {
			if (orgCode.equalsIgnoreCase("error")) {
				log.debug("Exception");
				throw new ApiCodeException("Duplicated Email", ApiCode.BAD_REQUEST_1);
			}

			is01Reply = is01Legacy.getInsurances(authorization, nextPage, limit);

			is01Reply.setInsuList(is01Legacy.getInsuranceList(is01Request));

			log.debug(is01Reply.toString());

		} catch (ApiCodeException ex) {
			log.debug(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			log.debug(ex.getMessage());
			throw new ApiCodeException(ApiCode.INTERNAL_SERVER_ERROR);
		}
		return is01Reply;

	}
}