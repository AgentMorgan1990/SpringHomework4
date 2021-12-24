package com.geekbrains.spring.web.repositories;

import com.geekbrains.spring.web.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Modifying
    @Query(value = """
            INSERT INTO users_roles (user_id, role_id)
            VALUES (?1,?2)
             """,
            nativeQuery = true
    )
    void addRoleToUser(Long userId, Long roleId);
}
