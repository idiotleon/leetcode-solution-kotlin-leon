package com.idiotleon.leetcode.lvl2.lc2367

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/number-of-arithmetic-triplets/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/number-of-arithmetic-triplets/solutions/2390637/check-n-diff-and-n-2-diff/comments/1530022
 * https://leetcode.com/problems/number-of-arithmetic-triplets/solutions/2390635/java-python-3-hashset-o-n-codes-w-analysis/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 */
@Suppress(UNUSED)
class Solution0HashSet {
    fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
        val nNums = nums.size

        val seen = HashSet<Int>(nNums)
        var count = 0

        for (num in nums) {
            if (seen.contains(num - diff) && seen.contains(num - diff * 2)) {
                ++count
            }

            seen.add(num)
        }

        return count
    }
}