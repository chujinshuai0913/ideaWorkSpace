package common.interceptor;

import common.model.UserLogin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor{
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
								Object arg2, Exception arg3) throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
						   Object arg2, ModelAndView arg3) throws Exception {

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
							 Object arg2) throws Exception {
		UserLogin userLogin = (UserLogin)request.getSession().getAttribute("userLogin");
		if(userLogin!=null) {
			return true;
		}else {
			String url =request.getContextPath()+"/sso/sharebook/login";
			response.sendRedirect(url);
			return true;
		}
	}
}
