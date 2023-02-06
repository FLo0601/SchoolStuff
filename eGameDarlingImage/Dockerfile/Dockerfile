FROM mysql:latest

ENV MYSQL_secure_auth=false
ENV MYSQL_ROOT_PASSWORD=TestPW
ENV MYSQL_USER=testUser
ENV MYSQL_PASSWORD=TestPW
ENV MYSQL_Database=eGameDarling

COPY ./scripts/ /docker-entrypoint-initdb.d/