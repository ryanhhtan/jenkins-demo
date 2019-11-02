node {
    label 'maven-docker-postgis'
    docker.image('mdillon/postgis:10').withRun('-e "POSTGRES_PASSWORD=example" -e "POSTGRES_DB=test"') { c ->
      docker.image('mdillon/postgis:10').inside("--link ${c.id}:mdillon-postgis") {
        sh 'while ! pg_isready; do echo "wating potgis to be ready..."; sleep 1; done'
        sh 'ehcho postgis is ready.'
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
