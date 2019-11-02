pipeline {
  agent none
  stages {
    stage('prepare-db') {
      agent {
        docker {
          image 'mdillon/postgis:10'
          args '--name postgis --hostname mdillon-postgis -e "POSTGRES_PASSWORD=example" -e "POSTGRES_DB=test"'
          reuseNode true
        }
      }
      steps {
        sh 'docker exec postgis pg_isready'
      }
    }
    stage('build') {
      agent {
        docker {
          image 'maven:3-alpine'
          label 'maven'
          reuseNode true
        }
      }
      steps {
        sh 'docker exec postgis pg_isready'
        sh 'mvn --version'
      }
    }
    stage('test') {
      steps {
        sh 'echo testing'
      }
    }
  }
}
