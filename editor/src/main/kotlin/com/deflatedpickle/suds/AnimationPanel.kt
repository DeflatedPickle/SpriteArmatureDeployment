package com.deflatedpickle.suds

import java.awt.GridBagLayout
import javax.swing.JButton
import javax.swing.JPanel

class AnimationPanel(applicationWindow: ApplicationWindow) : JPanel() {
    lateinit var nextFrameButton: JButton
    lateinit var previousFrameButton: JButton

    init {
        this.layout = GridBagLayout()

        nextFrameButton = JButton("Next Frame").apply {
            addActionListener {
                previousFrameButton.isEnabled = true

                applicationWindow.armaturePanel.frame++

                applicationWindow.armaturePanel.repaint()

                if (applicationWindow.armaturePanel.frame == applicationWindow.armaturePanel.armature!!.frames.size - 1) {
                    this.isEnabled = false
                }
            }
        }

        previousFrameButton = JButton("Previous Frame").apply {
            this.isEnabled = false

            addActionListener {
                nextFrameButton.isEnabled = true

                applicationWindow.armaturePanel.frame--

                applicationWindow.armaturePanel.repaint()

                if (applicationWindow.armaturePanel.frame == 0) {
                    this.isEnabled = false
                }
            }

        }

        this.add(previousFrameButton)
        this.add(nextFrameButton)
    }
}