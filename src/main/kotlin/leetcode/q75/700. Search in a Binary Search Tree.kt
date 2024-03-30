package src.main.kotlin.leetcode.q75

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    var curNode=root
    while(curNode!=null){
        if(curNode.`val`<`val`){
            curNode=curNode.right
        }else if(curNode.`val`>`val`){
            curNode=curNode.left
        }else{
            return curNode
        }
    }
    return null
}