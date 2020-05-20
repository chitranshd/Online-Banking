package com.example.fundtransfer.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.fundtransfer.bean.ExceptionBean;

@ControllerAdvice
public class ExceptionResolver {

	@ExceptionHandler(LowOnBalanceException.class)
	public ResponseEntity<ExceptionBean> balanceHandler(LowOnBalanceException ex){
	   ExceptionBean response=new ExceptionBean();
	   response.setStatus(HttpStatus.BAD_REQUEST.value());
	   response.setMessage(ex.getMessage());
	   response.setTimeStamp(System.currentTimeMillis());
	   return new ResponseEntity<ExceptionBean>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionBean> globalHandler(LowOnBalanceException ex){
	   ExceptionBean response=new ExceptionBean();
	   response.setStatus(HttpStatus.BAD_REQUEST.value());
	   response.setMessage(ex.getMessage());
	   response.setTimeStamp(System.currentTimeMillis());
	   return new ResponseEntity<ExceptionBean>(response, HttpStatus.BAD_REQUEST);
	}
}
