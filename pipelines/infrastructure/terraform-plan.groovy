pipelineJob("Infrastructure/Terraform Plan") {

    description("Terraform Plan")

    logRotator {
        daysToKeep(30)
        numToKeep(20)
    }

    definition {

        cpsScm {

            scm {

                git {

                    remote {

                        url("https://github.com/company/terraform-live.git")

                        credentials("github-token")

                    }

                    branch("*/main")

                }

            }

            scriptPath("jenkins/Jenkinsfile.plan")

        }

    }

}