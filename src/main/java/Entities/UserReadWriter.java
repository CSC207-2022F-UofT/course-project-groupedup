package Entities;

import java.io.*;

public class UserReadWriter implements ReadWriter{

    @Override
    public void saveToFile(String filepath, Object user) throws IOException {
        OutputStream file = new FileOutputStream(filepath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        output.writeObject(user);
        output.close();
    }

    @Override
    public ObjectMap readFromFile(String filepath) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(filepath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        User user = (User) input.readObject();
        input.close();
        return user;
    }
}
