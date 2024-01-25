package Quiz;
//package com.uopeople;

import java.util.Scanner;

public class Quiz
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);// to get users input
	
		/* 
		 question in an array of array gotten from
		 https://www.mentimeter.com/blog/audience-energizers/55-free-trivia-and-fun-quiz-question-templates
		*/
		String[][] questions = {
				{
					"Where would you be if you were standing on the Spanish Steps?",
					"A. Rome",
					"B. Paris",
					"C. Nigeria",
					"D. Morrocco"	
				},
				{
					"Who was the Ancient Greek God of the Sun?",
					"A. Zeus",
					"B. Apollo",
					"C. Medusa",
					"D. Heath"
				},
				{
					"In which festival of life is BALSAM FIR tree decorated and used",
					"A. Halloween",
					"B. Dawali",
					"C. Christmas",
					"D. Independent day"
				},
				{
					"Where did sushi originate?",
					"A. Italy",
					"B. America",
					"C. Norway",
					"D. China"
				},
				{
					"What meat is used in a shepherd's pie?",
					"A. Lamb",
					"B. Goat",
					"C. Pig",
					"D. Cow"
				}
		};
		
		// answers to the questions
		String[] answer = {"A", "B", "C", "D", "A"};
		
		System.out.println("Hello! am Ada, nice to meet you, what's your name? ");
		
		// get players name
		String response = scan.next();
		
		// player enters OK to proceed
		System.out.println("Ok! " + response + ". \nQuiz time. It's simple, enter OK to proceed ");
		
		// expect ok 
		String ok = scan.next().toUpperCase();
		
		// total quiz grade
		byte grade = 0;
		
		if (ok.equals("OK")) {
			// append failed questions with there answers
			String[] failed = new String[questions.length];
			
			// looping through the questions {}
			for (int i = 0; i < questions.length; i++) {

                // number the questions
                System.out.print((i + 1)  + ". ");

                // looping through each question and answers {{}}
				for (int j = 0; j < questions[i].length; j++) {
					System.out.println(questions[i][j]);
				}

                String ans;

                do{
                    System.out.print("\nYour option: ");
                
                    // get users option to each question
                    ans = scan.next().toUpperCase();
                    
                    // check if the right option is picked
                    switch (ans) {
                        case "A":
                            if (answer[i].equals("A")) {
                                grade += 1;
                            } else {
                                failed[i] = i + ". " + questions[i][0] + "\n Correct answer is: " + answer[i];
                            }
                            break;
                        case "B":
                            if (answer[i].equals("B")) {
                                grade += 1;
                            } else {
                                failed[i] = i + ". " + questions[i][0] + "\n Correct answer is: " + answer[i];
                            }
                            break;
                        case "C":
                            if (answer[i].equals("C")) {
                                grade += 1;
                            } else {
                                failed[i] = i + ". " + questions[i][0] + "\n Correct answer is: " + answer[i];
                            }
                            break;
                        case "D":
                            if (answer[i].equals("D")) {
                                grade += 1;
                            } else {
                                failed[i] = i + ". " + questions[i][0] + "\n Correct answer is: " + answer[i];
                            }
                            break;
                        default:
                            System.out.println("Not a valid option(A - D).  ");
                    } 
                } while (!ans.equals("A") && !ans.equals("B") && !ans.equals("C") && !ans.equals("D"));

                System.out.println();
            }

			// total number of questions
			int allQuestion = questions.length;
			
			// percentage of grade 
			double percent = ((double) grade / allQuestion) * 100;
			System.out.println("\nComplete!!! You got " + grade + " out of " + allQuestion);
			System.out.println("Percentage score is " + percent + "%\n");
			
            // display failed question with the answer, if any
            System.out.println("This section displays CORRECTIONS for those you failed\n");
            for (int f = 0; f < failed.length; f++) {
                if (failed[f] != null){
                    System.out.println(failed[f]);
                } 
            }

			scan.close(); // Close the Scanner
			return;
		} else {
			System.out.println("Have a nice Day");
			scan.close(); // Close the Scanner
			return;
		}	
	}
}
