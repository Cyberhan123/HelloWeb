package cn.hselfweb.http.server.base

import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

class HttpServer() {
    lateinit var httpExchangeDispacher: HttpExchangeDispacher
    lateinit var httpSimpleServer: HttpServer
    lateinit var httpRespone: HttpResponse
    lateinit var httpResquest: HttpRequest

    //对之后的客户端实现进行提前兼容
    constructor(httpServerImpl: HttpServer, fileUrl: String) : this() {
        this.httpSimpleServer = httpServerImpl
        createInstance(fileUrl)
    }

    //如果不实现客户端就将原声实现封装进来
    constructor(path: String,port:Int) : this() {
        httpSimpleServer = HttpServer.create(InetSocketAddress(port), 0)
        createInstance(path)
    }

    fun createInstance(path: String) {
        httpExchangeDispacher = HttpExchangeDispacher()
        httpRespone = httpExchangeDispacher.httpResponse
        httpResquest = httpExchangeDispacher.httpRequest
        httpSimpleServer.createContext(path, httpExchangeDispacher)
        //需要处理异步 和多线程
        httpSimpleServer.executor = null
    }


    fun runServer() {
        httpSimpleServer.start()
    }
}