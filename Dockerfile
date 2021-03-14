# Crear imagen:
# docker build -t mysql-classicmodels:1 .
#
# Crear un contenedor nombrado classicmodels-db:
# docker run -d -p 3300:3306 --name classicmodels-db -e MYSQL_ROOT_PASSWORD=root mysql-classicmodels:1
#
# Acceder al contenedor:
# docker exec -it classicmodels-db bash
#
# Arrancar el contenedor:
# docker start classicmodels-db
#
# Parar el contenedor:
# docker stop classicmodels-db

FROM mysql:5.7.31
ENV MYSQL_DATABASE classicmodels
ENV MYSQL_ROOT_PASSWORD root
COPY ./src/main/resources/mysqlsampledatabase.sql /docker-entrypoint-initdb.d
