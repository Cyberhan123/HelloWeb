package cn.hselfweb.http.server.base

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import java.lang.module.ModuleDescriptor.read


class HttpExchangeDispacher : HttpHandler {
    var httpResponse = HttpResponse()
    var httpRequest = HttpRequest()

    override fun handle(httpExchange: HttpExchange) {
//        val response = "hello world"
//        httpExchange.sendResponseHeaders(200, 0)
//        val os = httpExchange.getResponseBody()
//        os.write(response.toByteArray())
//        os.close()
        httpExchangeDispacher(httpExchange)

    }

    fun httpExchangeDispacher(httpExchange: HttpExchange) {
        val response = "hello world"
        httpExchange.sendResponseHeaders(200, 0)
        val os = httpExchange. responseBody
        os.write(response.toByteArray())
        os.close()
//        httpRequestHandle(httpExchange)
//        httpResponseHandle(httpExchange)
//        val response = "test"
//        httpExchange.sendResponseHeaders(200, 0)
//        httpExchange.responseBody.write(response.toByteArray())
//        httpExchange.responseBody.close()

    }

    private fun httpRequestHandle(httpExchange: HttpExchange) {
        httpRequest.headers = httpExchange.requestHeaders
        read(httpExchange.requestBody)
        httpRequest.requestBody = httpExchange.requestBody
        httpRequest.method = httpExchange.requestMethod
        httpRequest.uri = httpExchange.requestURI
        httpRequest.version = HttpResponse.Version.HTTP_1_1
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
