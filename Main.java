import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    int runs = 0, overs = 0, balls =0 , wickets = 0;
    Team t1 = new Team(),t2 = new Team(), winner;
    boolean inning1, inning2;
    JFrame frame;
    JPanel panel1, panel2, headPanel, mainPanel, newGame;
    JLabel score, over, slash, directions, heading, newGameLabel, team1Label, team2Label;
    JTextField scoreOut, wicketOut, overOut, ballOut, team1, team2;
    JTextArea message;
    JButton zero, score1, score2, score3, score4, score6, newGameButton, start;
    JComboBox<String> extras;
    void startGame(){
        frame = new JFrame("Cricket ScoreBoard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        newGame = new JPanel(null);

        newGameLabel = new JLabel("New Game");
        newGameLabel.setBounds(250,50,300,100);
        Font f = newGameLabel.getFont();
        newGameLabel.setFont(f.deriveFont(f.getSize() + 30f));
        newGame.add(newGameLabel);
        newGameLabel.setVisible(false);

        directions = new JLabel("Enter the names of the teams...");
        directions.setBounds(200,200,200,20);
        directions.setVisible(false);
        newGame.add(directions);

        team1Label = new JLabel("Team1: ");
        team1Label.setBounds(200,250,100,30);
        f = team1Label.getFont();
        team1Label.setFont(f.deriveFont(f.getSize()+10f));
        newGame.add(team1Label);
        team1Label.setVisible(false);

        team1 = new JTextField();
        team1.setBounds(310,250,150,30);
        f = team1.getFont();
        team1.setFont(f.deriveFont(f.getSize()+10f));
        newGame.add(team1);
        team1.setVisible(false);


        team2Label = new JLabel("Team2: ");
        team2Label.setBounds(200,300,100,30);
        f = team2Label.getFont();
        team2Label.setFont(f.deriveFont(f.getSize()+10f));
        newGame.add(team2Label);
        team2Label.setVisible(false);

        team2 = new JTextField();
        team2.setBounds(310,300,150,30);
        f = team2.getFont();
        team2.setFont(f.deriveFont(f.getSize()+10f));
        newGame.add(team2);
        team2.setVisible(false);

        newGameButton = new JButton("New Game");
        f = newGameButton.getFont();
        newGameButton.setFont(f.deriveFont(f.getSize() + 20f));
        newGameButton.setBounds(250,250,200,100);
        newGame.add(newGameButton);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGameButton.setVisible(false);
                newGameLabel.setVisible(true);
                directions.setVisible(true);
                team1Label.setVisible(true);
                team2Label.setVisible(true);
                team1.setVisible(true);
                team2.setVisible(true);
                start.setVisible(true);
            }
        });

        start = new JButton("Start Game");
        f = start.getFont();
        start.setFont(f.deriveFont(f.getSize() + 10f));
        start.setBounds(230,350,200,50);
        newGame.add(start);
        start.setVisible(false);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.name = team1.getText();
                t2.name = team2.getText();
                newGame.setVisible(false);
                runGame(frame);
            }
        });

        newGame.setBounds(0,0,700,700);

        frame.add(newGame);
        frame.setSize(700,700);
        frame.setVisible(true);
    }
    void runGame(JFrame frame1){
        frame = frame1;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(null);

        headPanel = new JPanel(null);

        heading = new JLabel("Cricket ScoreBoard");
        heading.setBounds(100,20,500,50);
        Font head = heading.getFont();
        heading.setFont(head.deriveFont(head.getSize() + 35f));


        panel1 = new JPanel(null);

        directions = new JLabel("Select the ball type...");
        directions.setBounds(50,40, 200,20);
        panel1.add(directions);

        zero = new JButton("0");
        zero.setBounds(140,280,50,50);
        zero.addActionListener(new Dot());
        panel1.add(zero);

        score1 = new JButton("1");
        score1.setBounds(70,160,50,50);
        score1.addActionListener(new Score1());
        panel1.add(score1);

        score2 = new JButton("2");
        score2.setBounds(140,160,50,50);
        score2.addActionListener(new Score2());
        panel1.add(score2);

        score3 = new JButton("3");
        score3.setBounds(210,160,50,50);
        score3.addActionListener(new Score3());
        panel1.add(score3);

        score4 = new JButton("4");
        score4.setBounds(100,220,50,50);
        score4.addActionListener(new Score4());
        panel1.add(score4);

        score6 = new JButton("6");
        score6.setBounds(180,220,50,50);
        score6.addActionListener(new Score6());
        panel1.add(score6);
        hideButtons();

        extras = new JComboBox<String>(new String[]{ "None", "Wicket", "No Ball", "Wide"});
        extras.setBounds(100,80,150,40);
        extras.setSelectedItem("None");
        extras.addActionListener(new Select());
        panel1.add(extras);

        message = new JTextArea();
        message.setBounds(75,370,200,100);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        message.setEditable(false);
        panel1.add(message);

        panel2 = new JPanel(null);

        score = new JLabel("Score: ");
        score.setBounds(40,100,70,20);
        panel2.add(score);
        Font font = score.getFont();
        Font newFont = font.deriveFont(font.getSize() + 5f);
        score.setFont(newFont);

        scoreOut = new JTextField("0");
        scoreOut.setBounds(130,100,70,30);
        font = scoreOut.getFont();
        scoreOut.setFont(font.deriveFont(font.getSize() + 5f));
        scoreOut.setEditable(false);
        scoreOut.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(scoreOut);

        slash = new JLabel("/");
        slash.setBounds(210,105,10,20);
        font = slash.getFont();
        slash.setFont(font.deriveFont(font.getSize()+5f));
        panel2.add(slash);

        wicketOut = new JTextField("0");
        wicketOut.setBounds(230,100,50,30);
        font = wicketOut.getFont();
        wicketOut.setFont(font.deriveFont(font.getSize() + 5f));
        wicketOut.setEditable(false);
        wicketOut.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(wicketOut);

        over = new JLabel("Overs: ");
        over.setBounds(40,155,70,20);
        panel2.add(over);
        font = over.getFont();
        newFont = font.deriveFont(font.getSize() + 5f);
        over.setFont(newFont);

        overOut = new JTextField("0");
        overOut.setBounds(130,150,70,30);
        font = overOut.getFont();
        overOut.setFont(font.deriveFont(font.getSize() + 5f));
        overOut.setEditable(false);
        overOut.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(overOut);

        slash = new JLabel(".");
        slash.setBounds(210,155,10,20);
        font = slash.getFont();
        slash.setFont(font.deriveFont(font.getSize()+5f));
        panel2.add(slash);

        ballOut = new JTextField("0");
        ballOut.setBounds(230,150,50,30);
        font = ballOut.getFont();
        ballOut.setFont(font.deriveFont(font.getSize() + 5f));
        ballOut.setEditable(false);
        ballOut.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(ballOut);


        headPanel.setBounds(0,0,700,100);
        panel1.setBounds(0,100,350,700);
        panel2.setBounds(350,100,350,700);

        mainPanel.add(heading);
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        frame.getContentPane().add(mainPanel);
        frame.setSize(700,700);
        frame.setVisible(true);

        innings1Start();
    }
    Main(){
        startGame();
    }

    class Score1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String extra = extras.getSelectedItem().toString();
            if(extra.equals("Wicket")){
                wickets+=1;
                runs += 1;
                balls += 1;
            } else if (extra.equals("None")) {
                balls+= 1;
                runs += 1;
            } else {
                runs +=1;
            }
            if(balls > 5){
                overs+=1;
                balls%=6;
            }
            setFields();
            extras.setSelectedItem("None");
            hideButtons();
            String s = message.getText();
            s = s + "It's a single...";
            message.setText(s);
            extras.setVisible(true);
            validate();
            directions.setText("Select the Ball Type...");
        }
    }
    class Score2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String extra = extras.getSelectedItem().toString();
            if(extra.equals("Wicket")){
                wickets+=1;
                runs += 2;
                balls += 1;
            } else if (extra.equals("None")) {
                balls+= 1;
                runs += 2;
            } else {
                runs +=2;
            }
            if(balls > 5){
                overs+=1;
                balls%=6;
            }
            setFields();
            extras.setSelectedItem("None");
            hideButtons();
            String s = message.getText();
            s = s + "It's a double...";
            message.setText(s);
            extras.setVisible(true);
            validate();
            directions.setText("Select the Ball Type...");
        }
    }
    class Score3 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String extra = extras.getSelectedItem().toString();
            if(extra.equals("Wicket")){
                wickets+=1;
                runs += 3;
                balls += 1;
            } else if (extra.equals("None")) {
                balls+= 1;
                runs += 3;
            } else {
                runs += 3;
            }
            if(balls > 5){
                overs+=1;
                balls%=6;
            }
            setFields();
            extras.setSelectedItem("None");
            hideButtons();
            String s = message.getText();
            s = s + "3, it is...";
            message.setText(s);
            extras.setVisible(true);
            validate();
            directions.setText("Select the Ball Type...");
        }
    }
    class Score4 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String extra = extras.getSelectedItem().toString();
            if(extra.equals("Wicket")){
                wickets+=1;
                runs += 4;
                balls += 1;
            } else if (extra.equals("None")) {
                balls+= 1;
                runs += 4;
            } else {
                runs +=4;
            }
            if(balls > 5){
                overs+=1;
                balls%=6;
            }
            setFields();
            extras.setSelectedItem("None");
            hideButtons();
            String s = message.getText().toString();
            s = s + "Hurray! It's a four...";
            message.setText(s);
            extras.setVisible(true);
            validate();
            directions.setText("Select the Ball Type...");
        }
    }
    class Score6 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String extra = extras.getSelectedItem().toString();
            if(extra.equals("Wicket")){
                wickets+=1;
                runs += 6;
                balls += 1;
            } else if (extra.equals("None")) {
                balls+= 1;
                runs += 6;
            } else {
                runs +=6;
            }
            if(balls > 5){
                overs+=1;
                balls%=6;
            }
            extras.setSelectedItem("None");
            hideButtons();
            String s = message.getText();
            s = s + "What a hit! It's a six...";
            message.setText(s);
            setFields();
            extras.setVisible(true);
            validate();
            directions.setText("Select the Ball Type...");
        }
    }
    class Dot implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String extra = extras.getSelectedItem().toString();
            if(extra.equals("Wicket")){
                wickets+=1;
                balls += 1;
            } else if (extra.equals("None")) {
                balls+= 1;
            } else {
                runs += 0;
            }
            if(balls > 5){
                overs+=1;
                balls%=6;
            }
            setFields();
            extras.setSelectedItem("None");
            hideButtons();
            String s = message.getText();
            s = s + "Dot Ball...";
            message.setText(s);
            extras.setVisible(true);
            validate();
            directions.setText("Select the Ball Type...");
        }
    }
    class Select implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            showButton();
            String s = extras.getSelectedItem().toString();
            if(s.equals("Wicket")){
                message.setText("Wicket Gone...\n");
            } else if(s.equals("No Ball")){
                message.setText("Ball Again... It's a no Ball.\n");
            } else if (s.equals("Wide")) {
                message.setText("It's wide...Play Safe\n");
            } else {
                message.setText("");
            }
            extras.setVisible(false);
            directions.setText("Enter the score earned...");
        }
    }

    public void hideButtons(){
        zero.setVisible(false);
        score1.setVisible(false);
        score2.setVisible(false);
        score3.setVisible(false);
        score4.setVisible(false);
        score6.setVisible(false);
    }
    public void showButton(){
        zero.setVisible(true);
        score1.setVisible(true);
        score2.setVisible(true);
        score3.setVisible(true);
        score4.setVisible(true);
        score6.setVisible(true);
    }
    public void innings1Start(){
        inning1 = true;
        message.setText(t1.name + " is batting now...");
    }
    public void inning2Start(){
        inning2 = true;
    }
    public void inning1Over(){
        t1.runs = runs;
        t1.wickets = wickets;
        t1.overs = overs;
        t1.balls = balls;
        message.setText(t1.name + ": Total Score: " + String.valueOf(t1.runs) + "/" + String.valueOf(t1.wickets) + "\n Overs: " + String.valueOf(t1.overs) + "." + String.valueOf(t1.balls));
        resetScoreBoard();
    }
    public void inning2Over(){
        String s = message.getText();
        s = s + "\n " + String.valueOf(t2.name) + "is batting now...";
        message.setText(s);
        t2.runs = runs;
        t2.wickets = wickets;
        t2.overs = overs;
        t2.balls = balls;
        resetScoreBoard();
    }
    public void declareWinner(){
        if(t1.runs < t2.runs) winner = t2;
        else winner = t1;
        String s = t1.name + ": Score: " +
                t1.runs + " / " + t1.wickets
                + " Overs: " + t1.overs + " . " + t1.balls
                + "\n"
                + t2.name + ": Score: "+
                t2.runs + " / " + t2.wickets
                + "Overs: " + t2.overs + " . " + t2.balls
                + "\n\nCongratulations..."
                + winner.name + " is the Winner...";
        message.setText(s);
    }
    public void resetScoreBoard(){
        runs = 0;
        wickets = 0;
        balls = 0;
        overs = 0;
        setFields();
    }
    void setFields(){
        scoreOut.setText(String.valueOf(runs));
        wicketOut.setText(String.valueOf(wickets));
        overOut.setText(String.valueOf(overs));
        ballOut.setText(String.valueOf(balls));
    }
    void validate(){
        if(inning2){
            if(t1.runs<runs){
                inning2Over();
                declareWinner();
                directions.setVisible(false);
                extras.setVisible(false);
                message.setBounds(50,50,250,400);
                Font f = message.getFont();
                message.setFont(f.deriveFont(f.getSize()+5f));
            }
        }
        if(wickets==10 || overs == 2){
            if(inning1){
                if(inning2){
                    inning2Over();
                    declareWinner();
                } else {
                    inning1Over();
                    inning2Start();
                }
            }
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}
