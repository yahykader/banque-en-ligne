pipeline{
  agent any  
    stages{
       stage('Build and Package'){
         steps{ 
            sh 'C:/ProgramData/chocolatey/lib/maven/apache-maven-3.6.1/bin/mvn package'
         }}
       stage('Build and Test'){
         steps{ 
            sh 'C:/ProgramData/chocolatey/lib/maven/apache-maven-3.6.1/bin/mvn verify'
         }}  
    }
}
