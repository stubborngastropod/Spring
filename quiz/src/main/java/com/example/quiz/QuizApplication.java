package com.example.quiz;

import com.example.quiz.entity.Quiz;
import com.example.quiz.repository.QuizRepository;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args)
				.getBean(QuizApplication.class).execute();
		}
		@Autowired
		QuizService service;

		private void execute() {
//			setup();
//			showList();
//			showOne();
//			updateQuiz();
//			deleteQuiz();
//			showList();
			doQuiz();
		}

		private void setup() {
			Quiz quiz1 = new Quiz(null, "Quiz test 1", true, "nono");
			Quiz quiz2 = new Quiz(null, "Quiz test 2", true, "nono");
			Quiz quiz3 = new Quiz(null, "Quiz test 3", true, "nono");
			Quiz quiz4 = new Quiz(null, "Quiz test 4", true, "nono");
			Quiz quiz5 = new Quiz(null, "Quiz test 5", true, "nono");
			List<Quiz> quizList = new ArrayList<>();
			Collections.addAll(quizList, quiz1, quiz2, quiz3, quiz4, quiz5);
			for (Quiz quiz : quizList) {
				service.insertQuiz(quiz);
			}
		}

		private void showList() {
			System.out.println("---All data---");
			Iterable<Quiz> quizzes = service.selectAll();
			for (Quiz quiz : quizzes) {
				System.out.println(quiz);
			}
			System.out.println("--------------");
		}

		private void showOne() {
			System.out.println("---no1 data---");
			Optional<Quiz> quizOpt = service.selectOneById(1);
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
			service.updateQuiz(quiz1);
			System.out.println(quiz1 + "changed");
			System.out.println("-----------------");
		}

		private void deleteQuiz() {
			System.out.println("---Delete data---");
			service.deleteQuizById(4);
			System.out.println("-----------------");
		}

		private void doQuiz() {
			System.out.println("---Random quiz---");
			Optional<Quiz> quizOpt = service.selectOneRandomQuiz();
			if (quizOpt.isPresent()) {
				System.out.println(quizOpt.get());
			} else {
				System.out.println("No data");
			}
			System.out.println("-----------------");

			Boolean myAnswer = false;
			Integer id = quizOpt.get().getId();
			if (service.checkQuiz(id, myAnswer)) {
				System.out.println("Correct");
			} else {
				System.out.println("Wrong");
			}
		}
	}
