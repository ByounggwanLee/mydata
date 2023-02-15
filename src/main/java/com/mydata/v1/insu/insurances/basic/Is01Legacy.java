/**
 * 보험 기본정보 조회 Legacy 클래스
 * 정보주체가 계약한 금융회사별 보험 목록 조회(Feign Client)
 * @name_ko 보험 기본정보 조회 Legacy 클래스
 * @author 이병관
*/package com.mydata.v1.insu.insurances.basic;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="IS01", url="${prop.test.url}")
public interface Is01Legacy {
	/*
	 *  정보주체가 계약한 보험별 기본정보(주계약정보) 조회
	 *  GET 방식으로 RequestParam 요청에 대한 Feign Client 
	 *  @RequestParam Authorization 접근토큰
	 *  @RequestParam nextPage 조회 타임스탬프
	 *  @RequestParam limit 최대조회갯수
	 *  @Return is01Reply 보험 기본정보 조회 응답
	 */
	@GetMapping("/mydata/insurances/{authorization}")
	Is01Reply getInsurances(@PathVariable(value = "authorization", required = false) String authorization, 
			                @RequestParam(value = "nextPage", required = false) String nextPage,
			                @RequestParam("limit") String limit);

	/*
	 *  정보주체가 계약한 보험별 기본정보(주계약정보) List 조회
	 *  Post 방식으로 @RequestBody 요청에 대한 eign Client 
	 *  @RequestBody is01Request 요청전문
	 *  @Return List<InsuList> 기본정보(주계약정보) List 응답
	 */
	@PostMapping("/mydata/insuranceList")
	List<InsuList> getInsuranceList(Is01Request isRequest);
}
