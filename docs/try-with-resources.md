## Try-With-Resources Example

Here’s a simple example of a `try-with-resources` block in Java:

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        // Try-with-resources automatically closes resources after the try block.
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Explanation:

- **`try-with-resources`** is used to automatically close resources (e.g., files, database connections) when they are no
  longer needed.
- In the example, the `BufferedReader` resource is declared within the `try` block.
- Once the try block finishes (whether it completes normally or throws an exception), the resource is automatically
  closed, meaning no need to explicitly call `reader.close()`.
- It helps to avoid memory leaks and ensures that resources are properly handled, even in the event of exceptions.

### Requirements:

- The resource must implement the `AutoCloseable` interface, which provides the `close()` method.

<br>
