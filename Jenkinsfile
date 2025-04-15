pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Asmaasada/Example_POM_automation.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building with Maven...'
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests with Maven...'
                sh 'mvn test'
                echo 'Publishing JUnit test results...'
                junit 'target/surefire-reports/*.xml'
            }
        }
        stage('Package') {
            steps {
                echo 'Packaging with Maven...'
                sh 'mvn package'
                // You might want to archive artifacts here
                archiveArtifacts 'target/*.jar' // Example for a JAR file
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add your deployment steps here (e.g., deploying to a server, uploading to a registry)
                echo 'Deployment steps go here'
            }
        }
    }
}
