def buildImage(String fullImage) {
    sh "docker build -t ${fullImage} ."
}

def loginAndPush(String credId, String fullImage) {
    withCredentials([usernamePassword(
        credentialsId: credId,
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {
        sh """
            echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin
            docker push ${fullImage}
            docker logout
        """
    }
}

return this
