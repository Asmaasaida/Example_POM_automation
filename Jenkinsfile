pipeline {
    agent any // Run this pipeline on any available Jenkins agent

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code...'
                git url: git(url: 'https://github.com/Asmaasaida/Example_POM_automation.git', // Replace with your repo URL
                               credentialsId: 'Asmaasaida', // Replace with your Jenkins credential ID
                               branch: 'main') // Adjust branch if needed
            }
        }
        stage('Build') {
            steps {
                echo 'Building the Maven project...'
                sh 'mvn clean install -DskipTests' // Clean and build, skipping tests for now
            }
        }
        stage('Test') {
            steps {
                echo 'Running the TestNG tests...'
                sh 'mvn test' // Execute your TestNG tests using Maven
                junit '**/surefire-reports/TEST-*.xml' // Publish JUnit-style test reports
            }
        }
        // You can add more stages here for other steps like static analysis, reporting, deployment, etc.
    }

    post {
        always {
            echo 'Pipeline finished.'
            // Optional: Clean up steps
        }
        success {
            echo 'Tests passed!'
            // Optional: Actions on success
        }
        failure {
            echo 'Tests failed.'
            // Optional: Actions on failure (e.g., send notifications)
        }
    }
}
