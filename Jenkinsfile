node {
    def WORKSPACE = "/home/ansari/jenkins/workspace/springboot-deploy"
    def dockerImageTag = "springboot-deploy${env.BUILD_NUMBER}"

try{
     notifyBuild('STARTED')
     stage('Clone Repo from MW') {
        git url: 'https://github.com/ansarikaleem/mw.git',
            credentialsId: 'springdeploy-user',
            branch: 'main'
     }
      stage('Build docker for MW') {
             dockerImage = docker.build("springboot-deploy:${env.BUILD_NUMBER}")
      }

      stage('Deploy docker'){
              echo "Docker Image Tag Name: ${dockerImageTag}"
              sh "docker stop springboot-deploy || true && docker rm springboot-deploy || true"
              sh "docker run --name springboot-deploy -d -p 8081:8081 springboot-deploy:${env.BUILD_NUMBER}"
      }
}catch(e){
    currentBuild.result = "FAILED"
    throw e
}finally{
    notifyBuild(currentBuild.result)
 }
}

def notifyBuild(String buildStatus = 'STARTED'){

// build status of null means successful
  buildStatus =  buildStatus ?: 'SUCCESSFUL'
  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def now = new Date()
  // message
  def subject = "${buildStatus}, Job: ${env.JOB_NAME} FRONTEND - Deployment Sequence: [${env.BUILD_NUMBER}] "
  def summary = "${subject} - Check On: (${env.BUILD_URL}) - Time: ${now}"
  def subject_email = "Spring boot Deployment"
  def details = """<p>${buildStatus} JOB </p>
    <p>Job: ${env.JOB_NAME} - Deployment Sequence: [${env.BUILD_NUMBER}] - Time: ${now}</p>
    <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME}</a>"</p>"""


  // Email notification
    emailext (
         to: "pbhapps@gmail.com",
         subject: "Jenkins Build",
         body: "A Build has been generated",
         recipientProviders: [[$class: 'DevelopersRecipientProvider']]
       )
}