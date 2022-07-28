#!/bin/env groovy
import com.example.builder

def call (String IMAGENAME) {
    return new builder(this).buildDockerImage(IMAGENAME)
}
    