package org.runicacorn.dungeon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster, Long> {
}
