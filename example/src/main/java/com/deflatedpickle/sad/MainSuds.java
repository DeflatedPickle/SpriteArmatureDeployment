package com.deflatedpickle.sad;

import com.deflatedpickle.suds.ApplicationWindow;

import javax.swing.*;

public class MainSuds {
    public static void main(String []args) {
        StaticArmature armature = new StaticArmature(ClassLoader.getSystemClassLoader().getResource("armature.xml"));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        ApplicationWindow applicationWindow = new ApplicationWindow();
        applicationWindow.getArmaturePanel().setArmature(armature);

        // applicationWindow.pack();
        applicationWindow.setVisible(true);
    }
}
