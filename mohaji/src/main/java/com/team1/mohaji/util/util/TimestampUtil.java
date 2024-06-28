package com.team1.mohaji.util.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimestampUtil {
	//	Timestamp 타입을 날짜 + 시간으로 변환
	public static String dateTimeToString(Timestamp timestamp) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(timestamp);
	}

	//	Timestamp 타입을 날짜로 변경
	public static String dateToString(Timestamp timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(timestamp);
	}
	
}
