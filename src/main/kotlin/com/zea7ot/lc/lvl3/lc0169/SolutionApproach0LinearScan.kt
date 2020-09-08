/**
 * https://leetcode.com/problems/majority-element/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * the description of the problem guarantees that there always will be a majority element
 *
 * References:
 *  https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
 */
package com.zea7ot.lc.lvl3.lc0169

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun majorityElement(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        val size = nums.size
        val freq = hashMapOf<Int, Int>()

        for (num in nums) {
            freq[num] = (freq[num] ?: 0) + 1
            if (freq[num] ?: -1 > size / 2) return num
        }

        return Int.MAX_VALUE
    }
}