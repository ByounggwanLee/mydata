/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : Controller- 전업권 공통제공 Controller 클래스(CommonController)
 * Class Name : CommonController.java
 * Description : 전업권 공통제공 Controller 클래스
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
package com.mydata.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.base.BaseReply;
import com.mydata.domain.mybatis.TmSlotList;
import com.mydata.domain.service.StatisticService;
import com.mydata.exception.ApiCodeException;
import com.mydata.service.insu.insurances.v1.Is01ReplyV1;

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

/**
 * 공통 Controller 클래스 전업권 공통제공 서비스
 * 
 * @name_ko 보험 기본정보 조회 Controller 클래스
 * @author 이병관
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "공통서비스", description = "전업권 공통서비스")
public class CommonController {
	final StatisticService statisticService;

	/*
	 * 정보제공자 통계자료 중 시간대별 통계목록 조회한다.
	 * 
	 * @name_ko 정보제공자 통계자료 중 시간대별 통계목록 조회
	 * 
	 * CommonController.getTmSlotList(apiCode,requestDate)
	 * 
	 * @RequestParam apiCode API 구분 코드
	 * 
	 * @RequestParam requestDate 통계일자
	 * 
	 * @Return ResponseEntity<List<TmSlotList>> 시간대별 통계목록
	 */
	@Operation(summary = "시간대별 통계목록 조회", description = "정보제공자 통계자료 중 시간대별 통계목록 조회")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = TmSlotList.class))),
			@ApiResponse(responseCode = "404", description = "TmSlotList not found", content = @Content) })
	@GetMapping("/tmslotlist")
	@SneakyThrows
	public ResponseEntity<List<TmSlotList>> getTmSlotList(
			@Parameter(required = true, description = "API 구분 코드") @RequestParam(value = "api_code") String apiCode, // API
																														// 구분
																														// 코드
			@Parameter(required = true, description = "통계일자") @RequestParam(value = "request_date", required = false) String requestDate // 통계일장
	) {

		try {
			List<TmSlotList> tmSlotList = statisticService.getTmSlotList(apiCode, requestDate);

			return new ResponseEntity<>(tmSlotList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
