# assignment-text-parser
Solution for simple text parser assignment. See Assignment.txt for details. Note: program expects correctly formatted text as input, i.e. it won't handle missing or misplaced braces.

## Running the precompiled app
cd to project root directory and run
`java -jar app.jar <text>`
e.g.
`java -jar app.jar "{This is my {homework|assignment}.}"`

## Building using gradle

cd to project root directory and run
`./gradlew buildJar`

## Running tests
In project root directory type
`./gradlew clean test`
