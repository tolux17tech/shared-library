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


}