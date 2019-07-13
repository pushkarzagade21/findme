package com.sniper.findme.common.model;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ResultObject.
 */
public class ResultObject {

	/** The result. */
	private Object result;

	/** The error list. */
	private List<ErrorDetails> errorList = new ArrayList<>();

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result the new result
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * Gets the error list.
	 *
	 * @return the error list
	 */
	public List<ErrorDetails> getErrorList() {
		return errorList;
	}

	/**
	 * Sets the error list.
	 *
	 * @param errorList the new error list
	 */
	public void setErrorList(List<ErrorDetails> errorList) {
		this.errorList = errorList;
	}

}
