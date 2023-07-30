package com.educational.material.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educational.material.exception.ProductNotfoundException;
import com.educational.material.vo.ResponseVO;

@ControllerAdvice
public class ProductExceptionController {

	@ExceptionHandler(value = ProductNotfoundException.class)
	public ResponseEntity<ResponseVO> exception(ProductNotfoundException exception) {
		ResponseVO responseVO = getResponseVO(exception);
		return new ResponseEntity<>(responseVO, HttpStatus.UNAUTHORIZED);
	}

	 private ResponseVO getResponseVO(ProductNotfoundException ex) {
	        ResponseVO responseVO = new ResponseVO();
	        responseVO.setAppStatusCode(ex.getCode());
	        responseVO.getMessage().add(ex.getUserMessage());
	        responseVO.setError(ex.toString());
	        //logger.error(ex.toString(), ex);
	        return responseVO;
	    }
}
