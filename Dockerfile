#基础镜像，如果本地仓库没有，会从远程仓库拉取
FROM openjdk:8-jdk-alpine
MAINTAINER by lilvhua
RUN echo 'Asia/Shanghai'> /etc/timezone
ENV LANG zh_CN.UTF-8
#容器中创建目录
RUN mkdir -p /usr/local/service
RUN mkdir -p /usr/local/service/logs
#编译后的jar包copy到容器中创建到目录内
COPY usr-server/target/usr-server.jar /usr/local/service/api.jar
COPY startup.sh /usr/local/service/startup.sh
COPY docker/* /usr/local/service/
#指定容器启动时要执行的命令
ENTRYPOINT ["sh","/usr/local/service/startup.sh"]

#containers env
#JAVA_OPTS=-Xms128m -Xmx512m -XX:MaxNewSize=250m -XX:+UseConcMarkSweepGC

