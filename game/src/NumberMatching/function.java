//package NumberMatching;
//
//import java.util.ArrayList;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//import juldarigi.background;
//
//public class function extends JPanel{
//	
//	private static int answer;
//	private static ArrayList<ImageIcon> marbles;
//	
//	//셔플
//	public static int[] shuffle(int[] arr){
//	    for(int x=0;x<arr.length;x++){
//	      int i = (int)(Math.random()*arr.length);
//	      int j = (int)(Math.random()*arr.length);
//	      int tmp = arr[i];
//	      arr[i] = arr[j];
//	      arr[j] = tmp;
//	    }
//	    return arr;
//	}
//
//	
//	public static int randomMarble(int level) {
//		NumberMatching.background.comment.setText(level+"/4");
//		String imgUrl = "../img/marble";
//		int[] answers = {0,0,0,0};
//		int[] numbers = new int[15];
//		for(int i=0;i<numbers.length;i++) {
//			numbers[i] = i+1;
//		}
//				
//		//섞인 숫자 배열
//		int[] random_number = shuffle(numbers);
//		int answerIndex = (int)(Math.random() * 4);
//		
//		//랜덤 보기
//		for(int i=0;i<answers.length;i++) {
//			answers[i] = random_number[i];
//			System.out.println(answers[i]);
//		}
//		
//		marbles = new ArrayList<ImageIcon>();
//
//		
//		//이미지 준비
//		for(int i=0;i<random_number[answerIndex];i++) {
//			int type = (int)(Math.random() * 2)+1;
//			String res =  imgUrl+Integer.toString(type);
//			marbles.add( new ImageIcon(function.class.getResource(imgUrl+Integer.toString(type)+".png")));
//		}
//		//panel에 출력
//		for(int i=0;i<random_number[answerIndex];i++) {
//			JLabel label = new JLabel();
//			int locationX = (int)(Math.random()*820); //865
//			int locationY = (int)(Math.random()*300); //190
//			label.setBounds(locationX, locationY, 69, 69);
//			label.setIcon(marbles.get(i));
//			NumberMatching.background.gamePanel.add(label);
//		}
//		
//		changeBtnValue(answers);
//		answer = answers[answerIndex];
//		return answers[answerIndex];
//	}
//	
//	
//	public static void changeBtnValue(int[] answers) {
//		NumberMatching.background.btn1.setText(Integer.toString(answers[0]));
//		NumberMatching.background.btn2.setText(Integer.toString(answers[1]));
//		NumberMatching.background.btn3.setText(Integer.toString(answers[2]));
//		NumberMatching.background.btn4.setText(Integer.toString(answers[3]));
//	}
//	
//	
//	public static void checkAnswer(JButton btn) {
//		int selected = Integer.parseInt(btn.getText());
//		System.out.println(selected);
//		//기존 이미지 삭제
//		for(int i=0;i<marbles.size();i++) {
//			marbles.remove(i);
//		}
//		if(selected == answer) {
//			
//		}
//		NumberMatching.background.gamePanel.repaint();
//		randomMarble(execute.level++);
//	}
//	
//
//}
