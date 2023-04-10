/**
 * https://leetcode.com/problems/longest-repeating-substring/
 *
 * Time Complexity:     O(`lenS` ^ 3)
 * Space Complexity:    O(`lenS`)
 *
 * this is not a typical problem that can be solved by KMP algorithm,
 *  which strictly excludes overlapped situations.
 *
 * References:
 *  https://leetcode.com/problems/longest-repeating-substring/discuss/619339/C%2B%2B-KMP-Solution.
 */
package com.idiotleon.leetcode.lvl4.lc1062

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1KMPAlgorithm {
    fun longestRepeatingSubstring(str: String): Int {
        var longest = 0
        for (idx in str.indices) {
            longest = maxOf(longest, kmp(idx, str))
        }

        return longest
    }

    private fun kmp(idxStart: Int, str: String): Int {
        val lenS = str.length
        var lo = idxStart

        val kmpTable = IntArray(lenS) { 0 }

        var longest = 0

        for (hi in 1 + idxStart until lenS) {
            while (lo > idxStart && str[lo] != str[hi]) lo = kmpTable[lo - 1] + idxStart
            if (str[lo] == str[hi]) kmpTable[hi] = (++lo) - idxStart

            longest = maxOf(longest, lo - idxStart)
        }

        return longest
    }

    // does not work
    // this problem is NOT a typical KMP problem
//    private fun kmp(idxStart: Int, str: String): Int{
//        val lenS = str.length
//
//        val kmpTable = IntArray(lenS){ 0 }
//
//        var longest = 0
//        var lo = idxStart
//        var hi = idxStart + 1
//
//        while(hi < lenS){
//            when{
//                str[lo] == str[hi] -> kmpTable[hi] = (++lo) - idxStart
//                lo == 0 -> ++hi
//                else -> lo = kmpTable[lo - 1] + idxStart
//            }
//
//            longest = maxOf(longest, lo - idxStart)
//        }
//
//        return longest
//    }
}