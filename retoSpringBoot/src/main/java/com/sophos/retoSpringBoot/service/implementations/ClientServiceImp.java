package com.sophos.retoSpringBoot.service.implementations;

import com.sophos.retoSpringBoot.entity.Client;
import com.sophos.retoSpringBoot.repository.ClientRepository;
import com.sophos.retoSpringBoot.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        //if (LocalDate.now() - client.getBirthday()  > 18) {
            //return clientRepository.save(client);
        //} else {
            //return null;
        //}
        return clientRepository.save(client);
    }

    @Override
    public Client readClient(Long clientId) {
        return clientRepository.findByClientId(clientId);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public boolean deleteClient(Long clientId) {
        if (clientRepository.findByClientId(clientId).getAccounts().size() > 0) {
            System.out.println("No se puede eliminar este cliente porque tiene al menos una cuenta");
            return false;
        } else {
            clientRepository.deleteById(clientId);
            return true;
        }

    }
}
