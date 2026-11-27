pipeline {
    agent any
    trigger{
        githubpush()
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                // Example for later: sh 'docker build -t my-app:1.0 .'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Running tests...'
                // Example for later: sh 'npm test' or sh 'mvn test'
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Example for later: sh 'docker push my-app:1.0'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline completed successfully! 🎉'
        }
        failure {
            echo 'Pipeline failed. ❌'
        }
    }
}
#test3
