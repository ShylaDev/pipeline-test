@NonCPS
def call() {
    def jobname = env.JOB_NAME
    def buildnum = env.BUILD_NUMBER.toInteger()
    def job = Jenkins.instance.getItemByFullName(jobname)
    for (build in job.builds) {
        if (!build.isBuilding()) {
            continue
        }
        if (buildnum == build.getNumber().toInteger()) {
            continue
        }
        echo "Stopping previous build: ${build}"
        build.doStop()
    }
}
