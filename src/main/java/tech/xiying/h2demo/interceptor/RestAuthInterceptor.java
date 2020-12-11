package tech.xiying.h2demo.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shanghao5
 */
@Service
public class RestAuthInterceptor implements HandlerInterceptor {

    /**
     * 身份校验参数属性名
	 */
	private final static String AUTH_PARAMETER_KEY = "Token";
	
	private static Logger log = LoggerFactory.getLogger(RestAuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(handler instanceof HandlerMethod){
			HandlerMethod methodHandler = (HandlerMethod)handler;
			RestAuthValidator auth = methodHandler.getMethodAnnotation(RestAuthValidator.class);
			// 不进行身份校验
			if (auth == null || !auth.valid()) {
				return true;
			}
		}
		// 校验通过
		if (validate(request.getHeader(AUTH_PARAMETER_KEY), request)) {
			return true;
		}

		throw new RuntimeException("request forbidden");
	}
	

	private boolean validate(String token, HttpServletRequest req) {
		return true;
	}
	
}
