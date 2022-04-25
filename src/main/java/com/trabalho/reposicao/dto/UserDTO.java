package com.trabalho.reposicao.dto;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO
{
    private Long id;

    @Length(min = 5, max = 50)
	private String nome;

    @Length(min = 20, max = 50)
	private String email;

    @Length(min = 15, max = 75)
	private String password;
}
