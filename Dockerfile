# This dockerfile uses the ubuntu image
# Author: thy

FROM openjdk:17
MAINTAINER shinyMT@163.com
ADD bbb_lbb.jar bbb_lbb.jar

EXPOSE 11101

VOLUME ["/log"]

RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo "Asia/Shanghai" >/etc/timezone
# dubbo 3.1.0 在jdk9+上需要--add-opens java.base/java.lang java.base/java.util java.base/java.math
CMD ["java", "-jar", "./bbb_lbb.jar", "--spring.profiles.active=prod", "--add-opens","java.base/java.lang=ALL-UNNAMED","--add-opens","java.base/java.util=ALL-UNNAMED","--add-opens","java.base/java.math=ALL-UNNAMED"]
