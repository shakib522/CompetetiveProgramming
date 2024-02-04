package leetcode


class RecentCounter {
     val que = ArrayDeque<Int>()
    fun ping(t: Int): Int {
        que.addLast(t)
        val n = t-3000
        for (i in 0..<que.size) {
            if (que.first() < n) {
                que.removeFirst()
            } else {
                break
            }
        }
        return que.size
    }

}


fun main() {
    val recentCounter = RecentCounter()
    println(recentCounter.ping(1))
    println(recentCounter.ping(100))
    println(recentCounter.ping(3001))
    println(recentCounter.ping(3002))
}