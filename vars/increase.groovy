#!?usr/bin/env groovy

def call () {

    echo "Incerementing app-version .."
    sh "mvn build-helper:parse-version versions:set\
    -DnewVersion=\\\${parsedVersion.nextMajorVersion}.\\\${parsedVersion.nextMinorVersion}.\\\${parsedVersion.nextIncrementalVersion}\
    versions:commit"

}