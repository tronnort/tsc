```text
consul 安装配置

序号　	 节点ip	节点名称 	 角色
1	 10.0.xx.55	 server1	 server
2	 10.0.xx.203	 server2	 server
3	 10.0.xx.204	 server3	 server
4	 10.0.xx.205	 client1	 client & web ui

unzip consul_1.2.0_linux_amd64.zip
假设都解压到~/consul/bin目录下，解压后会得到1个名为consul的可执行文件
 
sudo cp ./consul /usr/local/bin
为了方便，可以将其复制到/usr/local/bin下（本步骤可选，需要root权限）

启动server端

基本的命令为：

consul agent -server -bind=10.0.xx.55 -client=0.0.0.0 -bootstrap-expect=3 -data-dir=/data/application/consul_data/ -node=server1
看着一大堆参数，其实不复杂

-server 表示是以服务端身份启动

-bind 表示绑定到哪个ip（有些服务器会绑定多块网卡，可以通过bind参数强制指定绑定的ip）

-client 指定客户端访问的ip(consul有丰富的api接口，这里的客户端指浏览器或调用方)，0.0.0.0表示不限客户端ip

-bootstrap-expect=3 表示server集群最低节点数为3，低于这个值将工作不正常(注：类似zookeeper一样，通常集群数为奇数，方便选举，consul采用的是raft算法)

-data-dir 表示指定数据的存放目录（该目录必须存在）

-node 表示节点在web ui中显示的名称

启动成功后，终端窗口不要关闭，可以在浏览器里，访问下，类似 http://10.0.xx.55:8500/，正常的话，应该会看到一行文字：Consul Agent。

为了防止终端关闭后，consul退出，可以在刚才命令上，加点东西，类似：
nohup xxx  > /dev/null 2>&1 & 

即:

nohup consul agent -server -bind=10.0.xx.55 -client=0.0.0.0 -bootstrap-expect=3 -data-dir=/data/application/consul_data/ -node=server1 > /dev/null 2>&1 &
将其转入后台运行。

另外2台节点上，也做类似操作：
nohup consul agent -server -bind=10.0.xx.203 -client=0.0.0.0 -bootstrap-expect=3 -data-dir=/data/application/consul_data/ -node=server2 > /dev/null 2>&1 &
nohup consul agent -server -bind=10.0.xx.204 -client=0.0.0.0 -bootstrap-expect=3 -data-dir=/data/application/consul_data/ -node=server3 > /dev/null 2>&1 &


启动client端

几乎完全一样，只是把-server 去掉，在10.0.xx.205上运行：

nohup consul agent -client=0.0.0.0 -data-dir=/data/application/consul_data/ -node=client1  -ui  > /dev/null 2>&1 &



要加自己加入集群，可以运行以下命令（假设：其它3个节点，都加入10.0.xx.55）

consul join 10.0.xx.55

consul members  查看集群节点

访问 http://10.0.xx.205:8500/ui
```