package com.an7one.leetcode.lvl2.lc0690

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

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
class SolutionApproach0DFSRecursive {
    fun getImportance(employees: List<Employee>, id: Int): Int {
        val idToEmployee = HashMap<Int, Employee>()
        for (employee in employees) {
            val (idEmployee, _, _) = employee
            idToEmployee[idEmployee] = employee
        }

        return dfs(id, idToEmployee)
    }

    private fun dfs(id: Int, idToEmployee: HashMap<Int, Employee>): Int {
        val (_, importance, subordinates) = idToEmployee[id]!!

        var totalValue = importance
        for (sub in subordinates) {
            totalValue += dfs(sub, idToEmployee)
        }

        return totalValue
    }
}