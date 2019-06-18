package com.deflatedpickle.suds

import com.deflatedpickle.sad.StaticArmature
import com.deflatedpickle.sad.StaticBone
import java.awt.*
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JPanel
import javax.swing.SwingUtilities

class ArmaturePanel : JPanel() {
    var armature: StaticArmature? = null
        set(value) {
            field = value

            if (field != null) {
                for (bone in field!!.frames[0].values) {
                    loopBones(bone, null)
                }
            }
        }

    var frame = 0
    set(value) {
        field = value

        for (bone in armature!!.frames[frame].values) {
            loopBones(bone, null)
        }
    }

    var scaleFactor = 10

    val boneMap = mutableMapOf<String, DisplayBone>()

    lateinit var centre: Point

    val cursorArrow = Cursor(Cursor.DEFAULT_CURSOR)
    val cursorHand = Cursor(Cursor.HAND_CURSOR)

    var hoveringBone: DisplayBone? = null

    init {
        this.background = Color.WHITE

        this.addMouseMotionListener(object : MouseAdapter() {
            override fun mouseMoved(e: MouseEvent) {
                for (i in boneMap.values) {
                    if (e.x > i.centeredLocation.x && e.x < i.centeredLocation.x + i.centeredSize.x
                        && e.y > i.centeredLocation.y && e.y < i.centeredLocation.y + i.centeredSize.y
                    ) {
                        this@ArmaturePanel.cursor = cursorHand
                        hoveringBone = i
                        break
                    } else {
                        this@ArmaturePanel.cursor = cursorArrow
                        hoveringBone = null
                    }
                }
            }
        })
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val g2D = g as Graphics2D

        val originalFont = g2D.font
        g2D.font = Font(originalFont.fontName, Font.BOLD, 14)

        centre = Point(this.width / 2, this.height / 2)

        for (i in boneMap.values) {
            i.draw(g2D, centre, scaleFactor)
        }
    }

    private fun loopBones(bone: StaticBone, parentBone: DisplayBone?) {
        val children = bone.children

        val displayBone: DisplayBone
        if (!boneMap.containsKey(bone.name)) {
            displayBone = DisplayBone(bone, parentBone)
            boneMap[bone.name] = displayBone
        }
        else {
            displayBone = boneMap[bone.name]!!
            displayBone.location = Point(bone.properties["x"] as Int, bone.properties["y"] as Int)
        }

        if (children != null) {
            for (i in bone.children.values) {
                loopBones(i, displayBone)
            }
        }
    }
}