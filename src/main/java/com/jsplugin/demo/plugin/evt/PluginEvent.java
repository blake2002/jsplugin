package com.jsplugin.demo.plugin.evt;

 public class PluginEvent {

    //切点
    private String point;
    private int callType;
    private Object data;

    public PluginEvent(String point, int callType, Object data) {
        this.point = point;
        this.callType = callType;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public int getCallType() {
        return callType;
    }

    public void setCallType(int callType) {
        this.callType = callType;
    }

    @Override
    public String toString() {
        return "PluginEvent{" +
                "point='" + point + '\'' +
                ", callType=" + callType +
                ", data=" + data +
                '}';
    }
}
