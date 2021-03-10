### 数位动态规划1

* 状态表示
    * 集合:
    * 属性:

* 状态计算 <br/>
  f[i][j] = f[i - 1][j] + f[i - 1][j - i * 1] + f[i - 1][j - i * 2] + ... + f[i - 1][j - i * s] <br/>
  f[i][j - 1] = f[i - 1][j - i * 1] + f[i - 1][j - i * 2] + ... + f[i - 1][j - i * s] <br/>
  ... <br/><br/>
  => f[i][j] = f[i - 1][j] + f[i][j - i] <br/>
  with space compression, similar to Knapsack - Complete Pack => f[j] = f[j] + f[j - 1]

References: <br/>
Paid Course, 55min: https://www.acwing.com/video/36/

### 数位动态规划2

* 状态表示
    * 集合: 所有总和是i，并且恰好表示成j个数的和的方案
    * 属性: 数量

* 状态计算 <br/>
    * 方案中最小值是1: f[i - 1, j - 1]
    * 方案中最小值大于1: f[i - j, j]

  f[i, j] = f[i - 1, j - 1] + f[i - j, j]
  => ans = f[n, 1] + f[n, 2] + ... + f[n, n]

Reference: <br/>
Paid Course, 67min: https://www.acwing.com/video/36/