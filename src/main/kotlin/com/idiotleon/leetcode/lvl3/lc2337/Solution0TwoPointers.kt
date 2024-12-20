package com.idiotleon.leetcode.lvl3.lc2337

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/move-pieces-to-obtain-a-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/move-pieces-to-obtain-a-string/solutions/2261392/java-python-3-2-methods-w-brief-explanation-and-analysis/?envType=company&envId=facebook&favoriteSlug=facebook-six-months&difficulty=MEDIUM
 */
@Suppress(UNUSED)
class Solution0TwoPointers {
    private companion object {
        private const val LEFT = 'L'
        private const val RIGHT = 'R'
    }

    fun canChange(start: String, target: String): Boolean {
        if (start.filterNot { it == '_' } != target.filterNot { it == '_' }) {
            return false
        }
        val lenS = start.length
        var idxS = 0
        var idxT = 0
        while (idxS < lenS && idxT < lenS) {
            while (idxS < lenS && start[idxS] == '_') {
                ++idxS
            }
            while (idxT < lenS && target[idxT] == '_') {
                ++idxT
            }
            if (idxS < lenS && idxT < lenS && (start[idxS] == LEFT && idxS < idxT || target[idxT] == RIGHT && idxS > idxT)) {
                return false
            }
            ++idxS
            ++idxT
        }

        return true
    }
}
