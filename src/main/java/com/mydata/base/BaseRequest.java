/**
 * Mydata 수신전문 공통 클래스
 * 모든 수신전문은 상속하여 사용한다.
 * @name_ko 수신전문 공통 클래스
 * @author 이병관
*/
package com.mydata.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "수신전문 공통")
public class BaseRequest {
	// @Schema(description = "", nullable = true , defaultValue = "" , example = ""  , allowableValues = {"", ""})
	@Schema(description = "Header :  접근토큰	aNS (1500)", nullable = false)
	String authorization;       // Header :  접근토큰			Y	aNS (1500)
	@Schema(description = "Header :  거래고유번호	AN (25)", nullable = false)
	String xApiTranId;          // Header :  거래고유번호		Y	AN (25)
	@Schema(description = "Header :  API 유형		aNS (12)", nullable = false)
	String xApiType;            // Header :  API 유형			Y	aNS (12)
	@Schema(description = " 기관코드		aN (10)", nullable = false)
	String orgCode;             // Body   :  기관코드			Y	aN (10)
	@Schema(description = "조회 타임스탬프	N (14)", nullable = true)
	String searchTimestamp;     // Body   :  조회 타임스탬프		N	N (14)
}
