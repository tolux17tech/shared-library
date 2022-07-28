#!/bin/env groovy
 

package com.example 

class Docker implements Serializable {
    
    
    def script 

    Docker(script) {
        this.script = script
    }

    def buildDockerImage (String IMAGENAME) {
        
        script.sh "docker build . -t $IMAGENAME"
        
    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId:"Dockerhub", usernameVariable:"user",passwordVariable:"pass")]) {
        script.sh "echo $script.pass | docker login -u $script.user --password-stdin"
        
    
       }
    } 

    def dockerPush() {
        script.sh "docker push $IMAGENAME"
    }
}