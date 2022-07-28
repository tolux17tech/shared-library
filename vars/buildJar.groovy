#!/bin/env groovy
def call () {
    sh "mvn package"
    echo "Building gv script"
    echo "My name is ${Name}"
    echo "My name is ${params.type}"
}


// def call () {
//     return new Docker(this).buildJar()
// }