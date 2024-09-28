## 4.1 Cassandra setup
### Create network
Add network
```bash
docker network create cassandra-net
```

### Run docker image
```bash
docker run --name my-cassandra --network cassandra-net -p 9042:9042 -d cassandra:latest
```

### Use cqlsh to add keyspace
```bash
docker run -it --network cassandra-net --rm cassandra cqlsh my-cassandra
```
```
create keyspace tacocloud
... with replication={'class':'SimpleStrategy', 'replication_factor':1}
... and durable_writes=true;
```
