#!/bin/bash
#-Ddubbo.application.register-mode=instance \
java -jar \
-Dadmin.registry.address=zookeeper://emon:2181 -Dadmin.config-center=zookeeper://emon:2181 -Dadmin.metadata-report.address=zookeeper://emon:2181 /c/Job/JobResource/IdeaProjects/Idea2020/github/dubbo-admin-0.5.0-SNAPSHOT.jar