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

    }

    post {
        always {
            deleteDir()
        }
    }
}