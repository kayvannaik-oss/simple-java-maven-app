pipeline {
    agent any
    tools { maven 'maven-tools' }

    environment {
        DOCKER_CREDENTIALS_ID = 'dockerhub-id'
        DOCKER_HUB_USER       = 'kaydocker143'
        IMAGE_NAME            = 'pipeline-repo'
        IMAGE_TAG             = "${env.BUILD_NUMBER}"
        FULL_IMAGE            = "kaydocker143/${IMAGE_NAME}:${IMAGE_TAG}"
    }

    stages {
        stage('Checkout')         { steps { checkout scm } }
        stage('Build with Maven') { steps { sh 'mvn clean package -DskipTests' } }
        stage('Docker Build & Push') {
            steps {
                script {
                    def docker = load 'docker.groovy'
                    docker.buildImage(env.FULL_IMAGE)
                    docker.loginAndPush(env.DOCKER_CREDENTIALS_ID, env.FULL_IMAGE)
                }
            }
        }
    }

    post {
        success { echo "✅ Pushed ${env.FULL_IMAGE}" }
        failure { echo "❌ Pipeline failed" }
    }
}
