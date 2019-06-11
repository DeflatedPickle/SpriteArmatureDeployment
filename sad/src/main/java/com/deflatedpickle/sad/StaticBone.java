package com.deflatedpickle.sad;

import java.util.HashMap;

public class StaticBone {
    String name;
    HashMap<String, StaticBone> children = new HashMap<>();
    HashMap<String, Object> properties = new HashMap<>();

    public StaticBone(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + name + ", children: " + String.join(",", children.keySet()) + ", properties: " + properties.toString();
    }
}
