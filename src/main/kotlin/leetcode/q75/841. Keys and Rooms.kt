package src.main.kotlin.leetcode.q75




fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    return bfs(rooms)
}

fun bfs(rooms: List<List<Int>>):Boolean{
    val visited=Array(rooms.size){false}
    val queue=ArrayDeque<Int>()
    queue.addFirst(0)
    visited[0]=true
    while (queue.isNotEmpty()){
        val node=queue.removeFirst()
        for (i in rooms[node]){
            if (!visited[i]){
                queue.addLast(i)
                visited[i]=true
            }
        }
    }
    for (i in visited){
        if(!i){
            return false
        }
    }
    return true
}