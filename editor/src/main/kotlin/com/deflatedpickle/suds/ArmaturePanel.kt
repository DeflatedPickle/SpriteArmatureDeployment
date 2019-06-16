package com.deflatedpickle.suds

import com.deflatedpickle.sad.StaticArmature
import com.deflatedpickle.sad.StaticBone
import java.awt.*
import javax.swing.JPanel

class ArmaturePanel : JPanel() {
    lateinit var armature: StaticArmature
    var frame = 0

    var scaleFactor = 10

    val boneList = mutableListOf<DisplayBone>()

    lateinit var centre: Point

    init {
        this.background = Color.WHITE
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g2D = g as Graphics2D

        if (boneList.isEmpty()) {
            for (i in armature.frames[frame].values) {
                loopBones(i, null)
            }
        }

        val originalFont = g2D.font
        g2D.font = Font(originalFont.fontName, Font.BOLD, 14)

        centre = Point(this.width / 2, this.height / 2)

        for (i in boneList) {
            i.draw(g2D, centre, scaleFactor)
        }
    }

    fun loopBones(bone: StaticBone, parentBone: DisplayBone?) {
        val children = bone.children

        val displayBone = DisplayBone(bone, parentBone)
        boneList.add(displayBone)

        if (children != null) {
            for (i in bone.children.values) {
                loopBones(i, displayBone)
            }
        }
    }
}