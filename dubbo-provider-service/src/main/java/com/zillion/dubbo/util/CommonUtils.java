package com.zillion.dubbo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



/**
 * 公共方法
 * @author 李君
 */
public class CommonUtils {
	
	/*
	 * 字符串是否为空
	 */
	public static boolean isBank(String str) {
		if (str == null || "".equals(str)) {
		      return true;
		}else{
			 return false;
		}
	}
	
	/*
	 * 判断字符串是否为数字
	 */
	public static boolean isNumber(String str){
		Pattern pt = Pattern.compile("^[0-9]*$");
		Matcher mt = pt.matcher(str);
		return mt.matches();
	}
	
	/*
	 * 获得当前分页开始的记录数
	 */
	public static int getFirstSize(int pageNo,int pageSize){
        int firstSize = 0;
        firstSize = (pageNo -1) * pageSize;
        if(firstSize < 0){
        	firstSize = 0;
        }
        return firstSize;
    }
	
	/*
	 * base64加密解密
	 */
	public static String base64Encode(String type, String data){
		String res = null;
		try {   
			if("enccode".equals(type)){
				res = new BASE64Encoder().encode(data.getBytes());
			}else if("decode".equals(type)){
				res = new String(new BASE64Decoder().decodeBuffer(data));
			}else{
				res = "";
			}
		} catch (Exception e) {        			
			e.printStackTrace();  
		}
		return res;
	}
}
