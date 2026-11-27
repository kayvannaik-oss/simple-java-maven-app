pipeline {
    agent any

       tools {
        maven 'maven-version' // This name must EXACTLY match the name you gave in Jenkins Global Tools
    }
    
    triggers {
        githubPush()
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                // Example for later: sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('Update POM Version') {
            steps {
                echo 'Updating POM version to 1.1...version'
                // Updates the version and removes the backup file in one step
                sh 'mvn versions:set -DnewVersion=1.1 -DgenerateBackupPoms=false'
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
