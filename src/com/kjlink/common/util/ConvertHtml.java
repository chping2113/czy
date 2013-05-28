package com.kjlink.common.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ConvertHtml {
	public static final String strFrom = "script";
	public static final String strTo = "script";

	public static String convertTextarea(String strSource) {
/*		String strDest = "";
		int intFromLen = strFrom.length();
		int intPos;
		while ((intPos = strSource.indexOf(strFrom)) != -1) {
			strDest = strDest + strSource.substring(0, intPos);
			strDest = strDest + strTo;
			strSource = strSource.substring(intPos + intFromLen);
		}
		strDest = strDest + strSource;*/
		
		
		String strDest = strSource;
		
		strDest = strDest.replace("&", "&amp;");
		strDest = strDest.replace("'", "&acute;");
		strDest = strDest.replace("\"", "&quot;");
		strDest = strDest.replace(" ", "&nbsp;");
		strDest = strDest.replace("<", "&lt;");
		strDest = strDest.replace(">", "&gt;");
		
		
		String[] dest=strDest.split("\r");
		String temp1 = "";
		
		for(int i=0;i<dest.length;i++){
			String temp=dest[i].replace("\n", "");
			temp1 += "<p>"+temp+"</p>";	
		}
		strDest = temp1;

		//strDest = strDest.replace("<br/>", "\r\n");

		return strDest;
	}

	public static String convertInputText(String str) {
		str = str.replace("&", "&amp;");
		str = str.replace("'", "&acute;");
		str = str.replace("\"", "&quot;");
		str = str.replace(" ", "&nbsp;");
		str = str.replace("<", "&lt;");
		str = str.replace(">", "&gt;");
		return str;
	}
}
