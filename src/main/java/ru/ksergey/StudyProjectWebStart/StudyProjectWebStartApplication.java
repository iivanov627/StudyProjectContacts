package ru.ksergey.StudyProjectWebStart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.ksergey.StudyProjectWebStart.config.database.DatabaseInitializer;

@SpringBootApplication
public class StudyProjectWebStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyProjectWebStartApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(DatabaseInitializer dbInitializer){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				dbInitializer.init();
			}
		};
	}
}
