package com.jsplugin.demo.plugin;

import java.util.HashMap;
import java.util.Map;

public class PluginInfo implements IPlugin{
    private String code;
    private String groupName;
    private String pluginName;
    private int callType;
    private String point;
    private int enabled ;

    private String pluginContent;

    private Map<String,String> paramsMap ;

    public PluginInfo(String content,String code, String groupName, String pluginName, int callType, String point, int enabled) {
        this.pluginContent= content;
        this.code = code;
        this.groupName = groupName;
        this.pluginName = pluginName;
        this.callType = callType;
        this.point = point;
        this.enabled = enabled;
        this.paramsMap = new HashMap<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public int getCallType() {
        return callType;
    }

    public void setCallType(int callType) {
        this.callType = callType;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Map<String, String> getParamsMap() {
        return paramsMap;
    }

    public void setParamsMap(Map<String, String> paramsMap) {
        this.paramsMap = paramsMap;
    }

    public String getPluginContent() {
        return pluginContent;
    }

    public void setPluginContent(String pluginContent) {
        this.pluginContent = pluginContent;
    }

    @Override
    public String toString() {
        return "PluginInfo{" +
                "code='" + code + '\'' +
                ", groupName='" + groupName + '\'' +
                ", pluginName='" + pluginName + '\'' +
                ", callType=" + callType +
                ", point='" + point + '\'' +
                ", enabled=" + enabled +
                ", pluginContent='" + pluginContent + '\'' +
                ", paramsMap=" + paramsMap +
                '}';
    }
}
