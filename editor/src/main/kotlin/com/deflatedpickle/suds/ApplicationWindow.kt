package com.deflatedpickle.suds

import java.awt.Dimension
import javax.swing.JFrame

class ApplicationWindow : JFrame("Suds") {
    val armaturePanel = ArmaturePanel()

    init {
        this.size = Dimension(600, 600)

        this.add(armaturePanel)
    }
}