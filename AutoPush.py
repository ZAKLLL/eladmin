import os
import time
import paramiko

print("开始推送")

a = os.popen('scp E:/github学习项目/eladmin\classes/artifacts/eladmin_system_jar/eladmin-system.jar root@120.76.62.44:/root/aigongjiao/eladmin_system_jar/')

print(a)


try:
    trans = paramiko.Transport(('120.76.62.44', 22))
    trans.connect(username='root', password='ZWZlove520')
    ssh = paramiko.SSHClient()
    ssh._transport = trans
    channel = ssh.invoke_shell()

    channel.send('cd /root/aigongjiao\n')
    time.sleep(1)
    channel.send('./restart.sh\n')
    time.sleep(4)
    output = channel.recv(4048).decode('utf-8')
    print(output)
    print('success')
    trans.close()
except paramiko.SSHException:
    print("fail")

print("done")
