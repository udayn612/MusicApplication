package com.stackroute.controller;

import com.stackroute.domain.Music;
import com.stackroute.repository.MusicRepository;
import com.stackroute.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
public class MusicController {

    MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService)
    {
        this.musicService=musicService;
    }

    @PostMapping("music")
    public ResponseEntity<?> saveMusic(@RequestBody Music music)
    {
        ResponseEntity responseEntity;
        try
        {
            musicService.saveMusic(music);
            responseEntity=new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @GetMapping("musics")
    public ResponseEntity<?> getAllMusic()
    {
        return new ResponseEntity<List<Music>>(musicService.getAllMusic(),HttpStatus.OK);
    }

    @PutMapping("music/{trackId}")
    public ResponseEntity<?> updateMusic(@RequestBody Music music,@PathVariable("trackId") int trackId)
    {
        ResponseEntity responseEntity;

        try
        {
           musicService.saveMusic(music);
           responseEntity=new ResponseEntity<String>("Successfully updated",HttpStatus.OK);
        }
        catch(Exception e)
        {
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @DeleteMapping("music/{trackId}")
    public ResponseEntity<?> deleteMusic(@PathVariable("trackId") int trackId)
    {
        ResponseEntity responseEntity;

        try
        {
            responseEntity= new ResponseEntity<List<Music>>(musicService.deleteMusic(trackId),HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @GetMapping("music/{trackId}")
    public ResponseEntity<?> findById(@PathVariable("trackId")int trackId)
    {
        return new ResponseEntity(musicService.findById(trackId),HttpStatus.OK);

    }



}
