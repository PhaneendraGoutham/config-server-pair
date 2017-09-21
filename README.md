# config-server-pair

Secure configs storage examples with Spring Cloud Config Server

## Build

`gradle clean build`

## Deploy to Vagrant
```
vagrant up && \
    gradle build && \
    ansible-playbook -i ansible/hosts-vagrant ansible/vagrant.yml
```
