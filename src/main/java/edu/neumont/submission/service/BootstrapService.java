package edu.neumont.submission.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.neumont.submission.model.Problem;
import edu.neumont.submission.model.Round;
import edu.neumont.submission.model.Test;
import edu.neumont.submission.model.Tournament;

@Service
public class BootstrapService {
	@PersistenceContext EntityManager em;
	
	@Transactional
	public void setupRoundSix() {
		Query query = em.createNativeQuery("SELECT * FROM Tournament t WHERE t.name = 'March Madness Tournament 2015'", Tournament.class);
		Tournament t = (Tournament)query.getSingleResult();
		
		Round toRemove = null;
		for ( Round r : t.getRounds() ) {
			if ( r.getName().equals("Championship Round") ) {
				toRemove = r;
			}
		}
		t.removeRound(toRemove);
		
		Round championship = new Round();
		championship.setMaxTime(75L);
		championship.setName("Championship Round");
		championship.setStartDate(LocalDateTime.of(2015, 3, 17, 11, 5));
		championship.setEndDate(championship.getStartDate().plus(75, ChronoUnit.MINUTES));
		t.addRound(championship);
		
		
		try {
			Problem p = new Problem("Toll Booth", "Toll Booth", BootstrapService.class.getClassLoader().getResourceAsStream("problems/toll-booth/description"));
			Test t1 = new Test(p, "", "10 7 2 2 2 2 2 4", "4", 1000, true);
			Test t2 = new Test(p, "", "10 7 2 2 2 2 2 3", "2", 1000, true);
			Test t3 = new Test(p, "", "10 1 2 3 4 5 6 7 8 9 10", "1", 1000, true);
			Test t4 = new Test(p, "", "15 1 2 3 4 5 6 7 8 9 10", "2", 1000, false);
			Test t5 = new Test(p, "", "60 3 5 7 11 13 17 23 29", "4", 1000, false);
			Test t6 = new Test(p, "", "60 59 29 17 14 7 6 3", "3", 1000, false);
			Test t7 = new Test(p, "", "60 59 29 14 6 3", "-1", 1000, true);
			p.addTest(t1);	
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			p.addTest(t6);
			p.addTest(t7);
			championship.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}
		
		try {
			Problem p = new Problem("Conlang", "Conlang", BootstrapService.class.getClassLoader().getResourceAsStream("problems/conlang/description"));
			Test t1 = new Test(p, "", "greenbatcorn art green bat corn", "true", 1000, true);
			Test t2 = new Test(p, "", "ababa ab ba a abba", "true", 1000, true);
			Test t3 = new Test(p, "", "banana b ana", "false", 1000, true);
			Test t4 = new Test(p, "", "banana b a n", "true", 1000, false);
			Test t5 = new Test(p, "", "ababa abb bba a abba", "false", 1000, false);
			Test t6 = new Test(p, "", "ababa ab bba a abba", "true", 1000, false);
			Test t7 = new Test(p, "", "ababa abb ba a abba", "true", 1000, false);
			p.addTest(t1);
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			p.addTest(t6);
			p.addTest(t7);
			championship.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}
		
		em.persist(t);
	}
		
