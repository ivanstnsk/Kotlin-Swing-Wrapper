package me.airomad.kotlinswingwrapper.demo

import me.airomad.kotlinswingwrapper.frame
import me.airomad.kotlinswingwrapper.panel
import me.airomad.kotlinswingwrapper.splitpane
import java.awt.GridBagConstraints
import javax.swing.JLabel

/**
 * Created by Airomad on 18.02.2017.
 * Two Panels Demo
 */

fun main(args: Array<String>) {
    twoPanelsFrame()
}

fun twoPanelsFrame() {
    frame {
        size { 400 AND 400 }
        add {
            splitpane {
                left {
                    panel {
                        debug = true
                        row {
                            cell {
                                add { JLabel("First panel") }
                                init {
                                    anchor = GridBagConstraints.CENTER
                                    insets.top = 100
                                    insets.bottom = 100
                                }
                            }
                        }
                    }
                }
                right {
                    panel {
                        debug = true
                        row {
                            cell {
                                add { JLabel("Second panel") }
                                init {
                                    anchor = GridBagConstraints.CENTER
                                    insets.top = 100
                                    insets.bottom = 100
                                }
                            }
                        }
                    }
                }
                divider {
                    size { 10 }
                    location { 150 }
                    orientation { HORIZONTAL }
                }
            }
        }
        onClose { EXIT_ON_CLOSE }
        visibility { true }
    }
}