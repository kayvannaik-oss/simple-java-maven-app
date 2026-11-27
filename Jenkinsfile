pipeline {
    agent any
    
    tools {
        maven 'maven-version' // Replace with your exact Maven tool name in Jenkins
    }

    triggers {
        githubPush()
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
            }
        }
        
        stage('Update POM Version & Push') {
            steps {
                echo 'Updating POM version to 1.1...'
                // 1. Update version
                sh 'mvn versions:set -DnewVersion=1.1 -DgenerateBackupPoms=false'
                
                // 2. Commit and push
                sh '''
                    git config user.email "kayvannaik9353@gmail.com"
                    git config user.name "kayvan naik"
                    git add pom.xml
                    git commit -m "Bump version to 1.1 [skip ci]"
                    
                    # Note: You need to replace the URL below with your credentials or use Jenkins Credentials Binding
                    git push origin HEAD:version-upgrade-1
                '''
            }
        }
        
        stage('Test') {
            steps {
                echo 'Running tests...'
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
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
