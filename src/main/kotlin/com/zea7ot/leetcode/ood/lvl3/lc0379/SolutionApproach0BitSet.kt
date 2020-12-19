/**
 * https://leetcode.com/problems/design-phone-directory/
 *
 * Time Complexities:
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/design-phone-directory/discuss/85335/Java-AC-solution-with-Bitset-and-efficient-get()-+-comments/120445
 */
package com.zea7ot.leetcode.ood.lvl3.lc0379

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BitSet(private val maxNumbers: Int) {
    private val bitSet = BitSet(maxNumbers)

    fun get(): Int {
        val num = bitSet.nextClearBit(0)
        if (num == maxNumbers) return -1
        bitSet.flip(num)
        return num
    }

    fun check(phoneNum: Int): Boolean = !bitSet.get(phoneNum)

    fun release(phoneNum: Int) = bitSet.clear(phoneNum)
}