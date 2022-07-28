#!/usr/bin/env groovy

import com.example.groovy

def call(){
    return new Docker(this).dockerPush()
}