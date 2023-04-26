// add imports 

def call(body){
    def config [:]
    def builder
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline{
        agent any{
            tools {
                // add tools here
            }
            environment {
                // add ENV VARS here
            }
            stages {
                stage('Init'){
                    steps {
                        echo ("start stage here")
                        script {
                            // enter sh cmds here
                        }
                    }
                }
                stage('Code Checkout'){
                    steps {
                        //steps for code checkout
                        echo ("SCM Checkout")
                    }
                }
                stage('Build and Test'){
                    steps {
                        echo ("steps for build and test here")
                        script {
                            //enter sh cmds here
                        }
                    }
                }
                stage('Security Scan'){
                    steps {
                        echo ("Scan here")
                    }
                }
                stage('Publish'){
                    steps {
                        echo ("Publish here")
                    }
                }
            }
            post { 
                always { 
                    echo 'run audit trail here'
                }
            }
        }
    }
}