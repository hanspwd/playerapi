package com.hanspwd.playerapi.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    
    // id, username, level, isBanned, joinDate.
    private int id;
    private String username;
    private long level;
    private boolean isBanned;
    private LocalDateTime joinDate;

}
