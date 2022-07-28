#!/usr/bin/env groovy
 

package com.example 

class Docker implements Serializable {
    
    
    def script 

    Docker(script) {
        this.script = script
    }


//     def buildJar () {
//         script.sh "mvn package"
//         script.sh "echo Building gv script"
//         script.sh "echo My name is ${Name}"
//         script.sh "echo My name is ${params.type}"
// }
    
    

    def buildDockerImage (String IMAGENAME) {
        
        script.sh "docker build . -t $IMAGENAME"
        
    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId:"Dockerhub", usernameVariable:"user",passwordVariable:"pass")]) {
        script.sh "echo $script.pass | docker login -u $script.user --password-stdin"
        
    
       }
    } 

    def dockerPush(String IMAGENAME) {
        script.sh "docker push $IMAGENAME"
    }
}