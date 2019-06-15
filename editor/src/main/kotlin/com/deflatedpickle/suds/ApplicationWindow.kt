package com.deflatedpickle.suds

import javax.swing.JFrame

class ApplicationWindow : JFrame("Suds") {
    val armaturePanel = ArmaturePanel()

    init {
        this.add(armaturePanel)
    }
}