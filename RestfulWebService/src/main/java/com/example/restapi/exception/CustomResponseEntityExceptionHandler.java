package com.example.restapi.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.restapi.model.error.ErrorResponse;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * INFO: ex.getMessage() will contain complete error message along with the
	 * field error(error msg defined by the validation parameter on the model class)
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request) throws Exception {
		ErrorResponse errorResp = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity(errorResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleuserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorResponse errorResp = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity(errorResp, HttpStatus.NOT_FOUND);
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse errorResp = new ErrorResponse(LocalDateTime.now(), ex.getFieldError().getDefaultMessage(),
				ex.getFieldError().getRejectedValue().toString());

		return new ResponseEntity(errorResp, HttpStatus.BAD_REQUEST);
	}

}
