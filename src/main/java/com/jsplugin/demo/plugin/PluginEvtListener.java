package com.jsplugin.demo.plugin;

import com.google.common.eventbus.Subscribe;

public class PluginEvtListener {

    @Subscribe
    public void OnListener(PluginEvent evt)
    {
        System.out.println("+++++"+evt.toString());
    }
}
