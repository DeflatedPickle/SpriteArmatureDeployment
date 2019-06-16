package com.deflatedpickle.sad;

import com.deflatedpickle.suds.ApplicationWindow;

public class MainSuds {
    public static void main(String []args) {
        StaticArmature armature = new StaticArmature(ClassLoader.getSystemClassLoader().getResource("armature.xml"));

        ApplicationWindow applicationWindow = new ApplicationWindow();
        applicationWindow.getArmaturePanel().setArmature(armature);

        // applicationWindow.pack();
        applicationWindow.setVisible(true);
    }
}
