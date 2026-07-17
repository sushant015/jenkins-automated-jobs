class PipelineDefaults {
    static void configure(job) {
        job.logRotator {
            daysToKeep(30)
            numToKeep(50)
        }
        job.concurrentBuild(false)
    }
}