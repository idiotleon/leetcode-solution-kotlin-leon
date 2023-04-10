package com.idiotleon.leetcode.lvl4.lc0489

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/robot-room-cleaner/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/robot-room-cleaner/discuss/153530/DFS-Logical-Thinking/239683
 * https://leetcode.com/problems/robot-room-cleaner/discuss/153530/DFS-Logical-Thinking
 */
@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private companion object {
        private val DIRS = intArrayOf(0, -1, 0, 1, 0)
    }

    fun cleanRoom(robot: FakeRobot) {
        val seen = HashSet<String>()
        return backtrack(0, 0, 0, seen, robot)
    }

    private fun backtrack(
        row: Int, col: Int, dir: Int, seen: HashSet<String>, robot: FakeRobot
    ) {
        robot.clean()

        for (d in 0 until 4) {
            val newDir = (dir + d) % 4
            val nextRow = row + DIRS[newDir]
            val nextCol = col + DIRS[newDir + 1]

            if (seen.add(hash(nextRow, nextCol)) && robot.move()) {
                backtrack(nextRow, nextCol, newDir, seen, robot)

                // to move one step backward, while maintaining the same direction
                robot.turnRight()
                robot.turnRight()
                robot.move()
                robot.turnRight()
                robot.turnRight()
            }

            // to change the direction
            robot.turnRight()
        }
    }

    private fun hash(row: Int, col: Int) = "$row#$col"
}