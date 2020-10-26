package com.closa.data.dao;

import com.closa.data.model.MenuOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface moRepository extends JpaRepository<MenuOption, Long> {
}
