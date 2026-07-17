pipelineJob("Mobile/Android Build") {

    definition {

        cpsScm {

            scm {

                git {

                    remote {

                        url("https://github.com/company/mobile.git")

                        credentials("github-token")

                    }

                }

            }

            scriptPath("android/Jenkinsfile")

        }

    }

}