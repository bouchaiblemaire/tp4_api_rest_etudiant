#! /bin/bash
docker exec tp4_app_rest_dockerise-postgresl-1  bash -c "curl -O -L https://einfo-learning.fr/partages/dev_avance/employee_bd.sql.tar.gz &&\
tar xvfz employee_bd.sql.tar.gz && PGPASSWORD=password psql \
  -h 127.0.0.1 \
  -p 5432 \
  -d devavance_db \
  -U devavance_user \
  -f employee_bd.sql&&rm employee_bd.sql.*"