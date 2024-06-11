package com.ltts.exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(value = NoDataFoundException.class)
	public ResponseEntity<ErrorModel> HandleNoDataFoundException(final NoDataFoundException NDFE,final HttpServletRequest request) {
		ErrorModel error=new ErrorModel();
		error.setDescription(NDFE.getMessage());
		error.setErrordate(LocalDateTime.now());
		error.setRequestedURI(request.getRequestURI());
		error.setErrorCode(404);
		
		return new ResponseEntity<ErrorModel>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = OperationFailedException.class)
	public ResponseEntity<ErrorModel> HandleOperationFailedException(final OperationFailedException OFE ,final HttpServletRequest request){
		ErrorModel error=new ErrorModel();
		error.setDescription(OFE.getMessage());
		error.setErrordate(LocalDateTime.now());
		error.setRequestedURI(request.getRequestURI());
		error.setErrorCode(500);
		
		return new ResponseEntity<ErrorModel>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = DataPresentException.class)
	public ResponseEntity<ErrorModel> HandleDataPresentException(final DataPresentException DPE , final HttpServletRequest request){
		ErrorModel error=new ErrorModel();
		error.setDescription(DPE.getMessage());
		error.setErrordate(LocalDateTime.now());
		error.setRequestedURI(request.getRequestURI());
		error.setErrorCode(409);
		
		return new ResponseEntity<ErrorModel>(error,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = FieldMissingException.class)
	public ResponseEntity<ErrorModel> HandleFieldMissingException(final FieldMissingException FME,final HttpServletRequest request){
		ErrorModel error=new ErrorModel();
		error.setDescription(FME.getMessage());
		error.setErrordate(LocalDateTime.now());
		error.setRequestedURI(request.getRequestURI());
		error.setErrorCode(400);
		
		return new ResponseEntity<ErrorModel>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ErrorModel> HandleRuntimeException(final RuntimeException Exp, final HttpServletRequest request){
		ErrorModel error=new ErrorModel();
		error.setDescription(Exp.getMessage());
		error.setErrordate(LocalDateTime.now());
		error.setRequestedURI(request.getRequestURI());
		error.setErrorCode(503);
		
		return new ResponseEntity<ErrorModel>(error,HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	
}
