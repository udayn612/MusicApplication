package com.stackroute.controller;

import com.stackroute.Exceptions.TrackAlreadyFoundException;
import com.stackroute.Exceptions.TrackNotFoundException;
import com.stackroute.domain.Music;
import com.stackroute.repository.MusicRepository;
import com.stackroute.service.MusicService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/")
@Api(value="music application",description = "you can add your music search and delete")
public class MusicController {

    MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService)
    {
        this.musicService=musicService;
    }

    @PostMapping("music")
    public ResponseEntity<?> saveMusic(@RequestBody Music music) throws TrackAlreadyFoundException
    {
        ResponseEntity responseEntity;

            musicService.saveMusic(music);
            responseEntity=new ResponseEntity<String>("successfully created", HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("musics")
    public ResponseEntity<?> getAllMusic()
    {
        return new ResponseEntity<List<Music>>(musicService.getAllMusic(),HttpStatus.OK);
    }

    @PutMapping("music/{trackId}")
    public ResponseEntity<?> updateMusic(@RequestBody Music music,@PathVariable("trackId") int trackId) throws TrackAlreadyFoundException
    {
        ResponseEntity responseEntity;

           musicService.saveMusic(music);
           responseEntity=new ResponseEntity<String>("Successfully updated",HttpStatus.OK);


        return responseEntity;
    }


    @DeleteMapping("music/{trackId}")
    public ResponseEntity<?> deleteMusic(@PathVariable("trackId") int trackId) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;

            responseEntity= new ResponseEntity<List<Music>>(musicService.deleteMusic(trackId),HttpStatus.OK);

        return responseEntity;
    }


    @GetMapping("music/{trackId}")
    public ResponseEntity<?> findById(@PathVariable("trackId")int trackId) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;

            responseEntity= new ResponseEntity<Optional<Music>>(musicService.findById(trackId),HttpStatus.OK);
        return responseEntity;

    }

    @GetMapping("musics/{trackName}")
    public ResponseEntity<?> findByName(@PathVariable String trackName)
    {
        return new ResponseEntity(musicService.findByTrackName(trackName),HttpStatus.OK);
    }





}
