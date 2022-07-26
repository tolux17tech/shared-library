def call () {
    sh "mvn package"
    echo "Building gv script"
    echo "My name is ${Name}"
    echo "My name is ${params.type}"
}