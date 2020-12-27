## Week 32 Solution (LeetCode)

👀 https://leetcode.com/problems/customers-who-never-order/
####

```SQL
# Write your MySQL query statement below
SELECT Customers.Name "Customers"
FROM Customers LEFT OUTER JOIN Orders
ON Customers.Id = Orders.CustomerId
WHERE Orders.CustomerId IS NULL
```

####

👀 https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
####
[solution](https://github.com/BBBOMi/Algorithms-New/blob/master/week32/Leet1689.kt)
####

👀 https://leetcode.com/problems/stone-game/
####
[solution](https://github.com/BBBOMi/Algorithms-New/blob/master/week32/Leet877.kt)
####

