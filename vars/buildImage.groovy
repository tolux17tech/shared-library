#!/bin/env groovy
def call (String IMAGENAME) {
    withCredentials([usernamePassword(credentialsId:"Dockerhub", usernameVariable:"user",passwordVariable:"pass")]) {
        sh "docker build . -t $IMAGENAME"
        sh "echo $pass | docker login -u $user --password-stdin"
        sh "docker push $IMAGENAME"
    
    }
}

#information