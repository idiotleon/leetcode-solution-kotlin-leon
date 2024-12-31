package com.idiotleon.leetcode.lvl2.lc2824

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution1BrutalForce {
    fun countPairs(nums: List<Int>, target: Int): Int {
        val nNums = nums.size

        var count = 0

        for(lo in 0 until nNums - 1){
            for(hi in lo + 1 until nNums){
                if(nums[lo] + nums[hi] < target){
                    ++count
                }
            }
        }

        return count
    }
}