pipelineJob("Infrastructure/Terraform-Plan") {
    description("Terraform Plan")
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url("https://github.com/company/terraform-live.git")
                        credentials("github-token")
                    }
                    branch("main")
                }
            }
            scriptPath("jenkins/Jenkinsfile.plan")
        }
    }
}