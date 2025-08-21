package com.educational.material.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.educational.material.exception.unchecked.BaseUncheckedException;
import com.educational.material.exception.unchecked.InvalidAuthTokenException;
import com.educational.material.vo.ResponseVO;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(InvalidAuthTokenException.class)
	public ResponseEntity<ResponseVO> invalidAuthTokenException(InvalidAuthTokenException ex, WebRequest request) {
		ResponseVO responseVO = getResponseVO(ex);
		return new ResponseEntity<ResponseVO>(responseVO, HttpStatus.UNAUTHORIZED);
	}
	
	private ResponseVO getResponseVO(BaseUncheckedException ex) {
		ResponseVO responseVO = new ResponseVO();
		responseVO.setAppStatusCode(ex.getCode());
		responseVO.getMessage().add(ex.getMessage());
		responseVO.setError(ex.toString());
		return responseVO;
	}
	
}
