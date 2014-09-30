package org.siani.itrules;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;

public class DateTime extends java.util.Date {

	public DateTime(String value) {
		super(new SimpleDateFormat("dd/MM/yyyy").parse(value,new ParsePosition(0)).getTime());
	}
}
