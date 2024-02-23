package leetcode


fun main() {
    val myCircularQueue = MyCircularQueue(3)
    println(myCircularQueue.enQueue(1)) // return True
    println(myCircularQueue.enQueue(2))// return True
    println(myCircularQueue.enQueue(3)) // return True
    println(myCircularQueue.enQueue(4))// return False
    println(myCircularQueue.Rear())// return 3
    println(myCircularQueue.isFull()) // return True
    println(myCircularQueue.deQueue())// return True
    println(myCircularQueue.enQueue(4))// return True
    println(myCircularQueue.Rear())

}

class MyCircularQueue(k: Int) {
    val que = IntArray(k + 1)
    val siz = k + 1
    var front: Int
    var rear: Int

    init {
        front = 0
        rear = 0
    }

    fun enQueue(value: Int): Boolean {
        if (isFull()) {
            return false
        }
        que[rear] = value
        rear = ((rear + 1) % (siz))
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) {
            return false
        }
        front = (front + 1) % (siz)
        return true
    }

    fun Front(): Int {
        if (isEmpty()) {
            return -1
        }
        return que[front]
    }

    fun Rear(): Int {
        if (isEmpty()) {
            return -1
        }
        if (rear==0){
            return que[siz-1]
        }else{
            return que[rear-1]
        }

    }

    fun isEmpty(): Boolean {
        return front == rear
    }

    fun isFull(): Boolean {
        return front == ((rear + 1) % (siz))
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */