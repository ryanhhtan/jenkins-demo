pipeline {
  agent {
    docker {
      image 'docker:dind'
      args '-v /var/run/docker.sock:/var/run/docker.sock'
      reuseNode true
    }
  }
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
        sh 'while ! docker run --rm mdillon/postgis:10k pg_isready -h mdillon-postgis; do echo "waiting postgis ready..."; sleep 1; done'
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
