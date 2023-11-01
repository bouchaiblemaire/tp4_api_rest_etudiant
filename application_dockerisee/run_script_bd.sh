#! /bin/bash

if [ ! $# -eq 1 ] 
then
  echo usage : run_script.sh nom_du_conteneur_postgresql
  echo nom_du_conteneur_postgresql : nom du conteneur hébergeant le serveur de base de données PostgreSQL
  exit 1
fi

docker exec $1  bash -c "curl -O -L https://einfo-learning.fr/partages/dev_avance/employee_bd.sql.tar.gz &&\
tar xvfz employee_bd.sql.tar.gz && PGPASSWORD=password psql \
  -h 127.0.0.1 \
  -p 5432 \
  -d devavance_db \
  -U devavance_user \
  -f employee_bd.sql&&rm employee_bd.sql.*"

exit 0

