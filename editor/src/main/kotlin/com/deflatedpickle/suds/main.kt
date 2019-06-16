package com.deflatedpickle.suds

import javax.swing.UIManager

fun main() {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())

    val frame = ApplicationWindow()
    frame.isVisible = true
}
