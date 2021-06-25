## Installation steps -

* Build the project as jar using mvn clean install
* create docker image by running following command at root of project - docker build -t imageName .
* Once image is build run it as container - docker run --name containerName -dit -p 8080:8080 imageName, this will run container in host
  machine and exposes at port 8080 to outer world.