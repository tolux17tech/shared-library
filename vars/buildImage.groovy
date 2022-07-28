#!/usr/bin/env groovy

def call (){
    echo "Building the Docker image"
            withCredentials([usernamePassword(credentialsId: "Dockerhub", usernameVariable: "user", passwordVariable: "pass")]){
                sh "docker build . -t  tolux17tech/demo:8.5"
                sh "echo $pass | docker login -u $user --password-stdin"
                sh "docker push tolux17tech/demo:8.5"
            }
}