
public class StartGame {

	public static void main(String[] args) {
		//��ӭ���棬��ʾ����
		for(int i=0;i<30;i++){
			System.out.print('��');
		}
		System.out.println();
		
		System.out.print('��');
		for(int i=0;i<105;i++){
			System.out.print(' ');
		}
		System.out.print('��');
		System.out.println();
		
		System.out.print('��');
		for(int i=0;i<74;i++){
			System.out.print(' ');
			if(i==37){
			System.out.print("��   ʿ   ��   ��   ��");	
			}
		}
		System.out.print('��');
		System.out.println();
		
		System.out.print('��');
		for(int i=0;i<105;i++){
			System.out.print(' ');
		}
		System.out.print('��');
		System.out.println();
		
		for(int i=0;i<30;i++){
			System.out.print('��');
		}
		System.out.println();
		//��ʼ��Ϸ
		Game game=new Game();
		game.play();
	}

}
