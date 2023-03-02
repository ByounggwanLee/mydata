/**
 * <PRE>
 * System Name : Mydata 시스템 (마이데이터)
 * Business Name : 공통 - Spring Boot OpenApi DOC 환경설정 클래스(OpenApiConfig)
 * Class Name : ApiCode.java
 * Description : OpenApi DOC 환경설정 클래스
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

package com.mydata.config;

/**
 * Spring Boot OpenApi DOC 환경설정 클래스
 * 
 * @name_ko  Spring Boot OpenApi DOC 환경설정 클래스
 * @author 이병관
**/
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@ConditionalOnProperty(name = "springdoc.swagger-ui.enabled", havingValue = "true", matchIfMissing = true)
public class OpenApiConfig {
	// https://codingnconcepts.com/spring-boot/configure-springdoc-openapi/
	private static final String BEARER_FORMAT = "JWT";
	private static final String SCHEME = "Bearer";
	private static final String SECURITY_SCHEME_NAME = "Security Scheme";

	@Value("${api.info.title: api.info.title}")
	private String title;

	@Value("${api.info.description: api.info.description}")
	private String description;

	@Value("${api.info.version: api.info.version}")
	private String version;

	@Value("${api.info.term-of-service: api.info.terms-of-service}")
	private String termOfService;

	@Value("${api.info.contact.name: api.info.contact.name}")
	private String contactName;

	@Value("${api.info.contact.email: api.info.contact.email}")
	private String contactEmail;

	@Value("${api.info.contact.url: api.info.contact.url}")
	private String contactUrl;

	@Value("${api.info.license.name: api.info.license.name}")
	private String licenseName;

	@Value("${api.info.license.url: api.info.license.url}")
	private String licenseUrl;

	/*
	 * Swagger 화면의 정보를 설정한다.
	 * 
	 * @name_ko Swagger 화면의 정보 설정
	 * 
	 * OpenApiConfig.api()
	 * 
	 * @return OpenAPI 설정 api 정보
	 */

	@Bean
	public OpenAPI api() {
		return new OpenAPI().schemaRequirement(SECURITY_SCHEME_NAME, getSecurityScheme())
				.security(getSecurityRequirement()).info(info());
	}

	/*
	 * Swagger 화면의 전체 Control Group을 설정한다.
	 * 
	 * @name_ko Swagger 화면의 Group을 설정(전체 Control)
	 * 
	 * OpenApiConfig.apiAll()
	 * 
	 * @return GroupedOpenApi 설정 정보
	 */
	@Bean
	public GroupedOpenApi apiAll() {
		return GroupedOpenApi.builder().group("all").pathsToMatch("/**").build();
	}

	/*
	 * Swagger 공통 Control 화면의 Group을 설정한다.
	 * 
	 * @name_ko Swagger 화면의 Group을 설정(버전이 없는 공통 Control)
	 * 
	 * OpenApiConfig.apiNoVersion()
	 * 
	 * @return GroupedOpenApi 설정 정보
	 */
	@Bean
	public GroupedOpenApi apiNoVersion() {
		return GroupedOpenApi.builder().group("common").pathsToExclude("/**")
				.packagesToScan("com.mydata.controller.commoncontroller").build();
	}

	/*
	 * Swagger 화면의 Sample Control Group을 설정한다.
	 * 
	 * @name_ko Swagger 화면의 Group을 설정(Sample Control)
	 * 
	 * OpenApiConfig.apiSample()
	 * 
	 * @return GroupedOpenApi 설정 정보
	 */
	@Bean
	public GroupedOpenApi apiSample() {
		return GroupedOpenApi.builder().group("sample").pathsToMatch("/**").packagesToScan("com.mydata.sample").build();
	}

	/*
	 * Swagger 화면의 Mydata Version 1 ControlGroup을 설정한다.
	 * 
	 * @name_ko Swagger 화면의 Group을 설정(Mydata Version1 Control)
	 * 
	 * OpenApiConfig.apiV1()
	 * 
	 * @return GroupedOpenApi 설정 정보
	 */
	@Bean
	public GroupedOpenApi apiV1() {
		return GroupedOpenApi.builder().group("v1").pathsToMatch("/v1/**").packagesToScan("com.mydata.controller")
				.build();
	}

	/*
	 * Swagger 화면의 Mydata Version2 Control Group을 설정한다.
	 * 
	 * @name_ko Swagger 화면의 Group을 설정(Mydata Version2 Control)
	 * 
	 * OpenApiConfig.apiV2()
	 * 
	 * @return GroupedOpenApi 설정 정보
	 */
	@Bean
	public GroupedOpenApi apiV2() {
		return GroupedOpenApi.builder().group("v2").pathsToMatch("/v2/**").packagesToScan("com.mydata.controller")
				.build();
	}

	/*
	 * Swagger 화면의 기본정보를 설정한다.
	 * 
	 * @name_ko Swagger 화면의 기본정보 설정
	 * 
	 * OpenApiConfig.info()
	 * 
	 * @return OpenAPI 기본설정 정보
	 */
	private Info info() {
		return new Info().title(title).description(description).version(version)
				.contact(new Contact().name(contactName).email(contactEmail).url(contactUrl))
				.license(new License().name(licenseName).url(licenseUrl));
	}

	/*
	 * Swagger 화면의 Security정보를 설정한다.
	 * 
	 * @name_ko Swagger 화면의 Security정보 설정
	 * 
	 * OpenApiConfig.getSecurityRequirement()
	 * 
	 * @return OpenAPI Security 설정 정보
	 */
	private List<SecurityRequirement> getSecurityRequirement() {
		SecurityRequirement securityRequirement = new SecurityRequirement();
		securityRequirement.addList(SECURITY_SCHEME_NAME);
		return List.of(securityRequirement);
	}

	/*
	 * Swagger 화면의 Security정보를 설정한다.
	 * 
	 * @name_ko Swagger 화면의 Json Web Token Security정보 설정
	 * 
	 * OpenApiConfig.getSecurityScheme()
	 * 
	 * @return OpenAPI Json Web Token Security정보
	 */
	private SecurityScheme getSecurityScheme() {
		SecurityScheme securityScheme = new SecurityScheme();
		securityScheme.bearerFormat(BEARER_FORMAT);
		securityScheme.type(SecurityScheme.Type.HTTP);
		securityScheme.in(SecurityScheme.In.HEADER);
		securityScheme.scheme(SCHEME);
		return securityScheme;
	}
}