package cn.hselfweb.http.server.base

import com.sun.net.httpserver.Headers
import java.io.InputStream
import java.net.URI

class HttpRequest {
    lateinit var uri: URI
    lateinit var version: HttpResponse.Version
    lateinit var method: String
    lateinit var requestBody: InputStream
    lateinit var headers: Headers
}