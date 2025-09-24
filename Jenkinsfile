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
                    sh 'echo "Killing any existing application..."'
                    sh 'pkill -f MySpringBootApp-0.0.1-SNAPSHOT.jar || true'
                    sh 'echo "Starting application in background..."'
                    sh 'nohup java -jar target/MySpringBootApp-0.0.1-SNAPSHOT.jar > application.log 2>&1 &'
                    sh 'echo "Waiting for application to start..."'
                    sh 'sleep 25'
                    sh 'echo "Application logs:"'
                    sh 'cat application.log'
                    sh 'echo "Checking if application is running:"'
                    sh 'ps aux | grep MySpringBootApp || echo "No processes found"'
                    sh 'echo "Testing application endpoint:"'
                    sh 'curl -f http://localhost:9090/health'
                    echo 'Application deployed successfully!'
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