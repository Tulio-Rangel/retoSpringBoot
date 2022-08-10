package com.sophos.retoSpringBoot.repository;

import com.sophos.retoSpringBoot.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
    Movement findByMovementId(Long accountId);
    List<Movement> findAllByAccountId(Long accountId);
}
