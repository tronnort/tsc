xx-example  的模块是未实现微服务的，属于功能测试

docker 
执行可运行的jar文件
       将springboot-1.jar放在虚拟机的/usr目录下，然后执行命令启动jar

docker run -d -p 9090:9090 -v /usr/springboot-1.jar:/usr/springboot-1.jar --name springboot java:8u111 java -jar /usr/springboot-1.jar
 

 

     -d 表示在后台启动

     -p 9090:9090 表示将容器的端口 映射成宿主主机的端口，否则9090端口访问不到

     -v /usr/springboot-1.jar:/usr/springboot-1.jar 表示将宿主主机的jar文件，映射到容器中（分号前为宿主主机的路径，分号后为容器中的路径）

     --name springboot 表示为该容器取一个全局唯一的名称，这里我取的名称为springboot

    java:8u111 表示镜像文件的名称和tag

    java -jar /usr/springboot-1.jar 表示运行jar包，注意：这里的jar包为容器中的位置，是通过前面的-v属性映射的