/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.common.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.RandomStringUtils;


/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-10
 */
public class StringUtil {
	public static String iso2Utf8(String str) {
		if(str == null)
			return null;
		String s = "";
		try {
			s = new String(str.getBytes("iso8859-1"), "utf-8");
		} catch(Exception e) {
			throw new RuntimeException("Convert String " + str + " from iso8859-1 to utf-8 error...");
		}
		return s;
	}
	/**
	 * 验证是否是中文或数字
	 * @param str
	 * @return
	 */
	public static boolean isGBK(String str) {
		if (str != null && !"".equals(str.trim())){
			String regex = "\\d+";  // 验证是否是数字
			Pattern pattern = Pattern.compile(regex);  
			Matcher matcher = pattern.matcher(str);  
			if (!matcher.matches()) {
				regex = "[\\u4e00-\\u9fa5]+"; // 验证是否是中文
				pattern = Pattern.compile(regex);  
				matcher = pattern.matcher(str); 
			}
			return matcher.matches();
		}
		return false;
	}
	/**
	 * 将utf-8编码格式的字符串  还原为编码之前的字符串
	 */
	public static String utf2gbk(String str){ // str 为utf-8格式编码
		if (str != null && !"".equals(str.trim())) {
			try {
				return URLDecoder.decode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static String gbk2utf(String str) {
		if (str != null && !"".equals(str.trim())) {
			try {
				return URLEncoder.encode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 输入字符串如果为空返回整型0
	 * @param str
	 * @return
	 */
	public static int getIntByString(String str){
		int result =0 ;
		if(null!=str&&!"".equals(str)){
			result = Integer.parseInt(str);
			if(result==0)
				return 0;				
		}else{
			return 0;		
		}
		return result;
	}
	/**
	 * 随机生成一个10位的数字串
	 * @return
	 */
	public static String getRandomString(int count) {
		return RandomStringUtils.random(count, true, true);
	}
	
	public static boolean isNumeric(String str)  
	{  
		Pattern pattern = Pattern.compile("[0-9]*");  
		Matcher isNum = pattern.matcher(str);  
		if( !isNum.matches() )  
		{  
			return false;  
		}  
		return true;  
	} 
	
	/**
	 * 随机生成UUID字符串
	 * @param args
	 */
	
	public static String getRandomUUID() {
		return java.util.UUID.randomUUID().toString();
	}
	
	public static String getRandomPassword(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssms", Locale.SIMPLIFIED_CHINESE);
		String pw = sdf.format(new Date());;
		pw = pw + getRandomString(3);
		return pw;
	}
	
	public static String limitCode(String code,int start,int end,char c){
		if(code.length()<end || start>end){
			return code;
		}
		StringBuffer newCode = new StringBuffer();
		newCode.append(code.substring(0, start));
		for(int i=start ; i<end ;i++){
			newCode.append(c);
		}
		newCode.append(code.substring(end, code.length()));
		return newCode.toString();
	}
	
	public static String showAll(Double v){
		DecimalFormat df = new DecimalFormat("##0.0");
		
////        BigDecimal b = new BigDecimal(Double.toString(v));
//        System.out.println(b.toString()+"v"+v);
        return df.format(v);
    }
	
	/**
     * 根据指定的参数limit来限制传入的文本信息，超出的部分以"..."代替
     * @param text
     * @param limit
     * @return
     */
    public static String limitTextTest(String text, int limit) {
    	if(text == null) {
    		return "";
    	}
    	byte[] bt = text.getBytes();
    	if(text.getBytes().length > limit ) {
    		System.out.println("=="+text.length());
    		if(limit%2 == 0 && text.getBytes().length%2 == 0)
    			return new String(bt,0,limit) + "...";
    		else{
    			return new String(bt,0,--limit) + "...";
    		}
    			
    	}
    	return text;
    }
    
	public static int byteLength(String string){
		int count = 0;
		for(int i=0;i<string.length();i++){
			if(Integer.toHexString(string.charAt(i)).length()==4){
				count += 2;
			}else{
				count++;
			}
		}
		return count;
	}
	
	public static String limitText(String string, int limit) {
		StringBuffer sb = new StringBuffer();
		if (byteLength(string) > limit) {
			int count = 0;
			for (int i = 0; i < string.length(); i++) {
				char temp = string.charAt(i);
				if (Integer.toHexString(temp).length() == 4) {
					count += 2;
				} else {
					count++;
				}
				if (count < limit) {
					sb.append(temp);
				}
				if (count == limit) {
					sb.append(temp);
					break;
				}
				if (count > limit) {
					break;
				}
			}
			sb.append("...");
		} else {
			sb.append(string);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
//		System.out.println(limitCode("32523543256265",2,2,'#'));
		System.out.println(limitText("325235",4));
		System.out.println(limitText("3测试的的的3",8));
//		System.out.println(limitText("3测试的的的3",4).length());
//		System.out.println(limitText("大发达",4));
	}
	
	
}
