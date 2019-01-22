package com.stackroute.service;

import com.stackroute.domain.Music;
import com.stackroute.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Music saveMusic(Music music) {
       Music savedMusic=musicRepository.save(music);

       return savedMusic;
    }

    @Override
    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    @Override
    public Music updateMusic(Music music,int trackId)
    {
        Music updateMusic=musicRepository.save(music);
        return updateMusic;
    }

    @Override
    public List<Music> deleteMusic(int trackId)
    {
        musicRepository.deleteById(trackId);
        return musicRepository.findAll();
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
