node {
    label 'maven-docker-postgis'
    docker.image('mdillon/postgis:10').withRun('--hostname mdillon-postgis -e "POSTGRES_PASSWORD=example" -e "POSTGRES_DB=test"') { c ->
      docker.image('mdillon/postgis:10').inside() {
        sh 'while ! pg_isready -h mdillon-postgis; do echo "wating potgis to be ready..."; sleep 1; done'
        sh 'echo postgis is ready.'
      }
      docker.image('maven:3-alpine').inside() {
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
