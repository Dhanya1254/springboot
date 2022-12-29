library identifier: "pipeline-library@v1.5",
retriever: modernSCM(
  [
    $class: "GitSCMSource",
    remote: "https://github.com/redhat-cop/pipeline-library.git"
  ]
)

appName = "dhanyabuild"
pipeline {
    // Use the 'maven' Jenkins agent image which is provided with OpenShift 
    agent  any 
    stages {
         stage("Checkout") {
            steps {
                checkout scm
            }
        }
     
        stage("Docker Build") {
            steps {
                // This uploads your application's source code and performs a binary build in OpenShift
                // This is a step defined in the shared library (see the top for the URL)
                // (Or you could invoke this step using 'oc' commands!)
                binaryBuild(buildConfigName: appName, buildFromPath: ".")
              
            }
        }
      stage("TEST: Can tag image") {
       steps{
    tagImage([
            sourceImagePath: "dhanya-jenkins",
            sourceImageName: "springboot",
            sourceImageTag : "latest",
            toImagePath: "dhanya-jenkins",
            toImageName    : "springboot",
            toImageTag     : "${env.BUILD_NUMBER}"
    ])
}
     }
 /*stage("Trigger Deployment Update Pipeline"){
        steps{
          build job:'updatefile' , parameters: [string(name: 'DOCKERTAG',value: env.BUILD_NUMBER)]
        }
      }*/
 
      }
}
