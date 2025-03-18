package org.example.javatokoltintest250318.repository;

import org.example.javatokoltintest250318.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
