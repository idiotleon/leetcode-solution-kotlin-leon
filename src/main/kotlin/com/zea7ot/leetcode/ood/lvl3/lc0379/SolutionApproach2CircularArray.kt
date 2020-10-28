/**
 * https://leetcode.com/problems/design-phone-directory/
 *
 * Time Complexities:
 *  initialization:     O(`maxNumbers`)
 *  get():              O(1)
 *  check():            O(1)
 *  release():          O(1)
 *
 *  Space Complexity:   O(`maxNumbers`)
 *
 * References:
 *  https://leetcode.com/problems/design-phone-directory/discuss/122908/Java-O(1)-time-o(n)-space-single-Array-99ms-beats-100
 */
package com.zea7ot.leetcode.ood.lvl3.lc0379

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach2CircularArray(private val maxNumbers: Int) {
    private companion object {
        private const val USED = -1
    }

    private val numPool = IntArray(maxNumbers) { idx -> (idx + 1) % maxNumbers }
    private var idx = 0

    /** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */


    /** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
    fun get(): Int {
        if (numPool[idx] == USED) return -1
        val res = idx
        idx = numPool[idx]
        numPool[res] = USED
        return res
    }

    /** Check if a number is available or not. */
    fun check(number: Int): Boolean {
        return numPool[number] != USED
    }

    /** Recycle or release a number. */
    fun release(number: Int) {
        if (numPool[number] != USED) return
        numPool[number] = idx
        idx = number
    }
}