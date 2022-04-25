package com.trabalho.reposicao.service;

import java.util.List;
import java.util.Optional;

import com.trabalho.reposicao.dto.UserDTO;
import com.trabalho.reposicao.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll()
    {
        return userRepository.findAll();
    }

    public UserDTO findById(Long id)
    {
        Optional<UserDTO> user = userRepository.findById(id);
        
        if(!user.isPresent())
        {
            return null;
        }

        return user.get();
    }

    public UserDTO create(UserDTO user)
    {
        return userRepository.save(user);
    }

    public boolean update(UserDTO user)
    {
        if(!userRepository.existsById(user.getId()))
        {
            return false;
        }

        userRepository.save(user);

        return true;
    }

    public boolean delete(Long id)
    {
        if(!userRepository.existsById(id))
        {
            return false;
        }

        userRepository.deleteById(id);

        return true;
    }
}
