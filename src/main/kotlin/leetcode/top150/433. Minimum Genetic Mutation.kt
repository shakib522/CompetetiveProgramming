package src.main.kotlin.leetcode.top150

import java.util.LinkedList
import java.util.Queue


fun main() {
    val hashSet = hashSetOf(1, 6, 3, 8)
    println(hashSet)
}


fun minMutation(
    startGene: String, endGene: String, ban: Array<String>
): Int {
    val bank = ArrayList<String>()
    bank.add(startGene)
    for (b in ban) {
        bank.add(b)
    }
    val hs = HashSet<String>() //does not contain order
    hs.add(startGene)
    val map = HashMap<String, ArrayList<String>>()
    //create graph using map like adjacency list
    for (s in bank) {
        for (str in bank) {
            if (difference(s, str) == 1) {
                val lis = map.getOrDefault(s, ArrayList())
                lis.add(str)
                map[s] = lis
            }
        }
    }
    var q: Queue<String> = LinkedList()
    q.add(startGene)
    var mutation = 0
    while (q.isNotEmpty()) {
        val t: Queue<String> = LinkedList()
        while (q.isNotEmpty()) {
            val s = q.poll()
            val lis = map.getOrDefault(s, ArrayList())
            for (str in lis) {
                if (!hs.contains(str)) {
                    t.add(str)
                    hs.add(str)
                    if (str == endGene) {
                        return mutation + 1
                    }
                }
            }
        }
        mutation++
        q = t
    }
    return -1
}

fun difference(s: String, str: String): Int {
    val a = s.toCharArray()
    val b = str.toCharArray()
    var diff = 0
    for (i in 0..<8) {
        if (a[i] != b[i]) {
            diff++
        }
    }
    return diff
}