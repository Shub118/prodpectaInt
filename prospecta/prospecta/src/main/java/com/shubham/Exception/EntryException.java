package com.shubham.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EntryException extends Exception{
	
	public EntryException(String msg) {
		super(msg);
	}
}
