package com.sniper.findme.common.model;

import java.util.ArrayList;
import java.util.List;

public class ResultObject {
	private Object result;
	private List<ErrorDetails> errorList = new ArrayList<>();

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public List<ErrorDetails> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<ErrorDetails> errorList) {
		this.errorList = errorList;
	}

}
