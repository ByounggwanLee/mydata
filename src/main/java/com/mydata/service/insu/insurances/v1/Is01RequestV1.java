/**
 * 보험 기본정보 조회 요청 클래스
 * @name_ko 보험 기본정보 조회 요청 클래스
 * @author 이병관
*/package com.mydata.service.insu.insurances.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mydata.base.BaseRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)     // Camel응답을 Snake응답으로
@JsonInclude(JsonInclude.Include.NON_NULL)                      // Null 값은 제외한다.
@Schema(description = "보험 기본정보 조회 요청")
public class Is01RequestV1 extends BaseRequest{
	// @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
	@Schema(description = " 다음 페이지 기준개체	aNS (1000)", nullable = true)
    String nextPage;            // 다음 페이지 기준개체	N	aNS (1000)
	@Schema(description = " 최대조회갯수		N (3))", nullable = false)
    String limit;               // 최대조회갯수			Y	N (3) 
}