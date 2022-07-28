#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {
    def script

    Docker (script) {
        this.script = script 
    }

    def buildJar () {
        script.echo "Building The Application"
        script.sh "mvn package"
    }

    def buildImage (){
    script.echo "Building the Docker image"
            script.withCredentials([script.usernamePassword(credentialsId: "Dockerhub", usernameVariable: "user", passwordVariable: "pass")]){
                script.sh "docker build . -t  tolux17tech/demo:8.5"
                script.sh "echo $script.pass | docker login -u $script.user --password-stdin"
                script.sh "docker push tolux17tech/demo:8.5"
            }
    }

    def deployApp(){
        script.echo "Application is deploying like yesterday"
    }

    def increase(){
        script.echo "Incerementing app-version .."
        script.sh "mvn build-helper:parse-version versions:set\
        -DnewVersion=\\\${parsedVersion.nextMajorVersion}.\\\${parsedVersion.nextMinorVersion}.\\\${parsedVersion.nextIncrementalVersion}\
        versions:commit"

    }


}