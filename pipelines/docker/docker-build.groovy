pipelineJob("Applications/Docker Build") {

    definition {

        cpsScm {

            scm {

                git {

                    remote {

                        url("https://github.com/company/docker-app.git")

                        credentials("github-token")

                    }

                    branch("*/main")

                }

            }

            scriptPath("Jenkinsfile")

        }

    }

}