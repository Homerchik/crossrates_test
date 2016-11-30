package com.homerchik.common

import java.net.URL

import com.typesafe.config.ConfigFactory


/**
  * Created by homerchik on 30.11.16.
  */
object Env {
 val config = ConfigFactory.load()
 val port = 80
 val proto = "https"

 def getHostname: String = config.getString("hostname")
 def getApiUrl(apiName : String): URL = apiName match {
   case "crossrates" => new URL(proto, getHostname, port, config.getString("api-v1.crossrates"))
 }

}
