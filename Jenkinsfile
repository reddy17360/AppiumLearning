pipeline {
    agent any

    tools {
        jdk 'JDK17' // Make sure JDK17 is configured in Jenkins Tools
    }

    parameters {
        string(name: 'DEVICE_NAME',  description: 'Android device/emulator name', defaultValue: 'emulator-5554')
        string(name: 'PLATFORM_VERSION', description: 'Android/iOS platform version', defaultValue: '11')
        choice(name: 'APPIUM_MODE', choices: ['code', 'pipeline'], description: 'How to start Appium: inside test code OR pipeline')
        booleanParam(name: 'USE_BROWSERSTACK', defaultValue: true, description: 'Run tests on BrowserStack?')
    }

    environment {
        ANDROID_HOME = "/Users/sanjeevareddysj/Library/Android/sdk"
        PATH = "/opt/homebrew/bin:${JAVA_HOME}/bin:${ANDROID_HOME}/platform-tools:${ANDROID_HOME}/tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/reddy17360/AppiumLearning.git'
            }
        }

        stage('Verify Environment') {
            steps {
                sh 'echo "JAVA_HOME=$JAVA_HOME"'
                sh 'echo "ANDROID_HOME=$ANDROID_HOME"'
                sh 'java -version'
                sh './gradlew -v'
                sh 'adb version'
                sh 'echo "Using device: $DEVICE_NAME"'
                sh 'echo "Platform version: $PLATFORM_VERSION"'
                sh 'echo "Appium mode: $APPIUM_MODE"'
                sh 'echo "Run on BrowserStack: $USE_BROWSERSTACK"'
            }
        }

        stage('Start Appium (if pipeline mode)') {
            when { expression { return params.APPIUM_MODE == 'pipeline' } }
            steps {
                sh 'echo "Starting Appium..."'
                sh 'nohup appium --base-path /wd/hub --log-level error > appium.log 2>&1 &'
                sh 'sleep 10'
            }
        }

        stage('Build Tests') {
            steps {
                sh './gradlew clean build -x test'
            }
        }

        stage('Run Tests') {
            steps {
                withCredentials([
                    string(credentialsId: 'BROWSERSTACK_USERNAME', variable: 'BROWSERSTACK_USERNAME'),
                    string(credentialsId: 'BROWSERSTACK_ACCESS_KEY', variable: 'BROWSERSTACK_ACCESS_KEY')
                ]) {
                    sh """
                        ./gradlew clean testBrowserStack \
                        -DUSE_BROWSERSTACK=${params.USE_BROWSERSTACK} \
                        -DdeviceName=${params.DEVICE_NAME} \
                        -DplatformVersion=${params.PLATFORM_VERSION}
                    """
                }
            }
        }

        stage('Stop Appium (if pipeline mode)') {
            when { expression { return params.APPIUM_MODE == 'pipeline' } }
            steps {
                sh 'echo "Stopping Appium..."'
                sh 'pkill -f appium || true'
            }
        }

        stage('Verify Report Folder') {
            steps {
                sh 'ls -l ExtentReports/reports'
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'ExtentReports/reports',
                    reportFiles: 'index.html',
                    reportName: 'Extent Report'
                ])
            }
        }
    }
}
