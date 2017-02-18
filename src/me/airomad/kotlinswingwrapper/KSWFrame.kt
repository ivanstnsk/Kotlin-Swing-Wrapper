package me.airomad.kotlinswingwrapper

import javax.swing.JComponent
import javax.swing.JFrame

/**
 * Created by Airomad on 18.02.2017.
 * KSW Frame
 */

fun frame(block: Frame.() -> Unit): JFrame {
    return Frame.apply { block() }.frame
}

object Frame : KSWComponent() {
    val DO_NOTHING_ON_CLOSE = 0
    val HIDE_ON_CLOSE = 1
    val DISPOSE_ON_CLOSE = 2
    val EXIT_ON_CLOSE = 3
    lateinit var frame: JFrame

    fun add(component: () -> JComponent) = set { frame.add(component()) }
    fun size(block: Size.() -> KSWComponent) = Size.block()
    fun onClose(value: () -> Int) = set { frame.defaultCloseOperation = value() }
    fun visibility(value: () -> Boolean) = set { frame.isVisible = value() }

    fun apply(block: Frame.() -> Unit) : Frame {
        frame = JFrame()
        this.block()
        return this
    }

    object Size {
        infix fun Int.AND(height: Int) = set { frame.setSize(this, height) }
    }
}

