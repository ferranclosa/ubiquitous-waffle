package com.closa.data.dao;


import com.closa.data.model.MenuGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface mgRepository extends JpaRepository<MenuGroup, Long > {
    Optional<MenuGroup> findByMgCode(String mgCode);
}
