package com.jsplugin.demo.plugin.evt;

public class PluginBeforeApiEvent extends PluginEvent{
    public PluginBeforeApiEvent(String point, int callType, Object data) {
        super(point, callType, data);
    }
}
