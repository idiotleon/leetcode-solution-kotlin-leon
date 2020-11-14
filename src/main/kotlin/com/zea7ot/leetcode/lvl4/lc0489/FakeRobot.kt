package com.zea7ot.leetcode.lvl4.lc0489

class FakeRobot {
    // This is the Robot's API interface.
    // You should not implement it, or speculate about its implementation
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    fun move(): Boolean = true

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    fun turnLeft() {}
    fun turnRight() {}

    // Clean the current cell.
    fun clean() {}
}