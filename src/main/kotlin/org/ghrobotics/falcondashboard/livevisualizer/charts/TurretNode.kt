package org.ghrobotics.falcondashboard.livevisualizer.charts

import edu.wpi.first.wpilibj.geometry.Rotation2d
import javafx.beans.property.ReadOnlyDoubleProperty
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import org.ghrobotics.falcondashboard.Properties
import org.ghrobotics.lib.mathematics.units.inMeters
import tornadofx.*

class TurretNode(
    rotation: Rotation2d,
    scaleProperty: ReadOnlyDoubleProperty) : StackPane()
{
    init {
        style {
            backgroundColor = multi(Color.TRANSPARENT)
            borderColor = multi(box(Color.MAROON))
            borderWidth = multi(box(0.25.em))
        }
        usePrefHeight = true
        usePrefWidth = true
        prefHeightProperty()
            .bind(scaleProperty.multiply(Properties.kTargetWidth.inMeters()))
        prefWidthProperty()
            .bind(scaleProperty.multiply(Properties.kTargetThickness.inMeters()))
    }
}