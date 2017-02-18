package me.airomad.kotlinswingwrapper.demo

import me.airomad.kotlinswingwrapper.Row
import me.airomad.kotlinswingwrapper.frame
import me.airomad.kotlinswingwrapper.panel
import java.awt.GridBagConstraints
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JTextField

/**
 * Created by Airomad on 18.02.2017.
 * Sign In Frame Demo
 */

fun main(args: Array<String>) {
    signInFrame()
}

fun signInFrame() {
    val LOGIN = "Jon"
    val PASSWORD = "Snow"
    val statusLabel = JLabel()
    val loginField = JTextField()
    val passwordField = JTextField()

    frame {
        size { 400 AND 250 }
        onClose { EXIT_ON_CLOSE }
        add {
            panel {
                debug = true
                row {
                    Row.cell {
                        add { JLabel("Login: Jon | Password: Snow") }
                        init {
                            gridwidth = 2
                            anchor = GridBagConstraints.CENTER
                            insets.bottom = 10
                        }
                    }
                }
                row {
                    Row.cell {
                        add { statusLabel }
                        init {
                            gridwidth = 2
                            anchor = GridBagConstraints.CENTER
                            insets.bottom = 10
                        }
                    }
                }
                row {
                    Row.cell {
                        add { JLabel("Login: ") }
                        init {
                            fill = GridBagConstraints.BOTH
                            insets.bottom = 5
                        }
                    }
                    Row.cell {
                        add {
                            loginField.apply { columns = 20 }
                        }
                        init { insets.bottom = 5 }
                    }
                }
                row {
                    Row.cell {
                        add { JLabel("Password: ") }
                        init {
                            fill = GridBagConstraints.BOTH
                            insets.bottom = 15
                        }
                    }
                    Row.cell {
                        add {
                            passwordField.apply { columns = 20 }
                        }
                        init { insets.bottom = 15 }
                    }
                }
                row {
                    Row.cell {
                        add {
                            JButton("Sing in").apply {
                                addActionListener {
                                    if (loginField.text == LOGIN && passwordField.text == PASSWORD)
                                        statusLabel.text = "Correct input!"
                                    else
                                        statusLabel.text = "Incorrect input!"
                                }
                            }
                        }
                        init {
                            gridwidth = 2
                            anchor = GridBagConstraints.CENTER
                        }
                    }
                }
            }
        }
        visibility { true }
    }
}