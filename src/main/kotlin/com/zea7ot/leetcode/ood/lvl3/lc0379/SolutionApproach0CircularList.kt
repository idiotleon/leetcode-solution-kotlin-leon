/**
 * https://leetcode.com/problems/design-phone-directory/
 *
 * Time Complexities:
 *  initialization:     O(1)
 *  get():              O(1)
 *  check():            O(1)
 *  release():          O(1)
 *
 *  Space Complexity:   O(`maxNumbers`)
 *
 * References:
 *  https://leetcode.com/problems/design-phone-directory/discuss/350903
 */
package com.zea7ot.leetcode.ood.lvl3.lc0379

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0CircularList(private val maxNumbers: Int) {
    private companion object {
        private const val USED = -1
    }

    private val numsPool = LinkedList<Int>().also { it.add(1) }
    private var idx = 0

    /** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */


    /** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
    fun get(): Int {
        if (idx == numsPool.size) numsPool.add(idx + 1)
        if (numsPool.size > maxNumbers) {
            numsPool.removeLast()
            return -1
        }

        val res = idx
        idx = numsPool[idx]
        numsPool[res] = USED
        return res
    }

    /** Check if a number is available or not. */
    fun check(number: Int): Boolean {
        return number < maxNumbers && (number >= numsPool.size || numsPool[number] != USED)
    }

    /** Recycle or release a number. */
    fun release(number: Int) {
        if (number < numsPool.size && numsPool[number] == USED) {
            numsPool[number] = idx
            idx = number
        }
    }
}