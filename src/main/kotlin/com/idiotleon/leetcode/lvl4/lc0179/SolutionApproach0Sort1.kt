package com.idiotleon.leetcode.lvl4.lc0179

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/largest-number/
 *
 * Time Complexity:     O(`nNums` * len * lg(`nNums`)) + O(`nNums` * len) ~ O(`nNums` * len * lg(`nNums`))
 *  len, the average length of the string
 *
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/largest-number/discuss/53158/My-Java-Solution-to-share
 */
@Suppress(UNUSED)
class SolutionApproach0Sort1 {
    fun largestNumber(nums: IntArray): String {
        // sanity check
        if (nums.isEmpty()) return ""

        val nNums = nums.size
        val strs = Array(nNums) { "" }
        for (i in 0 until nNums) {
            strs[i] = nums[i].toString()
        }

        strs.sortWith { a, b -> (b + a).compareTo(a + b) }

        if (strs[0][0] == '0') return "0"

        val builder = StringBuilder()
        for (str in strs) {
            builder.append(str)
        }

        return builder.toString()
    }
}