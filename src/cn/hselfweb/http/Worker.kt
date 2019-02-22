package cn.hselfweb.http

import cn.hselfweb.http.server.base.HttpServer

class Worker {
    fun start() {
      HttpServer().runServer()
    }
}

fun main() {
    Worker().start()
    //print("fuck")
}