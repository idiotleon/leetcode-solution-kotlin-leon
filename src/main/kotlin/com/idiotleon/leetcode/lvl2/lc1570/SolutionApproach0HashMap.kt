/**
 * @author: Leon
 * https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
 *
 * Time Complexity:     O(min(digitsV1, digitsV2))
 * Space Complexity:    O(digitsV1 + digitsV2)
 *
 * Reference:
 * https://leetcode.com/problems/dot-product-of-two-sparse-vectors/discuss/826713/Java-100-O(min(dm-dn))-solution/866242
 */
package com.idiotleon.leetcode.lvl2.lc1570

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SparseVector(nums: IntArray) {
    private val idxToVal = HashMap<Int, Int>()

    init {
        for ((idx, num) in nums.withIndex()) {
            if (num != 0)
                idxToVal[idx] = num
        }
    }

    // Return the dotProduct of two sparse vectors
    fun dotProduct(vec: SparseVector): Int {
        val idxToVal1 = this.valToIdx // one vector
        val idxToVal2 = vec.valToIdx // the other vector

        // to make sure vector1 is of smaller size,
        // later on to start with
        if (idxToVal1.size > valToIdx2.size)
            return vec.dotProduct(this)

        var product = 0
        for ((idx1, num1) in idxToVal1) {
            idxToVal2[idx1]?.let { num2 ->
                product += num1 * num2
            }
        }

        return product
    }
}