	@Transactional
	public void setupRoundFive() {
		Query query = em.createNativeQuery("SELECT * FROM Tournament t WHERE t.name = 'March Madness Tournament 2015'", Tournament.class);
		Tournament t = (Tournament)query.getSingleResult();
		
		Round toRemove = null;
		for ( Round r : t.getRounds() ) {
			if ( r.getName().equals("Final Four") ) {
				toRemove = r;
			}
		}
		t.removeRound(toRemove);
		
		Round finalFour = new Round();
		finalFour.setMaxTime(50L);
		finalFour.setName("Final Four");
		finalFour.setStartDate(LocalDateTime.of(2015, 3, 12, 12, 5));
		finalFour.setEndDate(finalFour.getStartDate().plus(50, ChronoUnit.MINUTES));
		t.addRound(finalFour);
		
		
		try {
			Problem p = new Problem("Fibonacci", "Fibonacci", BootstrapService.class.getClassLoader().getResourceAsStream("problems/prime-fibonacci/description"));
			Test t1 = new Test(p, "", "5", "89", 1000, true);
			Test t2 = new Test(p, "", "10", "433494437", 1000, true);
			Test t3 = new Test(p, "", "1", "2", 1000, true);
			Test t4 = new Test(p, "", "13", "4114278174457313509", 10000, false);
			Test t5 = new Test(p, "", "12", "99194853094755497", 1000, false);
			p.addTest(t1);	
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			finalFour.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}
		
		try {
			Problem p = new Problem("Amicable or Betrothed?", "Amicable or Betrothed?", BootstrapService.class.getClassLoader().getResourceAsStream("problems/amicable-or-betrothed/description"));
			Test t1 = new Test(p, "", "220", "284", 1000, true);
			Test t2 = new Test(p, "", "48", "75", 1000, true);
			Test t3 = new Test(p, "", "50", "none", 1000, true);
			Test t4 = new Test(p, "", "6232", "6368", 1000, false);
			Test t5 = new Test(p, "", "5775", "6128", 1000, false);
			Test t6 = new Test(p, "", "1000", "none", 1000, false);
			p.addTest(t1);
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			p.addTest(t6);
			finalFour.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}
		
		em.persist(t);
	}
	
