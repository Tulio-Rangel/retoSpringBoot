package com.sophos.retoSpringBoot.service;

import com.sophos.retoSpringBoot.entity.Client;

public interface ClientService {
    Client createClient(Client client);
    Client readClient(Long clientId);
    Client updateClient(Client client);
    void deleteClient(Long clientId);
}
