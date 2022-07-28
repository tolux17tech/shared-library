#!/bin/env groovy
 

Package com.example 

class Docker implements Serializable {
    
    
    def script 

    Docker(script) {
        this.script = script
    }

    def buildDockerImage (String) {
        script.withCredentials([script.usernamePassword(credentialsId:"Dockerhub", usernameVariable:"user",passwordVariable:"pass")]) {
        script.sh "docker build . -t $IMAGENAME"
        script.sh "echo $script.pass | docker login -u $script.user --password-stdin"
        script.sh "docker push $IMAGENAME"
    
       }
    }
}