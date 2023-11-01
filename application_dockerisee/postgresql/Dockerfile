FROM ubuntu:14.04
MAINTAINER Docker Education Team <education@docker.com>

ENV PG_VERSION 9.3
ENV PGDATA /etc/postgresql/$PG_VERSION/main
RUN locale-gen en_US.UTF-8
RUN apt-get update
RUN apt-get -y install postgresql postgresql-client postgresql-contrib

# RUN pg_dropcluster $PG_VERSION main && pg_createcluster --locale en_US.UTF-8 $PG_VERSION main

RUN echo "host    all             all             0.0.0.0/0 trust" >> /etc/postgresql/$PG_VERSION/main/pg_hba.conf
RUN echo "listen_addresses='*'" >> /etc/postgresql/$PG_VERSION/main/postgresql.conf

RUN service postgresql start && \
    su postgres sh -c "createuser -d -r -s devavance_user" && \
    su postgres sh -c "psql -c \"alter user devavance_user with encrypted password 'password';\"" && \
    su postgres sh -c "createdb -w -O devavance_user devavance_db" && \
    su postgres sh -c "psql -c \"GRANT ALL PRIVILEGES ON DATABASE devavance_db to devavance_user;\""

RUN apt install curl -y

EXPOSE 5432

# CMD ["su","postgres","-c","/usr/lib/postgresql/$PG_VERSION/bin/postgres"]
CMD ["su", "postgres", "-c", "/usr/lib/postgresql/$PG_VERSION/bin/postgres -D /var/lib/postgresql/$PG_VERSION/main/ -c config_file=/etc/postgresql/$PG_VERSION/main/postgresql.conf"]
