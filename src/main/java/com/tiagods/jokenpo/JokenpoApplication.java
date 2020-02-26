package com.tiagods.jokenpo;

import com.tiagods.jokenpo.enums.Resultado;
import com.tiagods.jokenpo.observer.Humano;
import com.tiagods.jokenpo.observer.Maquina;
import com.tiagods.jokenpo.observer.model.Jogador;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
@SpringBootApplication
public class JokenpoApplication implements CommandLineRunner {

	@Autowired
	private JogoService jogo;

	@RequestMapping
	@GetMapping
	public ResponseEntity<?> index(){
		return ResponseEntity.ok().body("Aplicação Online");
	}

	public static void main(String[] args) {
		SpringApplicationBuilder builder1 = new SpringApplicationBuilder(JokenpoApplication.class);
		builder1.headless(false);
		ConfigurableApplicationContext context = builder1.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		String nome = JOptionPane.showInputDialog(null,"Qual o seu nome",
				"");
		if(nome!=null) {
			jogo.comecarJogo(nome);
			System.exit(0);
		}
		else System.exit(0);
	}
}
