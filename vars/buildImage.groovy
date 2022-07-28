#!/usr/bin/env groovy
import com.example.Docker

def call (String IMAGENAME) {
    return new Docker(this).buildDockerImage(IMAGENAME)
}
    