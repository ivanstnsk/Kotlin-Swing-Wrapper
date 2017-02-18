package me.airomad.kotlinswingwrapper

import javax.swing.JComponent
import javax.swing.JSplitPane

/**
 * Created by Airomad on 18.02.2017.
 * SplitPane
 */

fun splitpane(block: SplitPane.() -> Unit): JSplitPane {
    return SplitPane.apply { block() }.component
}

object SplitPane : KSWComponent() {
    lateinit var component: JSplitPane

    fun divider(block: Divider.() -> KSWComponent) = Divider.block()
    fun left(value: () -> JComponent) = set { component.leftComponent = value() }
    fun right(value: () -> JComponent) = set { component.rightComponent = value() }

    fun apply(block: SplitPane.() -> Unit) : SplitPane {
        component = JSplitPane()
        this.block()
        return this
    }

    object Divider {
        val VERTICAL = 0
        val HORIZONTAL = 1

        fun size(value: () -> Int) = set { component.dividerSize = value() }
        fun location(value: () -> Int) = set { component.dividerLocation = value() }
        fun orientation(value: () -> Int) = set { component.orientation = value() }
    }
}
