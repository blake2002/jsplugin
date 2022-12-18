package com.jsplugin.demo.plugin;

public class PluginEvent {
    private String evtType;
    private Object data;

    public PluginEvent(String evtType, Object data) {
        this.evtType = evtType;
        this.data = data;
    }

    public String getEvtType() {
        return evtType;
    }

    public void setEvtType(String evtType) {
        this.evtType = evtType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PluginEvent{" +
                "evtType='" + evtType + '\'' +
                ", data=" + data +
                '}';
    }
}
