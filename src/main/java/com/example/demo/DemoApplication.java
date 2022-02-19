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

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@ComponentScan(basePackages = { "com.example.demo" })
@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(LoteRepository repository, BoletoRepository boletoRepository) {
		return (args) -> {
			/*Random random = new Random();

			for (int i = 0; i <= 1000000 ; i++) {
				BoletoEntity bol = new BoletoEntity();
				bol.setValor(new BigDecimal(random.nextInt(1000)));
				boletoRepository.save(bol);
				System.out.println("count : "+ i + " last: 1000000");
			}*/


			/*LoteEntity lote1 = new LoteEntity();
			lote1.setLoteId(1L);
			lote1.setValor("200");
			lote1.setBoletos(Collections.singleton(boletoEntity));
			repository.save(lote1);*/

			Instant start = Instant.now();

			List<BoletoEntity> allBoletos = (List<BoletoEntity>) boletoRepository.findAll();

			List<BoletoEntity> boletosSelecionados = allBoletos.stream()
					.sorted(Comparator.comparing(BoletoEntity::getValor))
					.sorted(Collections.reverseOrder())
					.collect(Collectors.toList());

			boletosSelecionados.forEach(boletoEntity -> System.out.println("valor: "+ boletoEntity.getValor()));

			//ordenado do valor

			Instant end = Instant.now();
			System.out.println("size : " + allBoletos.size());
			System.out.println(Duration.between(start, end));
		};
	}

}
