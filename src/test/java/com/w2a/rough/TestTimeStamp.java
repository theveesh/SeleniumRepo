package com.w2a.rough;

import java.util.Date;

public class TestTimeStamp {
	
	public static void main(String[] args) {
		Date d = new Date();
		String scrname = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		System.out.println(d);
		System.out.println(scrname);
		System.out.println(System.getProperty("user.dir"));
	}
	
}
