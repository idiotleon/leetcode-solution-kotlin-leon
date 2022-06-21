package com.an7one.leetcode.lvl2.lc0398

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.random.Random

/**
 * @author: Leon
 * https://leetcode.com/problems/random-pick-index/
 *
 * Time Complexity:     O()
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://youtu.be/mjKq89QAaJA?t=495
 *  https://leetcode.com/problems/random-pick-index/discuss/88072/Simple-Reservoir-Sampling-solution
 */
@Suppress(UNUSED)
class SolutionApproach0ReservoirSampling(private val nums: IntArray) {
    fun pick(target: Int): Int {
        var ans = -1
        var count = 0
        for ((idx, num) in nums.withIndex()) {
            // to skip/continue if `num` is not the `target`
            if (num != target)
                continue

            if (Random.nextInt(++count) == 0)
                ans = idx
        }

        return ans
    }
}