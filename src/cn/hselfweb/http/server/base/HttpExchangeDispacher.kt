package cn.hselfweb.http.server.base

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler

class HttpExchangeDispacher : HttpHandler {
    lateinit var httpResponse: HttpResponse
    lateinit var httpRequest: HttpRequest

    override fun handle(httpExchange: HttpExchange) {
        httpExchangeDispacher(httpExchange)
    }

    fun httpExchangeDispacher(httpExchange: HttpExchange) {
        httpRequestHandle(httpExchange)
        httpResponseHandle(httpExchange)
    }

    private fun httpRequestHandle(httpExchange: HttpExchange) {
        httpRequest.headers = httpExchange.requestHeaders
        httpRequest.requestBody = httpExchange.requestBody
        httpRequest.method = httpExchange.requestMethod
        httpRequest.uri = httpExchange.requestURI
        httpRequest.version=HttpResponse.Version.HTTP_1_1
    }

    private fun httpResponseHandle(httpExchange: HttpExchange) {
        httpResponse.body = httpExchange.responseBody
        httpResponse.stateCode = httpExchange.responseCode
        httpResponse.httpHeaders = httpExchange.responseHeaders
        httpResponse.httpRequest = httpRequest
        httpResponse.uri = httpRequest.uri
        httpResponse.version = HttpResponse.Version.HTTP_1_1
    }

}