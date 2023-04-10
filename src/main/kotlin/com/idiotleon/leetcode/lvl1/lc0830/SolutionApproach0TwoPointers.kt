package com.idiotleon.leetcode.lvl1.lc0830

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun largeGroupPositions(s: String): List<List<Int>> {
        val positions = arrayListOf<ArrayList<Int>>()
        // sanity check
        if (s.isEmpty())
            return positions

        val lenS = s.length

        var lo = 0
        var hi = 0

        while (hi < lenS) {
            while (hi < lenS && s[hi] == s[lo]) {
                ++hi
            }

            if (hi - lo >= 3)
                positions.add(arrayListOf(lo, hi - 1))

            lo = hi
            ++hi
        }

        return positions
    }
}