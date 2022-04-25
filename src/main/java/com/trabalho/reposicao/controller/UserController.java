package com.trabalho.reposicao.controller;

import java.util.List;

import javax.validation.Valid;

import com.trabalho.reposicao.dto.UserDTO;
import com.trabalho.reposicao.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1/user")
public class UserController implements ControllerInterface<UserDTO>
{
    @Autowired
    private UserService userService;

    @Override
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id)
    {
        UserDTO user = userService.findById(id);

        if(user != null)
        {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<UserDTO> post(@RequestBody UserDTO userParam) throws URISyntaxException
    {
        UserDTO user = userService.create(userParam);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).body(user);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@Valid @RequestBody UserDTO user)
    {
        if(userService.update(user))
        {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Long id)
    {
        if(userService.delete(id))
        {
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
