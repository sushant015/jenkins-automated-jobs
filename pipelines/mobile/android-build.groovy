pipelineJob("Mobile/Android-Build") {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url("https://github.com/company/mobile-app.git")
                    }
                }
            }
            scriptPath("Jenkinsfile")
        }
    }
}