pipeline {
    agent any
    stages {
        stage('■■Prepare branch github_access_token url') {
            agent any
            steps {
                git branch: 'main', 
                credentialsId: '43134ce5-9160-45f6-b3b9-723105d81532', 
                url: 'https://github.com/sangbinlee/board9.git'
            }
            post {
                failure{
                    error "■Fail Cloned Repository"
                }
            }
        }
        
        stage('■■Build') {
            agent any
            steps{
                // windows
                // bat '''
                //     echo '■start bootJar'
                //     ./gradlew clean bootJar
                //     '''
                
                // ubuntu
                sh '''
                    echo '■start bootJar'
                    chmod +x ./gradlew
                    ./gradlew clean bootJar
                    '''
            }
            post{
                failure{
                    error '■Fail Build'
                }
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
