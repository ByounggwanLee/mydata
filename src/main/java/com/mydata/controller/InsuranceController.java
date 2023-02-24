/**
 * 보험조회 Controller 클래스
 * 정보주체가 계약한 금융회사별 보험 목록 조회
 * @name_ko 보험 기본정보 조회 Controller 클래스
 * @author 이병관
*/
package com.mydata.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.base.BaseReply;
import com.mydata.exception.ApiCodeException;
import com.mydata.service.insu.insurances.v1.Is01ReplyV1;
import com.mydata.service.insu.insurances.v1.Is01ServiceV1;
import com.mydata.service.insu.insurances.v2.Is01ReplyV2;
import com.mydata.service.insu.insurances.v2.Is01ServiceV2;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "보험정보조회" , description = "정보주체가 계약한 보험별 정보 조회")
public class InsuranceController {
	final Is01ServiceV1 is01ServiceV1; // 보험 기본정보 조회 Service 클래스
	final Is01ServiceV2 is01ServiceV2; // 보험 기본정보 조회 Service 클래스

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
	@Operation(summary = "보험 기본정보 조회", description = "정보주체가 계약한 보험별 기본정보(주계약정보) 조회")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Is01ReplyV1.class))),
	        @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = Is01ReplyV1.class)))
	    })
	@GetMapping("/v1/insurances")
	@SneakyThrows
	public ResponseEntity<Is01ReplyV1> getInsurancesV1(
			@Parameter(required = false, description = "접근토큰") @RequestHeader(value = "Authorization", required = false) String authorization, // 접근토큰
			@Parameter(required = true, description = "거래고유번호") @RequestHeader(value = "x-api-tran-id") String xApiTranId, // 거래고유번호
			@Parameter(required = true, description = "API 유형") @RequestHeader(value = "x-api-type") String xApiType, // API 유형
			@Parameter(required = false, description = "기관코드") @RequestParam(value = "org_code") String orgCode, // 기관코드
			@Parameter(required = false, description = "조회 타임스탬프") @RequestParam(value = "search_timestamp", required = false) String searchTimestamp, // 조회 타임스탬프
			@Parameter(required = false, description = "다음 페이지 기준개체") @RequestParam(value = "next_page", required = false) String nextPage, // 다음 페이지 기준개체
			@Parameter(required = false, description = "최대조회갯수") @RequestParam(value = "limit") String limit) { // 최대조회갯수

		try {
			Is01ReplyV1 is01Reply = is01ServiceV1.getInsurances(authorization, xApiTranId, xApiType, orgCode,
					searchTimestamp, nextPage, limit);

			return new ResponseEntity<>(is01Reply, BaseReply.getHeaders(xApiTranId), HttpStatus.OK);
		} catch (ApiCodeException e) {
			return new ResponseEntity<>(
					Is01ReplyV1.builder().rspCode(e.getApiCode().getRspCode()).rspMsg(e.getMessage()).build(),
					BaseReply.getHeaders(xApiTranId), e.getApiCode().getHttpStatus());
		}
	}
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
	@Operation(summary = "보험 기본정보 조회", description = "정보주체가 계약한 보험별 기본정보(주계약정보) 조회")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Is01ReplyV2.class))),
	        @ApiResponse(responseCode = "400", description = "bad request operation", content = @Content(schema = @Schema(implementation = Is01ReplyV2.class)))
	    })
	@GetMapping("/v2/insurances")
	@SneakyThrows
	public ResponseEntity<Is01ReplyV2> getInsurancesV2(
			@Parameter(required = false, description = "접근토큰") @RequestHeader(value = "Authorization", required = false) String authorization, // 접근토큰
			@Parameter(required = true, description = "거래고유번호") @RequestHeader(value = "x-api-tran-id") String xApiTranId, // 거래고유번호
			@Parameter(required = true, description = "API 유형") @RequestHeader(value = "x-api-type") String xApiType, // API 유형
			@Parameter(required = false, description = "기관코드") @RequestParam(value = "org_code") String orgCode, // 기관코드
			@Parameter(required = false, description = "조회 타임스탬프") @RequestParam(value = "search_timestamp", required = false) String searchTimestamp, // 조회 타임스탬프
			@Parameter(required = false, description = "다음 페이지 기준개체") @RequestParam(value = "next_page", required = false) String nextPage, // 다음 페이지 기준개체
			@Parameter(required = false, description = "최대조회갯수") @RequestParam(value = "limit") String limit) { // 최대조회갯수

		try {
			Is01ReplyV2 is01Reply = is01ServiceV2.getInsurances(authorization, xApiTranId, xApiType, orgCode,
					searchTimestamp, nextPage, limit);

			return new ResponseEntity<>(is01Reply, BaseReply.getHeaders(xApiTranId), HttpStatus.OK);
		} catch (ApiCodeException e) {
			return new ResponseEntity<>(
					Is01ReplyV2.builder().rspCode(e.getApiCode().getRspCode()).rspMsg(e.getMessage()).build(),
					BaseReply.getHeaders(xApiTranId), e.getApiCode().getHttpStatus());
		}
	}

}
