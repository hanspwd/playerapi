package com.hanspwd.playerapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hanspwd.playerapi.model.Player;

// JpaRepository<Type, ID>
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
    
    Optional<Player> findByUsername(String username);
}
