package com.hospitalmgmt.system;

public class CustomEnum {

	public enum Action{
		PENDING("P"),
		ACCEPTED("A"),
		REJECTED("R");

		String value;
		Action(String value) {
			this.value = value; 
		}
	}
}
