package com.zea7ot.leetcode.lvl1.lc0830

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun largeGroupPositions(s: String): List<List<Int>> {
        val positions = arrayListOf<ArrayList<Int>>()
        // sanity check
        if (s.isEmpty()) return positions

        val lenS = s.length

        var prevChar = '#'
        var len = 1
        var idxStart = -1
        var idxEnd: Int = -1

        for (i in 0 until lenS) {
            if (s[i] == prevChar) {
                ++len

            } else {
                idxEnd = i - 1
                if (len >= 3) {
                    positions.add(arrayListOf(idxStart, idxEnd))
                }
                len = 1
                idxStart = i
                prevChar = s[i]
            }
        }

        if (len >= 3) {
            positions.add(arrayListOf(idxStart, lenS - 1))
        }

        return positions
    }
}