package com.hanspwd.playerapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 3, max = 30, message = "the username must be between 3 and 30 characters.")
    @NotNull(message = "the username cannot be null.")
    private String username;

    @Column(nullable = false)
    @NotNull(message = "the level cannot be null.")
    @Min(0)
    @Max(100)
    private Integer level;

    @Enumerated(EnumType.STRING) 
    @Column(nullable = false)
    @NotNull(message = "the username cannot be null.")
    private Rol rol;

    // TODO: Implementar una lista de algo que el player pueda poseer por EJ: logros.

}
