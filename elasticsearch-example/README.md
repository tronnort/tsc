#####docker安装elasticsearch
```text
docker network create tronnetwork

docker pull docker.elastic.co/elasticsearch/elasticsearch:6.7.2

sudo docker run -d --name elasticsearch --net tronnetwork -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:6.7.2
```