package cn.hselfweb.http.server.base


import com.sun.net.httpserver.Headers
import java.io.OutputStream
import java.net.URI
import java.util.*
import javax.net.ssl.SSLSession

class HttpResponse {
    lateinit var uri: URI
    lateinit var body: OutputStream
    lateinit var version: HttpResponse.Version
    var stateCode: Int = 0
    lateinit var httpHeaders: Headers
    lateinit var httpRequest: HttpRequest


    fun sslSession(): Optional<SSLSession> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    enum class Version {
        HTTP_1_1,
        HTTP_2;
    }


    fun previousResponse(): Optional<HttpResponse> {
        version = Version.HTTP_1_1
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}