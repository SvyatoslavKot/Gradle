package app.bankApp.DBtextformat;

import app.bankApp.Bank;
import app.entities.Client;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.currentThread;

/**
 * @author S. Kotov
 * class for reading client data from file .txt format
 * pattern Singleton
 */
public class ReadClient {
    /**
     * path to data file
     */
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
    //создаем коллекцию для хранения полученных данных
    HashMap<String, Client> clientHashMap = new HashMap<>();//создаем локальную коллекцию hashmap
    Client client;

    /**
     * method reading data from file
     * @param bank
     * @exception FileNotFoundException,IOException
     */
    public  void readBD (Bank bank){
        try {//устанавливаем связь с файлом
                FileInputStream fi = new FileInputStream(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(fi));
                String currentLine = " ";

                while (null != (currentLine = br.readLine())) {// если файл не пустой то читаем по строчно данные
                client = convertStringToClient(currentLine);//создаем объект на основе прочитанной строки
                clientHashMap.put(client.getNickName(), client);//помещаем объект в мапу
            }
            bank.getBankCollection().getClientHashMap().putAll(clientHashMap);//объединяем коллекции
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        }

    /**
     * method that converts currentLine to Client object
     * @param currentLine
     * @return Client
     */
    public Client convertStringToClient ( String currentLine){
        String[] sp = currentLine.split(" ");//разделяем строку по пробелам
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
        if (s!= null && s.contains("password:")){       //
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
