package org.runicacorn.dungeon;

import org.runicacorn.dungeon.Monster;
import org.runicacorn.dungeon.MonsterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/monsters")
public class MonstersController {

    private final MonsterRepository monsterRepository;

    public MonstersController(MonsterRepository monsterRepository){
        this.monsterRepository = monsterRepository;
    }

    @GetMapping
    public List<Monster> getMonsters() {
        return monsterRepository.findAll();
    }

    @GetMapping("/{id}")
    public Monster getMonster(@PathVariable Long id){
        return monsterRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createMonster(@RequestBody Monster monster) throws URISyntaxException {
        Monster savedMonster = monsterRepository.save(monster);
        return ResponseEntity.created(new URI("/monsters/" +savedMonster.getId())).body(savedMonster);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMonster(@PathVariable Long id, @RequestBody Monster monster){
        Monster currentMonster = monsterRepository.findById(id).orElseThrow(RuntimeException::new);
        currentMonster.setName(monster.getName());
        currentMonster.setStrength(monster.getStrength());
        currentMonster = monsterRepository.save(monster);

        return ResponseEntity.ok(currentMonster);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMonster(@PathVariable Long id){
        monsterRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
