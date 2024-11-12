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

        stage ('Sonar Analysis') {
            environment {
                scannerHome = tool 'SONAR'
            }
            steps {
                withSonarQuebEnv('SONARQUBE'){ 
                    sh "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBackend -Dsonar.host.url=http://localhost:9000 -Dsonar.login=squ_c720a3eacecb84305be49dcab4baf0fa98cd38af -Dsonar.java.binaries=target -Dsonar.converage.exclusions=**/.mvn/**,**/src/test/**,**/model/**,**Application.java"
                }
            }
        }
    }
}