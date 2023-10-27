package com.idiotleon.leetcode.lvl3.lc0735

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.collections.ArrayDeque

/**
 * @author: Leon
 * https://leetcode.com/problems/asteroid-collision/
 *
 * Time Complexity:     O(`nAsteroids`)
 * Space Complexity:    O(`nAsteroids`)
 */
@Suppress(UNUSED)
class SolutionApproach0Stack {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        // not used
        // val nAsteroids = asteroids.size

        val stack = ArrayDeque<Int>()

        for (asteroid in asteroids) {
            if (asteroid > 0 || stack.isEmpty() || stack.last() < 0) {
                stack.addLast(asteroid)
            } else {
                while (stack.isNotEmpty() && stack.last() > 0 && stack.last() < -asteroid) {
                    stack.removeLast()
                }

                if (stack.last() == -asteroid) {
                    stack.removeLast()
                } else if (stack.isEmpty() || stack.last() < 0) {
                    stack.addLast(asteroid)
                }
            }
        }

        return stack.reversed().toIntArray()
    }
}