	@Transactional
	public void setupRoundFour() {
		Query query = em.createNativeQuery("SELECT * FROM Tournament t WHERE t.name = 'March Madness Tournament 2015'", Tournament.class);
		Tournament t = (Tournament)query.getSingleResult();
		
		Round toRemove = null;
		for ( Round r : t.getRounds() ) {
			if ( r.getName().equals("Elite Eight") ) {
				toRemove = r;
			}
		}
		t.removeRound(toRemove);
		
		Round eliteEight = new Round();
		eliteEight.setMaxTime(50L);
		eliteEight.setName("Elite Eight");
		eliteEight.setStartDate(LocalDateTime.of(2015, 3, 9, 12, 5));
		eliteEight.setEndDate(eliteEight.getStartDate().plus(50, ChronoUnit.MINUTES));
		t.addRound(eliteEight);
		
		
		try {
			Problem p = new Problem("Spreadsheet", "Spreadsheet", BootstrapService.class.getClassLoader().getResourceAsStream("problems/spreadsheet/description"));
			Test t1 = new Test(p, "", "a1,a2,a3,b1,b2,b3,c1,c2,c3", "cycle", 1000, true);
			Test t2 = new Test(p, "", "a2 * a3,b2 + 4,a2 - 7,a1 + a3 + b2 + c1,5,a1 * 3,b3 * 2,b3 * c1,c2 - 9", "18,9,2,133,5,54,108,5832,5823", 1000, true);
			Test t3 = new Test(p, "", "a2 - 1,a3 - 1,b1 - 1,b2 - 1,b3 - 1,c1 - 1,c2 - 1,c3 - 1,9", "1,2,3,4,5,6,7,8,9", 1000, true);
			Test t4 = new Test(p, "", "c1 * b2 * a3,a2 * a1,1,1,a2 * c2,c1 + a3,c1 * a2,b2 + b1,c1 - c2", "2,2,1,1,2,2,1,4,-1", 1000, false);
			Test t5 = new Test(p, "", "100,a1 * b2,b1 + b2 - b3,a1 + b2 + c3,5,c1 - b2,a1 + 500,b1 + b2,c1 - c2", "100,500,0,110,5,-5,600,505,5", 1000, false);
			Test t6 = new Test(p, "", "1,c3 * a3,b1 + b2 - b3,a1 + b2 + c3,5,c1 - b2,a1 + 500,b1 + b2,c1 - c2", "cycle", 1000, false);
			p.addTest(t1);
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			p.addTest(t6);
			eliteEight.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}
		
		try {
			Problem p = new Problem("Happy Numbers ", "Happy Numbers", BootstrapService.class.getClassLoader().getResourceAsStream("problems/happy-numbers/description"));
			Test t1 = new Test(p, "", "921", "true", 1000, true);
			Test t2 = new Test(p, "", "13", "true", 1000, true);
			Test t3 = new Test(p, "", "920", "false", 1000, true);
			Test t4 = new Test(p, "", "1000", "true", 1000, false);
			Test t5 = new Test(p, "", "1000029", "true", 1000, false);
			Test t6 = new Test(p, "", "1000028", "false", 1000, false);
			Test t7 = new Test(p, "", "1000000028", "false", 1000, false);
			p.addTest(t1);
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			p.addTest(t6);
			p.addTest(t7);
			eliteEight.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}
		
		em.persist(t);
	}
	
	
	@Transactional
	public void setupRoundThree() {
		Query query = em.createNativeQuery("SELECT * FROM Tournament t WHERE t.name = 'March Madness Tournament 2015'", Tournament.class);
		Tournament t = (Tournament)query.getSingleResult();
		
		Round toRemove = null;
		for ( Round r : t.getRounds() ) {
			if ( r.getName().equals("Sweet Sixteen") ) {
				toRemove = r;
			}
		}
		t.removeRound(toRemove);
		
		Round sweetSixteen = new Round();
		sweetSixteen.setMaxTime(50L);
		sweetSixteen.setName("Sweet Sixteen");
		sweetSixteen.setStartDate(LocalDateTime.now());//of(2015, 2, 23, 11, 5));
		sweetSixteen.setEndDate(sweetSixteen.getStartDate().plus(50, ChronoUnit.MINUTES));
		t.addRound(sweetSixteen);
		
		
		try {
			Problem p = new Problem("Figure and Ground", "Figure And Ground", BootstrapService.class.getClassLoader().getResourceAsStream("problems/figure-and-ground/description"));
			Test t1 = new Test(p, "", "abcdfghijklmnopquvwxyz school trees street paper set", "trees street", 1000, true);
			Test t2 = new Test(p, "", "abcdghijklmnopquvwxyz school trees street paper set", "", 1000, true);
			Test t3 = new Test(p, "", "bdefghijklmnopqrsuvwxyz cat act tack at", "cat act", 1000, true);
			Test t4 = new Test(p, "", "a bcdefghijklmnopqstruvwxyz happy coding", "bcdefghijklmnopqrstruvwxyz", 1000, false);
			Test t5 = new Test(p, "", "cdefghijklmnopqrstuvwxyz a aaa aba bbb abc", "aba", 1000, false);
			Test t6 = new Test(p, "", "abcdefghijklmnopqrstuvwxyz a b c d e f g h i j k l m n o p q r s t u v w x y z", "", 1000, false);
			p.addTest(t1);
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			p.addTest(t6);
			sweetSixteen.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}
		
		try {
			Problem p = new Problem("Contiguous Sum", "Contiguous Sum", BootstrapService.class.getClassLoader().getResourceAsStream("problems/contiguous-sum/description"));
			Test t1 = new Test(p, "", "-10,2,3,-2,0,5,-15", "8", 1000, true);
			Test t2 = new Test(p, "", "10,-11,10", "10", 1000, true);
			Test t3 = new Test(p, "", "50,-40,42,-10,9", "52", 1000, true);
			Test t4 = new Test(p, "", "-1,1,-2,-3,1", "1", 1000, false);
			Test t5 = new Test(p, "", "-1,-2,-3,-4,-5", "-1", 1000, false);
			Test t6 = new Test(p, "", "10,15,-10,25,4,-1,29", "72", 1000, false);
			Test t7 = new Test(p, "", "10,-15,-10,25,4,-1,29", "57", 1000, false);
			p.addTest(t1);
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			p.addTest(t6);
			p.addTest(t7);
			sweetSixteen.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}
		
		em.persist(t);
	}
	
