FROM mysql:5.7.31
ENV MYSQL_DATABASE classicmodels
COPY ./src/main/resources/ /docker-entrypoint-initdb.d/