package com.trabalho.reposicao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class User
{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column
    private Long id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String name;

    @Column(name = "user_email", nullable = false, length = 50)
    private String email;

    @Column(name = "user_password", nullable = false, length = 75)
    private String password;
}
