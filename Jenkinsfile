pipeline {
    agent any

    tools {
        // This tells Jenkins to use the Maven installation named "3.10.1"
        // Make sure this exactly matches the name in Manage Jenkins -> Tools
        maven 'maven-version' 
    }

    stages {
        stage('Build with Maven') {
            steps {
                echo 'Building the project with Maven...'
                // -B = batch mode (no colorful download logs, cleaner for Jenkins)
                // clean package = cleans previous builds and packages the new .jar
                sh 'mvn package'
            }
        }
        
        stage('Docker Build') {
            steps {
                echo 'Building the Docker image...'
                sh 'docker build -t kaydocker143/my-app:1.0 .'
            }
        }

        stage('Docker Push') {
            steps {
                echo 'Logging into Docker Hub and pushing the image...'
                // Using --password-stdin as you requested
                sh 'echo "dckr_pat_zZ1TLEFRjAffDnIKApyZNzXd32k" | docker login -u kaydocker143 --password-stdin'
                
                sh 'docker push kaydocker143/my-app:1.0'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully! Image pushed to Docker Hub.'
        }
        failure {
            echo 'Pipeline failed. Check the logs above.'
        }
    }
}
