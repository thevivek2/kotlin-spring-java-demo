package com.example.demo;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.core.Ordered.LOWEST_PRECEDENCE;

@Service
@Order(LOWEST_PRECEDENCE)
//KOTLIN SUSPEND FILTER HAS LOWEST EVEN THIS IS SET TO BE LOWEST
public class RequestTrackerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request, response);
        System.out.println(" **** RequestTrackerFilter *****************");
    }

}
