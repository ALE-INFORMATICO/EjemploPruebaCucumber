pipeline {
    agent {
        docker {
            image 'maven:3.8.3-openjdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn clean test -Dbrowser=remote'
            }
        }
    }
    post {
        always {
            publishTestResults serverAddress: 'https://cdga.atlassian.net',
                projectKey: 'PRUEB',
                filePath:'target/cucumber/*.json',
                format: 'Cucumber',
                autoCreateTestCases: true
        }
    }
}