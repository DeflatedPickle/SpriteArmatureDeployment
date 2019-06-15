package com.deflatedpickle.sad;

public class MainSad {
    public static void main(String []args) {
        StaticArmature armature = new StaticArmature(ClassLoader.getSystemClassLoader().getResource("armature.xml"));

        System.out.println(armature.bones.get("chest").get(0));
        System.out.println(armature.bones.get("chest").get(0).children.get("head"));

        System.out.println(armature.bones.get("chest").get(0).children.get("left_arm"));
        System.out.println(armature.bones.get("chest").get(0).children.get("left_arm").children.get("hand"));
    }
}
