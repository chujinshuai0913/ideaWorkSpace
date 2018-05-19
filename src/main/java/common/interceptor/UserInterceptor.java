package common.interceptor;

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
//		User user = (User)request.getSession().getAttribute(Constant.USER_SESSION);
//		if(user!=null) {
//			return true;
//		}
//		response.sendRedirect(request.getContextPath()+"/sharebook/jsp/shareindex");
		return true;
	}
}
