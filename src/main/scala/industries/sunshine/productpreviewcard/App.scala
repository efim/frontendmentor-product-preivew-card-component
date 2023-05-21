package industries.sunshine.productpreviewcard

import scala.scalajs.js
import scala.scalajs.js.annotation.*

import org.scalajs.dom

import com.raquo.laminar.api.L.{*, given}

@main
def App(): Unit =
  renderOnDomContentLoaded(
    dom.document.getElementById("app"),
    Main.appElement()
  )

object Main {
  def appElement(): Element =
    div(
      className := "w-screen h-screen",
      renderProductPreviewCard(),
      renderAttribution()
    )

  def renderProductPreviewCard() = {
    div(
      """

  Preview

  Gabrielle Essence Eau De Parfum

  A floral, solar and voluptuous interpretation composed by Olivier Polge,
  Perfumer-Creator for the House of CHANEL.

  $149.99
  $169.99

  Add to Cart

"""
    )
  }

  def renderAttribution() = {
    div(
      className := "attribution",
      "Challenge by ",
      a(
        href := "https://www.frontendmentor.io?ref=challenge",
        target := "_blank",
        "Frontend Mentor"
      ),
      " Coded by ",
      a(href := "#", "Your Name Here")
    )
  }
}
