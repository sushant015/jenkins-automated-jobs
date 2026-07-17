pipelineJob("Utilities/Cleanup Workspace") {

    description("Cleanup Jenkins Workspaces")

    definition {

        cps {

            script("""

pipeline {

    agent any

    stages {

        stage('Cleanup') {

            steps {

                cleanWs()

            }

        }

    }

}

""")

            sandbox(true)

        }

    }

}