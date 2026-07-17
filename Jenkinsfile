pipeline {
    agent any

    options {
        disableConcurrentBuilds()
        buildDiscarder(logRotator(
            daysToKeepStr: '30',
            numToKeepStr: '50'
        ))
        timestamps()
    }

    triggers {
        githubPush()
        // Uncomment if you prefer polling
        // pollSCM('H/5 * * * *')
    }

    environment {
        GIT_URL         = 'https://github.com/sushant015/jenkins-automated-jobs.git'
        GIT_BRANCH      = 'main'
        //GIT_CREDENTIALS = 'github-token'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: env.GIT_BRANCH,
                    //credentialsId: env.GIT_CREDENTIALS,
                    url: env.GIT_URL
            }
        }

        stage('Validate DSL') {
            steps {
                script {
                    sh '''
                        echo "Validating Groovy files..."

                        find . -name "*.groovy" -print

                        if command -v groovyc >/dev/null 2>&1; then
                            echo "Running Groovy syntax validation..."
                            find . -name "*.groovy" -print0 | xargs -0 groovyc
                        else
                            echo "groovyc is not available on this agent; skipping syntax validation."
                        fi
                    '''
                }
            }
        }

        stage('Generate Jenkins Jobs') {
            steps {

                jobDsl(
                    targets: [
                        'folders/**/*.groovy',
                        'pipelines/**/*.groovy',
                        'views/**/*.groovy'
                    ],
                    removedJobAction: 'DELETE',
                    removedViewAction: 'DELETE',
                    removedConfigFilesAction: 'DELETE',
                    lookupStrategy: 'SEED_JOB',
                    ignoreMissingFiles: false,
                    failOnMissingPlugin: true,
                    unstableOnDeprecation: true
                )
            }
        }
    }

    post {

        success {
            echo "✔ Jenkins Jobs Updated Successfully"
        }

        failure {
            echo "✖ Job Generation Failed"
        }

        cleanup {
            cleanWs()
        }
    }
}