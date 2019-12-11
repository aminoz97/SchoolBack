pipeline{
	agent any
	tools{
		maven 'apache-maven'
		jdk 'jdk1.8.0_171'
	}
	stages{
		stage('Build'){	
			steps{
			bat 'mvn install'
			}
			post {
				success{
					junit 'target/surefire-reports/*/.xml'
				}
			}
		}

	}
}
