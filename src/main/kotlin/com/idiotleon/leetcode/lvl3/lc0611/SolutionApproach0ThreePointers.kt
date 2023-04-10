/**
 * https://leetcode.com/problems/valid-triangle-number/
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/valid-triangle-number/discuss/104174/Java-O(n2)-Time-O(1)-Space
 *  https://leetcode.com/problems/valid-triangle-number/discuss/128135/A-similar-O(n2)-solution-to-3-Sum
 *  https://leetcode.com/problems/valid-triangle-number/discuss/321367/java-binary-search(log(n)-*-n2
 */
package com.idiotleon.leetcode.lvl3.lc0611

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ThreePointers {
    fun triangleNumber(nums: IntArray): Int {
        val nNums = nums.size
        nums.sort()

        var count = 0
        for (idx in 2 until nNums) {
            var lo = 0
            var hi = idx - 1
            while (lo < hi) {
                if (nums[lo] + nums[hi] > nums[idx]) {
                    count += hi - lo
                    --hi
                } else
                    ++lo
            }
        }

        return count
    }
}