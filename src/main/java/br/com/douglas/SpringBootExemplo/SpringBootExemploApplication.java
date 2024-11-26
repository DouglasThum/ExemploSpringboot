package br.com.douglas.SpringBootExemplo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.douglas.domain.Cliente;
import br.com.douglas.repositories.IClienteRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "br.com.douglas.repositories")
@EntityScan("br.com.douglas.*")
@ComponentScan(basePackages = "br.com.douglas")
public class SpringBootExemploApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootExemploApplication.class);
	
	@Autowired
	private IClienteRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootExemploApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		Cliente cliente = createCliente();
		repository.save(cliente);	
	}

	private Cliente createCliente() {
		return Cliente.builder()
				.cidade("Porto Alegre")
				.cpf(12312312310L)
				.email("Teste@teste.com")
				.endereco("Endereço")
				.estado("RS")
				.nome("Douglas")
				.numero(102030)
				.tel(10203040L)
				.build();
	}
}
