pipeline {
    agent any

    tools {
        jdk 'jdk-24'
        maven 'Maven'
    }

    environment {
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=true'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                git branch: 'main', url: 'https://github.com/nicohaase99/MySpringBootApp.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests...'
                sh 'mvn test'
            }
            post {
                always {
                    junit testResults: 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the application...'
                sh 'mvn package -DskipTests'
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo 'Archiving build artifacts...'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Deploy to Staging') {
            steps {
                script {
                    echo 'Deploying to staging environment...'
                    sh '''
                        echo "Killing any existing application..."
                        pkill -f MySpringBootApp-0.0.1-SNAPSHOT.jar || true
                        echo "Starting application in background..."
                        nohup java -jar target/MySpringBootApp-0.0.1-SNAPSHOT.jar > application.log 2>&1 &
                        echo "Waiting for application to start..."
                        sleep 20
                        echo "Application logs:"
                        cat application.log
                        echo "Testing application endpoint..."
                        curl -f http://localhost:9090/pet/owner
                        echo "Application deployed successfully!"
                    '''
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed!'
        }
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline execution failed!'
        }
    }
}