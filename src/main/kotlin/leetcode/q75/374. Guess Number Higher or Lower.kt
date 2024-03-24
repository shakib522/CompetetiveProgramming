package src.main.kotlin.leetcode.q75

abstract class GuessGame{
    abstract fun guessNumber(n:Int):Int
    fun guess(num:Int):Int{
        return if (num<1702766719){
            1
        }else if(num>1702766719){
            -1
        }else{
            0
        }
    }
}

fun main(){
    val s=Solution()
    println(s.guessNumber(2126753390))
}

class Solution:GuessGame() {
    override fun guessNumber(n:Int):Int {
        var start=1
        var end=n
        while (start<=end){
            val mid=((end.toLong()+start.toLong())/2).toInt()
            val res=guess(mid)
            if(res==-1){
                end=mid-1
            }else if(res==1){
                start=mid+1
            }else if(res==0){
                return mid
            }
        }
        return -1
    }
}