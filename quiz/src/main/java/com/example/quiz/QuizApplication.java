package com.example.quiz;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args)
				.getBean(QuizApplication.class).execute();
		}
		@Autowired
		QuizRepository repository;

		private void execute() {
//			setup();
//			showList();
//			showOne();
//			updateQuiz();
//			deleteQuiz();
//			showList();
		}

		private void setup() {
			Quiz quiz1 = new Quiz(null, "Is Spring framework?", true, "nono");
			quiz1 = repository.save(quiz1);

			Quiz quiz2 = new Quiz(null, "Does Spring MVC provide batch process?", false, "nono");
			quiz2 = repository.save(quiz2);
		}

		private void showList() {
			System.out.println("---All data---");
			Iterable<Quiz> quizzes = repository.findAll();
			for (Quiz quiz: quizzes) {
				System.out.println(quiz);
			}
			System.out.println("--------------");
		}

		private void showOne() {
			System.out.println("---no1 data---");
			Optional<Quiz> quizOpt = repository.findById(1);
			if (quizOpt.isPresent()) {
				System.out.println(quizOpt.get());
			} else {
				System.out.println("No data");
			}
			System.out.println("--------------");
		}

		private void updateQuiz() {
			System.out.println("---Change data---");
			Quiz quiz1 = new Quiz(1, "Changed question", true, "nunu");
			quiz1 = repository.save(quiz1);
			System.out.println(quiz1 + "changed");
			System.out.println("-----------------");
		}

		private void deleteQuiz() {
			System.out.println("---Delete data---");
			repository.deleteById(4);
			System.out.println("-----------------");
		}
	}
