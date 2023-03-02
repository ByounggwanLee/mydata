/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : DTO - 시간대별 통계목록 클래스(BaseReply)
 * Class Name : TmSlotList.java
 * Description : 시간대별 통계목록 클래스
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
package com.mydata.domain.mybatis;

import lombok.Data;

/**
 * 시간대별 통계목록 클래스(Snake 표기를 부득이 사용[Camel to Snake전환 불가])
 * 
 * @name_ko 시간대별 통계목록 클래스
 * @author 이병관
 **/
@Data
public class TmSlotList {
	String tm_slot; // 통계시점 시간대역 Y N(10)
	String sucess_api_cnt; // 성공한 API 호출 횟수 Y N(10)
	String fail_api_cnt; // 실패한 API 호출 횟수 Y N(10)
	String err_code_1_400_invalid_request; // 에러코드별 API 호출 횟수(1-400-invalid_request) Y N(10)
	String err_code_1_405_method_not_allowed; // 에러코드별 API 호출 횟수(1-405-method_not_allowed) Y N(10)
	String err_code_1_302_invalid_request; // 에러코드별 API 호출 횟수(1-302-invalid_request) Y N(10)
	String err_code_1_302_unauthorized_client; // 에러코드별 API 호출 횟수(1-302-unauthorized_client) Y N(10)
	String err_code_1_302_access_denied; // 에러코드별 API 호출 횟수(1-302-access_denied) Y N(10)
	String err_code_1_302_unsupported_response_type; // 에러코드별 API 호출 횟수(1-302-unsupported_response_type) Y N(10)
	String err_code_1_302_server_error; // 에러코드별 API 호출 횟수(1-302-server_error) Y N(10)
	String err_code_1_302_temporarily_unavailable; // 에러코드별 API 호출 횟수(1-302-temporarily_unavailable) Y N(10)
	String err_code_1_302_unauthorized_user; // 에러코드별 API 호출 횟수(1-302-unauthorized_user) Y N(10)
	String err_code_2_400_invalid_request; // 에러코드별 API 호출 횟수(2-400-invalid_request) Y N(10)
	String err_code_2_400_invalid_client; // 에러코드별 API 호출 횟수(2-400-invalid_client) Y N(10)
	String err_code_2_400_invalid_grant; // 에러코드별 API 호출 횟수(2-400-invalid_grant) Y N(10)
	String err_code_2_400_unauthorized_client; // 에러코드별 API 호출 횟수(2-400-unauthorized_client) Y N(10)
	String err_code_2_400_unsupported_grant_type; // 에러코드별 API 호출 횟수(2-400-unsupported_grant_type) Y N(10)
	String err_code_2_400_invalid_scope; // 에러코드별 API 호출 횟수(2-400-invalid_scope) Y N(10)
	String err_code_2_400_unauthorized_user; // 에러코드별 API 호출 횟수(2-400-unauthorized_user) Y N(10)
	String err_code_2_405_method_not_allowed; // 에러코드별 API 호출 횟수(2-405-method_not_allowed) Y N(10)
	String err_code_2_500_server_error; // 에러코드별 API 호출 횟수(2-500-server_error) Y N(10)
	String err_code_2_503_temporarily_unavailable; // 에러코드별 API 호출 횟수(2-503-temporarily_unavailable) Y N(10)
	String rsp_code_3_200_00000; // 응답코드별 API 호출 횟수(3-200-00000) Y N(10)
	String rsp_code_3_200_00001; // 응답코드별 API 호출 횟수(3-200-00001) Y N(10)
	String rsp_code_3_400_40001; // 응답코드별 API 호출 횟수(3-400-40001) Y N(10)
	String rsp_code_3_400_40002; // 응답코드별 API 호출 횟수(3-400-40002) Y N(10)
	String rsp_code_3_400_40003; // 응답코드별 API 호출 횟수(3-400-40003) Y N(10)
	String rsp_code_3_400_40004; // 응답코드별 API 호출 횟수(3-400-40004) Y N(10)
	String rsp_code_3_401_40101; // 응답코드별 API 호출 횟수(3-401-40101) Y N(10)
	String rsp_code_3_401_40102; // 응답코드별 API 호출 횟수(3-401-40102) Y N(10)
	String rsp_code_3_401_40103; // 응답코드별 API 호출 횟수(3-401-40103) Y N(10)
	String rsp_code_3_401_40104; // 응답코드별 API 호출 횟수(3-401-40104) Y N(10)
	String rsp_code_3_401_40105; // 응답코드별 API 호출 횟수(3-401-40105) Y N(10)
	String rsp_code_3_401_40106; // 응답코드별 API 호출 횟수(3-401-40106) Y N(10)
	String rsp_code_3_403_40301; // 응답코드별 API 호출 횟수(3-403-40301) Y N(10)
	String rsp_code_3_403_40302; // 응답코드별 API 호출 횟수(3-403-40302) Y N(10)
	String rsp_code_3_403_40303; // 응답코드별 API 호출 횟수(3-403-40303) Y N(10)
	String rsp_code_3_403_40304; // 응답코드별 API 호출 횟수(3-403-40304) Y N(10)
	String rsp_code_3_403_40305; // 응답코드별 API 호출 횟수(3-403-40305) Y N(10)
	String rsp_code_3_404_40401; // 응답코드별 API 호출 횟수(3-404-40401) Y N(10)
	String rsp_code_3_404_40402; // 응답코드별 API 호출 횟수(3-404-40402) Y N(10)
	String rsp_code_3_404_40403; // 응답코드별 API 호출 횟수(3-404-40403) Y N(10)
	String rsp_code_3_405_40501; // 응답코드별 API 호출 횟수(3-405-40501) Y N(10)
	String rsp_code_3_429_42901; // 응답코드별 API 호출 횟수(3-429-42901) Y N(10)
	String rsp_code_3_500_50001; // 응답코드별 API 호출 횟수(3-500-50001) Y N(10)
	String rsp_code_3_500_50002; // 응답코드별 API 호출 횟수(3-500-50002) Y N(10)
	String rsp_code_3_500_50003; // 응답코드별 API 호출 횟수(3-500-50003) Y N(10)
	String rsp_code_3_500_50004; // 응답코드별 API 호출 횟수(3-500-50004) Y N(10)
	String rsp_code_3_500_50005; // 응답코드별 API 호출 횟수(3-500-50005) Y N(10)
	String rsp_code_3_500_50006; // 응답코드별 API 호출 횟수(3-500-50006) Y N(10)
	String rsp_code_3_500_50007; // 응답코드별 API 호출 횟수(3-500-50007) Y N(10)
	String rsp_code_3_500_50008; // 응답코드별 API 호출 횟수(3-500-50008) Y N(10)
	String rsp_code_3_500_50009; // 응답코드별 API 호출 횟수(3-500-50009) Y N(10)
	String rsp_code_3_500_50010; // 응답코드별 API 호출 횟수(3-500-50010) Y N(10)
}
