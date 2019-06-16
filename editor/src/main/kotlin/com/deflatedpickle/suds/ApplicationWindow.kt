package com.deflatedpickle.suds

import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import javax.swing.JFrame

class ApplicationWindow : JFrame("Suds") {
    val armaturePanel = ArmaturePanel()
    val animationPanel = AnimationPanel(this)

    init {
        this.layout = GridBagLayout()

        this.size = Dimension(600, 600)

        this.add(armaturePanel, GridBagConstraints().apply {
            this.fill = GridBagConstraints.BOTH
            this.gridwidth = GridBagConstraints.REMAINDER
            this.weightx = 1.0
            this.weighty = 1.0
        })
        this.add(animationPanel, GridBagConstraints().apply {
            this.fill = GridBagConstraints.HORIZONTAL
            this.gridwidth = GridBagConstraints.REMAINDER
            this.weightx = 1.0
        })
    }
}