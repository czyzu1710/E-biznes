FROM ubuntu:18.04

RUN mkdir Documents/

VOLUME Documents/

RUN apt update && apt install -y openjdk-8-jdk npm wget

RUN wget https://downloads.lightbend.com/scala/2.12.13/scala-2.12.13.deb

RUN dpkg -i scala-2.12.13.deb

RUN npm install -g n 

RUN n latest && npm install -g npm@latest
