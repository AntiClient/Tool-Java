package eu.iamgio.anticlient.view

import eu.iamgio.anticlient.Actions
import eu.iamgio.anticlient.app.AntiClientApp
import javafx.geometry.Pos
import javafx.scene.control.TextArea
import javafx.scene.image.Image
import tornadofx.*

/**
 * @author Gio
 */
class ScanView : View("AntiClient") {

    override fun onDock() {
        currentStage?.isResizable = false
        currentWindow?.sizeToScene()
    }

    override val root = vbox {
        styleClass += "pane"
        prefWidth = 1020.0
        prefHeight = 600.0
        spacing = 25.0
        alignment = Pos.CENTER

        imageview(Image(AntiClientApp::class.java.getResourceAsStream("/assets/logo-crop.png"))) {
            fitWidth = 200.0
            fitHeight = 200.0
            isPreserveRatio = true
        }
        var textArea: TextArea? = null
        button("Scan") {
            styleClass.addAll("btn", "scan-btn")
            prefWidth = 150.0
            setOnAction {
                if(textArea == null) {
                    this@vbox.hbox {
                        alignment = Pos.CENTER
                        textArea = textarea {
                            styleClass += "scan-area"
                            isEditable = false
                        }
                    }
                } else textArea!!.text = ""
                Actions.scan(textArea!!)
            }
        }
    }
}
