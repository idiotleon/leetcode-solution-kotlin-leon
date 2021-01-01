/**
 * https://leetcode.com/problems/check-array-formation-through-concatenation/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nPieces`)
 *
 * References:
 *   https://leetcode.com/problems/check-array-formation-through-concatenation/discuss/918408/Python-5-lines-hashmap/768996
 *   https://leetcode.com/problems/check-array-formation-through-concatenation/discuss/918408/python-5-lines-hashmap/805476
 */
package com.zea7ot.leetcode.lvl2.lc1640

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun canFormArray(nums: IntArray, pieces: Array<IntArray>): Boolean {
        val nNums = nums.size

        val startToPiece = HashMap<Int, IntArray>()
        for (piece in pieces) {
            startToPiece[piece[0]] = piece
        }

        var idxN = 0

        while (idxN < nNums) {
            if (startToPiece[nums[idxN]] == null) return false

            val piece = startToPiece[nums[idxN]]!!
            val nPiece = piece.size

            var idxP = 0
            while (idxN < nNums && idxP < nPiece) {
                if (nums[idxN] != piece[idxP]) return false

                ++idxN
                ++idxP
            }
        }

        return true
    }
}