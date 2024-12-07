pipeline {
    agent any

    environment {
        PROJECT_NAME = "board9"
        // TEST_PREFIX = "test-IMAGE"
        // TEST_IMAGE = "${env.TEST_PREFIX}:${env.BUILD_NUMBER}"
        // TEST_CONTAINER = "${env.TEST_PREFIX}-${env.BUILD_NUMBER}"
        // REGISTRY_ADDRESS = "my.registry.address.com"

        // SLACK_CHANNEL = "#deployment-notifications"
        // SLACK_TEAM_DOMAIN = "MY-SLACK-TEAM"
        // SLACK_TOKEN = credentials("slack_token")
        // DEPLOY_URL = "https://deployment.example.com/"

        // COMPOSE_FILE = "docker-compose.yml"
        // REGISTRY_AUTH = credentials("docker-registry")
        // STACK_PREFIX = "my-project-stack-name"
    }


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
        // stage('■■Test') {
        //     steps {
        //         sh 'chmod +x ./gradlew'
        //         sh './gradlew test'
        //     }
        // }

        stage('■■Deploy') {
            steps {
                echo '■Deploying....'


                sh '''
                    echo "■Start board9 !"
                    CURRENT_PID=$(ps -ef | grep java | grep board9 | awk '{print $2}')
                    echo "$CURRENT_PID"

                    if [ -z $CURRENT_PID ]; then
                    echo "■>현재 구동중인 어플리케이션이 없으므로 종료하지 않습니다."

                    else
                    echo "■> kill -9 $CURRENT_PID"
                    kill -9 $CURRENT_PID
                    sleep 10
                    fi
                    echo "■>어플리케이션 배포 진행!"
                    nohup java -jar /var/lib/jenkins/workspace/${env.PROJECT_NAME}/build/libs/${env.PROJECT_NAME}-0.0.1-SNAPSHOT.jar &

                    echo "■배포까지 성공 !!"
                    '''



            }
        }
    }
}
