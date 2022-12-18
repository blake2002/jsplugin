package com.jsplugin.demo.interceptors;

import com.jsplugin.demo.plugin.PluginEvent;
import com.jsplugin.demo.plugin.PluginEvtListener;
import com.google.common.eventbus.AsyncEventBus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.Executors;

public class PluginInterceptor implements HandlerInterceptor {
    private final AsyncEventBus dispatcher = new AsyncEventBus(Executors.newFixedThreadPool(4));
    private final PluginEvtListener listener = new PluginEvtListener();

    public PluginInterceptor()
    {
        dispatcher.register(listener);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            System.out.println(new Date() + "--preHandle:" + request.getRequestURL());
            String matchUri = request.getRequestURI();
            dispatcher.post(new PluginEvent(matchUri,"api前切"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       try {
           System.out.println(new Date() + "--postHandle:" + request.getRequestURL());
           String matchUri = request.getRequestURI();
           dispatcher.post(new PluginEvent(matchUri,"api后切"));
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(new Date() + "--afterCompletion:" + request.getRequestURL());
    }
}
