pipeline {
  // Declaring environment variables for docker credentials.
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
        sh 'sbt clean compile'
        //sh 'sbt test'
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
        //sh 'sbt test'
        sh 'sbt assembly'
        archiveArtifacts artifacts: 'target/scala-2.11/*.jar', fingerprint: true, followSymlinks: false, onlyIfSuccessful: true
       //  sh 'sbt package'
        // Creating an image and pushing the image to Docker Hub
        script{
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
          docker.withRegistry( '',registryCredential ){
          dockerImage.push()
          }
        }
//    script{
//       kubernetesDeploy(configs: "deployment.yaml", kubeconfigId: "kube-id")
//      }
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
         echo "Successful completion!"
         cleanWs()
             }
      failure{
          echo "Failed!"
      }}
  }
