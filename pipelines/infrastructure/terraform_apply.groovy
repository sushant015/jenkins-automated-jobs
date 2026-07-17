pipelineJob("Infrastructure/Terraform Apply") {

    description("Terraform Apply")

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

            scriptPath("jenkins/Jenkinsfile.apply")

        }

    }

}