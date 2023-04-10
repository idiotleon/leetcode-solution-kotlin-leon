/**
 * @author: Leon
 *
 * References:
 *  Paid Course, 130min: https://www.acwing.com/video/15/
 */
package com.idiotleon.summary.byAlgorithm.dynamicProgramming.string.kmpAlgorithm

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class KMPAlgorithmPlain {
    fun kmpMatching(nums: CharArray, pattern: CharArray) {
        val nNums = nums.size
        val nPattern = pattern.size

        var lo = 0
        var hi = 2

        // to build up `nextChs`
        val nextChs = IntArray(nPattern) { 0 }
        while (hi < nPattern) {
            while (lo > 0 && pattern[hi] != pattern[lo + 1]) lo = nextChs[lo]
            if (pattern[hi] == pattern[lo + 1]) ++lo
            nextChs[hi] = lo

            ++hi
        }

        // to KMP match
        var idxN = 1
        var idxP = 0
        while (idxN <= nNums) {
            while (idxP > 0 && nums[idxN] != pattern[idxP + 1]) idxP = nextChs[idxP]
            if (nums[idxN] == pattern[idxP + 1]) ++idxP
            if (idxP == nPattern) { // to match successfully/completely
                println(idxN - nPattern)
                idxP = nextChs[idxP]
            }

            ++idxN
        }
    }
}