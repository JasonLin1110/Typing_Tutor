package HW3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements KeyListener{
	private int[] key_code = {
			//line1 without backspace
			KeyEvent.VK_BACK_QUOTE, KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_6, 
			KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9, KeyEvent.VK_0, KeyEvent.VK_MINUS, KeyEvent.VK_EQUALS, 
			//line2 without tab
			KeyEvent.VK_Q, KeyEvent.VK_W, KeyEvent.VK_E, KeyEvent.VK_R, KeyEvent.VK_T, KeyEvent.VK_Y, KeyEvent.VK_U, 
			KeyEvent.VK_I, KeyEvent.VK_O, KeyEvent.VK_P, KeyEvent.VK_OPEN_BRACKET, KeyEvent.VK_CLOSE_BRACKET, 
			KeyEvent.VK_BACK_SLASH,
			//line3 without caps_lock and enter
			KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_F, KeyEvent.VK_G, KeyEvent.VK_H, KeyEvent.VK_J, 
			KeyEvent.VK_K, KeyEvent.VK_L, KeyEvent.VK_SEMICOLON, KeyEvent.VK_QUOTE,
			//line4 without shift and up_arrow
			KeyEvent.VK_Z, KeyEvent.VK_X, KeyEvent.VK_C, KeyEvent.VK_V, KeyEvent.VK_B, KeyEvent.VK_N, KeyEvent.VK_M, 
			KeyEvent.VK_COMMA, KeyEvent.VK_PERIOD, KeyEvent.VK_SLASH, 
			//whitespace and other function button
			KeyEvent.VK_BACK_SPACE, KeyEvent.VK_TAB, KeyEvent.VK_CAPS_LOCK, KeyEvent.VK_ENTER, KeyEvent.VK_SHIFT, 
			KeyEvent.VK_UP, KeyEvent.VK_SPACE, KeyEvent.VK_LEFT, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT};
	
	private int caps_key = 0, init=0, test_fin=0, str_add=0, right=0, wrong=0, stack=0;
	
	private String test_str = "The quick brown fox jumps over a lazy dog";
	
	private JFrame window = new JFrame();
	
	private JButton key[] = {new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), 
			new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), 
			new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), 
			new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
			new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
			new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
			new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
			new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), 
			new JButton(), new JButton(), new JButton()};
	
	private JLabel right_click_time = new JLabel(" Type correctly: "+0),
			   wrong_click_time = new JLabel(" Type incorrectly: "+0),
			   finish = new JLabel("Not done");
	
	public GUI(){ GUI_window(); }
	
	private void GUI_window() {
		window.setSize(830,615);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Typing Application");
		window.setLayout(null);
		//Note
		JLabel lb1 = new JLabel(" Type some text using your keyboard. "
				+ "The keys you press will be highlighted and the text will be displayed." ),
				lb2 = new JLabel( " Note: First, please enter the shift key to switch to English input. "
				+ "Second, clicking the buttons with your mouse will not perform any action. ");
		lb1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lb1.setBounds(10, 0, 815, 20);
		lb2.setBounds(10, 20, 815, 20);
		//typing area
		JTextArea typingarea = new JTextArea();
		typingarea.setLineWrap(true);
		typingarea.setWrapStyleWord(true);
		typingarea.setBounds(10, 42, 790, 250);
		window.add(lb1);
		window.add(lb2);
		window.add(typingarea);
		JLabel test = new JLabel(" Let's get the test, please enter the sentence on the right. "
				+ "\"The quick brown fox jumps over a lazy dog\"");
		test.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		test.setBounds(10, 290, 800, 25);
		window.add(test);
		//add keyboard
		keyboard();
		right_click_time.setFont(new Font("Times New Roman", Font.PLAIN, 15));//221
		right_click_time.setBounds(10,524,150,20);
		wrong_click_time.setFont(new Font("Times New Roman", Font.PLAIN, 15));//221
		wrong_click_time.setBounds(10,550,150,20);
		window.add(right_click_time);
		window.add(wrong_click_time);
		finish.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		finish.setBounds(150,525,100,40);
		window.add(finish);
		//listen keyboard input
		typingarea.addKeyListener(this);
		window.setVisible(true);
	}
	
	private void keyboard() {
		
		int[] l1 = {96,49,50,51,52,53,54,55,56,57,48,45,61}, l2 = {113,119,101,114,106,121,117,105,111,112,91,93,92},
			  l3 = {97,115,100,102,103,104,106,107,108,59,39}, l4 = {122,120,99,118,98,110,109,44,46,47};//keyboard ascii code
		//keyboard line1
		for(int count=0; count <13;count++) {
			String word = Character.toString(l1[count]);
			JButton tmp = key[count];
			tmp.setText(word);
			tmp.setFont(new Font("Arial", Font.PLAIN, 14));
			tmp.setBackground(Color.LIGHT_GRAY);
			tmp.setBounds(10+(48+5)*(count),320,48,45);
			window.add(tmp);
		}
		JButton tmp2 = key[47];
		tmp2.setText("Backspace");
		tmp2.setFont(new Font("Arial", Font.PLAIN, 14));
		tmp2.setBackground(Color.LIGHT_GRAY);
		tmp2.setBounds(10+(48+5)*13,320,105,45);
		window.add(tmp2);
		//keyboard line2
		tmp2 = key[48];
		tmp2.setText("Tab");
		tmp2.setFont(new Font("Arial", Font.PLAIN, 14));
		tmp2.setBackground(Color.LIGHT_GRAY);
		tmp2.setPreferredSize(new Dimension(70, 45));
		tmp2.setBounds(10,371,70,45);
		window.add(tmp2);
		for(int count=0; count <13;count++) {
			String word = Character.toString(l2[count]);
			JButton tmp = key[count+13];
			tmp.setText(word);
			tmp.setFont(new Font("Arial", Font.PLAIN, 14));
			tmp.setBackground(Color.LIGHT_GRAY);
			tmp.setPreferredSize(new Dimension(48, 45));
			tmp.setBounds(85+(48+5)*(count),371,48,45);
			window.add(tmp);
		}
		//keyboard line3
		tmp2 = key[49];
		tmp2.setText("Caps");
		tmp2.setFont(new Font("Arial", Font.PLAIN, 14));
		tmp2.setBackground(Color.LIGHT_GRAY);
		tmp2.setPreferredSize(new Dimension(70, 45));
		tmp2.setBounds(10,422,70,45);
		window.add(tmp2);
		for(int count=0; count <11;count++) {
			String word = Character.toString(l3[count]);
			JButton tmp = key[count+26];
			tmp.setText(word);
			tmp.setFont(new Font("Arial", Font.PLAIN, 14));
			tmp.setBackground(Color.LIGHT_GRAY);
			tmp.setPreferredSize(new Dimension(48, 45));
			tmp.setBounds(85+(48+5)*(count),422,48,45);
			window.add(tmp);
		}
		tmp2 = key[50];
		tmp2.setText("Enter");
		tmp2.setFont(new Font("Arial", Font.PLAIN, 14));
		tmp2.setBackground(Color.LIGHT_GRAY);
		tmp2.setBounds(85+(48+5)*11,422,99,45);
		window.add(tmp2);
		//keyboard line4
		tmp2 = key[51];
		tmp2.setText("Shift");
		tmp2.setFont(new Font("Arial", Font.PLAIN, 14));
		tmp2.setBackground(Color.LIGHT_GRAY);
		tmp2.setBounds(10,473,100,45);
		window.add(tmp2);
		for(int count=0; count <10;count++) {
			String word = Character.toString(l4[count]);
			JButton tmp = key[count+37];
			tmp.setText(word);
			tmp.setFont(new Font("Arial", Font.PLAIN, 14));
			tmp.setBackground(Color.LIGHT_GRAY);
			tmp.setBounds(115+(48+5)*(count),473,48,45);
			window.add(tmp);
		}
		tmp2 = key[52];
		tmp2.setText("^");
		tmp2.setFont(new Font("Arial", Font.PLAIN, 14));
		tmp2.setBackground(Color.LIGHT_GRAY);
		tmp2.setBounds(85+(48+5)*11,473,48,45);
		window.add(tmp2);
		tmp2 = key[53];
		//keyboard line5
		tmp2.setText("");
		tmp2.setFont(new Font("Arial", Font.PLAIN, 14));
		tmp2.setBackground(Color.LIGHT_GRAY);
		tmp2.setBounds(115+(48+5)*2,524,318,45);
		window.add(tmp2);
		tmp2 = key[54];
		tmp2.setText("<");
		tmp2.setFont(new Font("Arial", Font.PLAIN, 14));
		tmp2.setBackground(Color.LIGHT_GRAY);
		tmp2.setBounds(85+(48+5)*10,524,48,45);
		window.add(tmp2);
		tmp2 = key[55];
		tmp2.setText("v");
		tmp2.setFont(new Font("Arial", Font.PLAIN, 14));
		tmp2.setBackground(Color.LIGHT_GRAY);
		tmp2.setBounds(85+(48+5)*11,524,48,45);
		window.add(tmp2);
		tmp2 = key[56];
		tmp2.setText(">");
		tmp2.setFont(new Font("Arial", Font.PLAIN, 14));
		tmp2.setBackground(Color.LIGHT_GRAY);
		tmp2.setBounds(85+(48+5)*12,524,48,45);
		window.add(tmp2);
	}
	private void board_change() {
		if(caps_key==0) {
			caps_key=1;
			key[13].setText("Q");
			key[14].setText("W");
			key[15].setText("E");
			key[16].setText("R");
			key[17].setText("T");
			key[18].setText("Y");
			key[19].setText("U");
			key[20].setText("I");
			key[21].setText("O");
			key[22].setText("P");
			key[26].setText("A");
			key[27].setText("S");
			key[28].setText("D");
			key[29].setText("F");
			key[30].setText("G");
			key[31].setText("H");
			key[32].setText("J");
			key[33].setText("K");
			key[34].setText("L");
			key[37].setText("Z");
			key[38].setText("X");
			key[39].setText("C");
			key[40].setText("V");
			key[41].setText("B");
			key[42].setText("N");
			key[43].setText("M");
		}//change to capital
		else if(caps_key==1){
			caps_key=0;
			key[13].setText("q");
			key[14].setText("w");
			key[15].setText("e");
			key[16].setText("r");
			key[17].setText("t");
			key[18].setText("y");
			key[19].setText("u");
			key[20].setText("i");
			key[21].setText("o");
			key[22].setText("p");
			key[26].setText("a");
			key[27].setText("s");
			key[28].setText("d");
			key[29].setText("f");
			key[30].setText("g");
			key[31].setText("h");
			key[32].setText("j");
			key[33].setText("k");
			key[34].setText("l");
			key[37].setText("z");
			key[38].setText("x");
			key[39].setText("c");
			key[40].setText("v");
			key[41].setText("b");
			key[42].setText("n");
			key[43].setText("m");
		}//change to lower case
	}
	private void line1() {
		String word=key[0].getText();
		if(word=="`") {
			key[0].setText("~");
			key[1].setText("!");
			key[2].setText("@");
			key[3].setText("#");
			key[4].setText("$");
			key[5].setText("%");
			key[6].setText("^");
			key[7].setText("&");
			key[8].setText("*");
			key[9].setText("(");
			key[10].setText(")");
			key[11].setText("_");
			key[12].setText("+");
			key[23].setText("{");
			key[24].setText("}");
			key[25].setText("|");
			key[35].setText(":");
			key[36].setText("\"");
			key[44].setText("<");
			key[45].setText(">");
			key[46].setText("?");
		}
		else {
			key[0].setText("`");
			key[1].setText("1");
			key[2].setText("2");
			key[3].setText("3");
			key[4].setText("4");
			key[5].setText("5");
			key[6].setText("6");
			key[7].setText("7");
			key[8].setText("8");
			key[9].setText("9");
			key[10].setText("0");
			key[11].setText("-");
			key[12].setText("=");
			key[23].setText("[");
			key[24].setText("]");
			key[25].setText("\\");
			key[35].setText(";");
			key[36].setText("'");
			key[44].setText(",");
			key[45].setText(".");
			key[46].setText("/");
		}
	}
	private void check(int num, char a) {
		int tmp=-1;
		for(int i=0;i<57;i++) {
			if(num==key_code[i]) {
				tmp=i;
				break;
			}
		}
		if(a==test_str.charAt(str_add)) {
			if(stack==0) {
				str_add++;
				right++;
			}
			else {
				wrong++;
				stack++;
			}
		}
		else if ( (0<=tmp && tmp<47) || tmp==53 || tmp==50 || tmp==48) {
			wrong++;
			stack++;
		}
		else if(tmp==47) {
			if(stack!=0) stack--;
			else if(str_add>0) str_add--;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		if(test_fin==0) {
			check(e.getKeyCode(), e.getKeyChar());
			if(str_add==41) {
				test_fin=1;
				finish.setText("Done");
				finish.setForeground(Color.RED);
			}
			right_click_time.setText(" Type correctly: "+right);
			wrong_click_time.setText(" Type incorrectly: "+wrong);
		}
		int keyCode = e.getKeyCode();
		for(int i=0;i<57;i++) {
			if(keyCode==key_code[i]) {
				key[i].setBackground(Color.YELLOW);
				if(keyCode == KeyEvent.VK_CAPS_LOCK) {
					board_change();
				}
				if(keyCode == KeyEvent.VK_SHIFT) {
					int t=caps_key;
					if(init==0) init=1;
					else {
						board_change();
						line1();
					}
					caps_key=t;
				}
				break;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		for(int i=0;i<57;i++) {
			if(keyCode==key_code[i]) {
				key[i].setBackground(Color.LIGHT_GRAY);
				if(keyCode == KeyEvent.VK_SHIFT) {
					if(caps_key==0) caps_key=1;
					else caps_key=0;
					board_change();
					line1();
				}
				break;
			}
		}
	}
}