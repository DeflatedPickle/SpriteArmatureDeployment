package com.deflatedpickle.sad;

import java.util.HashMap;

public class StaticBone {
    public String name;
    public HashMap<String, StaticBone> children = new HashMap<>();
    public HashMap<String, Object> properties = new HashMap<>();

    public StaticBone(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + name + ", children: " + String.join(",", children.keySet()) + ", properties: " + properties.toString();
    }
}
