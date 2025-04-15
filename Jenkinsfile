pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code...'
                git scm // This will use the Git SCM configuration you set in the Jenkins job
            }
        }
        stage('Build') {
            steps {
                echo 'Building the Maven project...'
                sh 'mvn clean install -DskipTests' // Clean and build, skipping tests in this phase
            }
        }
        stage('Test') {
            steps {
                echo 'Running the TestNG tests...'
                sh 'mvn test' // Execute your TestNG tests using Maven
                junit '**/surefire-reports/TEST-*.xml' // Publish JUnit-style test reports
            }
        }
    }
}
