package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtil {

	
	public String getTodayDate(String formate) throws ParseException {
		String date = java.time.LocalDate.now().toString();
		DateFormat parser = new SimpleDateFormat("yyyy-mm-dd");
		Date convertedDate = parser.parse(date);
		DateFormat formatter = new SimpleDateFormat(formate);
		date = formatter.format(convertedDate);
		return date;
	}

	public String getRandomNumber(int min, int max) {
		int b = (int) (Math.random() * (max - min + 1) + min);
		String number = String.valueOf(b);
		return number;
	}
	
	
}
