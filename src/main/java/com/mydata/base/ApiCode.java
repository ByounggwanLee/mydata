/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : 환경설정 - Api응답코드관리(ApiCode)
 * Class Name : ApiCode.java
 * Description : 응답코드 및 응답메시지 클래스
 * Modification History
 * 수정일	   수정자 요청자 수정내용
 * -------------------------------------
 * 2023.02.01  이병관 천민희  최초작성
 * 2023.03.02  이병관 천민희  주석작업
 * </PRE>
 * @version 1.0
 * @author 정/부 담당자(천민희/육지혜)
 * Copyright (C) 2023 by SK co.,Ltd. All right reserved.
**/
package com.mydata.base;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 응답코드 및 응답메시지 클래스
 *
 * @name_ko 응답코드 및 응답메시지 클래스
 * @author 이병관
**/
@AllArgsConstructor
@Getter
public enum ApiCode {
	// -------------------------------------------------------------------------
	// 1) 인가코드 발급 - ① 요청메시지 내 client_id 또는 redirect_uri 가 유효하지 않은 경우 등
	// -------------------------------------------------------------------------
	AUTHORITY_INVAILD_REQUEST(HttpStatus.BAD_REQUEST, "invalid_requet", "invaild_client_id"),
	AUTHORITY_INVAILD_REQUEST_1(HttpStatus.BAD_REQUEST, "invalid_requet", "invaild_redirection"),
	AUTHORITY_METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "method_not_allowed",
			"authentication_method_not_provided"),
	AUTHORITY_METHOD_NOT_ALLOWED_1(HttpStatus.METHOD_NOT_ALLOWED, "method_not_allowed",
			"허용되지 않은 HTTP Method 또는 잘못된 HTTP Method"),

	// -------------------------------------------------------------------------
	// 1) 인가코드 발급 - ② 그 외 (Callback URL로 리다이렉트)
	// -------------------------------------------------------------------------
	AUTHORITY_FOUND(HttpStatus.FOUND, "invalid_request",
			"client_id 및 redirect_uri가 유효하지만, 요청 파라미터에 문제가 있는 경우. (response_type이 포함되지 않은 경우, 파라미터명이 틀린 경우 등), 헤더 값 미존재 또는 잘못된 헤더값인 경우"),
	AUTHORITY_FOUND_1(HttpStatus.FOUND, "unauthorized_client",
			"클라이언트가 권한이 없는 경우 (허용되지 않은 원격지 IP, TLS 인증서 내 SERIALNUMBER 검증 실패 등)"),
	AUTHORITY_FOUND_2(HttpStatus.FOUND, "access_denied", "정보주체가 요청을 거부한 경우(전송요구 취소 등)"),
	AUTHORITY_FOUND_3(HttpStatus.FOUND, "unsupported_response_type", "response_type이 ‘code’가 아닌 경우"),
	AUTHORITY_FOUND_4(HttpStatus.FOUND, "server_error", "서버 오류 발생 시"),
	AUTHORITY_FOUND_5(HttpStatus.FOUND, "temporarily_unavailable", "서버가 일시적인 부하 등으로 서비스가 불가한 경우"),
	AUTHORITY_FOUND_6(HttpStatus.FOUND, "unauthorized_user", "정보주체가 권한이 없는 경우 (CI 불일치, 이용가능 연령이 아닌 고객인 경우 등)"),

	// -------------------------------------------------------------------------
	// 2) 접근토큰 발급/갱신/폐기
	// -------------------------------------------------------------------------
	TOKEN_BAD_REQUEST(HttpStatus.BAD_REQUEST, "invalid_request",
			"grant_type을 제외한 요청 파라미터에 문제가 있는 경우, 헤더 값 미존재 또는 잘못된 헤더값인 경우"),
	TOKEN_BAD_REQUEST_1(HttpStatus.BAD_REQUEST, "invalid_client", "클라이언트 인증이 실패한 경우"),
	TOKEN_BAD_REQUEST_2(HttpStatus.BAD_REQUEST, "invalid_grant",
			"인가코드, refresh token이 틀리거나, 유효(만료)하지 않은 경우, redirect_uri가 일치하지 않는 경우 등"),
	TOKEN_BAD_REQUEST_3(HttpStatus.BAD_REQUEST, "unauthorized_client",
			"클라이언트가 권한이 없는 경우 (허용되지 않은 원격지 IP, TLS 인증서 내 SERIALNUMBER 검증 실패 등)"),
	TOKEN_BAD_REQUEST_4(HttpStatus.BAD_REQUEST, "unsupported_grant_type", "grant_type 값이 잘못된 경우"),
	TOKEN_BAD_REQUEST_5(HttpStatus.BAD_REQUEST, "invalid_scope", "지정한 scope 값이 잘못된 경우"),
	TOKEN_BAD_REQUEST_6(HttpStatus.BAD_REQUEST, "unauthorized_user", "정보주체가 권한이 없는 경우 (CI 불일치, 이용가능 연령이 아닌 고객인 경우 등)"),
	TOKEN_METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "method_not_allowed",
			"허용되지 않은 HTTP Method 또는 잘못된 HTTP Method인 경우"),
	TOKEN_INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "server_error", "서버 오류 발생 시"),
	TOKEN_SERVICE_UNVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, "temporarily_unavailable",
			"서버가 일시적인 부하 등으로 서비스가 불가한 경우로 서버가 헤더에 “Retry-After”를 회신하면 추후 다시 접근토큰 폐기 요청(접근토큰 폐기 시)"),

	// -------------------------------------------------------------------------
	// 3) 그 외 API
	// -------------------------------------------------------------------------
	OK(HttpStatus.OK, "00000", "성공"), // 처리성공
	OK_1(HttpStatus.OK, "00001", "성공(UP_TO_DATE"), // 처리 성공 (부하 개선을 위한 Timestamp 기능을 구현한 기관이 회신할 데이터가 존재하지 않는 경우. 다만,
													// 이경우에도
													// rsp_code, rsp_msg, x-api-tran-id는 회신 필요)
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "40001", "요청 파라미터에 문제가 있는 경우 (데이터 타입, 길이 에러 등)"),
	BAD_REQUEST_1(HttpStatus.BAD_REQUEST, "40002", "헤더 값 미존재 또는 잘못된 헤더값"),
	BAD_REQUEST_2(HttpStatus.BAD_REQUEST, "40003", "허용된 API 버전이 아님"),
	BAD_REQUEST_3(HttpStatus.BAD_REQUEST, "40004",
			"내역관련(거래내역, 청구정보, 카드승인내역, 결제내역 등) 조회 API의 경우, 조회기간(From/To)이 전송기준(3.3.2 참조)을 초과하여 데이터 요청"),
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "40101", "유효하지 않은 접근토큰"),
	UNAUTHORIZED_1(HttpStatus.UNAUTHORIZED, "40102", "허용되지 않은 원격지 IP"),
	UNAUTHORIZED_2(HttpStatus.UNAUTHORIZED, "40103", "TLS 인증서 내 SERIALNUMBER 검증 실패"),
	UNAUTHORIZED_3(HttpStatus.UNAUTHORIZED, "40104", "API 사용 권한 없음 (불충분한 scope 등)"),
	UNAUTHORIZED_4(HttpStatus.UNAUTHORIZED, "40105", "자산(계좌, 카드 등)에 대한 정보조회 권한 없음 (전송요구 대상에 포함되지 않은 경우)"),
	UNAUTHORIZED_5(HttpStatus.UNAUTHORIZED, "40106", "전송요구 종료시점이 경과 (접근토큰이 유효한 상태이더라도, 전송요구 시 특정한 종료시점이 경과한 경우 에러 처리)"),
	FORBIDDEN(HttpStatus.FORBIDDEN, "40301", "올바르지 않은 API 호출"),
	FORBIDDEN_1(HttpStatus.FORBIDDEN, "40302", "일시적으로 해당 클라이언트의 요청이 제한됨"),
	FORBIDDEN_2(HttpStatus.FORBIDDEN, "40303",
			"기관코드 확인 불가 (요청메시지 내 기관코드(org_code)가 잘못된 기관코드인 경우, 중계기관 이용기관의 기관코드가 아닌 경우 등)"),
	FORBIDDEN_3(HttpStatus.FORBIDDEN, "40304", "최근 5년을 경과한 개인신용정보를 요청 (신정법 시행령 제28조의3제4항 관련)"),
	FORBIDDEN_4(HttpStatus.FORBIDDEN, "40305",
			"자산이 정상인 상태가 아님(카드 해지 등 자산의 현 상태가 정상이 아닌 경우, 전송요구 당시에는 ‘해지’상태가 아니었으나, 정보 요청 시 ‘해지’된 상태인 경우 등)"),
	NOT_FOUND(HttpStatus.NOT_FOUND, "40401", "요청한 엔드포인트는 존재하지 않음(일반적인 HTTP 404 에러)"),
	NOT_FOUND_1(HttpStatus.NOT_FOUND, "40402", "요청한 자산(계좌번호, 카드식별자 등)이 유효한 자산이 아님(존재하지 않는 자산 또는 타인의 자산)"),
	NOT_FOUND_2(HttpStatus.NOT_FOUND, "40403", "정보주체(고객) 미존재"),
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "40501", "허용되지 않은 HTTP Method 또는 잘못된 HTTP Method인 경우"),
	TOO_MANY_REQUEST(HttpStatus.TOO_MANY_REQUESTS, "42901", "정보제공 요청한도 초과 (정기적 전송주기 요청한도 초과 등)"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "50001", "시스템장애"),
	INTERNAL_SERVER_ERROR_1(HttpStatus.INTERNAL_SERVER_ERROR, "50002", "API 요청 처리 실패"),
	INTERNAL_SERVER_ERROR_2(HttpStatus.INTERNAL_SERVER_ERROR, "50003", "처리시간 초과 에러"),
	INTERNAL_SERVER_ERROR_3(HttpStatus.INTERNAL_SERVER_ERROR, "50004", "알 수 없는 에러(예비 배정)"),
	INTERNAL_SERVER_ERROR_4(HttpStatus.INTERNAL_SERVER_ERROR, "50005", "정보제공자 서비스 불가(중계기관용)"),
	INTERNAL_SERVER_ERROR_5(HttpStatus.INTERNAL_SERVER_ERROR, "50006", "이용기관 서비스 불가(거점중계기관용)"),
	INTERNAL_SERVER_ERROR_6(HttpStatus.INTERNAL_SERVER_ERROR, "50007", "전문 변환 에러(중계기관용)"),
	INTERNAL_SERVER_ERROR_7(HttpStatus.INTERNAL_SERVER_ERROR, "50008", "시스템 정기점검"),
	INTERNAL_SERVER_ERROR_8(HttpStatus.INTERNAL_SERVER_ERROR, "50009", "정기적 전송 가능 시간대가 아님"),
	INTERNAL_SERVER_ERROR_9(HttpStatus.INTERNAL_SERVER_ERROR, "50010", "장 초반/마감 응답거부");

	private final HttpStatus httpStatus; // HTTP 응답메세지
	private final String rspCode; // 응답코드
	private final String rspMsg; // 응답메시지
}
