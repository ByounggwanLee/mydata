package com.mydata.exception;

import com.mydata.base.ApiCode;

public class ApiCodeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ApiCode apiCode;
	
	public ApiCodeException(String message, ApiCode apiCode ) {
		super(message);
		this.apiCode = apiCode;
	}
	
	public ApiCodeException(ApiCode apiCode ) {
		super(apiCode.getRspMsg());
		this.apiCode = apiCode;
	}
	
	public ApiCode getApiCode() {
		return this.apiCode;
	}
}
