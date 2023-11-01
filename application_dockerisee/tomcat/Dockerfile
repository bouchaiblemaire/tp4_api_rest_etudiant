FROM centos

MAINTAINER BL

RUN mkdir /opt/tomcat/


WORKDIR /opt/tomcat
RUN curl -O https://einfo-learning.fr/partages/dev_avance/apache-tomcat-9.0.80.tar.gz
RUN tar xvfz apache*.tar.gz
RUN mv apache-tomcat-9.0.80/* /opt/tomcat/.
RUN rm apache-tomcat-9.0.80.tar.gz 
RUN sed -i 's/mirrorlist/#mirrorlist/g' /etc/yum.repos.d/CentOS-*
RUN sed -i 's|#baseurl=http://mirror.centos.org|baseurl=http://vault.centos.org|g' /etc/yum.repos.d/CentOS-*
RUN yum -y makecache
RUN yum -y  update


RUN yum -y install java
RUN java -version

WORKDIR /opt/tomcat/conf
RUN curl -O -L  https://github.com/bouchaiblemaire/ressources/raw/main/tomcat/tomcat-users.xml.tar.gz
RUN tar xvfz tomcat-users.xml.tar.gz
RUN rm -rf tomcat-users.xml.tar.gz

WORKDIR /opt/tomcat/webapps/manager/META-INF
RUN curl -O -L  https://github.com/bouchaiblemaire/ressources/raw/main/tomcat/context.xml.tar.gz
RUN tar xvfz context.xml.tar.gz
RUN rm -rf context.xml.tar.gz


WORKDIR /opt/tomcat/webapps
RUN curl -O -L  https://einfo-learning.fr/partages/dev_avance/tp_api_rest.war


EXPOSE 8080

CMD ["/opt/tomcat/bin/catalina.sh", "run"]