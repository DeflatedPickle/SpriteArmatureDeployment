package com.deflatedpickle.sad;

public class Main {
    public static void main(String []args) {
        Armature armature = new Armature(ClassLoader.getSystemClassLoader().getResource("armature.xml"));

        System.out.println(armature.bones.get("head").get(0).get("y"));
        System.out.println(armature.bones.get("head").get(1).get("y"));
    }
}
