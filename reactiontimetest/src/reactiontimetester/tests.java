package reactiontimetester;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.RootPaneContainer;

public class tests extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JPanel jpMain, jpDisplay, jpButton, panel, panel2;
	JLabel outputDisplay, jlBtn;
	JTextArea typer = new JTextArea();
	JButton endBtn = new JButton();
	JButton easy, medium, hard;
	JButton test = new JButton();
	JButton click = new JButton();
	JButton home = new JButton();
	JButton randomBtn = new JButton();
	JButton wpmBtn = new JButton();
	String msg;
	double cnt;
	int wordCnt;
	long startTime;
	long elapsedTime;
	JLabel text;
	private JToggleButton tglbtnNewToggleButton;
	public tests() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		panel2 = new JPanel();
		panel2.setBackground(Color.BLACK);
		panel2.setLayout(null);
		panel2.setVisible(false);

		panel = new JPanel();		
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.add(home);
		
		home.setText("<html>Home</html>");
		home.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		home.setBackground(Color.LIGHT_GRAY);
		home.setBorderPainted(false);
		home.setOpaque(true);
		home.addActionListener(this);
		home.setPreferredSize(new java.awt.Dimension(750,100));
		home.setLocation(1000,1000);
		jpMain = new JPanel();
		jpMain.setLayout(new BorderLayout());
		
		jpDisplay = new JPanel();
		jpDisplay.setBackground(new Color(0, 0, 0));
		jpDisplay.setLayout(new FlowLayout());

		outputDisplay = new JLabel("", SwingConstants.CENTER);
		outputDisplay.setForeground(Color.WHITE);
		outputDisplay.setText(changeDsc("Choose a type of reaction test."));
		jpDisplay.add(outputDisplay, BorderLayout.SOUTH);
		new BorderLayout();
		jpMain.add(jpDisplay, BorderLayout.NORTH);
		
		ItemListener itemListener = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent)
            {
                int state = itemEvent.getStateChange();
                if (state == ItemEvent.SELECTED) {
                	outputDisplay.setForeground(Color.BLACK);
                	tglbtnNewToggleButton.setBackground(Color.BLACK);
                	tglbtnNewToggleButton.setForeground(Color.WHITE);
                	jpDisplay.setBackground(Color.WHITE);
                	panel2.setBackground(Color.WHITE);
        			jpButton.setBackground(Color.WHITE);
        			panel.setBackground(Color.WHITE);
        			home.setBackground(Color.BLACK);
        			home.setForeground(Color.WHITE);
        			typer.setBackground(Color.BLACK);
        			typer.setForeground(Color.WHITE);
                }
                else {
                	tglbtnNewToggleButton.setBackground(Color.WHITE);
                	outputDisplay.setForeground(Color.WHITE);
                	tglbtnNewToggleButton.setForeground(Color.BLACK);
                	jpDisplay.setBackground(Color.BLACK);
                	panel2.setBackground(Color.BLACK);
        			jpButton.setBackground(Color.BLACK);
        			panel.setBackground(Color.BLACK);
        			home.setBackground(Color.LIGHT_GRAY);
        			home.setForeground(Color.BLACK);
        			typer.setBackground(Color.WHITE);
        			typer.setForeground(Color.BLACK);
                }
            }
		};
		tglbtnNewToggleButton = new JToggleButton("<html>Toggle Light/Dark Mode</html>");
		jpDisplay.add(tglbtnNewToggleButton);
    	tglbtnNewToggleButton.setBackground(Color.WHITE);
    	tglbtnNewToggleButton.setOpaque(true);
    	tglbtnNewToggleButton.setBorderPainted(false);
		tglbtnNewToggleButton.addItemListener(itemListener);
		
		jpButton = new JPanel();
		jpButton.setLayout(new BorderLayout());
		jlBtn = new JLabel();
		jlBtn.setLayout(new FlowLayout());
		
		easy = new JButton();
		easy.setText("<html><div style='text-align: center;'>Basic Reaction Test</dv></html>");
		easy.setBackground(Color.GREEN);
		easy.setOpaque(true);
		easy.setBorderPainted(false);
		easy.addActionListener(this);
		jlBtn.add(easy);
		
		medium = new JButton();
		medium.setText("<html><div style='text-align: center;'>Randomized Locations Test</dv></html>");
		medium.addActionListener(this);
		medium.setBackground(Color.YELLOW);
		medium.setOpaque(true);
		medium.setBorderPainted(false);
		jlBtn.add(medium);
		
		hard = new JButton();
		hard.setText("<html><div style='text-align: center;'>Words Per Minute Test</dv></html>");		
		hard.addActionListener(this);
		hard.setBackground(Color.RED);
		hard.setOpaque(true);
		hard.setBorderPainted(false);
		jlBtn.add(hard);
		jpButton.add(jlBtn);
		new BorderLayout();
		jpMain.add(jpButton, BorderLayout.CENTER);
		
		getContentPane().add(jpMain);
		jpButton.setBackground(Color.BLACK);
		setSize((int)width, (int)height);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jpMain.addComponentListener(new ComponentListener() {

            @Override
            public void componentHidden(ComponentEvent arg0) {
            }

            @Override
            public void componentMoved(ComponentEvent arg0) {
            }

            @Override
            public void componentResized(ComponentEvent arg0) {
                int width = jpMain.getWidth();
                int height = jpMain.getHeight();
                easy.setFont(new Font("Lucida Grande", Font.BOLD, (int) ((width + height) / 50)));
                medium.setFont(new Font("Lucida Grande", Font.BOLD, (int) ((width + height) / 50)));
                hard.setFont(new Font("Lucida Grande", Font.BOLD,(int) (width + height) / 50));
                randomBtn.setFont(new Font("Lucida Grande", Font.BOLD,(int) (width + height) / 50));
                test.setFont(new Font("Lucida Grande", Font.BOLD,(int) (width + height) / 50));
                click.setFont(new Font("Lucida Grande", Font.BOLD,(int) (width + height) / 100));
                home.setFont(new Font("Lucida Grande", Font.BOLD,(int) (width + height) / 50));                
                easy.setPreferredSize(new java.awt.Dimension((int)(width / 5), (int)(height / 3)));
                medium.setPreferredSize(new java.awt.Dimension((int)(width / 5), (int)(height / 3)));
                hard.setPreferredSize(new java.awt.Dimension((int)(width / 5), (int)(height / 3)));
                randomBtn.setPreferredSize(new java.awt.Dimension((int)(width / 4), (int)(height / 5)));
                home.setPreferredSize(new java.awt.Dimension((int)(width / 2), (int)(height / 9)));
                test.setPreferredSize(new java.awt.Dimension((int)(width / 3), (int)(height / 5)));
                click.setPreferredSize(new java.awt.Dimension((int)(width / 5), (int)(height / 5)));
                typer.setPreferredSize(new java.awt.Dimension((int)(width / 3), (int)(height / 3)));
                endBtn.setPreferredSize(new java.awt.Dimension((int)(width / 6), (int)(height / 7)));
                wpmBtn.setPreferredSize(new java.awt.Dimension((int)(width / 4), (int)(height / 6)));
                if(wordCnt > 0) {
                    outputDisplay.setFont(new Font("Lucida Grande", Font.BOLD, (int) ((width + height) / 150)));
                }
                else {
                	outputDisplay.setFont(new Font("Lucida Grande", Font.BOLD, (int) ((width + height) / 50)));
                }

                ((RootPaneContainer) jpMain).getContentPane().revalidate();
            }

            @Override
            public void componentShown(ComponentEvent e) {

            }
        });
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actCmd = e.getActionCommand();
		
		if(actCmd.equals("<html><div style='text-align: center;'>Basic Reaction Test</dv></html>")) {
			reactionTest1();
		}
		else if(actCmd.equals("<html><div style='text-align: center;'>Randomized Locations Test</dv></html>")) {
			reactionTest2();
		}
		else if(actCmd.equals("<html><div style='text-align: center;'>Words Per Minute Test</dv></html>")) {
			reactionTest3();
		}
		else if(actCmd.equals("<html>Click Me When Ready</html>")) {
			double rand = Math.random() * 10 * 1000;
			for(int i = 0; i == 0;i++) {
			try {
				Thread.currentThread();
				Thread.sleep((long) rand);
			} catch (InterruptedException e1) {
				e1.printStackTrace();			
			}
			test.setVisible(false);
			click.setVisible(true);
			click.setText("<html>Click Now!</html>");
			click.setBackground(Color.GREEN);
			click.setOpaque(true);
			click.setBorderPainted(false);
			click.addActionListener(this);
			jlBtn.add(click);
			startTime = System.currentTimeMillis();
			}
		}
		else if(actCmd.equals("<html>Click Now!</html>")) {
			elapsedTime = System.currentTimeMillis() - startTime;
			click.setText("<html>Your reaction time is <br/>" + (elapsedTime - 25) + "ms</html>");
		}
		else if(actCmd.equals("<html>Home</html>")) {
			easy.setVisible(true);
			medium.setVisible(true);
			hard.setVisible(true);
			test.setVisible(false);
			click.setVisible(false);
			randomBtn.setVisible(false);
			jlBtn.setVisible(true);
			panel2.setVisible(false);
			jpButton.setVisible(true);
			panel.setVisible(true);
			wpmBtn.setVisible(false);
			typer.setVisible(false);
			endBtn.setVisible(false);
			jpMain.remove(panel2);
			outputDisplay.setText(changeDsc("<html>Choose a type of reaction test.</html>"));
		}
		else if(actCmd.equals("<html>Start</html>")) {
			jpMain.add(panel2);
			jpButton.setVisible(false);
			panel2.setVisible(true);
			outputDisplay.setVisible(false);
			panel.setVisible(false);
			panel2.add(randomBtn);
			randomBtn.setText("<html></html>");
			randomBtn.setSize(new java.awt.Dimension(50,50));
			randomBtn.setFont(new Font("Lucida Grande", Font.BOLD, 12));
			Random ran = new Random();
			int y = ran.nextInt(panel2.getHeight());
			while(50 > y || y > (panel2.getHeight() - 50)) {
				y = ran.nextInt(panel2.getHeight());
			}
			int x = ran.nextInt(panel2.getWidth());
			while(50 > x || x > (panel2.getWidth() - 50)) {
				x = ran.nextInt(panel2.getWidth());
			}
			randomBtn.setLocation(x, y);
			cnt = 0;
			startTime = System.currentTimeMillis();
		}
		else if(actCmd.equals("<html></html>")) {
			cnt = cnt + 0.5;
			elapsedTime = System.currentTimeMillis();
			if((elapsedTime - startTime > 30000 ) && (elapsedTime != startTime )) {
				outputDisplay.setVisible(true);
				panel.setVisible(true);
				DecimalFormat df = new DecimalFormat("#0.00");
				double aver = cnt / 30.0;
				randomBtn.setSize(new java.awt.Dimension(450,375));
				randomBtn.setLocation((jpMain.getWidth() / 2) - 225, (jpMain.getHeight() / 2) - 185);
				randomBtn.setFont(new Font("Lucida Grande", Font.BOLD, 20));
				randomBtn.setText("<html>It took an average of " + df.format(aver) + "s per button for you to click " + (int)cnt + " buttons.</html>");
			}
			else {
			Random ran = new Random();
			int y = ran.nextInt(panel2.getHeight());
			while(50 > y || y > (panel2.getHeight() - 50)) {
				y = ran.nextInt(panel2.getHeight());
			}
			int x = ran.nextInt(panel2.getWidth());
			while(50 > x || x > (panel2.getWidth() - 50)) {
				x = ran.nextInt(panel2.getWidth());
			}
			randomBtn.setLocation(x,y);
			}
		}
		else if(actCmd.equals("<html>Click When Ready</html>") || actCmd.equals("<html>Restart</html>")) {
			startTime = System.currentTimeMillis();
			wordCnt = 0;
			wpmBtn.setVisible(false);
			typer.setVisible(true);
			endBtn.setVisible(true);
			outputDisplay.setFont(new Font("Lucida Grande", Font.BOLD, (int) ((jpMain.getWidth() + jpMain.getHeight()) / 150)));
			double cop = Math.random();
			if(cop < 0.20) {
				wordCnt = 30;
				outputDisplay.setText(changeDsc("<html>Eating raw fish didn't sound like a good idea. \"It's a delicacy in Japan,\"<br/> didn't seem to make it any more appetizing. Raw fish is raw fish, delicacy or not.</html>"));
			}
			else if(cop < 0.40) {
				wordCnt = 62;
				outputDisplay.setText(changeDsc("<html>Barbara had been waiting at the table for twenty minutes.<br/> it had been twenty long and excruciating minutes. David had promised that he would be on time today.<br/> He never was, but he had promised this one time. She had made him repeat the promise multiple times<br/> over the last week until she'd believed his promise. Now she was paying the price.</html>"));
			}
			else if(cop < 0.60) {
				wordCnt = 90;
				outputDisplay.setText(changeDsc("<html>Mary had to make a decision and she knew that whatever decision she made,<br/> it would upset someone. It seemed like such a silly reason for people to get upset but she knew the minute<br/> that she began to consider doing it that there was no way everyone in her life would be pleased with what<br/> she ultimately decided to do. It was simply a question of who she would rather displease most.<br/> While this had always been her parents, and especially her mom, in the past that she tried to keep from upsetting,<br/> she decided that this time the person she was going to please the most with her decision was herself.\n"
						+ "</html>"));
			}
			else if(cop < 0.80) {
				wordCnt = 61;
				outputDisplay.setText(changeDsc("<html>He slowly poured the drink over a large chunk of ice he has especially chiseled off a larger block.<br/> He didn't particularly like his drinks cold, but he knew that the drama of chiseling the ice and then pouring,<br/> a drink over it looked far more impressive than how he actually liked it.<br/> It was all about image and he'd managed to perfect the image that he wanted to project.</html>"));
			}
			else if(cop < 1.00) {
				wordCnt = 83;
				outputDisplay.setText(changeDsc("<html>They told her that this was her once chance to show the world what she was made of.<br/> She believed them at the time.It was the big stage and she knew the world would be there to see.<br/> The only one who had disagreed with this sentiment was her brother.<br/> He had told her that you don't show the world what you're made of when they are all watching,<br/> you show that in your actions when nobody was looking. It was looking more and more like her brother was correct."));
			}
			endBtn.setBackground(Color.CYAN);
			endBtn.setOpaque(true);
			endBtn.setBorderPainted(false);
			endBtn.addActionListener(this);
			endBtn.setText("<html>Done</html>");
			typer.setText("");
			typer.setBackground(Color.WHITE);
			typer.setOpaque(true);
			typer.setLineWrap(true);
			jlBtn.add(typer);
			jlBtn.add(endBtn, BorderLayout.SOUTH);
		}
		else if(actCmd.equals("<html>Done</html>")) {
			typer.setVisible(false);
			endBtn.setText("<html>Restart</html>");
			DecimalFormat df = new DecimalFormat("#0.00");
			System.out.println();
			outputDisplay.setText(changeDsc("You typed at " + df.format(calculateWordsPerMinute(wordCnt, (elapsedTime / 1000 - startTime / 1000))) + " words per minute"));
		}
	}
	
	
	

	public void reactionTest1() {
		test.setText("<html>Click Me When Ready</html>");
		test.addActionListener(this);
		test.setBackground(Color.RED);
		test.setOpaque(true);
		test.setBorderPainted(false);
		outputDisplay.setText(changeDsc("<html>After you click on the red button <br/>it will at a random moment turn green.<br/> Click the button as soon as it turns green</html>"));
		easy.setVisible(false);
		medium.setVisible(false);
		hard.setVisible(false);
		jlBtn.add(test);
		test.setVisible(true);
	}

	public void reactionTest2() {
		easy.setVisible(false);
		medium.setVisible(false);
		hard.setVisible(false);
		outputDisplay.setText(changeDsc("<html><div style='text-align: center;'>After clicking on the start buttons will one by one<br/> spawn in random locations and in the end it will <br/>calculate the average time it took to click them.</dv></html>"));
		randomBtn.setText("<html>Start</html>");
		randomBtn.addActionListener(this);
		randomBtn.setBackground(Color.BLUE);
		randomBtn.setOpaque(true);
		randomBtn.setBorderPainted(false);
		jlBtn.add(randomBtn);
		randomBtn.setVisible(true);
		
		
	}
	public void reactionTest3() {
		easy.setVisible(false);
		medium.setVisible(false);
		hard.setVisible(false);
		wpmBtn.setVisible(true);
		wpmBtn.setFont(new Font("Lucida Grande", Font.BOLD, 32));
		wpmBtn.setBackground(Color.MAGENTA);
		wpmBtn.setOpaque(true);
		wpmBtn.setBorderPainted(false);
		wpmBtn.setText("<html>Click When Ready</html>");
		wpmBtn.addActionListener(this);
		outputDisplay.setText(changeDsc("<html>A passage will pop up and you will have to type it <br/>into the textbox below.The timer will start<br/> after a three second countdown.<br/>Click done when finished.</html"));
		jlBtn.add(wpmBtn);
	}
	public static int calculateWordsPerMinute(int wordCount, long elapsedTimeInSeconds) {
        double minutes = elapsedTimeInSeconds / 60.0;
        int wordsPerMinute = (int) (wordCount / minutes);
        return wordsPerMinute;
    }
	private String changeDsc(String newDsc) {
		String sg = newDsc;
		return sg;
	}
}