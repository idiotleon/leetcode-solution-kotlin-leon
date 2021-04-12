/**
 * https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
 *
 * Time Complexity:     O(min(digitsV1, digitsV2))
 * Space Complexity:    O(digitsV1 + digitsV2)
 *
 * Reference:
 *  https://leetcode.com/problems/dot-product-of-two-sparse-vectors/discuss/826713/Java-100-O(min(dm-dn))-solution/866242
 */
package com.an7one.leetcode.lvl2.lc1570

import com.an7one.leetcode.util.Constant

@Suppress(Constant.Annotation.UNUSED)
class SparseVector(nums: IntArray) {
    private val valToIdx = HashMap<Int, Int>()

    init {
        for ((idx, num) in nums.withIndex()) {
            if (num != 0)
                valToIdx[idx] = num
        }
    }

    // Return the dotProduct of two sparse vectors
    fun dotProduct(vec: SparseVector): Int {
        val valToIdx1 = valToIdx // one vector
        val valToIdx2 = vec.valToIdx // the other vector

        // to make sure vector1 is of smaller size,
        // later on to start with
        if (valToIdx1.size > valToIdx2.size)
            return vec.dotProduct(this);

        var product = 0;
        for ((idx1, num1) in valToIdx1) {
            valToIdx2[idx1]?.let { num2 ->
                product += num1 * num2
            }
        }

        return product;
    }
}