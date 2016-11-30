package com.homerchik.helpers

import java.net.URL

import scalaj.http.Http

/**
  * Created by homerchik on 30.11.16.
  */
object HttpRequester {
  def get[T](url: URL): String = {
    Http("https://www.tinkoff.ru/api/v1/currency_rates/").asString.body
  }

}
