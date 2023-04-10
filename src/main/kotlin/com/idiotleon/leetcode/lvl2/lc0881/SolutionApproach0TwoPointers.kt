/**
 * https://leetcode.com/problems/boats-to-save-people/
 *
 * Time Complexity:     O(`nPeople`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/boats-to-save-people/discuss/156740/C%2B%2BJavaPython-Two-Pointers
 */
package com.idiotleon.leetcode.lvl2.lc0881

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        val nPeople = people.size

        people.sort()
        var lo = 0
        var hi = nPeople - 1

        var count = 0

        while (lo <= hi) {
            ++count

            if (people[lo] + people[hi] <= limit) ++lo

            --hi
        }

        return count
    }
}