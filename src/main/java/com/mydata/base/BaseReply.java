/**
 * Mydata 응답전문 공통 클래스
 * 모든 응답전문은 상속하여 사용한다.
 * 오류(Exception)는 바로 사용한다.
 * @name_ko 응답전문 공통 클래스
 * @author 이병관
*/

package com.mydata.base;

import org.springframework.http.HttpHeaders;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
@NoArgsConstructor
@Schema(description = "응답전문 공통")
public class BaseReply {
	// @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
	@Schema(description = "세부응답코드  aN (5)", nullable = false)
	String rspCode;   //-- 세부 응답코드 Y aN (5)
	@Schema(description = "세부 응답메시지 AH (450)", nullable = false)
	String rspMsg;    //-- 세부 응답메시지 Y AH (450)
	
	/* 
	 * 요청메세지의 거래고유번호(x-api-tran-id)를 이용 전송 Header를 생성한다.
	 * @name_ko 응답 Header 생성
	 * @param xApiTranId 거래고유번호
	 * @return HttpHeaders
	 */
	public static  HttpHeaders getHeaders(String xApiTranId) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("x-api-tran-id", xApiTranId);
		return headers;
	}
}
