package com.hiext.mms.core.exception;

import com.hiext.mms.core.HttpCode;

/**
 * 
 * @author angy.zhang
 *
 */
@SuppressWarnings("serial")
public class DataParseException extends BaseException {

	public DataParseException() {
	}

	public DataParseException(Throwable ex) {
		super(ex);
	}

	public DataParseException(String message) {
		super(message);
	}

	public DataParseException(String message, Throwable ex) {
		super(message, ex);
	}

	protected HttpCode getHttpCode() {
		return HttpCode.INTERNAL_SERVER_ERROR;
	}

}
