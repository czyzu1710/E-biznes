FROM ubuntu:18.04

RUN useradd -ms /bin/bash mczyz

WORKDIR /home/mczyz

RUN mkdir scala && mkdir react

VOLUME scala react

EXPOSE 3000 9000

RUN apt update && apt install -y openjdk-8-jdk npm wget

RUN wget https://downloads.lightbend.com/scala/2.12.13/scala-2.12.13.deb && wget https://dl.bintray.com/sbt/debian/sbt-1.4.9.deb

RUN dpkg -i scala-2.12.13.deb && rm scala-2.12.13.deb && dpkg -i sbt-1.4.9.deb && rm sbt-1.4.9.deb

RUN npm install -g n && n latest && npm install -g npm@latest
 
USER mczyz
