#!/bin/env groovy
def call () {
    withCredentials([usernamePassword(credentialsId:"Dockerhub", usernameVariable:"user",passwordVariable:"pass")]) {
        sh "docker build . -t tolux17tech/demo:3.48"
        sh "echo $pass | docker login -u $user --password-stdin"
        sh "docker push tolux17tech/demo:3.48"
    
    }
}