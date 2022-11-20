package Entities;

import group_creation_use_case.GroupRegisterDSRequestModel;

import java.io.*;
import java.util.HashMap;

public class GroupReadWriter implements ReadWriter<HashMap<String, Group>>{
    /**
     * Serializes a hashmap (key: group name, value: Group object) of all the system's existing Groups to the filepath
     * @param filepath of the file that Groups will be saved to
     * @param groups the hashmap of Groups to be saved
     * @throws IOException
     */
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

    /**
     *
     * @param filepath of the file that the hashmap of Groups will be fetched from
     * @return a hashmap (key: group name, value: Group object) of all the existing Groups in the system
     * @throws IOException
     * @throws ClassNotFoundException
     */
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
