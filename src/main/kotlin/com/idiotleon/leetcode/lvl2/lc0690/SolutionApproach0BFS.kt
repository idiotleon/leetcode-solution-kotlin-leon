package com.idiotleon.leetcode.lvl2.lc0690

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/employee-importance/
 *
 * Time Complexity:     O(V + E)
 * Space Complexity:    O(V + E)
 *
 * Reference:
 * https://leetcode.com/problems/employee-importance/discuss/112587/Java-HashMap-bfs-dfs
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun getImportance(employees: List<Employee>, id: Int): Int {
        val idToEmployee = HashMap<Int, Employee>()
        for (employee in employees) {
            val (idEmployee, _, _) = employee
            idToEmployee[idEmployee] = employee
        }

        val employeeRoot = idToEmployee[id]!!

        val queue = ArrayDeque<Employee>().also {
            it.addFirst(employeeRoot)
        }

        var totalValue = 0

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val (_, importance, idsSub) = queue.removeLast()

                totalValue += importance

                for (idSub in idsSub) {
                    queue.addFirst(idToEmployee[idSub]!!)
                }
            }
        }

        return totalValue
    }
}