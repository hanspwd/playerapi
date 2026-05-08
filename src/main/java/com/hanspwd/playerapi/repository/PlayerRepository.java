package com.hanspwd.playerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hanspwd.playerapi.model.Player;

// JpaRepository<Type, ID>)
public interface PlayerRepository extends JpaRepository<Player, Long>{
    
}
