package com.deflatedpickle.sad;

public class MainSad {
    public static void main(String []args) {
        StaticArmature armature = new StaticArmature(ClassLoader.getSystemClassLoader().getResource("armature.xml"));

        System.out.println(armature.bones.get("chest").get(0));
        System.out.println(armature.bones.get("chest").get(0).children.get("head"));

        System.out.println("----------------");

        System.out.println(armature.frames.get(0).get("chest"));
        System.out.println(armature.frames.get(0).get("chest").children.get("head"));

        System.out.println("------");

        System.out.println(armature.frames.get(1).get("chest"));
        System.out.println(armature.frames.get(1).get("chest").children.get("head"));
    }
}
