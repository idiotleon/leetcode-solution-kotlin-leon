package com.idiotleon.leetcode.lvl3.lc1538


// This is ArrayReader's API interface.
// You should not implement it, or speculate about its implementation
class FakeArrayReader {
    // Compares 4 different elements in the array
    // return 4 if the values of the 4 elements are the same (0 or 1).
    // return 2 if three elements have a value equal to 0 and one element has value equal to 1 or vice versa.
    // return 0 : if two element have a value equal to 0 and two elements have a value equal to 1.

    fun query(a: Int, b: Int, c: Int, d: Int): Int = 1

    // Returns the length of the array

    fun length(): Int = 1
}