动态规划

* 状态表示
    * 集合: 所有将第i堆石子到第j堆石子合并成一堆石子的合并方式
    * 属性: 最小值(Min)

* 状态计算 f[i, j] = min(f[i, k] + f[k + 1, j] + (prefixSums[j] - prefixSums[i - 1])), k = i ~ (j - )
    Time Complexity:    O(n ^ 3)