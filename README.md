# Algorithm-API

This is a Spring Boot-based API that provides implementations for common algorithms such as graph traversal (BFS), sorting (Quicksort), and searching (Binary Search).

## 🚀 Features
- **Graph Traversal:** BFS (Breadth-First Search) for traversing graph data.
- **Sorting:** Quicksort algorithm for sorting arrays.
- **Searching:** Binary Search for efficient element lookup.
- Handles invalid input gracefully with meaningful error messages.
- Built using Spring Boot framework to create a RESTful API.

## 📂 Project Structure
```
Algorithm-API
│   .gitattributes
│   .gitignore
│   HELP.md
│   mvnw
│   mvnw.cmd
│   pom.xml
│
├───.idea
│       .gitignore
│       compiler.xml
│       encodings.xml
│       jarRepositories.xml
│       misc.xml
│       uiDesigner.xml
│       vcs.xml
│       workspace.xml
│
├───.mvn
│   └───wrapper
│           maven-wrapper.jar
│           maven-wrapper.properties
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───example
│   │   │           └───algorithmapi
│   │   │               │   AlgorithmAPIApplication.java
│   │   │               │
│   │   │               ├───config
│   │   │               ├───controller
│   │   │               │       AlgorithmController.java
│   │   │               │
│   │   │               ├───model
│   │   │               │       LogEntry.java
│   │   │               │
│   │   │               ├───repository
│   │   │               │       LogRepository.java
│   │   │               │
│   │   │               └───service
│   │   │                       AlgorithmService.java
│   │   │
│   │   └───resources
│   │       │   application.properties
│   │       │
│   │       ├───static
│   │       └───templates
│   └───test
│       └───java
│           └───com
│               └───example
│                   └───algorithmapi
│                           AlgorithmAPIApplicationTests.java
│
└───target
    │   Algorithm-API-0.0.1-SNAPSHOT.jar
    │   Algorithm-API-0.0.1-SNAPSHOT.jar.original
    │
    ├───classes
    │   │   application.properties
    │   │
    │   └───com
    │       └───example
    │           └───algorithmapi
    │               │   AlgorithmAPIApplication.class
    │               │
    │               ├───controller
    │               │       AlgorithmController.class
    │               │
    │               ├───model
    │               │       LogEntry.class
    │               │
    │               ├───repository
    │               │       LogRepository.class
    │               │
    │               └───service
    │                       AlgorithmService.class
    │
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    ├───maven-archiver
    │       pom.properties
    │
    ├───maven-status
    │   └───maven-compiler-plugin
    │       ├───compile
    │       │   └───default-compile
    │       │           createdFiles.lst
    │       │           inputFiles.lst
    │       │
    │       └───testCompile
    │           └───default-testCompile
    │                   createdFiles.lst
    │                   inputFiles.lst
    │
    ├───surefire-reports
    │       2025-03-17T00-53-21_310.dumpstream
    │       com.example.algorithmapi.AlgorithmAPIApplicationTests.txt
    │       TEST-com.example.algorithmapi.AlgorithmAPIApplicationTests.xml
    │
    └───test-classes
        └───com
            └───example
                └───algorithmapi
                        AlgorithmAPIApplicationTests.class
```

## 🛠️ Setup and Running Instructions
1. **Clone the repository:**
```bash
git clone https://github.com/SakshithBillava/Algorithm-API.git
```

2. **Navigate to the project directory:**
```bash
cd Algorithm-API
```

3. **Build the project:**
```bash
./mvnw clean install
```

4. **Run the project:**
```bash
./mvnw spring-boot:run
```


## Endpoints and Usage
 
1. 🔍 Binary Search
- Endpoint: POST /api/binary-search
- Request:
  ```jason
  [1, 2, 3, 4, 5, 6, 7]
  ```
Example: 
```bash
curl -X POST http://localhost:8080/binary-search?target=5 \
-H "Content-Type: application/json" \
-d '[1, 2, 3, 4, 5, 6, 7]'
```
Response:
```jason
4
```

2. 📊 Quicksort
- Endpoint: POST /api/quicksort
- Request:
  ```jason
  [5, 3, 8, 6, 2, 7]
  ```
Example: 
```bash
curl -X POST http://localhost:8080/quick-sort \
-H "Content-Type: application/json" \
-d '[5, 3, 8, 6, 2, 7]'
```
Response:
```jason
[2, 3, 5, 6, 7, 8]
```
 
3. 🧭 BFS (Breadth-First Search)
- Endpoint: POST /api/bfs
- Request:
  ```jason
  {
  "A": ["B", "C"],
  "B": ["D", "E"],
  "C": ["F"],
  "D": [],
  "E": ["F"],
  "F": []
  }
  ```
Example: 
```bash
curl -X POST http://localhost:8080/bfs?start=A \
-H "Content-Type: application/json" \
-d '{
  "A": ["B", "C"],
  "B": ["D", "E"],
  "C": ["F"],
  "D": [],
  "E": ["F"],
  "F": []
}'
```
Response:
```jason
["A", "B", "C", "D", "E","F"]
```

## ✅ Future Improvements
- Add more algorithms (like DFS, Merge Sort, etc.)
- Improve performance and edge case handling

## License
This project is licensed under the [MIT License](./LICENSE).

