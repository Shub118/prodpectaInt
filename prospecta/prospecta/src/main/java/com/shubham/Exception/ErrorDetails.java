package com.shubham.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
	
	private String msg;
	private String desc;
	private LocalDateTime timeStamp;
}
