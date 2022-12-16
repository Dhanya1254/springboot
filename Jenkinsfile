pipeline {
    agent {
        all
    }
    stages {
        stage('build') {
            steps {
               docker build -t dhanyashree/springboot:v2
            }
        stage('push')
            steps{
               docker push dhanyashree/springboot:v2
            }
        }
    }
}
