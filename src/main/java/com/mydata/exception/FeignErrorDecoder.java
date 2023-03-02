/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : Exception - Mydata FeignErrorDecoder 클래스(ApiCodeException)
 * Class Name : FeignErrorDecoder.java
 * Description : Mydata FeignErrorDecoder 클래스
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
package com.mydata.exception;

import java.io.IOException;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mydata.base.ApiCode;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import feign.codec.StringDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * Mydata FeignErrorDecoder 클래스
 * 
 * @name_ko Mydata FeignErrorDecoder 클래스
 * @author 이병관
 */
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {
	private ObjectMapper objectMapper = new ObjectMapper();
	private StringDecoder stringDecoder = new StringDecoder();

	@Override
	public ApiCodeException decode(String methodKey, Response response) {
		String message = "Feign Client Call Error : " + methodKey ;

		log.warn("global error code {}", response.status());
		switch (response.status()) {
		case 400:
			return new ApiCodeException(message, ApiCode.BAD_REQUEST);
		case 403:
			return new ApiCodeException(message, ApiCode.FORBIDDEN);
		case 404:
			return new ApiCodeException(message, ApiCode.NOT_FOUND);
		case 500:
		case 501:
		case 502:
		case 503:
		case 504:
			return new ApiCodeException(message, ApiCode.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
}
