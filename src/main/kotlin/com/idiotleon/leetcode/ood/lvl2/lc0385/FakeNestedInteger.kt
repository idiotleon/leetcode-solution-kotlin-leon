package com.idiotleon.leetcode.ood.lvl2.lc0385

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class FakeNestedInteger {
    // Constructor initializes an empty nested list.
    constructor()

    // Constructor initializes a single integer.
    constructor(value: Int)

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean = true

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int? = 1

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit {}

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: FakeNestedInteger): Unit {}

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<FakeNestedInteger>? = ArrayList()
}
