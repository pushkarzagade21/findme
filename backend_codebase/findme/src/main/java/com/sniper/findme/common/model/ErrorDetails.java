package com.sniper.findme.common.model;

// TODO: Auto-generated Javadoc
/**
 * The Class ErrorDetails.
 */
public class ErrorDetails {
	
	/** The error code. */
	private String errorCode;
	
	/** The error message. */
	private String errorMessage;

	/**
	 * Instantiates a new error details.
	 *
	 * @param errorCode the error code
	 * @param errorMessage the error message
	 */
	public ErrorDetails(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
