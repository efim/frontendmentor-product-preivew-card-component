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
      renderProductPreviewCard(hardcodedProduct),
      renderAttribution()
    )

  def renderProductPreviewCard(product: ProductDescription) = {
    div(
      className := "bg-white rounded-lg w-[350px] h-[600px]",
      img(
        src := product.mobileImg,
        role := "img",
        className := "rounded-t-lg"
      ),
      div(
        className := "flex flex-col p-7",
        p(
          product.category,
          className := "text-sm text-gray-500 uppercase tracking-[.3rem]"
        ),
        p(
          product.title,
          className := "py-3 font-serif text-4xl font-bold"
        ),
        p(
          product.description,
          className := "text-base text-gray-500"
        ),
        div(
          className := "grid grid-cols-2 items-center pt-6 pb-5",
          p(product.price, className := "font-serif text-4xl text-dark-cyan"),
          product.oldPrice match {
            case Some(crossedPrice) =>
              p(crossedPrice, className := "text-sm text-gray-500 line-through")
            case None => emptyNode
          }
        ),
        button(
          img(
            src := "/images/icon-cart.svg",
            role := "img",
            className := "px-3"
          ),
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

  final case class ProductDescription(
      mobileImg: String,
      desktopImg: String,
      category: String,
      title: String,
      description: String,
      price: String,
      oldPrice: Option[String]
  )
  val hardcodedProduct = ProductDescription(
    "/images/image-product-mobile.jpg",
    "/images/image-product-desktop.jpg",
    "Perfume",
    "Gabrielle Essence Eau De Parfum",
    "A floral, solar and voluptuous interpretation composed by Olivier Polge, Perfumer-Creator for the House of CHANEL.",
    "$169.99",
    Some("$199.99")
  )
}
