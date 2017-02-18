package me.airomad.kotlinswingwrapper

import java.awt.GridBagConstraints
import javax.swing.JComponent
import javax.swing.JPanel

/**
 * Created by Airomad on 18.02.2017.
 * KSW Panel
 */

fun panel(block: Panel.() -> Unit): JPanel {
    return Panel.apply { block() }.panel
}

object Panel : KSWComponent() {
    lateinit var gbc: GridBagConstraints
    lateinit var panel: JPanel
    var component: JComponent? = null

    fun row(block: Row.() -> Unit) = set { gbc.nextRow(); Row.block() }

    fun apply(block: Panel.() -> Unit) : Panel {
        gbc = GridBagConstraints()
        panel = JPanel()
        component = null

        this.block()
        return this
    }

    object Row {
        fun cell(block: Cell.() -> Unit) = setCell { Cell.block() }

        fun setCell(block: () -> Unit) : KSWComponent {
            block()
            if (component != null) {
                panel.add(component, gbc)
                return Panel
            }
            gbc.nextCell()
            gbc.clear()
            return Panel
        }

        object Cell {
            fun add(value: () -> JComponent) = set { component = value() }
            fun grid(block: Grid.() -> KSWComponent) = Grid.block()

            object Grid {
                val NONE = 0
                val BOTH = 1
                val HORIZONTAL = 2
                val VERTICAL = 3

                val CENTER = 10

                fun pos(block: Pos.() -> KSWComponent) = Pos.block()
                fun size(block: Size.() -> KSWComponent) = Size.block()
                fun align(value: () -> Int) = set { gbc.anchor = value() }
                fun fill(value: () -> Int) = set { gbc.fill = value() }
                fun padding(block: Pad.() -> KSWComponent) = Pad.block()

                object Pos {
                    infix fun Int.AND(y: Int) = set { gbc.gridx = this; gbc.gridy = y }
                }

                object Size {
                    infix fun Int.AND(height: Int) = set { gbc.gridwidth = this; gbc.gridheight = height }
                }

                object Pad {
                    fun top(value: () -> Int) = set { gbc.insets.top = value() }
                    fun right(value: () -> Int) = set { gbc.insets.right = value() }
                    fun bottom(value: () -> Int) = set { gbc.insets.bottom = value() }
                    fun left(value: () -> Int) = set { gbc.insets.left = value() }
                }
            }
        }
    }
}