pipeline {
    agent any
    environment {
      
	    GIT_URL = "https://github.com/lqsavage/sba-search-service.git"
		GIT_CRED = "a2a33599-8110-4059-beff-06537fca7e89"
		DOCKER_REPO="registry.cn-hangzhou.aliyuncs.com/dev_savage/sba-search"
		DOCKER_REG="https://registry.cn-hangzhou.aliyuncs.com"
		DOCKER_REG_KEY = "8ca82a1c-4869-46d6-93f6-07af36ca23aa"
		dockerImage = ''
      
    }
    stages {
    	stage('CheckOut Code'){
         	steps{
         	    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: GIT_CRED, url: GIT_URL]]])
            	}
              }
        stage('Maven Build'){
        	steps{
        	    sh 'mvn clean install -DskipTests'
        	}

        }
        
        stage('Building image') {
	      steps{
	        script {
	           docker.withRegistry( DOCKER_REG, DOCKER_REG_KEY ) {dockerImage = docker.build DOCKER_REPO + ":$BUILD_NUMBER"
	           }
	        }
	      }
	    }
	    stage('Push Image') {
      steps{
        script {
		   docker.withRegistry( DOCKER_REG, DOCKER_REG_KEY ) {
		            dockerImage.push()
		          }
		        }
		      }
		}

		stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $DOCKER_REPO:$BUILD_NUMBER"
      }
    }
   }
  

}