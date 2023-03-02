/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : Sample - 보험 정보 조회 Legacy 테스트 Controller 클래스(InsuranceTestController)
 * Class Name : InsuranceTestController.java
 * Description : 보험 정보 조회 Legacy 테스트 Controller클래스
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
package com.mydata.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.base.ApiCode;
import com.mydata.service.insu.insurances.v1.InsuListV1;
import com.mydata.service.insu.insurances.v1.Is01ReplyV1;
import com.mydata.service.insu.insurances.v1.Is01RequestV1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * 보험 정보 조회 Legacy 테스트 Controller 클래스 정보주체가 계약한 금융회사별 보험 목록 조회 기간계 서버에 존재하는
 * RestController를 가정한 Class
 * 
 * @name_ko 보험 기본정보 조회 Lagacy Controller 클래스
 * @author 이병관
 */
@RestController
@Tag(name = "Legacy 테스트")
@Slf4j
public class InsuranceTestController {
	/*
	 * 정보주체가 계약한 보험별 기본정보(주계약정보) 조회 Legacy 시스템에서 조회한다.[GET]
	 * 
	 * @name_ko 정보주체가 계약한 보험별 기본정보(주계약정보) 조회 Legacy 시스템에서 조회
	 * 
	 * InsuranceTestController.InsuranceTestController(Authorization,
	 * nextPage,limit, is01Reply)
	 * 
	 * @RequestParam Authorization 접근토큰
	 * 
	 * @RequestParam nextPage 조회 타임스탬프
	 * 
	 * @RequestParam limit 최대조회갯수
	 * 
	 * @Return is01Reply 보험 기본정보 조회 응답
	 */
	@Operation(summary = "보험별 기본정보(주계약정보) 조회", description = "정보주체가 계약한 보험별 기본정보(주계약정보) 조회")
	@GetMapping("/insurances/{authorization}")
	Is01ReplyV1 getInsurances(
			@Parameter(required = false, description = "접근토큰") @PathVariable(value = "authorization") String authorization,
			@Parameter(required = false, description = "다음 페이지 기준개체") @RequestParam(value = "nextPage") String nextPage,
			@Parameter(description = "최대조회갯수") @RequestParam(value = "limit") String limit) {

		Is01ReplyV1 is01Reply = Is01ReplyV1.builder().rspCode(ApiCode.OK.getRspCode()).rspMsg(ApiCode.OK.getRspMsg())
				.searchTimestamp("searchTimestamp").nextPage("nextPage").insuCnt("10").insuList(new ArrayList<>())
				.build();

		return is01Reply;
	}

	/*
	 * 정보주체가 계약한 보험별 기본정보(주계약정보) List 조회한다.[Post 방식으로 @RequestBody 요청에 대한 Sample]
	 * 
	 * @name_ko 정보주체가 계약한 보험별 기본정보(주계약정보) List 조회 Legacy 시스템에서 조회
	 * 
	 * InsuranceTestController.InsuranceTestController(is01Request)
	 * 
	 * @RequestBody is01Request 요청전문
	 * 
	 * @Return List<InsuList> 기본정보(주계약정보) List 응답
	 */
	@Operation(summary = "보험별 기본정보(주계약정보) List 조회", description = "정보주체가 계약한 보험별 기본정보(주계약정보) List 조회")
	@PostMapping("/insuranceList")
	List<InsuListV1> getInsuranceList(@RequestBody Is01RequestV1 is01Request) {
		List<InsuListV1> insuList = new ArrayList<>();
		for (int i = 1; i < 11; i++) {
			insuList.add(InsuListV1.builder().insuNum("insuNum" + 1).isConsent("isConsent" + i).prodName("prodName" + i)
					.insuStatus("insuStatus" + i).insuType("insuType" + i).build());
		}

		return insuList;
	}
}
