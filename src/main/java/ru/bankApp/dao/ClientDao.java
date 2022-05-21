package ru.bankApp.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bankApp.app.entities.Client;
import java.util.List;

@Component
public class ClientDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> allClients(){
            return jdbcTemplate.query("SELECT * FROM client", new BeanPropertyRowMapper<>(Client.class));
        }

        public  void add(Client client){
            jdbcTemplate.update("INSERT INTO client(username,lastname,age,addressee,mobilephone,email,password) VALUES(?,?,0,?,?,?,?)",
              client.getUserName(),client.getLastName(),client.getAddressee(),client.getMobilePhone(),client.geteMail(),client.getPassword());
        }

        public  Client  getByPhone (String phone){
        return jdbcTemplate.query("SELECT * FROM client WHERE mobilephone=?", new Object[]{phone},new BeanPropertyRowMapper<>(Client.class))
                .stream().findAny().orElse(null);

        }

        public Client getById(int id){
        return jdbcTemplate.query("SELECT * FROM client WHERE id=?", new Object[]{id},new BeanPropertyRowMapper<>(Client.class))
                .stream().findAny().orElse(null);
        }

        public void upDate(int id, Client client){
           jdbcTemplate.update("UPDATE client SET addressee=?, username=?,lastname=?,mobilephone=?,email=?,age = ? WHERE id=?",
                   client.getAddressee(), client.getUserName(),client.getLastName(),client.getMobilePhone(),client.geteMail(),client.getAge(), id);
        }
        public void delete(int id){
           jdbcTemplate.update("DELETE FROM client WHERE id=?", id);

        }

}
