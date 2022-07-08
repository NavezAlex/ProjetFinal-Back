package projectFinal.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projectFinal.models.dto.ClientDTO;
import projectFinal.models.entity.Client;
import projectFinal.models.form.ClientInsertForm;
import projectFinal.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;
    private final PasswordEncoder encoder;

    public ClientService(ClientRepository repository, PasswordEncoder encoder) {
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
}
