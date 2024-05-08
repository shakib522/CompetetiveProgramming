package src.main.kotlin.leetcode.dailyChallenge


fun findRelativeRanks(score: IntArray): Array<String> {
    val sortedScore = score.sortedArrayDescending()
    val map = mutableMapOf<Int, String>()
    for (i in sortedScore.indices) {
        when (i) {
            0 -> map[sortedScore[i]] = "Gold Medal"
            1 -> map[sortedScore[i]] = "Silver Medal"
            2 -> map[sortedScore[i]] = "Bronze Medal"
            else -> map[sortedScore[i]] = (i + 1).toString()
        }
    }
    return score.map {
        map[it]!!
    }.toTypedArray()
}