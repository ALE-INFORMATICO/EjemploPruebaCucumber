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

            cucumber buildStatus: 'UNSTABLE',
                            failedFeaturesNumber: 1,
                            failedScenariosNumber: 1,
                            skippedStepsNumber: 1,
                            failedStepsNumber: 1,
                            classifications: [
                                    [key: 'Commit', value: '<a href="${GERRIT_CHANGE_URL}">${GERRIT_PATCHSET_REVISION}</a>'],
                                    [key: 'Submitter', value: '${GERRIT_PATCHSET_UPLOADER_NAME}']
                            ],
                            reportTitle: 'My report',
                            fileIncludePattern: 'target/cucumber/*.json',
                            sortingMethod: 'ALPHABETICAL',
                            trendsLimit: 100
        }
    }
}