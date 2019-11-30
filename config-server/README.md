gitlab



    docker run --detach \
      --hostname gitlab.example.com \
      --publish 443:443 --publish 8089:80 --publish 2289:22 \
      --name gitlab \
      --restart always \
      --volume /opt/docker/gitlab/config:/etc/gitlab \
      --volume /opt/docker/gitlab/logs:/var/log/gitlab \
      --volume /opt/docker/gitlab/data:/var/opt/gitlab \
      gitlab/gitlab-ce
      
      
      账号root
      第一次要求修改密码不少于8位    
      
      http://192.168.1.110:8089/
      
      
      ssh-keygen -t rsa -C “邮箱名”
      C:\Users\Administrator\.ssh
      用文本编辑器打开文件id_rsa.pub,复制内容,添加到GitHub的ssh keys中
      
      
      http://192.168.1.110:8089/root/config.git
      
    





rabbitmq

    docker run -d --hostname my-rabbit --name rabbitmq -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin -p 15672:15672 -p 5672:5672 rabbitmq:3.7.7-management
    
    
    http://192.168.1.110:15672/
    
    docker inspect rabbitmq


