/**
 * https://leetcode.com/problems/design-phone-directory/
 *
 * Time Complexities:
 *  initialization:     O()
 *  get():              O()
 *  check():            O()
 *  release():          O()
 *
 * Space Complexity:    O()
 *
 * References:
 *
 */
package com.zea7ot.leetcode.ood.lvl3.lc0379

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1Set(private val maxNumbers: Int) {
    private var assigned = 0
    private val recycle = HashSet<Int>()

    /** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */


    /** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
    fun get(): Int {
        if (recycle.isNotEmpty()) {
            return getFromRecycle()
        }

        if (assigned < maxNumbers) {
            return assigned++
        }

        return -1
    }

    /** Check if a number is available or not. */
    fun check(number: Int): Boolean {
        return isLegal(number) && !hasBeenAssigned(number)
    }

    /** Recycle or release a number. */
    fun release(number: Int) {
        if (isLegal(number) && hasBeenAssigned(number)) {
            recycle.add(number)
        }
    }

    private fun isLegal(phoneNumber: Int) = phoneNumber in 0 until maxNumbers

    private fun hasBeenAssigned(phoneNumber: Int) = phoneNumber < assigned && !recycle.contains(phoneNumber)

    private fun getFromRecycle(): Int {
        val iter = recycle.iterator()
        val num = iter.next()
        iter.remove()
        return num
    }
}