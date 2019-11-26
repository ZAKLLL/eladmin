import os
print("开始推送")

a = os.popen('scp E:/github学习项目/eladmin\classes/artifacts/eladmin_system_jar/eladmin-system.jar root@120.76.62.44:/root/aigongjiao/eladmin_system_jar/')

print(a)

print("done")
