package com.deflatedpickle.suds

import com.deflatedpickle.sad.StaticBone
import java.awt.*

class DisplayBone(val bone: StaticBone, var parentBone: DisplayBone?) {
    var size: Point
    var location: Point

    val centeredLocation = Point()
    val centeredSize = Point()

    init {
        val properties = bone.properties
        location = Point(properties["x"] as Int, properties["y"] as Int)

        size = Point(2, 2)
    }

    fun draw(g2D: Graphics2D, centre: Point, scaleFactor: Int) {
        val circleX = (centre.x - (size.x * scaleFactor) / 2) + location.x * scaleFactor
        val circleY = (centre.y - (size.y * scaleFactor) / 2) + location.y * scaleFactor
        centeredLocation.setLocation(circleX, circleY)
        centeredSize.setLocation(size.x * scaleFactor, size.y * scaleFactor)

        val textX = circleX - (g2D.fontMetrics.stringWidth(bone.name) / 4)
        val textY = circleY + (g2D.fontMetrics.height)

        g2D.color = Color.BLUE
        g2D.fillOval(circleX, circleY, size.x * scaleFactor, size.y * scaleFactor)

        g2D.color = Color.ORANGE
        g2D.drawString(bone.name, textX, textY)

        if (parentBone != null) {
            val parentCircleX = (centre.x - (parentBone!!.size.x * scaleFactor) / 2) + parentBone!!.location.x * scaleFactor
            val parentCircleY = (centre.y - (parentBone!!.size.y * scaleFactor) / 2) + parentBone!!.location.y * scaleFactor

            g2D.color = Color.GREEN
            g2D.stroke = BasicStroke(4f)
            g2D.drawLine(circleX + (size.x * scaleFactor) / 2, circleY + (size.y * scaleFactor) / 2,
                parentCircleX + (parentBone!!.size.x * scaleFactor) / 2, parentCircleY + (parentBone!!.size.y * scaleFactor) / 2)
        }
    }
}