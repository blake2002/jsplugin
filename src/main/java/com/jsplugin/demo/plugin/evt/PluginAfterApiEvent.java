package com.jsplugin.demo.plugin.evt;

public class PluginAfterApiEvent extends PluginEvent{
    public PluginAfterApiEvent(String point, int callType, Object data) {
        super(point, callType, data);
    }
}
