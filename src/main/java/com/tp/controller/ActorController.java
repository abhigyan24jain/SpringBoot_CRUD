package com.tp.controller;

import com.tp.entity.Actor;
import com.tp.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActorController {
    private final ActorService actorService;

    @PostMapping("/create")
    public String addActor(@RequestBody Actor actor) {
        actorService.saveActor(actor);
        return  "Actor created";
    }
    @PutMapping("/update")
    public String updateActorDetails(@RequestParam int id, @RequestBody Actor actor) {
        actorService.updateActorDetails(id, actor);
        return "Actor details updated";
    }
    @DeleteMapping("/delete")
    public String deleteActor(@RequestParam int id) {
        return actorService.deleteActor(id);
    }

    @GetMapping
    public List<Actor> findAllActor() {
        List<Actor> actorList = actorService.findAllActor();
        return actorList;
    }

    @GetMapping("/actors")
    public List<Actor> findAllActorsWithPaginationAndSorting(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo, @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,@RequestParam(value = "sortBy", defaultValue = "actorId", required = false) String sortBy) {
        List<Actor> actorPage = actorService.findAllActorsWithPaginationAndSorting(pageNo, pageSize, sortBy);
        return actorPage;
    }
}
