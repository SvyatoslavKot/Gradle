package ru.bankApp.service;

import org.hibernate.criterion.NotNullExpression;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;
import ru.bankApp.app.bankApp.exeption.ClientAddExeption;
import ru.bankApp.app.entities.Client;
import ru.bankApp.dao.ClientDao;

import java.util.List;

@Service
public class ClientService {


    ClientDao clientDao;

    public ClientService(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void addClient (Client client) throws ClientAddExeption {
        if (clientDao.getByPhone(client.getMobilePhone())!= null){
            throw  new ClientAddExeption("Клиент с таким телефоном создан!");
        }
            clientDao.add(client);

    }
    public Client getByPhone (String phone ){
       return clientDao.getByPhone(phone);
    }

    public  Client  getById (int id){
        return clientDao.getById(id);
    }

    public List<Client> getAllClient () {
       return clientDao.allClients();
    }
    public void upDate( Client client){
        clientDao.upDate(client.getId(), client);
    }

    public void delete (int id){
        clientDao.delete(id);
    }

    public Client checkPassword(String phone, String password) throws ClientAddExeption{
        Client client;
        if (getByPhone(phone)!=null){
            client = getByPhone(phone);
            if (client.getPassword().equals(password)){
                return client;
            } else return null;
        }else throw new ClientAddExeption("Клиента с таким номером телефона не существует");
    }
}
