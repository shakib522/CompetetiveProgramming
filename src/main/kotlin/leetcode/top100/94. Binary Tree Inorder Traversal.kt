package src.main.kotlin.leetcode.top100

import java.util.Stack

class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null }
class Solutions {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list=mutableListOf<Int>()
        inOrder(root,list)
        return list.toList()
    }
    fun inOrder(root:TreeNode?,list:MutableList<Int>){
        val stack=Stack<Int>()
        root?.let { stack.push(it.`val`) }
        while (!stack.isEmpty()){

        }
        if(root?.left!=null){
            inOrder(root.left,list)
        }
        root?.let{
            list.add(it.`val`)
        }
        //list.add(root?.`val`)
        if(root?.right!=null){
            inOrder(root.right,list)
        }
    }
    fun inorderTraversalIterative(root: TreeNode?): List<Int> {
        val stack=Stack<TreeNode?>()
        val list=mutableListOf<Int>()
        var curNode=root
        stack.push(root)
        //root?.let{ list.add(it.`val`)}
        while(stack.isNotEmpty()){
            var k:TreeNode? = null
            if(curNode?.left!=null){
                curNode=curNode.left
                stack.push(curNode)
            }else{
                k=stack.pop()
                if(k!=null){
                    list.add(k.`val`)
                }
            }

            if(k?.right!=null){
                curNode=k.right
                stack.push(curNode)
            }

        }
        return list.toList()
    }
}