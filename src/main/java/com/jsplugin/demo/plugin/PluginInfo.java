package com.jsplugin.demo.plugin;

public class PluginInfo {
    private String code;
    private String groupName;
    private String pluginName;
    private int callType;
    private String point;
    private int enabled ;

    public PluginInfo(String code, String groupName, String pluginName, int callType, String point, int enabled) {
        this.code = code;
        this.groupName = groupName;
        this.pluginName = pluginName;
        this.callType = callType;
        this.point = point;
        this.enabled = enabled;
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

    @Override
    public String toString() {
        return "PluginInfo{" +
                "code='" + code + '\'' +
                ", groupName='" + groupName + '\'' +
                ", pluginName='" + pluginName + '\'' +
                ", callType=" + callType +
                ", point='" + point + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
