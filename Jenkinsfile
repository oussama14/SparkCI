pipeline {

    agent any

    tools {
        maven "mvn"
    }
    

    triggers {
        pollSCM "* * * * *"
    }

    options {
        timestamps()
        ansiColor("xterm")
    }

    parameters {
        booleanParam(name: "RELEASE",
                description: "Build a release from current commit.",
                defaultValue: false)
    }

    stages {

        stage("Build & Deploy SNAPSHOT") {
            steps {
                sh "mvn -B deploy"
            }
        }

        stage("Release") {
            when {
                expression { params.RELEASE }
            }
            steps {
                sh "mvn -B release:prepare"
                sh "mvn -B release:perform"
            }
        }

    }

    post {
        always {
            deleteDir()
        }
    }
}