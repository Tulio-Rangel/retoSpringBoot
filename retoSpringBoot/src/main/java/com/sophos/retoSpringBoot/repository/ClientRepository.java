package com.sophos.retoSpringBoot.repository;

import com.sophos.retoSpringBoot.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByClientId(Long clientId);

}
