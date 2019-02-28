package cn.hselfweb.http

import cn.hselfweb.http.server.base.HttpServer

class Worker {
    var fileUrl: String = "/appication"
    fun start() {
      HttpServer(fileUrl,8000).runServer()
    }
}

fun main() {
    Worker().start()
    //print("fuck")
}