package src.main.kotlin.leetcode.top100

fun main() {
    val board= arrayOf(charArrayOf('A','B','C','E'),charArrayOf('S','F','C','S'),charArrayOf('A','D','E','E'))
    println(exist(board,"ABCCED"))
}

fun exist(board: Array<CharArray>, word: String): Boolean {
    val n=board.size
    val m=board[0].size
    for (i in 0..<n){
        for(j in 0 ..< m){
            if (board[i][j]==word[0]){
                if(search(i,j,n,m,word,board,0)){
                    return true
                }
            }
        }
    }
    return false
}

fun search(i:Int,j:Int,n:Int,m:Int,word:String,board:Array<CharArray>,k:Int):Boolean{
    if (k==word.length){
        return true
    }
    if(i<0 || j <0 || i==n || j==m || board[i][j]!=word[k]){
        return false
    }
    val ch=board[i][j]
    board[i][j]='#'
    val op1= search(i+1,j,n,m,word,board,k+1)
    val op2= search(i,j+1,n,m,word,board,k+1)
    val op3= search(i-1,j,n,m,word,board,k+1)
    val op4= search(i,j-1,n,m,word,board,k+1)
    board[i][j]=ch
    return op1 || op2 || op3 || op4
}