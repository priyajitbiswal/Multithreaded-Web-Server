# MultithreadedWebServer

A Java project demonstrating different web server architectures: single-threaded, multithreaded, and thread pool-based. Each implementation is organized in its own directory for clarity and comparison.

## Project Structure

* `SingleThreaded/`

  * `Client.java`: A simple client implementation for testing the single-threaded server.
  * `Server.java`: A single-threaded server that processes requests sequentially.

* `Multithreaded/`

  * `Client.java`: A client implementation for testing the multithreaded server.
  * `Server.java`: A multithreaded server where each incoming connection is handled by a new thread.

* `ThreadPool/`

  * `Server.java`: A server implementation using a thread pool to efficiently manage a fixed number of threads for handling multiple client requests.

* `Test Plan.jmx`

  * A JMeter test plan for benchmarking and comparing the performance of the different server implementations.

## Features

* **SingleThreaded Server**: Processes requests one at a time, suitable for understanding basic server-client communication.
* **Multithreaded Server**: Handles multiple requests concurrently, demonstrating the use of threads in Java.
* **ThreadPool Server**: Optimizes resource usage by reusing a fixed number of threads, ideal for high-performance scenarios.

## How to Run

1. **Compile**
   Navigate to the desired implementation directory and compile the Java files:

   ```bash
   javac Server.java Client.java
   ```

2. **Start the Server**
   Run the server in the desired implementation directory:

   ```bash
   java Server
   ```

3. **Run the Client**
   In a separate terminal, execute the client:

   ```bash
   java Client
   ```

4. **Performance Testing**
   Open `Test Plan.jmx` in [Apache JMeter](https://jmeter.apache.org/) and configure the test plan to benchmark the server implementations.

## Requirements

* Java 8 or higher
* (Optional) [Apache JMeter](https://jmeter.apache.org/) for running the test plan

## Performance Comparison

Use the JMeter test plan to evaluate:

* Response time
* Throughput
* Resource utilization

## License

This project is for educational purposes.

