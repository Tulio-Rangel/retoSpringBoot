package com.sophos.retoSpringBoot.service;

import com.sophos.retoSpringBoot.entity.Movement;

public interface MovementService {
    Movement createMovement(Movement movement);
    Movement readMovement(Long movementId);
    Movement readAllMovementByAccountId(Long accountId);
    Movement updateMovement(Movement movement);
    boolean deleteMovement(Long movementId);
}
