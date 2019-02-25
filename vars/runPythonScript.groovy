#!/usr/bin/env groovy
def call(){
    final output = libraryResource('../resources/py_scripts/check_disk.py')
    writeFile(file: 'check_disk.py', text: output)
    sh('chmod +x ./check_disk.py && ./check_disk.py 80')
}
