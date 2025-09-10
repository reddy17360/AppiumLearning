pipeline {
    agent any

    tools {
        jdk 'JDK17'   // Make sure JDK17 is configured in Jenkins Tools
    }

    parameters {
        string(name: 'DEVICE_NAME', defaultValue: 'emulator-5554', description: 'Android device/emulator name')
        string(name: 'ANDROID_HOME', defaultValue: '/Users/jenkins/Library/Android/sdk', description: 'Android SDK path')
        choice(name: 'APPIUM_MODE', choices: ['code', 'pipeline'], description: 'How to start Appium: inside test code OR pipeline')
    }

    environment {
            JAVA_HOME = "/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home"
            ANDROID_HOME = "/Users/jenkins/Library/Android/sdk"
            PATH = "${JAVA_HOME}/bin:${ANDROID_HOME}/platform-tools:${ANDROID_HOME}/tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin"
        }

    stages {
        stage('Checkout') {
            steps {
               git branch: 'main', url: 'https://github.com/reddy17360/AppiumLearning.git'

            }
        }

        stage('Verify Environment') {
            steps {
                sh 'java -version'
                sh './gradlew -v'
                sh 'adb version'
                sh 'echo "Using device: $DEVICE_NAME"'
                sh 'echo "Appium mode: $APPIUM_MODE"'
            }
        }

        stage('Start Appium (if pipeline mode)') {
            when { expression { return params.APPIUM_MODE == 'pipeline' } }
            steps {
                sh 'appium --base-path /wd/hub --log-level error &'
                sleep 10 // wait for Appium server to boot
            }
        }

        stage('Build Tests') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Run Tests') {
            steps {
                sh "./gradlew -PdeviceName=$DEVICE_NAME test"
            }
        }

        stage('Stop Appium (if pipeline mode)') {
            when { expression { return params.APPIUM_MODE == 'pipeline' } }
            steps {
                sh 'pkill -f appium || true'
            }
        }

       stage('Reports') {
           steps {
               // Publish TestNG results (requires "TestNG Results Plugin" in Jenkins)
               publishTestNG testNGPattern: 'build/test-output/testng-results.xml'

               // Archive TestNG HTML reports
               archiveArtifacts artifacts: 'build/reports/tests/test/**/*', fingerprint: true
           }
       }

    }
}
