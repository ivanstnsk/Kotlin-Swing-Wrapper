package me.airomad.kotlinswingwrapper.demo

import me.airomad.kotlinswingwrapper.panel
import java.awt.Dimension
import java.awt.GridBagConstraints
import javax.swing.JButton
import javax.swing.JFrame
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

    val p = panel {
        debug = true
        row {
            cell {
                add { JLabel("Login: Jon | Password: Snow") }
                init {
                    gridwidth = 2
                    anchor = GridBagConstraints.CENTER
                    insets.bottom = 10
                }
            }
        }
        row {
            cell {
                add { statusLabel }
                init {
                    gridwidth = 2
                    anchor = GridBagConstraints.CENTER
                    insets.bottom = 10
                }
            }
        }
        row {
            cell {
                add { JLabel("Login: ") }
                init {
                    fill = GridBagConstraints.BOTH
                    insets.bottom = 5
                }
            }
            cell {
                add {
                    loginField.apply { columns = 20 }
                }
                init { insets.bottom = 5 }
            }
        }
        row {
            cell {
                add { JLabel("Password: ") }
                init {
                    fill = GridBagConstraints.BOTH
                    insets.bottom = 15
                }
            }
            cell {
                add {
                    passwordField.apply { columns = 20 }
                }
                init { insets.bottom = 15 }
            }
        }
        row {
            cell {
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

    JFrame().apply {
        size = Dimension(400, 400)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        add(p)
        isVisible = true
    }
}