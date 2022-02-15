package com.example.demo;

import com.example.demo.model.BoletoEntity;
import com.example.demo.model.LoteEntity;
import com.example.demo.repository.BoletoRepository;
import com.example.demo.repository.LoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collections;
import java.util.Optional;

@ComponentScan(basePackages = { "com.example.demo" })
@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(LoteRepository repository) {
		return (args) -> {
			BoletoEntity boletoEntity = new BoletoEntity();
			boletoEntity.setBoletoId(1L);

			LoteEntity lote1 = new LoteEntity();
			lote1.setLoteId(1L);
			lote1.setValor("200");
			lote1.setBoletos(Collections.singleton(boletoEntity));



			repository.save(lote1);



			log.info("LoteEntity found with findAll():");
			log.info("-------------------------------");
			for (LoteEntity lote : repository.findAll()) {
				log.info(lote.toString());
			}
			log.info("");


			Optional<LoteEntity> boleto = repository.findById(1L);
			log.info("LoteEntity found with findById(1L):");
			log.info("--------------------------------");
			log.info(boleto.toString());
			log.info("");


			log.info("");
		};
	}

}
