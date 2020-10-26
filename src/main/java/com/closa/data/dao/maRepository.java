package com.closa.data.dao;

import com.closa.data.model.MenuApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface maRepository extends JpaRepository<MenuApp, Long > {
}
