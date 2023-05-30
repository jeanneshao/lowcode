package com.jeanne.lowcode.interceptors.access;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class AccessInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AccessInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("-------------------------preHandler-------------------------");
        if (handler instanceof HandlerMethod) {
//            User user = getUser(request, response);
//            // 向当前访问的线程里保存user， 用于UserArgumentResolver 直接获取（同一个请求，同一个线程）
//            // 先执行 拦截器， 再执行 UserArgumentResolver
//            UserContext.setUser(user);
            HandlerMethod hm = (HandlerMethod) handler;
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }
            logger.info("---------------------get----AccessLimit-------------------------");

//            boolean needLogin = accessLimit.needLogin();
//            if (needLogin) {
//                if (user == null) {
//                    render(response, CodeMsg.SESSION_ERROR);
//                    return false;
//                }
//            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                      @Nullable ModelAndView modelAndView) throws Exception {
        logger.info("<====================AccessInterceptor  post handle<====================>");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                               @Nullable Exception ex) throws Exception {
        logger.info("<====================AccessInterceptor afterCompletion<====================>");

    }
//    private void render(HttpServletResponse response, CodeMsg cm) throws Exception {
//        response.setContentType("application/json;charset=UTF-8");
//        OutputStream out = response.getOutputStream();
//        String str = JSON.toJSONString(Result.error(cm));
//        out.write(str.getBytes("UTF-8"));
//        out.flush();
//        out.close();
//    }

//    private User getUser(HttpServletRequest request, HttpServletResponse response) {
//        String token = request.getHeader(JwtUtil.COOKIE_NAME_TOKEN);
//
//        Claims claims = null;
//        try {
//            claims = JwtUtil.parseJWT(token);
//            JSONObject userInfo = (JSONObject) JSONObject.parse(claims.getSubject());
//            return new User(userInfo);
//        } catch (Exception e) {
//            logger.error("jwt parse error: ", e);
//            return null;
//        }
//    }

}
