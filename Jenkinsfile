pipeline{

  agent any  
    stages{
       stage('Build and Test'){
         steps{ 
           bat label: '', script: 'mvn verify'
         }}
       stage('Generate Reports'){
         steps{ 
            cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
         }}   
    }
}
