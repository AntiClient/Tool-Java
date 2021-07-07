package eu.iamgio.anticlient.app

import eu.iamgio.anticlient.view.LoginView
import javafx.scene.image.Image
import tornadofx.*

class AntiClientApp : App(LoginView::class) {

    init {
        loadFont("/fonts/Roboto-Regular.ttf", 36)
        loadFont("/fonts/Roboto-Bold.ttf", 36)
        importStylesheet("/stylesheets/styles.css")
        setStageIcon(Image(javaClass.getResourceAsStream("/assets/logo.png")))
    }
}