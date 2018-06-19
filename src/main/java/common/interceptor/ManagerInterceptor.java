package common.interceptor;

import common.mapper.UserManagerMapper;
import common.model.UserManagerLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerInterceptor implements HandlerInterceptor{
	@Autowired
	private UserManagerMapper userManagerMapper;
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
								Object arg2, Exception arg3) throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
						   Object arg2, ModelAndView arg3) throws Exception {

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
							 Object arg2) throws Exception {
		UserManagerLogin userManagerLogin = (UserManagerLogin)request.getSession().getAttribute("userManagerLogin");
		if(userManagerLogin!=null) {
			return true;
		}else {
			response.sendRedirect(request.getContextPath()+"/sso/sharemanager/login.jsp");
			return false;
		}
	}
}
