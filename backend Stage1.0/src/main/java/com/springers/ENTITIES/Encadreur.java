package com.springers.ENTITIES;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level=AccessLevel.PRIVATE)
@Builder
@Table(name = "encadreur")
public class Encadreur {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "encadreur_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;
}
