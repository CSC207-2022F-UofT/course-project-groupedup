package Entities;

import java.io.*;
import java.util.HashMap;

public class UserReadWriter implements ReadWriter<HashMap<String, User>>{

    @Override
    public void saveToFile(String filepath, HashMap<String, User> users) throws IOException {
        OutputStream file = new FileOutputStream(filepath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        output.writeObject(users);
        output.close();
    }

    @Override
    public HashMap<String, User> readFromFile(String filepath) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(filepath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        HashMap<String, User> users = (HashMap<String, User>) input.readObject();
        input.close();
        return users;
    }
}
