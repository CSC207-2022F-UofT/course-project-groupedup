package Entities;

import java.io.*;

public class UserIDMapReadWriter implements ReadWriter{
    @Override
    public void saveToFile(String filepath, Object userIDMap) throws IOException {
        OutputStream file = new FileOutputStream(filepath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        output.writeObject(userIDMap);
        output.close();
    }

    @Override
    public ObjectMap readFromFile(String filepath) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(filepath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        UserIDMap userIDMap = (UserIDMap) input.readObject();
        input.close();
        return userIDMap;
    }
}
