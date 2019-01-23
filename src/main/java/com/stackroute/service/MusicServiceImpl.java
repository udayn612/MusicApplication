package com.stackroute.service;

import com.stackroute.Exceptions.TrackAlreadyFoundException;
import com.stackroute.Exceptions.TrackNotFoundException;
import com.stackroute.domain.Music;
import com.stackroute.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService {

    MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Music saveMusic(Music music) throws TrackAlreadyFoundException {

        if(musicRepository.existsById(music.getTrackId()))
        {
            throw new TrackAlreadyFoundException("track already exists");
        }
       Music savedMusic=musicRepository.save(music);

        if(savedMusic==null)
        {
            throw new TrackAlreadyFoundException("track does not exists");
        }

       return savedMusic;
    }

    @Override
    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    @Override
    public Music updateMusic(Music music,int trackId) throws TrackNotFoundException
    {
        if(!musicRepository.existsById(trackId))
        {
            throw new TrackNotFoundException("track to update doesnt exists try posting first");
        }

        Music updateMusic=musicRepository.save(music);

        if(updateMusic==null)
        {
            throw new TrackNotFoundException("track doesnt exists");
        }
        return updateMusic;
    }

    @Override
    public List<Music> deleteMusic(int trackId) throws TrackNotFoundException
    {
        if(!musicRepository.existsById(trackId))
        {
            throw new TrackNotFoundException("track to delete doesnt exists");
        }

        musicRepository.deleteById(trackId);

        return musicRepository.findAll();
    }

    @Override
    public Optional<Music> findById(int trackId) throws TrackNotFoundException {
        if(!musicRepository.existsById(trackId))
        {
            throw new TrackNotFoundException("track your are searching doesnt exists");
        }
       Optional<Music> music= musicRepository.findById(trackId);

        if(music==null)
        {
            throw new TrackNotFoundException("track doesnt exists");
        }
       return music;


    }

    @Override
   public List<Music> findByTrackName(String trackName)
    {
       return musicRepository.findByTrackName(trackName);

    }

//
//    @Override
//    public Music updateMusic() {
//        return null;
//    }
//
//    @Override
//    public Music deleteMusic() {
//        return null;
//    }
}
