package com.jsplugin.demo.plugin;

import com.google.common.eventbus.Subscribe;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

@Component
public class PluginEvtListener  implements ApplicationContextAware{
    ScriptEngine jsEngine = new ScriptEngineManager().getEngineByName("JavaScript");
    // 方式三，使用Context设置变量
    ScriptContext PluginContext = jsEngine.getContext();
    @Subscribe
    public void OnListener(PluginEvent evt)
    {
        jsEngine.setContext(PluginContext);
        System.out.println("+++++"+evt.toString());
    }

    @PostConstruct
    private void init()
    {

        PluginContext.setAttribute("hello", "polo", ScriptContext.GLOBAL_SCOPE);
    }
}
