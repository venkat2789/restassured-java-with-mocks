# restassured-java-with-mocks

A starter project and automation framework for api testing, using rest-assured and java. Responses are mocked using Wiremock, to avoid dependency on external apis.

Below are the tech-stack used:

Maven
- manage dependencies and plugins, integrate with CI/CD tools

JUnit4
- runners, annotations, wiremock config etc. Can be easily upgraded to JUnit5.

Wiremock
- used for mocking responses using a mapping json. Files are at: src/test/resources/mappings

Tests
- simple tests validating a response
- tests with RequestSpecification
- tests using GPath to traverse through response JSON and get required values
- tests with Serialization and Deserialization

GIT
- source control and integration options

Jenkins
- integration options using Maven commands

Reports
- native surefire-reports included in xml and txt formats
- can be extended to html report by running appropriate maven commands `mvn site`

Shout out to @basdijkstra for his amazing workshop on Wiremock: https://github.com/basdijkstra/wiremock-workshop. A lot of mapping logic has been borrowed from his workshop.
