package projectFinal.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projectFinal.models.dto.ClientDTO;
import projectFinal.models.entity.Client;
import projectFinal.models.form.ClientInsertForm;
import projectFinal.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService  {

    private ClientRepository repository;
    private PasswordEncoder encoder;

    public ClientService() {
        this.repository = repository;
        this.encoder = encoder;
    }

    public List<ClientDTO> getAll(){
        return repository.findAll().stream()
                .map(ClientDTO::of)
                .toList();
    }

    public long insert(ClientInsertForm form){
        Client c = form.toEntity();
        c.setPassword( encoder.encode(c.getPassword()) );
        return repository.save(c).getId();
    }

    public Client findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public Client findByEmail(String email){
        return repository.findByEmail(email);
    }

    public Client save(ClientDTO clientDTO){
        Client client = new Client();
        client.setUsername(clientDTO.getUsername());
        client.setPassword( encoder.encode(clientDTO.getPassword()) );
        client.setEmail(clientDTO.getEmail());
        client.setDateNaissance(clientDTO.getDateNaissance());
        return repository.save(client) ;
    }

    public Client save(Client client){
        return repository.save(client);
    }


}
