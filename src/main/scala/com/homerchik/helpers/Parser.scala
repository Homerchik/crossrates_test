package com.homerchik.helpers

import org.json4s._
import org.json4s.jackson.JsonMethods._


/**
  * Created by homerchik on 30.11.16.
  */
object Parser {
  implicit val format = DefaultFormats

  def parseResponse(response: String): Response = parse(response).extract[Response]
}

case class Response(resultCode: String, payload: Payload)

case class Payload(rates: List[Rate])

case class Rate(category: String, fromCurrency: Currency, toCurrency: Currency, buy: Double)

case class Currency(code: Int, name: String)
