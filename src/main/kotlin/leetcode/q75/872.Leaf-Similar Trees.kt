package src.main.kotlin.leetcode.q75


fun main(){

}

fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    var list=mutableListOf<Int>()
    list=inOrder(root1,list)
    var list2=mutableListOf<Int>()
    list2=inOrder(root2,list2)
    println(list)
    println(list2)
    if(list==list2){
        return true
    }else{
        return false
    }
}
fun inOrder(root:TreeNode?,list:MutableList<Int>):MutableList<Int>{
    if(root?.left!=null){
        inOrder(root.left,list)
    }
    if(root?.left==null&&root?.right==null){
        root?.let{list.add(it.`val`)}
    }

    if(root?.right!=null){
        inOrder(root.right,list)
    }
    return list
}