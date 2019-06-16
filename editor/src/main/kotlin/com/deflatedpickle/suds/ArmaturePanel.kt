package com.deflatedpickle.suds

import com.deflatedpickle.sad.StaticArmature
import com.deflatedpickle.sad.StaticBone
import java.awt.*
import javax.swing.JPanel

class ArmaturePanel : JPanel() {
    lateinit var armature: StaticArmature
    var frame = 0

    var scaleFactor = 10
    val circleSize = 2 * scaleFactor

    lateinit var centre: Point

    init {
        this.background = Color.WHITE
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g2D = g as Graphics2D

        val originalFont = g2D.font
        g2D.font = Font(originalFont.fontName, Font.BOLD, 14)

        centre = Point(this.width / 2, this.height / 2)

        for (i in armature.frames[frame].values) {
            loopBones(g2D, i)
        }
    }

    fun loopBones(g2D: Graphics2D, bone: StaticBone) {
        val children = bone.children
        val properties = bone.properties

        val circleX = (centre.x - circleSize / 2) + properties["x"] as Int * scaleFactor
        val circleY = (centre.y - circleSize / 2) + properties["y"] as Int * scaleFactor

        val textX = circleX - (g2D.fontMetrics.stringWidth(bone.name) / 4)
        val textY = circleY + (g2D.fontMetrics.height)

        g2D.color = Color.BLUE
        g2D.fillOval(circleX, circleY, circleSize, circleSize)

        g2D.color = Color.ORANGE
        g2D.drawString(bone.name, textX, textY)

        if (bone.children != null) {
            for (i in bone.children.values) {
                loopBones(g2D, i)
            }
        }
    }
}