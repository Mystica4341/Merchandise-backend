package com.mirera.merchandise.infrastructure.repository;

import com.mirera.merchandise.application.port.outbound.users.UserRepository;

public class UserReposityImpl implements UserRepository {
    @Override
    public void saveUser(Users user) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void deleteUser(Users user) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void deleteUserById(int userId)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Users findUserById(String userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean existsByUsername(String username) {
        // TODO Auto-generated method stub
        return false;
    }
}
