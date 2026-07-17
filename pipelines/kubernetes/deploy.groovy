pipelineJob("Infrastructure/Kubernetes Deploy") {

    definition {

        cpsScm {

            scm {

                git {

                    remote {

                        url("https://github.com/company/kubernetes.git")

                        credentials("github-token")

                    }

                }

            }

            scriptPath("jenkins/deploy.groovy")

        }

    }

}