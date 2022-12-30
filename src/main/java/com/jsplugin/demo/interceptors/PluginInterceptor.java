package com.jsplugin.demo.interceptors;

import com.google.common.eventbus.AsyncEventBus;
import com.jsplugin.demo.Consts;
import com.jsplugin.demo.plugin.PluginEvtListener;
import com.jsplugin.demo.plugin.evt.PluginAfterApiEvent;
import com.jsplugin.demo.plugin.evt.PluginBeforeApiEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.Executors;
@Component
public class PluginInterceptor implements HandlerInterceptor {
    private final AsyncEventBus dispatcher = new AsyncEventBus(Executors.newFixedThreadPool(4));
    @Resource
    private PluginEvtListener listener ;

    @PostConstruct
    public void init()
    {
        dispatcher.register(listener);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            System.out.println(new Date() + "--preHandle:" + request.getRequestURL());
            String matchUri = request.getRequestURI();
            dispatcher.post(new PluginBeforeApiEvent(matchUri, Consts.CallType.Before_Api,"api前切"));
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
           dispatcher.post(new PluginAfterApiEvent(matchUri,Consts.CallType.After_Api,"api后切"));
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
