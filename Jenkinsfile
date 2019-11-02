node {
    label 'maven-docker-postgis'

    docker.image('mdillon/postgis').withRun('-e "POSTGRES_PASSWORD=example"') { c ->
      docker.image('mdillon-postgis').inside("--link ${c.id}:mdillon-postgis") {
        sh 'echo postgis'
      }
      docker.image('maven:3-alpine').inside("--link ${c.id}:mdillon-postgis") {
        sh 'mvn --version'
      }
    }
}
pipeline {
  agent {
    label 'maven-docker-postgis'
  }
  stages {
    stage('build') {
      steps {
        sh './mvnw compile'
      }
    }
  }
}
