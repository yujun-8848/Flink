## 回溯算法
result = []
def backrack(路径，选择列表)：
    if 满足结束条件：
        result.add(路径)
        return
    for 选择 in 选择列表：
        做选择
        backrack(路径，选择列表)
        撤销选择