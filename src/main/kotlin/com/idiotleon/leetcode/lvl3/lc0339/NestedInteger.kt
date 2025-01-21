package com.idiotleon.leetcode.lvl3.lc0339

/**
 * a fake `NestedInteger` class
 */
data class NestedInteger(
    private val value: Int? = null,
    private val list: List<NestedInteger>? = null
) {
    fun isInteger(): Boolean = false

    fun getInteger(): Int? = value

    fun getList(): List<NestedInteger>? = list
}