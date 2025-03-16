# Algorithm-API

This Spring Boot-based API provides RESTful endpoints to showcase common algorithm implementations, offering developers a simple and efficient way to interact with well-known algorithms. The API includes implementations of fundamental algorithms used in computer science and software engineering, such as Graph Traversal (BFS), Sorting (QuickSort), and Searching (Binary Search). These algorithms are essential for solving various computational problems and are widely used in software development

## 🚀 Features
- **Graph Traversal:** BFS (Breadth-First Search) for traversing graph data.
- **Sorting:** Quicksort algorithm for sorting arrays.
- **Searching:** Binary Search for efficient element lookup.
- Handles invalid input gracefully with meaningful error messages.
- Built using Spring Boot framework to create a RESTful API.

## Technologies Used:
- Spring Boot: A powerful framework for building Java-based RESTful web services quickly and with minimal configuration.
- Java: The primary programming language for implementing the algorithms and API.
- Maven: Dependency management and build automation.

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
├───.mvn
│   └───wrapper
│           maven-wrapper.jar
│           maven-wrapper.properties
│
└───src
   ├───main
   │   ├───java
   │   │   └───com
   │   │       └───example
   │   │           └───algorithmapi
   │   │               │   AlgorithmAPIApplication.java
   │   │               │
   │   │               ├───config
   │   │               ├───controller
   │   │               │       AlgorithmController.java
   │   │               │
   │   │               ├───model
   │   │               │       LogEntry.java
   │   │               │
   │   │               ├───repository
   │   │               │       LogRepository.java
   │   │               │
   │   │               └───service
   │   │                       AlgorithmService.java
   │   │
   │   └───resources
   │       └───application.properties
   │       
   │       
   │       
   └───test
       └───java
           └───com
               └───example
                   └───algorithmapi
                           AlgorithmAPIApplicationTests.java

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

