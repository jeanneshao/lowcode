package com.jeanne.lowcode.interceptors.query;


import com.jeanne.lowcode.vo.TextSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class QueryParamInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(QueryParamInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("---------------------QueryParamInterceptor----preHandler-------------------------");
        if (handler instanceof HandlerMethod) {

            HandlerMethod hm = (HandlerMethod) handler;
            ConvertQueryParam convertQueryParam = hm.getMethodAnnotation(ConvertQueryParam.class);
            if (convertQueryParam == null) {
                return true;
            }
            String queryString = request.getQueryString();
            Optional<String> textSearchOpt = Arrays.stream(queryString.split("&"))
                    .filter(queryItem -> queryItem.startsWith("textSearch"))
                    .findFirst();
            if (textSearchOpt.isEmpty()) {
                return true;
            }
            textSearchOpt.ifPresent(textSearch->{
                log.info("QueryParamInterceptor.textSearch===>{}",textSearch);
                String[] searchItemSplits = textSearch.split(";");
                List<TextSearchVo.SearchIem> searchIemList = Arrays.stream(searchItemSplits)
                        .filter(item -> StringUtils.hasText(item))
                        .map(item -> {
                            String[] fieldOperatorParam = item.split("-");

                            return TextSearchVo.SearchIem.builder()
                                    .field(fieldOperatorParam[0])
                                    .operator(fieldOperatorParam[1])
                                    .params(fieldOperatorParam[2].split(","))
                                    .build();
                        }).collect(Collectors.toList());
                TextSearchVo textSearchVo = TextSearchVo.builder().searchIemList(searchIemList).build();
                log.info("QueryParamInterceptor.obtained textSearch===>{}",textSearchVo);
                TextSearchContext.set(textSearchVo);
            });

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                      @Nullable ModelAndView modelAndView) throws Exception {
        logger.info("<====================QueryParamInterceptor  post handle<====================>");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                               @Nullable Exception ex) throws Exception {
        logger.info("<====================QueryParamInterceptor afterCompletion<====================>");

    }


}
