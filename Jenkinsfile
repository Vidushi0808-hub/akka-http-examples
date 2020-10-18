pipeline {
  //def img
  environment{
    registry = "vidushi0808/akka-http"
    registryCredential = 'docker-hub'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Development') {
      steps {
        echo 'Development Stage'
        sh 'sbt compile'
        sh 'sbt test'
     }
    }
    stage('Testing') {
      steps {
        echo 'Testing '
        sh 'sbt test'
      }
    }
    stage('Production') {
      steps {
        echo 'Production'
        sh 'sbt test'
        sh 'sbt package' 
        sh 'docker build -t akka-http:latest .'
        sh 'docker tag akka-http:latest vidushi0808/akka-http'
        sh 'docker push vidushi0808/akka-http:latest'
        //withDockerRegistry([ credentialsId: "docker-hub", url: "vidushi0808/akka-http" ]) {
         // sh 'docker push akka-http:latest'
        //}
        // sh 'docker push dockerImage'
        //script{
        //dockerImage = docker build registry + ":$BUILD_NUMBER" 
        //}
        //withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          //sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          //sh 'docker push akka:latest'
        //}
       // script{
       // dockerImage = docker build registry + ":$BUILD_NUMBER"
        // docker.withRegistry( '', registryCredential ) {
        // dockerImage.push()
        // }
       // }
      }
    }
  }
 post {
     always {
     mail to: "vidushi.bansal@knoldus.com",
     subject: "Completion of ${env.JOB_NAME}",
     body: "${env.JOB_NAME} has been completed. Refer to: ${env.BUILD_URL}"
             }
     success {
         echo "Successful!"
         cleanWs()
             }
      failure{
          echo "Failed!"
      }}
  }
