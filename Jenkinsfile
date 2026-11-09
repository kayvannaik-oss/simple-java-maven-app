pipeline {
    agent any

    tools {
        // Must match the name you gave the Maven tool in Jenkins
        maven 'maven-3.10.0'
    }

    environment {
        // Jenkins credential ID for Docker Hub (username/password)
        DOCKER_CREDENTIALS_ID = 'dockerhub-id'
        // Your Docker Hub username (also used as image namespace)
        DOCKER_HUB_USER       = 'kaydocker14'
        // Image name and tag
        IMAGE_NAME            = 'my-app'
        IMAGE_TAG             = "${env.BUILD_NUMBER}"
        // Full image reference
        FULL_IMAGE            = "${DOCKER_HUB_USER}/${IMAGE_NAME}:${IMAGE_TAG}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {dockerhub-credentials
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh """
                    docker build -t ${FULL_IMAGE} .
                """
            }
        }

        stage('Login & Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: env.DOCKER_CREDENTIALS_ID,
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker push "${FULL_IMAGE}"
                        docker logout
                    '''
                }
            }
        }
    }

    post {
        success {
            echo "✅ Build, image creation, and push completed: ${FULL_IMAGE}"
        }
        failure {
            echo "❌ Pipeline failed. Check the logs above."
        }
    }
}
