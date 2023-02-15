/**
 * 보험 기본정보 조회 Controller 클래스
 * 정보주체가 계약한 금융회사별 보험 목록 조회
 * @name_ko 보험 기본정보 조회 Controller 클래스
 * @author 이병관
*/
package com.mydata.v1.insu.insurances.basic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.base.BaseReply;
import com.mydata.exception.ApiCodeException;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/insurance")
@Slf4j
@Tag(name = "보험 기본정보 조회")
public class Is01Controller {
	final Is01Service is01Service; // 보험 기본정보 조회 Service 클래스

	/*
	 *  정보주체가 계약한 보험별 기본정보(주계약정보) 조회
	 *  @RequestHeader Authorization 접근토큰
	 *  @RequestHeader xApiTranId 거래고유번호
	 *  @RequestHeader xApiType API 유형
	 *  @RequestParam orgCode 기관코드
	 *  @RequestParam nextPage 조회 타임스탬프
	 *  @RequestParam limit 최대조회갯수
	 *  @Return ResponseEntity<is01Reply> 보험 기본정보 조회 응답
	 */
	@GetMapping
	@SneakyThrows
	public ResponseEntity getInsurances(
			@Parameter(required = false, description = "접근토큰") @RequestHeader(value = "Authorization", required = false) String authorization, // 접근토큰
			@Parameter(required = true, description = "거래고유번호") @RequestHeader(value = "x-api-tran-id") String xApiTranId, // 거래고유번호
			@Parameter(required = true, description = "API 유형") @RequestHeader(value = "x-api-type") String xApiType, // API 유형
			@Parameter(required = false, description = "기관코드") @RequestParam(value = "org_code") String orgCode, // 기관코드
			@Parameter(required = false, description = "조회 타임스탬프") @RequestParam(value = "search_timestamp", required = false) String searchTimestamp, // 조회 타임스탬프
			@Parameter(required = false, description = "다음 페이지 기준개체") @RequestParam(value = "next_page", required = false) String nextPage, // 다음 페이지 기준개체
			@Parameter(required = false, description = "최대조회갯수") @RequestParam(value = "limit") String limit) { // 최대조회갯수

		try {
			Is01Reply is01Reply = is01Service.getInsurances(authorization, xApiTranId, xApiType, orgCode,
					searchTimestamp, nextPage, limit);

			return new ResponseEntity<>(is01Reply, BaseReply.getHeaders(xApiTranId), HttpStatus.OK);
		} catch (ApiCodeException e) {
			return new ResponseEntity<>(
					BaseReply.builder().rspCode(e.getApiCode().getRspCode()).rspMsg(e.getMessage()).build(),
					BaseReply.getHeaders(xApiTranId), e.getApiCode().getHttpStatus());
		}
	}
}
