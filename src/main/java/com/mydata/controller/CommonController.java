/**
 * 공통 Controller 클래스
 * 전업권 공통제공 서비스
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
@Tag(name = "공통서비스" , description = "전업권 공통서비스")
public class CommonController {

}
