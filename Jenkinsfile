pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Build stage done'
            }
        }
        stage('Test') {
            steps {
                echo 'Test stage done'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploy stage done'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