	@Transactional
	public void setupRoundTwo() {
		Query query = em.createNativeQuery("SELECT * FROM Tournament t WHERE t.name = 'March Madness Tournament 2015'", Tournament.class);
		Tournament t = (Tournament)query.getSingleResult();
		
		Round toRemove = null;
		for ( Round r : t.getRounds() ) {
			if ( r.getName().equals("Round of 32") ) {
				toRemove = r;
			}
		}
		t.removeRound(toRemove);
		for ( Round r : t.getRounds() ) {
			if ( r.getName().equals("Round of 32 - First Session") ) {
				toRemove = r;
			}
		}
		t.removeRound(toRemove);
		for ( Round r : t.getRounds() ) {
			if ( r.getName().equals("Round of 32 - Second Session") ) {
				toRemove = r;
			}
		}
		t.removeRound(toRemove);
		for ( Round r : t.getRounds() ) {
			if ( r.getName().equals("Qualifying Round") ) {
				toRemove = r;
			}
		}
		t.removeRound(toRemove);

		Round roundOf32Session1 = new Round();
		roundOf32Session1.setMaxTime(50L);
		roundOf32Session1.setName("Round of 32 - First Session");
		roundOf32Session1.setStartDate(LocalDateTime.of(2015, 2, 23, 11, 5));
		roundOf32Session1.setEndDate(roundOf32Session1.getStartDate().plus(50, ChronoUnit.MINUTES));
		t.addRound(roundOf32Session1);
		
		Round roundOf32Session2 = new Round();
		roundOf32Session2.setMaxTime(50L);
		roundOf32Session2.setName("Round of 32 - Second Session");
		roundOf32Session2.setStartDate(LocalDateTime.of(2015, 2, 24, 12, 5));
		roundOf32Session2.setEndDate(roundOf32Session2.getStartDate().plus(50, ChronoUnit.MINUTES));
		t.addRound(roundOf32Session2);
		
		try {
			Problem p = new Problem("Vowel Police", "Vowel Police", BootstrapService.class.getClassLoader().getResourceAsStream("problems/vowel-police/description"));
			Test t1 = new Test(p, "", "cantalever", "cntlvr 6", 1000, true);
			Test t2 = new Test(p, "", "Interpolate", "ntrplt 12", 1000, true);
			Test t3 = new Test(p, "", "O'Sullivan", "'Sllvn 13", 1000, true);
			Test t4 = new Test(p, "", "30-year-old", "30-yr-ld 7", 1000, false);
			Test t5 = new Test(p, "", "aaaeeeiiiooouuu", " 45", 1000, false);
			Test t6 = new Test(p, "", "!@#$%^&*()", "!@#$%^&*() 0", 1000, false);
			p.addTest(t1);
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			p.addTest(t6);
			roundOf32Session1.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}
		
		try {
			Problem p = new Problem("Rhyme Time", "Rhyme Time", BootstrapService.class.getClassLoader().getResourceAsStream("problems/rhyme-time/description"));
			Test t1 = new Test(p, "", "na banana order", "9 0", 1000, true);
			Test t2 = new Test(p, "", "batmobile batmobiles fire pizza dog", "13 2 2 1", 1000, true);
			Test t3 = new Test(p, "", "ana banana", "12", 1000, true);
			Test t4 = new Test(p, "", "eee eeeeee ewewew", "26 9", 1000, false);
			Test t5 = new Test(p, "", "abcba abcbabcbabcba defgh", "29 0", 1000, false);
			Test t6 = new Test(p, "", "eeeeee eee eeee eeeee eeeeee", "18 24 30 38", 1000, false);
			p.addTest(t1);
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			p.addTest(t6);
			roundOf32Session1.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}
		
		/*try {
			Problem p = new Problem("Contiguous Sum", "Contiguous Sum", new File("problems/contiguous-sum/description"));
			Test t1 = new Test(p, "", "-10,2,3,-2,0,5,-15", "8", 1000, true);
			Test t2 = new Test(p, "", "10,-11,10", "10", 1000, true);
			Test t3 = new Test(p, "", "50,-40,42,-10,9", "52", 1000, true);
			Test t4 = new Test(p, "", "-1,1,-2,-3,1", "1", 1000, false);
			Test t5 = new Test(p, "", "-1,-2,-3,-4,-5", "-1", 1000, false);
			Test t6 = new Test(p, "", "10,15,-10,25,4,-1,29", "72", 1000, false);
			Test t7 = new Test(p, "", "10,-15,-10,25,4,-1,29", "57", 1000, false);
			p.addTest(t1);
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			p.addTest(t6);
			p.addTest(t7);
			roundOf32Session1.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}*/
		
		try {
			Problem p = new Problem("Step It", "Step It", BootstrapService.class.getClassLoader().getResourceAsStream("problems/step-it/description"));
			Test t1 = new Test(p, "", "4 36 8", "5", 1000, true);
			Test t2 = new Test(p, "", "6 1 -1", "6", 1000, true);
			Test t3 = new Test(p, "", "7 8 .1", "11", 1000, true);
			Test t4 = new Test(p, "", "8 8 92", "1", 1000, true);
			Test t5 = new Test(p, "", "12 14 .1", "21", 1000, true);
			Test t6 = new Test(p, "", "14 12 .01", "-1", 1000, true);
			Test t7 = new Test(p, "", "13 100 29", "4", 1000, false);
			Test t8 = new Test(p, "", "12 16 .04", "101", 1000, false);
			Test t9 = new Test(p, "", "1 1000000000 .01", "99999999901", 1000, false);
			p.addTest(t1);
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			p.addTest(t6);
			p.addTest(t7);
			p.addTest(t8);
			p.addTest(t9);
			roundOf32Session2.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}
		
		try {
			Problem p = new Problem("Decompress", "Decompress", BootstrapService.class.getClassLoader().getResourceAsStream("problems/decompress/description"));
			Test t1 = new Test(p, "", "ban{1,3} {0,6}", "banana banana", 1000, true);
			Test t2 = new Test(p, "", "See Spot Run. {0,9}Jump.{8,4}{3,9}!", "See Spot Run. See Spot Jump. Run Spot Run!", 1000, true);
			Test t3 = new Test(p, "", "e{0,5}", "eeeeee", 1000, true);
			Test t4 = new Test(p, "", "e{0,5} {0,3}{6,4}", "eeeeee eee eee", 1000, false);
			Test t5 = new Test(p, "", "abracad{0,4}", "abracadabra", 1000, false);
			p.addTest(t1);
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			roundOf32Session2.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}
		
		/*try {
			Problem p = new Problem("Prime Fibonnaci", "Prime Fibonnaci", new File("problems/prime-fibonnaci/description"));
			Test t1 = new Test(p, "", "5", "89", 1000, true);
			Test t2 = new Test(p, "", "3", "5", 1000, true);
			Test t3 = new Test(p, "", "9", "514229", 1000, true);
			Test t4 = new Test(p, "", "10", "433494437", 1000, false);
			Test t5 = new Test(p, "", "11", "2971215073", 1000, false);
			Test t6 = new Test(p, "", "1", "2", 1000, false);
			p.addTest(t1);
			p.addTest(t2);
			p.addTest(t3);
			p.addTest(t4);
			p.addTest(t5);
			p.addTest(t6);
			roundOf32Session2.addProblem(p);
		} catch ( IOException e ) {
			e.printStackTrace(); // log and move on for now
		}*/
		
		em.persist(t);
	}
	
