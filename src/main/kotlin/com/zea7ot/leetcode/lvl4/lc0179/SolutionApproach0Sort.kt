/**
 * https://leetcode.com/problems/largest-number/
 *
 * Time Complexity:     O(`size` * len * lg(`size`)) + O(`size`)
 *  len, the average length of the string
 *
 * Space Complexity:    O(`size`)
 *
 * References:
 *  https://leetcode.com/problems/largest-number/discuss/53158/My-Java-Solution-to-share
 */
package com.zea7ot.leetcode.lvl4.lc0179

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Sort {
    fun largestNumber(nums: IntArray): String {
        // sanity check
        if (nums.isEmpty()) return ""

        val size = nums.size
        val strs = Array(size) { "" }
        for (i in 0 until size) {
            strs[i] = nums[i].toString()
        }

        strs.sortWith(Comparator { a, b -> (b + a).compareTo(a + b) })

        if (strs[0][0] == '0') return "0"

        val builder = StringBuilder()
        for (str in strs) {
            builder.append(str)
        }

        return builder.toString()
    }
}