pipeline {

    agent any

    tools {
        maven "mvn"
    }


    triggers {
        pollSCM "* * * * *"
    }

//    options {
//        timestamps()
//        ansiColor("xterm")
//    }

    parameters {
        booleanParam(name: "RELEASE",
                description: "Build a release from current commit.",
                defaultValue: false)
    }

    stages {

        stage("Running Tests") {
            steps {
                sh "mvn test"
            }
        }

        stage("Install Jar ") {
            steps {
                sh "mvn clean"
                sh "mvn install"
            }
        }
        stage ("Upload Jar to Nexus") {
            steps {
                nexusArtifactUploader(
                        nexusVersion: 'nexus2',
                        protocol: 'http',
                        nexusUrl: 'http://localhost:8081/nexus',
                        groupId: "org.example",
                        version: "1.0",
                        repository: 'repo_2',
                        credentialsId: 'nexus_id',
                        artifacts: [
                                [artifactId: 'org.example',
                                 file: "SparkCI-1.0.jar",
                                 type: 'jar']
                        ]


                )
            }
        }


    }

    post {
        always {
            deleteDir()
        }
    }
}