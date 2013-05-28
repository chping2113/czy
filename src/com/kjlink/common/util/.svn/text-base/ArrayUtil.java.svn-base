package com.kjlink.common.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {
	
	/**
	 * 把一个数组的成员通过str指定的字符串连接起来并返回
	 * @param array为需要连接的数组
	 * @param str为数组元素连接符
	 * @return 返回连接后的结果
	 */
	public static String join(Object[] array, String str) {
		if(array == null || str == null) 
			return "";
		
		StringBuffer sb = new StringBuffer();
		for(Object obj : array) {
			sb.append(obj.toString());
			sb.append(str);
		}
		
		String tmp = sb.toString();
		//去除最后一个连接符
		if(tmp.endsWith(str)) {
			tmp = tmp.substring(0, tmp.lastIndexOf(str));
		}
		return tmp;
	}
	
	public static Object[] removeElement(Object[] array, Object[] subarray) {
		if(array == null || subarray == null)
			return null;
		
		if(subarray.length > 0) {
			List<Object> list = new ArrayList<Object>(array.length);
			for(Object obj : array) {
				boolean matched = false;
				for(Object o : subarray) {
					if(obj.equals(o)) {
						matched = true;
						break;
					}
				}
				
				if(! matched) {
					list.add(obj);
				}
			}
			return list.toArray();
		}
		
		return array;
	}
	
	public static boolean contains(Object[] array, Object element) {
		boolean con = false;
		for(Object o : array) {
			if(o.equals(element))
				return true;
		}
		return con;
	}
	
	public static void main(String[] args) {
		Object[] ary = {"aa", "bb", "cc", "dd"};
		
		String str = join(ary, ",");
		System.out.println(str);
		
		Object[] sub = {"aa", "bb", "ee"};
		ary = removeElement(ary, sub);
		System.out.println(join(ary, ","));
		
		System.out.println(contains(sub, "aa"));
	}
}
