package Swings;


//import java.util.*;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
//class QuizQuestion {
//    String question;
//    String[] options;
//    int correctAnswerIndex;
//
//    public QuizQuestion(String question, String[] options, int correctAnswerIndex) {
//        this.question = question;
//        this.options = options;
//        this.correctAnswerIndex = correctAnswerIndex;
//    }
//}
//
//public class QuizApp extends JFrame implements ActionListener {
//    JTextArea questionArea;
//    JRadioButton opt1, opt2, opt3, opt4;
//    JButton nextBtn, quitBtn, fiftyBtn, audienceBtn;
//    ButtonGroup bg;
//
//    QuizQuestion[] questions;
//    int current = 0, score = 0;
//    int[] questionPoints = {10,20,30,40,50,60,70,80,90,100};
//
//    // lifelines (only once for whole game)
//    boolean fiftyUsed = false;
//    boolean audienceUsed = false;
//
//    // safe levels
//    int safeScoreAt5 = 0;
//    int safeScoreAt7 = 0;
//
//    QuizApp() {
//        setTitle("Quiz App with Lifelines");
//        setSize(500, 400);
//        setLayout(new BorderLayout());
//
//        // question area
//        questionArea = new JTextArea();
//        questionArea.setFont(new Font("Arial", Font.BOLD, 14));
//        questionArea.setLineWrap(true);
//        questionArea.setWrapStyleWord(true);
//        questionArea.setEditable(false);
//        add(questionArea, BorderLayout.NORTH);
//
//        // options
//        opt1 = new JRadioButton();
//        opt2 = new JRadioButton();
//        opt3 = new JRadioButton();
//        opt4 = new JRadioButton();
//
//        bg = new ButtonGroup();
//        bg.add(opt1);
//        bg.add(opt2);
//        bg.add(opt3);
//        bg.add(opt4);
//
//        JPanel optionsPanel = new JPanel();
//        optionsPanel.setLayout(new GridLayout(4,1));
//        optionsPanel.add(opt1);
//        optionsPanel.add(opt2);
//        optionsPanel.add(opt3);
//        optionsPanel.add(opt4);
//
//        add(optionsPanel, BorderLayout.CENTER);
//
//        // buttons panel
//        nextBtn = new JButton("Next");
//        quitBtn = new JButton("Quit");
//        fiftyBtn = new JButton("50-50");
//        audienceBtn = new JButton("Audience Poll");
//
//        JPanel btnPanel = new JPanel();
//        btnPanel.setLayout(new FlowLayout());
//        btnPanel.add(nextBtn);
//        btnPanel.add(quitBtn);
//        btnPanel.add(fiftyBtn);
//        btnPanel.add(audienceBtn);
//
//        add(btnPanel, BorderLayout.SOUTH);
//
//        // listeners
//        nextBtn.addActionListener(this);
//        quitBtn.addActionListener(this);
//        fiftyBtn.addActionListener(this);
//        audienceBtn.addActionListener(this);
//
//        // load questions
//        questions = prepareQuestions();
//        loadQuestion();
//
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//
//    private QuizQuestion[] prepareQuestions() {
//        return new QuizQuestion[]{
//            new QuizQuestion("What does JVM stand for?",
//                new String[]{"Java Virtual Machine", "Java Variable Method", "Java Verified Module", "Java Vendor Machine"}, 0),
//            new QuizQuestion("What is the extension of a compiled Java file?",
//                new String[]{".java", ".exe", ".jar", ".class"}, 3),
//            new QuizQuestion("Who started developing Java?",
//                new String[]{"Bjarne Stroustrup", "James Gosling", "Moore", "Dennis Ritchie"}, 1),
//            new QuizQuestion("What does the 'javac' tool do?",
//                new String[]{"Runs Java programs", "Deletes Java classes", "Compiles Java code", "Packages Java files"}, 2),
//            new QuizQuestion("Which of the following is not a Java keyword?",
//                new String[]{"static", "Boolean", "final", "new"}, 1),
//            new QuizQuestion("Which is not a feature of Java?",
//                new String[]{"Portable", "Object Oriented", "Low Level Language", "Occupies Less Memory"}, 2),
//            new QuizQuestion("Which access modifier makes a method accessible only within its own class?",
//                new String[]{"public", "protected", "private", "default"}, 2),
//            new QuizQuestion("Where are objects stored in Java?",
//                new String[]{"Stack", "Heap", "Registers", "Cache"}, 1),
//            new QuizQuestion("Which keyword is used to inherit from an interface?",
//                new String[]{"implements", "extends", "inherits", "instanceof"}, 0),
//            new QuizQuestion("Which is a wrapper class for primitive 'int' in Java?",
//                new String[]{"Int", "integer", "Num", "Integer"}, 3)
//        };
//    }
//
//    private void loadQuestion() {
//        if (current < questions.length) {
//            QuizQuestion q = questions[current];
//            questionArea.setText("Q" + (current+1) + ": " + q.question);
//            opt1.setText(q.options[0]);
//            opt2.setText(q.options[1]);
//            opt3.setText(q.options[2]);
//            opt4.setText(q.options[3]);
//            bg.clearSelection();
//
//            // reset visibility (for 50-50 effect)
//            opt1.setVisible(true);
//            opt2.setVisible(true);
//            opt3.setVisible(true);
//            opt4.setVisible(true);
//        } else {
//            showResult();
//        }
//    }
//
//    private void applyFiftyFifty(QuizQuestion q) {
//        // hide 2 wrong options randomly
//        ArrayList<Integer> wrongOptions = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            if (i != q.correctAnswerIndex) wrongOptions.add(i);
//        }
//        Collections.shuffle(wrongOptions);
//        int hide1 = wrongOptions.get(0);
//        int hide2 = wrongOptions.get(1);
//
//        if (hide1 == 0) opt1.setVisible(false);
//        if (hide1 == 1) opt2.setVisible(false);
//        if (hide1 == 2) opt3.setVisible(false);
//        if (hide1 == 3) opt4.setVisible(false);
//
//        if (hide2 == 0) opt1.setVisible(false);
//        if (hide2 == 1) opt2.setVisible(false);
//        if (hide2 == 2) opt3.setVisible(false);
//        if (hide2 == 3) opt4.setVisible(false);
//    }
//
//    private void showResult() {
//        if (current == questions.length && score == Arrays.stream(questionPoints).sum()) {
//            JOptionPane.showMessageDialog(this, 
//                "🎉 Great job! You answered all questions correctly!\nYour Final Score: " + score);
//        } else {
//            JOptionPane.showMessageDialog(this, 
//                "Game Over! Your Final Score: " + score);
//        }
//        System.exit(0);
//    }
//
//
//    private boolean checkAnswer() {
//        QuizQuestion q = questions[current];
//        if (opt1.isSelected() && q.correctAnswerIndex == 0) return true;
//        if (opt2.isSelected() && q.correctAnswerIndex == 1) return true;
//        if (opt3.isSelected() && q.correctAnswerIndex == 2) return true;
//        if (opt4.isSelected() && q.correctAnswerIndex == 3) return true;
//        return false;
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == nextBtn) {
//            if (checkAnswer()) {
//                JOptionPane.showMessageDialog(this, "Correct! You earned " + questionPoints[current] + " points");
//                score += questionPoints[current];
//
//                // set safe levels
//                if (current == 4) safeScoreAt5 = score;
//                if (current == 6) safeScoreAt7 = score;
//
//            } else {
//                // Wrong Answer Handling with Safe Levels
//                if (current < 4) {
//                    JOptionPane.showMessageDialog(this, "Wrong! You lose. Final Score: 0");
//                    System.exit(0);
//                } else if (current < 6) {
//                    JOptionPane.showMessageDialog(this, "Wrong! You get safe level at Q5. Final Score: " + safeScoreAt5);
//                    System.exit(0);
//                } else {
//                    JOptionPane.showMessageDialog(this, "Wrong! You get safe level at Q7. Final Score: " + safeScoreAt7);
//                    System.exit(0);
//                }
//            }
//            current++;
//            loadQuestion();
//        } 
//        else if (e.getSource() == quitBtn) {
//            JOptionPane.showMessageDialog(this, "You Quit! Final Score: " + score);
//            System.exit(0);
//        }
//        else if (e.getSource() == fiftyBtn) {
//            if (!fiftyUsed) {
//                applyFiftyFifty(questions[current]);
//                fiftyUsed = true;
//                fiftyBtn.setEnabled(false);
//                fiftyBtn.setVisible(false); 
//            } else {
//                JOptionPane.showMessageDialog(this, "50-50 already used!");
//            }
//        }
//        else if (e.getSource() == audienceBtn) {
//            if (!audienceUsed) {
//                JOptionPane.showMessageDialog(this, "Audience Suggests: Option " + 
//                        (questions[current].correctAnswerIndex+1));
//                audienceUsed = true;
//                audienceBtn.setEnabled(false);
//                audienceBtn.setVisible(false);
//            } else {
//                JOptionPane.showMessageDialog(this, "Audience Poll already used!");
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new QuizApp();
//    }
//}
