package com.example.restapi.model.error;

import java.time.LocalDateTime;

public class ErrorResponse {

	public LocalDateTime timestamp;
	public String md_error_msg;
	public String md_details;

	public ErrorResponse(LocalDateTime timestamp, String md_error_msg, String md_details) {
		super();
		this.timestamp = timestamp;
		this.md_error_msg = md_error_msg;
		this.md_details = md_details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMd_error_msg() {
		return md_error_msg;
	}

	public void setMd_error_msg(String md_error_msg) {
		this.md_error_msg = md_error_msg;
	}

	public String getMd_details() {
		return md_details;
	}

	public void setMd_details(String md_details) {
		this.md_details = md_details;
	}

}
