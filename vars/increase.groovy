#!?usr/bin/env groovy

import com.example.Docker

def call () {


    return new Docker(this).increase()

    // echo "Incerementing app-version .."
    // sh "mvn build-helper:parse-version versions:set\
    // -DnewVersion=\\\${parsedVersion.nextMajorVersion}.\\\${parsedVersion.nextMinorVersion}.\\\${parsedVersion.nextIncrementalVersion}\
    // versions:commit"



}