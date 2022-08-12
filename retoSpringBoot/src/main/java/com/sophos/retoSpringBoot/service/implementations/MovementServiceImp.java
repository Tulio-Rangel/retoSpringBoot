package com.sophos.retoSpringBoot.service.implementations;

import com.sophos.retoSpringBoot.entity.Movement;
import com.sophos.retoSpringBoot.repository.MovementRepository;
import com.sophos.retoSpringBoot.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementServiceImp implements MovementService {
    @Autowired
    private MovementRepository movementRepository;

    @Override
    public Movement createMovement(Movement movement) {
        return movementRepository.save(movement);
    }

    @Override
    public Movement readMovement(Long movementId) {
        return movementRepository.findByMovementId(movementId);
    }

    @Override
    public Movement readAllMovementByAccountId(Long accountId) {
        return (Movement) movementRepository.findAllByAccountId(accountId);
    }

    @Override
    public Movement updateMovement(Movement movement) {
        return movementRepository.save(movement);
    }

    @Override
    public boolean deleteMovement(Long movementId) {
        if (movementRepository.findByMovementId(movementId).getEstatus().equalsIgnoreCase("Activo")) {
            System.out.println("No se puede eliminar un movimiento activo");
            return false;
        } else {
            movementRepository.deleteById(movementId);
            return true;
        }
    }
}
