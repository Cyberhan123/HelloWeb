package cn.hselfweb.http.server.base

import java.lang.Exception
import java.util.*
import java.util.logging.XMLFormatter
import kotlin.math.log

class test {
    var head = ListLink()
    var size: Int = 0

    class ListLink {
        var elem: Int = 0
        lateinit var next: ListLink
    }

    fun traversal(pos: Int): ListLink {
        TODO("")
    }

    fun checkBoundsExclusive(pos: Int) {
        TODO("make empty")
    }

    fun add(pos: Int, elem: ListLink) {
        head.next

    }

    fun get(pos: Int) {
        TODO("")
    }

    fun remove(pos: Int): ListLink {
        val pre = traversal(pos)
        size--
        val elem = pre.next
        pre.next = pre.next.next

        return (elem)
    }

}

class test1 {
    fun getindex(pos: Int, arr: LinkedList<Int>): Int {
        if (pos < arr.size)
            return arr[arr.size - pos]
        else{
            throw Exception("erro")
        }
    }
}

fun main() {
var number= arrayOf(1,2,3,4,5,6)
    val test = number.asList()
}