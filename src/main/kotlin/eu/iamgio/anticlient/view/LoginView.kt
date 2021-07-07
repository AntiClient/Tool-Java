package eu.iamgio.anticlient.view

import eu.iamgio.anticlient.Actions
import eu.iamgio.anticlient.app.AntiClientApp
import javafx.css.PseudoClass
import javafx.geometry.Pos
import javafx.scene.control.TextField
import javafx.scene.image.Image
import tornadofx.*

class LoginView : View("AntiClient") {

    override fun onDock() {
        currentStage?.isResizable = false
    }

    override val root = anchorpane {
        val pane = this
        styleClass += "pane"
        prefWidth = 700.0
        prefHeight = 500.0
        vbox {
            styleClass += "login"
            spacing = 7.5
            prefWidth = pane.prefWidth / 1.75
            layoutX = pane.prefWidth / 2 - prefWidth / 2
            layoutY = pane.prefHeight / 2 - 75
            alignment = Pos.CENTER
            label("LOGIN") {
                styleClass += "login-title"
            }
            var textfield: TextField? = null
            val hbox = hbox {
                alignment = Pos.CENTER_LEFT
                styleClass += "login-fieldbox"
                prefWidth = this@vbox.prefWidth
                prefHeight = 45.0
                stackpane {
                    styleClass += "key-icon-container"
                    imageview(Image(AntiClientApp::class.java.getResourceAsStream("/assets/key-variant.png"))) {
                        styleClass += "key-icon"
                    }
                }
                textfield = textfield {
                    styleClass += "login-field"
                    promptText = "PIN"
                    prefWidth = this@hbox.prefWidth
                    prefHeight = this@hbox.prefHeight
                    setOnAction {
                        val valid = Actions.isPinValid(text)
                        println(text)
                        if(valid) {
                            Actions.onPinEnter(text)
                            replaceWith<ScanView>()
                        }
                        this@hbox.pseudoClassStateChanged(PseudoClass.getPseudoClass("error"), !valid)
                    }
                }
            }
            button("Login") {
                styleClass += "btn"
                prefWidth = this@vbox.prefWidth
                prefHeight = hbox.prefHeight
                setOnAction {textfield!!.onAction.handle(it)}
            }
        }
    }
}