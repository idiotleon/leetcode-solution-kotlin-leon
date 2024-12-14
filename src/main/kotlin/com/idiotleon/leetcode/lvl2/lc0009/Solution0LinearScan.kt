package com.idiotleon.leetcode.lvl2.lc0009

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/palindrome-number/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/palindrome-number/solutions/3651712/2-methods-c-java-python-beginner-friendl-4iqp/
 * https://leetcode.com/problems/palindrome-number/solutions/5127/9-line-accepted-java-code-without-the-need-of-handling-overflow/
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        val reversed = reverse(x)
        return reversed == x
    }

    private fun reverse(num: Int): Int {
        var num = num
        var res = 0
        while (num > 0) {
            val digit = num % 10
            res *= 10
            res += digit
            num /= 10
        }
        return res
    }
}