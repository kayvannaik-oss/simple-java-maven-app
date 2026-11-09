def loginAndPush(String credId, String fullImage) {
    withCredentials([usernamePassword(
        credentialsId: credId,
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {
        sh """
            echo "=== DEBUG INFO ==="
            echo "Logging in as: \$DOCKER_USER"
            echo "Pushing to:    ${fullImage}"
            echo "==================="
            echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin
            docker push ${fullImage}
            docker logout
        """
    }
}
return this
