package cn.hselfweb.http.server.base

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer

class HttpServer() {
    lateinit var httpExchangeDispacher: HttpExchangeDispacher
    lateinit var httpSampleServer: HttpServer
    lateinit var httpRespone: HttpResponse
    lateinit var httpResquest: HttpRequest

    //对之后的客户端实现进行提前兼容
    constructor(httpServerImpl: HttpServer, fileUrl: String) : this() {
        this.httpSampleServer = httpServerImpl
        createInstance(fileUrl)
    }

    //如果不实现客户端就将原声实现封装进来
    constructor(fileUrl: String) : this() {
        httpSampleServer = HttpServer.create()
        createInstance(fileUrl)
    }

    var fileUrl: String = "/appication"
    fun createInstance(fileUrl: String) {
        httpExchangeDispacher = HttpExchangeDispacher()
        httpRespone = httpExchangeDispacher.httpRespone
        httpResquest = httpExchangeDispacher.httpResquest
        httpSampleServer.createContext(fileUrl, httpExchangeDispacher)
        //需要处理异步 和多线程
        httpSampleServer.executor = null
    }


    fun runServer() {
        httpSampleServer.start()
    }
}