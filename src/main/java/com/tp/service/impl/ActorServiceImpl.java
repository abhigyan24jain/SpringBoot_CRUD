package com.tp.service.impl;

import com.tp.entity.Actor;
import com.tp.repository.ActorRepository;
import com.tp.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;

    @Override
    public void saveActor(Actor actor) {
        actorRepository.save(actor);
    }


    @Override
    public void updateActorDetails(int id, Actor actor){
        Optional<Actor> actor1 = actorRepository.findById(id);
        if (actor1.isPresent()) {
            Actor actor2 = actor1.get();
            System.out.println("Actor Before Update: " + actor2);
            actor2.setActorName(actor.getActorName());
            actor2.setMovieName(actor.getMovieName());
            actor2.setMovieCollection(actor.getMovieCollection());
            actorRepository.save(actor2);
            Optional<Actor> actor3 = actorRepository.findById(id);
            System.out.println("Actor After Update: " + actor3);
        }

    }

    @Override
    public String deleteActor(int id) {
        actorRepository.deleteById(id);
        return "Actor Deleted Successfully";
    }

    @Override
    public List<Actor> findAllActor() {
        return actorRepository.findAll();
    }

    @Override
    public List<Actor> findAllActorsWithPaginationAndSorting(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        return actorRepository.findAll(pageable).getContent();
    }
}
