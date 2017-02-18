package me.airomad.kotlinswingwrapper

import java.awt.*
import javax.swing.BorderFactory
import javax.swing.JComponent
import javax.swing.JPanel

/**
 * Created by Airomad on 17.02.2017.
 * Kotlin Swing Wrapper
 */

val DEBUG_BORDER = BorderFactory.createLineBorder(Color.RED)

fun panel(init: Panel.() -> Unit): Panel {
    return Panel().apply { init() }
}

class Panel : JPanel() {
    var gbc: GridBagConstraints = GridBagConstraints()
    var debug: Boolean = false
        set(value) {
            field = value
            if (value) border = DEBUG_BORDER else border = null
        }

    init {
        layout = GridBagLayout()
        Row.panel = this
        Cell.panel = this
    }

    fun row(block: Row.() -> Unit) {
        Row.apply {
            gbc.nextRow()
            block()
        }
    }
}

object Row {
    lateinit var panel: Panel

    fun cell(block: Cell.() -> Unit) {
        panel.addComponent(Cell.apply { block() }.component)
    }
}

object Cell {
    lateinit var panel: Panel
    var component: JComponent? = null

    fun add(c: () -> JComponent) {
        component = c()
        if (panel.debug)
            component?.border = DEBUG_BORDER
    }

    fun init(block: GridBagConstraints.() -> Unit) {
        panel.gbc.apply { block() }
    }
}

fun Panel.addComponent(component: JComponent?) {
    if (component != null) {
        add(component, gbc)
        Cell.component = null
    }
    gbc.nextCell()
    gbc.clear()
}

fun GridBagConstraints.nextRow() {
    gridx = 0
    gridy++
}

fun GridBagConstraints.nextCell() {
    gridx++
}

fun GridBagConstraints.clear() {
    gridwidth = 1
    gridheight = 1
    anchor = 10
    fill = 0
    insets.clear()
    ipadx = 0
    ipady = 0
}

fun Insets.clear() {
    top = 0
    right = 0
    bottom = 0
    left = 0
}

operator fun Insets.plus(other: Insets): Insets {
    top += other.top
    right += other.top
    bottom += other.bottom
    left += other.left
    return this
}