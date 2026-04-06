package com.hanspwd.playerapi.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    
    // id, username, level, isBanned, joinDate.
    private int id;

    @NotBlank(message = "Username cannot be blank")
    @NotNull(message = "Username cannot be null")
    @Size(message = "Username must be between 3 and 15 characters", min = 3, max = 15)
    private String username;

    @Min(value = 1, message = "Level cannot be less than 1")
    @Max(value = 100, message = "Level cannot be more than 100")
    @NegativeOrZero(message = "Level cannot be negative")
    private long level;

    private boolean isBanned;

    @Past(message = "Join date cannot be in the future")
    @NotNull(message = "Join date cannot be null")
    private LocalDateTime joinDate;

}
