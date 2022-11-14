package Entities;

import group_creation_use_case.GroupRegisterDSRequestModel;

import java.io.*;
import java.util.HashMap;

public class GroupReadWriter implements ReadWriter<HashMap<String, Group>>{
    @Override
    public void saveToFile(String filepath, HashMap<String, Group> groups) throws IOException {
        OutputStream file = new FileOutputStream(filepath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        output.writeObject(groups);
        output.close();
        buffer.close();
        file.close();
    }

    @Override
    public HashMap<String, Group> readFromFile(String filepath) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(filepath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        HashMap<String, Group> groups = (HashMap<String, Group>) input.readObject();

        input.close();
        buffer.close();
        file.close();
        return groups;
    }
}
