/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 *
 * Time Complexity:     O(31 * `nNums`) ~ O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91049/Java-O(n)-solution-using-bit-manipulation-and-HashMap/95535
 *  https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91049/Java-O(n)-solution-using-bit-manipulation-and-HashMap
 */
package com.zea7ot.leetcode.lvl4.lc0421

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun findMaximumXOR(nums: IntArray): Int {
        // not used
        // val nNums = nums.size

        var max = 0
        var bitMask = 0

        for (idx in 31 downTo 0) {
            bitMask = bitMask or (1 shl idx)
            val prefixSet = HashSet<Int>()
            for (num in nums) {
                prefixSet.add(num and bitMask)
            }

            val greedyAttempt = max or (1 shl idx)
            for (prefix in prefixSet) {
                val theOtherNum = prefix xor greedyAttempt
                if (prefixSet.contains(theOtherNum)) {
                    max = greedyAttempt
                    break
                }
            }
        }

        return max
    }
}