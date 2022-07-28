#!/bin/env groovy
 

Package com.example 

class builder implements Serializable {
    
    
    def script 

    builder(script) {
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