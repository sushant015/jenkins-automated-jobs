pipelineJob("Infrastructure/Terraform-Apply") {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url("https://github.com/company/terraform-live.git")
                    }
                    branch("main")
                }
            }
            scriptPath("jenkins/Jenkinsfile.apply")
        }
    }
}