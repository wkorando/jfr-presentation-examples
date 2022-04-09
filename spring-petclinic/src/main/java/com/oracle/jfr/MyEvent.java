package com.oracle.jfr;

import jdk.jfr.Event;
import jdk.jfr.Category;
import jdk.jfr.Label;
import jdk.jfr.Description;
import jdk.jfr.Enabled;

@Category("Custom Events")
@Label("My Special Event")
@Enabled(false)
public class MyEvent extends Event {

//	@Description("A value of great importance")
//	private String importantValue;
//	
//	public void assignImportantValue(String importantValue) {
//		this.importantValue = importantValue;
//	}
}
