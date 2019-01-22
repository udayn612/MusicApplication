package com.stackroute.service;

import com.stackroute.domain.Music;

import java.util.List;

public interface MusicService {

    public Music saveMusic(Music music);

    public List<Music> getAllMusic();

    public Music updateMusic(Music music,int trackId);

    public List<Music> deleteMusic(int trackId);


}
