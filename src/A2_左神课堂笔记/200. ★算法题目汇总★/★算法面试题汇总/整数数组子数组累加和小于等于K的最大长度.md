# 整数数组子数组累加和小于等于K的最大长度

#数组累加和   
#可能性舍弃  

---
给定一个整数组成的无序数组arr，值可能正、可能负、可能0
给定一个整数值K
找到arr的所有子数组里，哪个子数组的累加和<=K，并且是长度最大的
返回其长度


复杂度: O (N)的解法

复杂度: O (N* logN)的解法
```text
建立累加和help数组的辅助help`数组, help`数组维持只升不降, 用二分法求解
```

Ref: [[整数数组子数组累加和小于等于K的最大长度-难点释疑]]

---
Plus:
[[整数数组子数组平均值小于等于V的最大长度]]

