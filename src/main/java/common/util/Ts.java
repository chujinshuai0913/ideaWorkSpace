package common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.model.UserShare;
import org.springframework.util.StringUtils;
import common.constant.ConstantsUtils;

public class Ts {
	public static boolean hv(String ps) {
		return !StringUtils.isEmpty(ps);
	}

	public static Date newDate() {
		return new Date();
	}

	public static UserShare getUser(HttpSession session) {
		return (UserShare) session.getAttribute(ConstantsUtils.UserCode.USER_SESSION);
	}

	public static int pageCount(double cnt, double pageSize) {
		if (pageSize == 0) {
			return 0;
		} else {
			return (int) Math.ceil(cnt / pageSize);
		}
	}

	public static Integer toInt(String rs) {
		return hv(rs) ? Integer.parseInt(rs.toString()) : null;
	}
	
	public static String uuid() {
		try {
			return UUID.randomUUID().toString().replace("-", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	//获取请求地址的IP
	 public static String getIpAddr(HttpServletRequest request){  
	        String ipAddress = request.getHeader("x-forwarded-for");  
	            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	                ipAddress = request.getHeader("Proxy-Client-IP");  
	            }  
	            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	                ipAddress = request.getHeader("WL-Proxy-Client-IP");  
	            }  
	            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
	                ipAddress = request.getRemoteAddr();  
	                if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
	                    //根据网卡取本机配置的IP  
	                    InetAddress inet=null;  
	                    try {  
	                        inet = InetAddress.getLocalHost();  
	                    } catch (UnknownHostException e) {  
	                        e.printStackTrace();  
	                    }  
	                    ipAddress= inet.getHostAddress();  
	                }  
	            }  
	            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
	            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
	                if(ipAddress.indexOf(",")>0){  
	                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
	                }  
	            }  
	            return ipAddress;   
	    }
}
