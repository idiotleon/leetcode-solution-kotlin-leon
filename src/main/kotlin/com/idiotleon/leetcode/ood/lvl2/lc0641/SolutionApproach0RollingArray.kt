/**
 * https://leetcode.com/problems/design-circular-deque/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 *  https://leetcode.com/problems/design-circular-deque/discuss/155209/c%2B%2B-99-ring-buffer-no-edge-cases.-fb-interviewer-really-loves-it.-easy-to-impl-in-4mins.-cheers!
 */
package com.idiotleon.leetcode.ood.lvl2.lc0641

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0RollingArray(private val k: Int) {
    private val buffer = IntArray(k) { 0 }
    private var cnt = 0
    private var idxFront = k - 1
    private var idxRear = 0

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    fun insertFront(value: Int): Boolean {
        if (cnt == k)
            return false

        buffer[idxFront] = value
        idxFront = (idxFront - 1 + k) % k
        ++cnt

        return true
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    fun insertLast(value: Int): Boolean {
        if (cnt == k)
            return false

        buffer[idxRear] = value
        idxRear = (idxRear + 1) % k
        ++cnt

        return true
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    fun deleteFront(): Boolean {
        if (cnt == 0)
            return false

        idxFront = (idxFront + 1) % k
        --cnt

        return true
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    fun deleteLast(): Boolean {
        if (cnt == 0)
            return false

        idxRear = (idxRear - 1 + k) % k
        --cnt

        return true
    }

    /** Get the front item from the deque. */
    fun getFront(): Int {
        if (cnt == 0)
            return -1

        return buffer[(idxFront + 1) % k]
    }

    /** Get the last item from the deque. */
    fun getRear(): Int {
        if (cnt == 0)
            return -1

        return buffer[(idxRear - 1 + k) % k]
    }

    /** Checks whether the circular deque is empty or not. */
    fun isEmpty(): Boolean {
        return cnt == 0
    }

    /** Checks whether the circular deque is full or not. */
    fun isFull(): Boolean {
        return cnt == k
    }
}