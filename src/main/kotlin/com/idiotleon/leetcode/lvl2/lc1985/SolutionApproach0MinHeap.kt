/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(`k`)
 */
package com.idiotleon.leetcode.lvl2.lc1985

import com.idiotleon.leetcode.util.Constant
import java.util.*

@Suppress(Constant.Annotation.UNUSED)
class SolutionApproach0MinHeap {
    fun kthLargestNumber(nums: Array<String>, k: Int): String {
        // not used
        // val nNums = nums.size
        val minHeap = PriorityQueue<String>{a, b -> if(a.length == b.length) a.compareTo(b) else a.length.compareTo(b.length)}
        for (num in nums){
            minHeap.offer(num)
            if(minHeap.size > k)
                minHeap.poll()
        }
        return minHeap.peek()
    }
}