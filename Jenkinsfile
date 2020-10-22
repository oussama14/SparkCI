pipeline {
    agent {
    Any
    }
    stages {
        stage("Build") {
            steps {
                sh "echo Build Application"
            }
        }
    }
        stage  ("Testing"){
        steps {
        sh "mvn test"
        }
        }


  }