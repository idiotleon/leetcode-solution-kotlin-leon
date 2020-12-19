/**
 * @author: Leon
 * https://leetcode.com/problems/asteroid-collision/
 *
 * Time Complexity:     O(`totalAsteroids`)
 * Space Complexity:    O(`totalAsteroids`)
 */
package com.zea7ot.leetcode.lvl3.lc0735

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        // not used
        // val totalAsteroids = asteroids.size

        val stack = LinkedList<Int>()

        for (asteroid in asteroids) {
            if (asteroid > 0 || stack.isEmpty() || stack.peek() < 0) stack.push(asteroid)
            else {
                while (stack.isNotEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop()
                }

                if (stack.peek() == -asteroid) stack.pop()
                else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid)
                }
            }
        }

        return stack.reversed().toIntArray()
    }
}