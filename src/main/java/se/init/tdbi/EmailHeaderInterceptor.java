package se.init.tdbi;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class EmailHeaderInterceptor extends HandlerInterceptorAdapter {

    private static final ThreadLocal<String> emailHolder = new ThreadLocal<>();
    private static final String OAUTH2_PROXY_EMAIL_HEADER = "X-Forwarded-Email";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        emailHolder.set(request.getHeader(OAUTH2_PROXY_EMAIL_HEADER));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        emailHolder.remove();
    }

    public static String getEmail() {
        return emailHolder.get();
    }
}
