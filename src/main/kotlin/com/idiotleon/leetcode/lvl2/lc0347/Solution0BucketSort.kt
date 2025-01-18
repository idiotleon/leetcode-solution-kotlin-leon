package com.idiotleon.leetcode.lvl2.lc0347

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/***
 * @author: Leon
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/top-k-frequent-elements/solutions/5149351/bucket-sort-by-kashar01-a5ml/
 */
@Suppress(UNUSED)
class Solution0BucketSort {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val nNums = nums.size

        val numToFreq = HashMap<Int, Int>(nNums).also {
            for (num in nums) {
                it[num] = 1 + (it[num] ?: 0)
            }
        }

        val buckets = List(nNums + 1) { mutableListOf<Int>() }.also {
            for ((num, freq) in numToFreq) {
                it[freq].add(num)
            }
        }

        val ans = IntArray(k) { 0 }
        var resIdx = 0
        for (idx in (nNums + 1 - 1) downTo 0) {
            if (resIdx == k) {
                break
            }
            val bucket = buckets[idx]
            for (num in bucket) {
                if (resIdx == k) {
                    break
                }

                ans[resIdx++] = num
            }
        }

        return ans
    }
}