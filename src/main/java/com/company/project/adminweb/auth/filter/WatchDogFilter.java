package com.company.project.adminweb.auth.filter;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * 看门狗
 *
 * @author wangzhj
 */
public class WatchDogFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WatchDogFilter.class);

    private static final String REQUEST_ID_NAME = "Request-Id";

    private static final String REQUEST_ID_KEY = "request_id";

    private static final String MDC_URI_KEY = "uri";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String uri = request.getRequestURI();
        try {
            //
            String requestId = request.getHeader(REQUEST_ID_NAME);
            if (Strings.isNullOrEmpty(requestId)) {
                requestId = String.valueOf(UUID.randomUUID().hashCode() & 0x7fffffff);
            }
            //
            MDC.put(REQUEST_ID_KEY, requestId);
            MDC.put(MDC_URI_KEY, uri);

            //
            filterChain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }
}
