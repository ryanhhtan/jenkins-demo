pipeline {
  agent none
  stages {
    stage('prepare') {
      agent {
        docker {
          image 'mdillon/postgis:10'
          args '-v /var/run/docker.sock:/var/run/docker.sock --hostname mdillon-postgis -e "POSTGRES_PASSWORD=example" -e "POSTGRES_DB=test"'
          reuseNode true
        }
      }
      steps {
        sh 'docker run --rm mdillon/postgis:10 pg_isready -h mdillon-postgis'
        sh 'echo postgis is up and running.'
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
        sh 'ping -c 1 mdillon-postgis'
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
