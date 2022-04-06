package app.bankApp.DBtextformat;

import app.bankApp.Bank;
import app.entities.Client;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.currentThread;

public class ReadClient {
    String path = "C:/Users/NADEZHDA/IdeaProjects/Gradle/src/main/resources/textDB/clients.txt";

    private static ReadClient readClient;
    private ReadClient() {
    }

    public static ReadClient getInstance(){
        if (readClient == null) {
            readClient = new ReadClient();
        }
        return readClient;
    }
    HashMap<String, Client> clientHashMap = new HashMap<>();
    Client client;
    public  void readBD (Bank bank){
        try {
                FileInputStream fi = new FileInputStream(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(fi));
                String currentLine = " ";
            while (null != (currentLine = br.readLine())) {
                client = convertStringToClient(currentLine);
                clientHashMap.put(client.getNickName(), client);

            }
            bank.getBankCollection().getClientHashMap().putAll(clientHashMap);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        }
    public Client convertStringToClient ( String currentLine){
        String[] sp = currentLine.split(" ");
        Client client1 = new Client();
        for (String s : sp){

            getIdandSet(s,client1);
            getNameAndSet(s,client1);
            getLastNameAndSet(s,client1);
            getNickName(s,client1);
            getPassword(s,client1);
        }
        return client1;
    }
    private void getPassword (String s, Client client1){
        if (s!= null && s.contains("password:")){
            client1.setPassword(s.split(":")[1]);
        }
    }
    private void getNickName (String s , Client client1){
        if ( s!= null && s.contains("nickName:")){
            client1.setNickName(s.split(":")[1]);
        }
    }
    private void getLastNameAndSet(String s, Client client1) {
        if ( s!= null && s.contains("lastName:")){
            client1.setLastName(s.split(":")[1]);
        }
    }
    private void getIdandSet(String s, Client client1) {
        if ( s!= null && s.contains("id:")){
            client1.setId(s.split(":")[1]);
        }
    }
    public  void getNameAndSet(String s, Client client1){
        if ( s!= null && s.contains("name:")){
            client1.setUserName(s.split(":")[1]);
        }
    }
}
