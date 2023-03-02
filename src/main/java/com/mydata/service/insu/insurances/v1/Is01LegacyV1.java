/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : 보험 기본정보 조회 - 보험 기본정보 조회 Legacy 클래스(Is01Legacy)
 * Class Name : Is01LegacyV1.java
 * Description : 보험 기본정보 조회 Legacy 클래스
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

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 보험 기본정보 조회 Legacy 클래스 정보주체가 계약한 금융회사별 보험 목록 조회(Feign Client)
 * 
 * @name_ko 보험 기본정보 조회 Legacy 클래스
 * @author 이병관
 */
@FeignClient(name = "IS01V1", url = "${prop.test.url}")
public interface Is01LegacyV1 {
	/*
	 * 정보주체가 계약한 보험별 기본정보(주계약정보) 조회한다. GET 방식으로 RequestParam 요청에 대한 Feign Client
	 * 
	 * @name_ko정보주체가 계약한 보험별 기본정보(주계약정보) 조회
	 * 
	 * Is01LegacyV1.getInsurances(authorization, nextPage, limit)
	 * 
	 * @RequestParam Authorization 접근토큰
	 * 
	 * @RequestParam nextPage 조회 타임스탬프
	 * 
	 * @RequestParam limit 최대조회갯수
	 * 
	 * @Return is01Reply 보험 기본정보 조회 응답
	 */
	@GetMapping("/mydata/insurances/{authorization}")
	Is01ReplyV1 getInsurances(@PathVariable(value = "authorization", required = false) String authorization,
			@RequestParam(value = "nextPage", required = false) String nextPage, @RequestParam("limit") String limit);

	/*
	 * 정보주체가 계약한 보험별 기본정보(주계약정보) List 조회한다. Post 방식으로 @RequestBody 요청에 대한 feign
	 * Client
	 * 
	 * @name_ko정보주체가 계약한 보험별 기본정보(주계약정보) 조회
	 * 
	 * Is01LegacyV1.getInsuranceList(is01Request)
	 * 
	 * @RequestBody is01Request 요청전문
	 * 
	 * @Return List<InsuList> 기본정보(주계약정보) List 응답
	 */
	@PostMapping("/mydata/insuranceList")
	List<InsuListV1> getInsuranceList(Is01RequestV1 isRequest);
}
