package com.eli.cruises.api.rs.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.transaction.TransactionSystemException;

import com.eli.cruises.api.errors.ApiError;
import com.eli.cruises.api.errors.NotFoundException;


@ControllerAdvice
class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);
	
	private class __Status_N_Message {
		HttpStatus status;
		String apiMessage;
	}


	private __Status_N_Message doStatusAndMessage(Exception ex, HttpStatus status) {
		
		__Status_N_Message sm = new __Status_N_Message();
		
    		if (ex instanceof NotFoundException) {

    			sm.status = HttpStatus.NOT_FOUND;
    			sm.apiMessage = "Not Found";
    			
    		} else if (ex instanceof DataIntegrityViolationException ||
    					ex instanceof JpaSystemException) {

    			sm.status = HttpStatus.NOT_ACCEPTABLE;
    			sm.apiMessage = "Data Error";

    		} else if (ex instanceof HttpMessageNotReadableException) {
    			
    			sm.status = HttpStatus.BAD_REQUEST;
    			sm.apiMessage = "Request Message Error";

    		} else if (ex instanceof TransactionSystemException) {
    			
    			sm.status = HttpStatus.CONFLICT;
    			sm.apiMessage = "Transaction Exception";

    		} else if (ex instanceof NullPointerException) {
    			
    			sm.status = HttpStatus.BAD_REQUEST;
    			sm.apiMessage = "Null Pointer Exception";

    		} else if (null==status) {
    			
    			sm.status = HttpStatus.INTERNAL_SERVER_ERROR;
    			sm.apiMessage = "Other Internal Error";
    		}

   		return sm;
	}

    protected ResponseEntity<ApiError> _handleVariousExceptions(
    		Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        
    	logger.debug("\n\n BEGIN BEGIN handleVariousExceptions\n\n");

    	String acceptHeader = showDebuggingInfo(ex,request);
    	
    	if (
    		null!=request && null!=acceptHeader &&
    		(acceptHeader.toLowerCase().contains(MediaType.APPLICATION_JSON_VALUE.toLowerCase()) || acceptHeader.contains("*/*"))
   			) {
    		
    		String apiError = (!ex.getLocalizedMessage().isEmpty())?ex.getLocalizedMessage():ex.getMessage();
    		
    		__Status_N_Message sm = doStatusAndMessage(ex, status);

   			ApiError error = new ApiError(sm.status,sm.apiMessage,apiError);
   			
   			return new ResponseEntity<ApiError>(error,status);

    	} else {
    		logger.error("Unsupported Media Type When Handling Exception:"+ ex.getLocalizedMessage());
    		//INTERNAL_SERVER_ERROR
    		return handleAllNoReturnedData(ex);
    	}

    	
    }

    protected ResponseEntity<Object> _handleVariousExceptionsReturnObject(
    		Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        
    	logger.debug("\n\n BEGIN BEGIN handleVariousExceptionsReturnObject\n\n");

    	String acceptHeader = showDebuggingInfo(ex,request);
    	
    	if (
    		null!=request && null!=acceptHeader &&
    		(acceptHeader.toLowerCase().contains(MediaType.APPLICATION_JSON_VALUE.toLowerCase()) || acceptHeader.contains("*/*"))
   			) {
    		
    		String apiError = (!ex.getLocalizedMessage().isEmpty())?ex.getLocalizedMessage():ex.getMessage();
    		
    		__Status_N_Message sm = doStatusAndMessage(ex, status);

   			ApiError error = new ApiError(sm.status,sm.apiMessage,apiError);
   			
   			return new ResponseEntity<Object>(error,status);

    	} else {
    		logger.error("Unsupported Media Type When Handling Exception:"+ ex.getLocalizedMessage());
    		//INTERNAL_SERVER_ERROR
    		return handleAllNoReturnedDataReturnObject(ex);
    	}

    	
    }

    
    
    private String showDebuggingInfo(Exception ex, WebRequest request) {

    	logger.debug("\n\nexception : " + ex.getClass().getName()+":"+ex.getMessage()+"\n\n",ex);

   		String acceptHeader = request.getHeader(HttpHeaders.ACCEPT);
   		logger.debug("\n\naccept header value : " + acceptHeader + "\n\n");

   		logger.debug("\n\n===Headers=======================");
		request.getHeaderNames().forEachRemaining((a)-> {
				logger.debug("header: "+a+" : "+request.getHeader(a));
			});
   		logger.debug("===============================\n\n");

   		logger.debug("\n\n===Parameters=======================");
		request.getParameterNames().forEachRemaining((a)-> {
				logger.debug("header: "+a+" : "+request.getParameter(a));
			});
   		logger.debug("===============================\n\n");

   		return acceptHeader;
    	
    }

    @ExceptionHandler({ 
    	NotFoundException.class //custom
    	,DataIntegrityViolationException.class
    	,JpaSystemException.class
    	,TransactionSystemException.class
    	,NullPointerException.class
    	})
    protected ResponseEntity<ApiError> handleVariousExceptions(
    		Exception ex, Object body, WebRequest request) { 
    
    	logger.debug("\n\nhandleVariousExceptions\n\n");

    	logger.debug("\n\nexception: " + ex.getClass().getName()+":"+ex.getMessage()+"\n\n",ex);

   		logger.debug("\n\nobject:"+body.getClass().getName()+"\n\n");

   		HttpHeaders headers = new HttpHeaders();
   		
   		request.getHeaderNames().forEachRemaining((a)->{
			String value = request.getHeader(a);
			List<String> values = new ArrayList<String>();
			values.add(value);
			headers.put(a,values);
   		});

		return _handleVariousExceptions( ex, headers, null, request);

    }


    @ExceptionHandler({ Exception.class })
    protected ResponseEntity<ApiError> handleAllExceptionsNotSpecified(Exception ex, Object body, WebRequest request)
    { 
    	logger.debug("\n\nhandleAllExceptionsNotSpecified\n\n");

    	logger.debug("\n\n\texception is : "+ex.getClass().getName()+"\n\n");

    	if (checkValidAcceptMediaTypes(request)) { 
    			ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,ex.getLocalizedMessage());
    			return new ResponseEntity<ApiError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    	} else {
    		logger.error("Unsupported Media Type When Handling Exception:"+ ex.getLocalizedMessage());
    		//INTERNAL_SERVER_ERROR
    		return handleAllNoReturnedData(ex);
    	}

    }

    private boolean checkValidAcceptMediaTypes(WebRequest request) {

    	logger.debug("\n\ncheckValidAcceptMediaTypes(Request): request obj is "+(null==request)+"\n\n");

    	if (null==request) { return false; }
    	
    	String acceptHeader = request.getHeader(HttpHeaders.ACCEPT);
    	boolean rtn = (
    		null!=acceptHeader &&
    		acceptHeader.toLowerCase().contains(MediaType.APPLICATION_JSON_VALUE.toLowerCase()) ||
    	    acceptHeader.toLowerCase().contains(MediaType.APPLICATION_XML_VALUE.toLowerCase())  ||
    	    acceptHeader.toLowerCase().contains("*/*")
   			)?true:false;
    	
    	logger.debug("\n\ncheckValidAcceptMediaTypes(Headers): returning "+rtn+"\n\n");

    	return rtn;
    }


    private boolean checkValidAcceptMediaTypes(HttpHeaders headers) {

    	logger.debug("\n\ncheckValidAcceptMediaTypes(Headers): Headers obj is "+(null==headers)+"\n\n");

    	if (null==headers) {
    		return false;
    	}
    	
    	Iterator<String> it = headers.keySet().iterator();
    	while (it.hasNext()) {
    		String key = it.next();
    		if (key.toLowerCase().contains("accept")) {
    			List<String> values = headers.get(key);
    			for (String v : values) {

    				if (v.toLowerCase().contains(MediaType.APPLICATION_JSON_VALUE.toLowerCase()) ||
    				   (v.toLowerCase().contains(MediaType.APPLICATION_XML_VALUE.toLowerCase()) ||
    					v.contains("*/*"))) {
    					
    					logger.debug("\n\ncheckValidAcceptMediaTypes(Headers): returning true.\n\n");

    					return true;
    				}
    			}
   			}
    	}
    	
    	logger.debug("\n\ncheckValidAcceptMediaTypes(Headers): returning false.\n\n");

    	return false;
    }




    protected ResponseEntity<ApiError> handleAllNoReturnedData(Exception ex) {

    	logger.debug("\n\nhandleAllNoReturnedData\n\n");

    	logger.debug("\n"+ex.getClass().getName()+"\n");

    	logger.error(ex.getLocalizedMessage(),ex);

    	ResponseEntity<ApiError> response = new ResponseEntity<ApiError>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    	
    	return response;
    }

    protected ResponseEntity<Object> handleAllNoReturnedDataReturnObject(Exception ex) {

    	logger.debug("\n\nhandleAllNoReturnedData\n\n");

    	logger.debug("\n"+ex.getClass().getName()+"\n");

    	logger.error(ex.getLocalizedMessage(),ex);

    	ResponseEntity<Object> response = new ResponseEntity<Object>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    	
    	return response;
    }

 
 
    @Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
 
    	logger.debug("\n\nhandleHttpMessageNotReadableException\n\n");


   		if (!checkValidAcceptMediaTypes(request)) {

			if (checkValidAcceptMediaTypes(headers)) {

				return _handleVariousExceptionsReturnObject(ex, headers, status, request);

			}
   		}

				return _handleVariousExceptionsReturnObject(ex, headers, status, request);
    	//return super.handleHttpMessageNotReadable(ex, headers, status, request);
    	
    }


    @Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
 
    	logger.debug("\n\nhandleHttpMessageNotWritableException\n\n");

   		if (!checkValidAcceptMediaTypes(request)) {

			if (checkValidAcceptMediaTypes(headers)) {

				return _handleVariousExceptionsReturnObject(ex, headers, status, request);

			}
   		}

    	return super.handleHttpMessageNotWritable(ex, headers, status, request);
    	
    }

 
    @Override
    //if annotated, an error occurs: ambiguous handler - because base class method already annotated
    //@ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, 
			HttpHeaders headers, HttpStatus status, WebRequest request) {
 
    	logger.debug("\n\nhandleHttpMediaTypeNotAcceptable\n\n");

    	return super.handleHttpMediaTypeNotAcceptable(ex, headers, status, request);
    	
    }
 
    @Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, 
			HttpHeaders headers, HttpStatus status, WebRequest request) {
 
    	logger.debug("\n\nhandleHttpMediaTypeNotSupported\n\n");

    	return super.handleHttpMediaTypeNotSupported(ex, headers, status, request);
    	
    }
 
    @Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, 
			HttpHeaders headers, HttpStatus status, WebRequest request) {
 
    	logger.debug("\n\nhandleHttpRequestMethodNotSupported\n\n");

    	return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
    	
    }
 
    @Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, 
			HttpHeaders headers, HttpStatus status, WebRequest request) {
 
    	logger.debug("\n\nhandleNoHandlerFoundException\n\n");

    	return super.handleNoHandlerFoundException(ex, headers, status, request);
    	//return handleVariousExceptions(ex, headers, status, request);
    	
    }
 
    @Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
 
    	logger.debug("\n\nBEGIN handleExceptionInternal\n\n");

    	return super.handleExceptionInternal(ex, body, headers, status, request);
    	
    }
 
}
