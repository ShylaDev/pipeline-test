#!/usr/bin/env groovy
def call() {
    (readFile('pom.xml') =~ '<version>(.+)-SNAPSHOT</version>')[0][1]
}
