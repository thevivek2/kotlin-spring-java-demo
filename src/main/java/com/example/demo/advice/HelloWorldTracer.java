package com.example.demo.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class HelloWorldTracer {

    @Bean(name = "traceInterceptor")
    public MethodInterceptor jpaTracker() {
        var trace = new CustomizableTraceInterceptor();
        trace.setEnterMessage("Entering $[methodName] $[arguments]");
        trace.setExitMessage("Exiting $[methodName] $[arguments] Returning $[returnValue]");
        trace.setLogExceptionStackTrace(true);
        trace.setUseDynamicLogger(true);
        trace.setLoggerName("com.example.demo.TraceService");
        return trace;
    }

    @Bean
    public DefaultPointcutAdvisor myAdvisor(@Qualifier("traceInterceptor") MethodInterceptor interceptor) {
        var pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("helloWorldFromMemory");
        return new DefaultPointcutAdvisor(pointcut, interceptor);
    }

}
