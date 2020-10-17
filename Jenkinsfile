pipeline {
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
      }
      steps{
        dockerImage = docker.build("Vidushi0808-hub/akka-http-examples")
        docker.push("latest")   
      }
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
           }
 
                }

}


