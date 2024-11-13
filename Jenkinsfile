pipeline {
    agent any
    stages {
        stage ('Build Backend') {
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
        }

        stage ('Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage ('Deploy Backend') {
            steps {
                deploy adapters: [tomcat8(credentialsId: '60aa6c92-4ea5-4450-becd-b3454d017806', path: '', url: 'http://localhost:8001')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
            }
        }

        stage ('API Test') {
            steps {
                git branch: 'main', credentialsId: '57beac03-4ee4-424b-89f5-c801e3265238', url: 'https://github.com/danielsilvalima1996/tasks-api-test'
                sh 'mvn test'
            }
        }
    }
}
