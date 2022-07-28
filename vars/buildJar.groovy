#!/usr/bin/env groovy

def call () {

    echo "Building The Application"
    sh "mvn package"
}







