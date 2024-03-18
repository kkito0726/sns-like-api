package com.ken.snsLike.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ken.snsLike.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

}
