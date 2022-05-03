package app.bankApp.DBtextformat;

import app.bankApp.Bank;
import app.entities.Client;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.currentThread;

public class WriteClient {

    private static WriteClient bdWriteClient;
    String path = "C:/Users/NADEZHDA/IdeaProjects/Gradle/src/main/resources/textDB/clients.txt";

    private WriteClient() {
    }

    public static WriteClient getInstance(){
        if (bdWriteClient == null) {
            bdWriteClient = new WriteClient();
        }
        return bdWriteClient;
    }

    Client client;
    public void writeClient (Bank bank)  {
        File file = new File(path);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path),"utf-8"));
            bufferedWriter.write("");
            HashMap<String, Client> clientHashMap = bank.getBankCollection().getClientHashMap();
            for (Map.Entry entry : clientHashMap.entrySet()) {
                client = (Client) entry.getValue();
                bufferedWriter.write("name:" + client.getUserName() + " ");
                bufferedWriter.write("lastName:" + client.getLastName() + " ");
                bufferedWriter.write("nickName:" + client.getNickName() + " ");
                bufferedWriter.write("phone:" + client.getMobilePhone() + " ");
                bufferedWriter.write("password:" + client.getPassword() + " ");
                bufferedWriter.write("id:" + client.getId() + " ");
                bufferedWriter.write("\n");

                bufferedWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
