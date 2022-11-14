package Entities;

import group_creation_use_case.GroupRegisterDSRequestModel;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class GroupIDMapReadWriter implements ReadWriter<HashMap<Integer, String>>{
    @Override
    public void saveToFile(String filepath, HashMap<Integer, String> groupIDMap) throws IOException {
        try{
            FileOutputStream file = new FileOutputStream(filepath);
            //OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(file);

            //output.writeObject(groupIDMap);
            Tuple<Integer, String> item;

            for (Integer key : groupIDMap.keySet()){
                item = new Tuple<Integer, String>(key, groupIDMap.get(key));
                output.writeObject(item);
            }
            //output.flush();
            output.close();
            //buffer.close();
            //file.close();
        }catch(Exception e){
            System.out.println("i hate this 1");
        }

    }

    @Override
    public HashMap<Integer, String> readFromFile(String filepath) throws IOException, ClassNotFoundException {
        try{
            FileInputStream file = new FileInputStream(filepath);
            //InputStream buffer = new BufferedInputStream(file);
            ObjectInputStream input = new ObjectInputStream(file);

            HashMap<Integer, String> groupIDMap = new HashMap<Integer,String>();
            Tuple<Integer, String> item;
            while ((item = (Tuple<Integer, String>) input.readObject()) != null){
                groupIDMap.put(item.key, item.value);
            }
            input.close();
            //buffer.close();
            //file.close();
            return groupIDMap;
        }catch(Exception e){
            System.out.println("i hate this 2");
            return new HashMap<Integer, String>();
        }

    }
}
