package com.jsplugin.demo.plugin.evt;

import com.jsplugin.demo.plugin.IPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class p1 implements IPlugin {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "p1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
