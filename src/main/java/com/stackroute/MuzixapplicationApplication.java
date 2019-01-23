package com.stackroute;

import com.stackroute.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:app2.properties")
public class MuzixapplicationApplication{

	@Autowired
	MusicRepository musicRepository;

	@Value("${musicId}")
	private int trackId;
	@Value("${musicName}")
	private String trackName;
	@Value("${musicComment}")
	private String trackComment;

	public static void main(String[] args) {
		SpringApplication.run(MuzixapplicationApplication.class, args);
	}

	

}

