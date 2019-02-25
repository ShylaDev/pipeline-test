#!/usr/bin/env groovy
def call() {
    (readFile('pom.xml') =~ '<version>(.+?)</version>')[0][1]
}
