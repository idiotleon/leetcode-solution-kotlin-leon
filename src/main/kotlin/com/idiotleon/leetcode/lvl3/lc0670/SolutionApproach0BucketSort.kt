/**
 * https://leetcode.com/problems/maximum-swap/
 *
 * Time Complexity:     O(`lenD`)
 * Space Complexity:    O(`lenD`)
 *
 * Reference:
 *  https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time
 */
package com.idiotleon.leetcode.lvl3.lc0670

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BucketSort {
    fun maximumSwap(num: Int): Int {
        val digits = num.toString().toCharArray()

        // not used
        // val lenD = digits.size

        val buckets = IntArray(10) { 0 }
        for ((idx, ch) in digits.withIndex()) {
            val digit = ch - '0'
            buckets[digit] = idx
        }

        var largestDigit = 9
        for ((idx, ch) in digits.withIndex()) {
            val digit = ch - '0'
            for (k in largestDigit downTo digit + 1) {
                if (buckets[k] > idx) {
                    swap(idx, buckets[k], digits)
                    return String(digits).toInt()
                }
            }

            largestDigit = digit
        }

        return num
    }

    private fun swap(i: Int, j: Int, chs: CharArray) {
        val temp = chs[i]
        chs[i] = chs[j]
        chs[j] = temp
    }
}