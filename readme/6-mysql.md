## MySQL setup
### Docker
```bash
docker run --name mysql-tacocloud -d \
  -e MYSQL_ROOT_PASSWORD=rootpassword \
  -e MYSQL_DATABASE=tacocloud \
  -e MYSQL_USER=tacouser \
  -e MYSQL_PASSWORD=tacopassword \
  -p 3306:3306 \
  mysql:latest
```