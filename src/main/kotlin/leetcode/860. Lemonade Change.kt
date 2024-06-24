package src.main.kotlin.leetcode

fun lemonadeChange(bills: IntArray): Boolean {
    var five=0
    var ten=0
    for (i in bills){
        if (i==5){
            five++
        }else if(i==10){
            if (five>0){
                five--
                ten++
            }else{
                return false
            }
        }else{
            if (five>0 && ten>0){
                five--
                ten--
            }else if (five>=3){
                five-=3
            }else{
                return false
            }
        }
    }
    return true
}