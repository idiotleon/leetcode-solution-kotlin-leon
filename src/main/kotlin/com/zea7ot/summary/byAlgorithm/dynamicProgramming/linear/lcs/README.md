动态规划

* 状态表示
    * 集合: 所有再第一个序列的前i个字母中出现，且在第二个序列的前j个字母中出现的子序列
    * 属性: 最大值(Max)

* 状态计算 f[i, j]
    * `00`: f[i - 1, j - 1]
    * `01`: f[i - 1, j] surely includes `01`, since it is about `Max`, f[i - 1, j] can represents `01`
    * `10`: f[i, j - 1] surely includes `10`, similarly above
    * `11`: 1 + f[i, j]