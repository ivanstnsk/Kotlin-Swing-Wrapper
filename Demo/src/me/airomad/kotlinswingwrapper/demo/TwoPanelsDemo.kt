package me.airomad.kotlinswingwrapper.demo

import me.airomad.kotlinswingwrapper.frame
import me.airomad.kotlinswingwrapper.panel
import me.airomad.kotlinswingwrapper.splitpane
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
                        row {
                            cell {
                                add { JLabel("First panel") }
                                grid {
                                    align { CENTER }
                                    padding {
                                        top { 100 }
                                        bottom { 100 }
                                    }
                                }
                            }
                        }
                    }
                }
                right {
                    panel {
                        row {
                            cell {
                                add { JLabel("Second panel") }
                                grid {
                                    align { CENTER }
                                    padding {
                                        top { 100 }
                                        bottom { 100 }
                                    }
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