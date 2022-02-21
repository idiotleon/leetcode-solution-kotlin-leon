package com.an7one.leetcode.lvl4.lc0179

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

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
 * https://leetcode.com/problems/largest-number/discuss/864106/Kotlin-Sorting-the-String-Array/1277846
 */
@Suppress(UNUSED)
class SolutionApproach0Sort0 {
    fun largestNumber(nums: IntArray): String {
        // not used
        // val nNums = nums.size

        val strs = nums.map{ it.toString() }.toMutableList().also {
            it.sortWith(Comparator { a, b -> (b + a).compareTo(a + b) })
        }.toList()

        return if(strs[0][0] == '0') "0" else strs.joinToString ("")
    }
}