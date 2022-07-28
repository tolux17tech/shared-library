#!/usr/bin/env groovy 
import com.test.Jenkins
def call(){
    return new Jenkins(this).buildImage()
}
   