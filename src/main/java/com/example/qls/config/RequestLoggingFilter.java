package com.example.qls.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Bỏ qua lọc những request không phải từ API để terminal đỡ bị rác
        if (!req.getRequestURI().startsWith("/api/")) {
            chain.doFilter(request, response);
            return;
        }

        System.out.println("\n========== [API REQUEST] ==========");
        System.out.println(">>> HÀNH ĐỘNG (Method) : " + req.getMethod());
        System.out.println(">>> ĐƯỜNG DẪN (URL)    : " + req.getRequestURI());

        // Cho phép request đi tiếp tới Controller để xử lý
        chain.doFilter(request, response);

        System.out.println("<<< TRẠNG THÁI (Status): " + res.getStatus() + (res.getStatus() == 200 ? " (THÀNH CÔNG)" : ""));
        System.out.println("===================================\n");
    }
}
