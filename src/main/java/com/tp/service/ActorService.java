package com.tp.service;

import com.tp.entity.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ActorService {

    void saveActor(Actor actor);

    void updateActorDetails(int id, Actor actor);

    String deleteActor(int id);

    List<Actor> findAllActor();

    List<Actor> findAllActorsWithPaginationAndSorting(int pageNo, int pageSize, String sortBy);
}
