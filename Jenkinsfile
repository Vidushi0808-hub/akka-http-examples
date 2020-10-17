pipeline {
  //def img
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
        //img = docker.build("Vidushi0808-hub/akka-http-examples")
        //img.push("latest")
        sh 'docker build -t shanem/spring-petclinic:latest .'
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: '9760089324', usernameVariable: 'vidushi0808')]) {
          sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push akka:latest'
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
