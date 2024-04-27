package src.main.kotlin.leetcode.contest

fun canMakeSquare(grid: Array<CharArray>): Boolean {

    for(i in 0..<grid.size-1){
        for(j in 0..<grid[i].size-1){
            var wc=0
            var bc=0
            if (grid[i][j]=='W'){
                wc++
            }else{
                bc++
            }

            if (grid[i][j+1]=='W'){
                wc++
            }else{
                bc++
            }

            if (grid[i+1][j]=='W'){
                wc++
            }else{
                bc++
            }

            if (grid[i+1][j+1]=='W'){
                wc++
            }else{
                bc++
            }
            if(wc>=3||bc>=3){
                return true
            }
        }
    }
    return false
}