pipeline {
  agent { 
    label 'docker'
  }
  stages {
    stage('prepare-db') {
      agent {
        docker {
          image 'mdillon/postgis:10'
          label 'mdillon-postgis'
          args '--name postgis --hostname mdillon-postgis -e "POSTGRES_PASSWORD=example" -e "POSTGRES_DB=test"'
          reuseNode true
        }
        steps {
          sh 'docker exec postgis pg_isready'
        }
      }
    }
    stage('build') {
      steps {
        sh 'echo building'
      }
    }
    stage('test') {
      steps {
        sh 'echo testing'
      }
    }
  }
}
