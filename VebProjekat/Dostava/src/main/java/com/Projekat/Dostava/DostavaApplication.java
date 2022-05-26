package com.Projekat.Dostava;

import com.Projekat.Dostava.entity.*;
import com.Projekat.Dostava.repository.ArtikalRepository;
import com.Projekat.Dostava.repository.KorisnikRepository;
import com.Projekat.Dostava.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DostavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DostavaApplication.class, args);
	}

}
