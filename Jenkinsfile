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
                dir('api-test') {
                    git branch: 'main', credentialsId: '57beac03-4ee4-424b-89f5-c801e3265238', url: 'https://github.com/danielsilvalima1996/tasks-api-test'
                    sh 'mvn test'
                }
            }
        }

        stage ('Deploy Frontend') {
            steps {
                dir('frontend') {
                    git branch: 'master', credentialsId: '57beac03-4ee4-424b-89f5-c801e3265238', url: 'https://github.com/danielsilvalima1996/tasks-frontend'
                    sh 'mvn clean package'
                    deploy adapters: [tomcat8(credentialsId: '60aa6c92-4ea5-4450-becd-b3454d017806', path: '', url: 'http://localhost:8001')], contextPath: 'tasks', war: 'target/tasks.war'
                }
            }
        }

        stage ('Functional Test') {
            steps {
                dir('functional-test') {
                    git branch: 'main', credentialsId: '57beac03-4ee4-424b-89f5-c801e3265238', url: 'https://github.com/danielsilvalima1996/tasks-functional-test'
                    sh 'mvn test'
                }
            }
        }
    }
}
