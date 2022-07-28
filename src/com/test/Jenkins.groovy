#!/usr/bin/env groovy

package com.test 

class Jenkins implements  Serializable {
    def script 

    Jenkins(script) {
        this.script = script 
    }

    def buildImage () {
    script.echo "Building the Docker image"
    script.withCredentials([script.usernamePassword(credentialsId: "Dockerhub", usernameVariable: "user", passwordVariable: "pass")]){
        script.sh "docker build . -t  tolux17tech/demo:12.5"
        script.sh "echo $script.pass | docker login -u $script.user --password-stdin"
        script.sh "docker push tolux17tech/demo:12.5"
        }
    }
}