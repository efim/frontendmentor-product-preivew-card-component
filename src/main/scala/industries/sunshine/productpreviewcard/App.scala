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
      className := "flex flex-col justify-center items-center w-screen h-screen bg-cream",
      renderProductPreviewCard(),
      renderAttribution()
    )

  def renderProductPreviewCard() = {
    div(
      className := "bg-white rounded-lg w-[350px] h-[600px]",
      img(
        src := "/images/image-product-mobile.jpg",
        role := "img",
        className := "rounded-t-lg"
      ),
      div(
        className := "flex flex-col p-7",
        p("Perfume", className := "text-sm text-gray-500 uppercase tracking-[.3rem]"),
        p(
          "Gabrielle Essence Eau De Parfum",
          className := "py-3 font-serif text-4xl font-bold"
        ),
        p(
          "A floral, solar and voluptuous interpretation composed by Olivier Polge, Perfumer-Creator for the House of CHANEL.",
          className := "text-base text-gray-500"
        ),
        div(
          className := "grid grid-cols-2 items-center pt-6 pb-5", 
          p("$149.99", className := "font-serif text-4xl text-dark-cyan"),
          p("$169.99", className := "text-sm text-gray-500 line-through")
        ),
        button(
          img(src := "/images/icon-cart.svg", role := "img", className := "px-3"),
          "Add to Cart",
          className := "w-full rounded-xl h-[3.25rem] bg-dark-cyan",
          className := "text-sm font-bold text-white",
          className := "flex flex-row justify-center items-center",
          className := "duration-300 active:scale-105 hover:bg-darkest-cyan"
        )
      )
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
