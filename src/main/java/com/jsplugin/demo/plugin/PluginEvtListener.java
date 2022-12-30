package com.jsplugin.demo.plugin;

import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;
import com.jsplugin.demo.Consts;
import com.jsplugin.demo.config.WebConfig;
import com.jsplugin.demo.plugin.evt.PluginAfterApiEvent;
import com.jsplugin.demo.plugin.evt.PluginBeforeApiEvent;
import com.jsplugin.demo.plugin.evt.PluginEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.script.*;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class PluginEvtListener  implements ApplicationContextAware{
    private List<PluginInfo> pluginInfos;
    private ApplicationContext applicationContext;

    private Map<String,String> pluginJsonMap = new HashMap<>();
    private Map<String,IPlugin> pluginMap = new HashMap<>();

    @Subscribe
    public void OnAfterApiListener(PluginAfterApiEvent evt)
    {

        try {

            if(evt.getCallType()!=Consts.CallType.After_Api || pluginInfos == null || pluginInfos.isEmpty())
            {
                return;
            }

            //查找 符合切点 与调用调用类型的 plugin
            List<PluginInfo> ps= pluginInfos.stream().filter(pluginInfo -> pluginInfo.getPoint().equals(evt.getPoint())
            && pluginInfo.getCallType() == evt.getCallType() && !pluginInfo.getPluginContent().isEmpty()).collect(Collectors.toList());
            if(ps == null || ps.isEmpty())
            {
                return;
            }

            ScriptEngine jsEngine = new ScriptEngineManager().getEngineByName("js");//.getEngineByName("JavaScript");
            // 注入 js 上下文变量
            for (PluginInfo plugin : ps)
            {
                for (Map.Entry<String,String> kv : plugin.getParamsMap().entrySet())
                {
                    String paramName = kv.getKey();
                    String paramVal = kv.getValue();
                    jsEngine.getContext().setAttribute(paramName, paramVal, ScriptContext.ENGINE_SCOPE);
                }
            }
            // 注入 spring boot 对象
            //todo: daizuo

            // 编译 执行
            if (jsEngine instanceof Compilable){
                for (PluginInfo plugin : ps)
                {
                    CompiledScript compileScript = ((Compilable) jsEngine).compile(plugin.getPluginContent());
                    if (compileScript != null){
                        compileScript.eval();
                    }
                }
            }
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
        System.out.println("+++++"+evt.toString());
    }

    @Subscribe
    public void OnBeforApiListener(PluginBeforeApiEvent evt)
    {
        try {

            if(evt.getCallType() != Consts.CallType.Before_Api || pluginInfos == null || pluginInfos.isEmpty())
            {
                return;
            }

            //查找 符合切点 与调用调用类型的 plugin
            List<PluginInfo> ps= pluginInfos.stream().filter(pluginInfo -> pluginInfo.getPoint().equals(evt.getPoint())
                    && pluginInfo.getCallType() == evt.getCallType() && !pluginInfo.getPluginContent().isEmpty()).collect(Collectors.toList());
            if(ps == null || ps.isEmpty())
            {
                return;
            }

            ScriptEngine jsEngine = new ScriptEngineManager().getEngineByName("js");//.getEngineByName("JavaScript");

            // 注入 js 上下文变量
            for (PluginInfo plugin : ps)
            {
                for (Map.Entry<String,String> kv : plugin.getParamsMap().entrySet())
                {
                    String paramName = kv.getKey();
                    String paramVal = kv.getValue();
                    jsEngine.getContext().setAttribute(paramName, paramVal, ScriptContext.ENGINE_SCOPE);
                }
            }
            // 注入 spring boot 对象
            //todo: daizuo

            // 编译 执行
            if (jsEngine instanceof Compilable){
                for (PluginInfo plugin : ps)
                {
                    CompiledScript compileScript = ((Compilable) jsEngine).compile(plugin.getPluginContent());
                    if (compileScript != null){
                        compileScript.eval();
                    }
                }
            }
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
        System.out.println("+++++"+evt.toString());
    }

    @PostConstruct
    private void init()
    {
        pluginInfos = getPluginInfos();

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private void getIPluginBean()
    {
//        if(this.pluginMap.size() == 0)
//        {
//            this.pluginMap = applicationContext.getBeansOfType(IPlugin.class);
//            for
//        }
    }

    private List<PluginInfo> getPluginInfos()
    {
        //  从数据库获取 参数配置
        //  这里直接使用 示例， 不从数据库获取了，

        PluginInfo pluginInfo= new PluginInfo("print('aaaa')","11","aa","p1", Consts.CallType.After_Api,"/api/usernames/haha",Consts.PluginEnabled.Enabled);
        pluginInfo.getParamsMap().put("param1","111");
        pluginInfo.getParamsMap().put("param2","222");
        pluginInfo.getParamsMap().put("param3","333");
       return Lists.newArrayList(pluginInfo);
    }
}
