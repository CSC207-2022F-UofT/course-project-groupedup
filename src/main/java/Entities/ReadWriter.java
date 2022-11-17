package Entities;

import java.io.IOException;

public interface ReadWriter<T> {
    void saveToFile(String filepath, T o) throws IOException;

    T readFromFile(String filepath) throws IOException, ClassNotFoundException;
}