	@Transactional
	public void setup() {
		Tournament t = new Tournament();
		t.setName("March Madness Tournament 2015");
		t.setActive(true);
		
		Round round = new Round();
		round.setMaxTime(50L);
		round.setName("Qualifying Round");
		round.setStartDate(LocalDateTime.of(2015, 2, 17, 10, 10));
		round.setEndDate(LocalDateTime.now().plus(500, ChronoUnit.MINUTES));
		t.addRound(round);
		
		Round roundTwo = new Round();
		roundTwo.setMaxTime(50000L);
		roundTwo.setName("Round of 32");
		roundTwo.setStartDate(LocalDateTime.of(2015, 2, 25, 12, 5));
		roundTwo.setEndDate(roundTwo.getStartDate().plus(50, ChronoUnit.MINUTES));
		t.addRound(roundTwo);

		String description = 
		"Betsy is interested in flags whose stars are formatted rectangularly where every odd row is the same length and every even row is one star less than the odd rows.<br/><br/>" +
		"Furthermore, call the width of this flag the number of stars in its first row and the height the number of rows. Betsy prefers the dimensions to be the closest to a square as possible. In the case of a tie, Betsy prefers flags with more columns than rows.<br/><br/>" +
		
		"For example, in the case of a <b>50-star flag</b>,<br/>" +
		"&nbsp;&nbsp;&nbsp;&nbsp;Betsy likes a flag whose odd rows have <b>6</b> stars and whose even rows have 5 stars (resulting in a flag with 9 rows of stars, 6, 5, 6, 5, 6, 5, 6, 5, 6)<br/>" +
		"&nbsp;&nbsp;&nbsp;&nbsp;as opposed to a flag whose odd rows have 5 stars and whose even rows have 4 stars (resulting in a flag with 10 rows of stars). A 6 x 9 flag is closer to a square than a 5 x 10 flag.<br/><br/>" +
		"For example, in the case of a <b>46-star flag</b>,<br/>" +
		"&nbsp;&nbsp;&nbsp;&nbsp;Betsy likes a flag whose odd rows have <b>7</b> stars and whose even rows have 6 stars (resulting in a flag with 7 rows of stars, 7, 6, 7, 6, 7, 6, 7)<br/>" +
		"&nbsp;&nbsp;&nbsp;&nbsp;as opposed to a flag whose odd rows have 12 stars and whose even rows have 11 stars (resulting in a flag with 4 rows of stars). A 7 x 7 flag is closer to a square than a 12 x 4 flag.<br/><br/>" +

		"Create a Solution that reads in the number of total stars from standard in and prints out the number of stars in the first row of Betsy's preferred flag.";

		Problem problem = new Problem("Betsy Ross", "Betsy Ross", description);
		
		round.addProblem(problem);
		
		Test firstTest = new Test(problem, "name", "50", "6", 1000, true);
		Test secondTest = new Test(problem, "name", "46", "7", 1000, true);
		Test thirdTest = new Test(problem, "name", "3", "2", 1000, true);
		Test fourthTest = new Test(problem, "name", "115", "12", 1000, true);
		Test fifthTest = new Test(problem, "name", "459384753", "28603", 8000, true);
		problem.addTest(firstTest);
		problem.addTest(secondTest);
		problem.addTest(thirdTest);
		problem.addTest(fourthTest);
		problem.addTest(fifthTest);

		Map<String, String> testStrings = new HashMap<String, String>();
		testStrings.put("143", "10");
		testStrings.put("116", "11");
		testStrings.put("80", "27");
		testStrings.put("112", "112");
		testStrings.put("846242343", "57125");
		
		for ( Map.Entry<String, String> entry : testStrings.entrySet() ) {
			problem.addTest(new Test(problem, "name", entry.getKey(), entry.getValue(), 8000, false));
		}
		
		em.persist(t);
	}
}
