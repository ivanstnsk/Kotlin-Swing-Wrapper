package me.airomad.kotlinswingwrapper.demo

import me.airomad.kotlinswingwrapper.frame
import me.airomad.kotlinswingwrapper.panel
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
                row {
                    cell {
                        add { JLabel("Login: Jon | Password: Snow") }
                        grid {
                            size { 2 AND 1 }
                            align { CENTER }
                            padding {
                                bottom { 10 }
                            }
                        }
                    }
                }
                row {
                    cell {
                        add { statusLabel }
                        grid {
                            size { 2 AND 1 }
                            align { CENTER }
                            padding {
                                bottom { 10 }
                            }
                        }
                    }
                }
                row {
                    cell {
                        add { JLabel("Login: ") }
                        grid {
                            align { CENTER }
                            fill { BOTH }
                            padding {
                                bottom { 5 }
                            }
                        }
                    }
                    cell {
                        add {
                            loginField.apply { columns = 20 }
                        }
                        grid {
                            padding {
                                bottom { 5 }
                            }
                        }
                    }
                }
                row {
                    cell {
                        add { JLabel("Password: ") }
                        grid {
                            fill { BOTH }
                            padding {
                                bottom { 15 }
                            }
                        }
                    }
                    cell {
                        add {
                            passwordField.apply { columns = 20 }
                        }
                        grid {
                            padding {
                                bottom { 15 }
                            }
                        }
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
                        grid {
                            size { 2 AND 1 }
                            align { CENTER }
                        }
                    }
                }
            }
        }
        visibility { true }
    }
}