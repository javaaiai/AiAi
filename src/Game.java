import java.util.Random;
import java.util.Scanner;

public class Game {
	private Scanner scan=new Scanner(System.in);
	private Random rand=new Random();
	private String player1;//���1������
	private String player2;//���2������
	private int tossPlayer1;//���1�����ӵ��� 1-6
	private int tossPlayer2;//���2�����ӵ��� 1-6
	private int posPlayer1;//���1��λ��
	private int posPlayer2;//���2��λ��
	private boolean isPause1;//���1�Ƿ���ͣ
	private boolean isPause2;//���2�Ƿ���ͣ
	Map map=new Map();
	//�����������
	public void setPlayer(){
		System.out.println("��ѡ����ң�");
		System.out.println("1.������ 2.��ɭ������ 3.��˰�ɪ 4.�Ͷ�");
tag1:		while(true){
			System.out.print("Ϊ���1ѡ���ɫ��");
			switch(scan.nextInt()){
				case 1:{
					player1="������";
					break;
				}
				case 2:{
					player1="��ɭ������";
					break;
				}
				case 3:{
					player1="��˰�ɪ";
					break;
				}
				case 4:{
					player1="�Ͷ�";
					break;
				}
				default:
					System.out.println("�������룬����������1-4");
					continue tag1;
			}
			break;
		}
		System.out.println();
tag2:		while(true){
			System.out.print("Ϊ���2ѡ���ɫ��");
			switch(scan.nextInt()){
				case 1:{
					player2="������";
					break;
				}
				case 2:{
					player2="��ɭ������";
					break;
				}
				case 3:{
					player2="��˰�ɪ";
					break;
				}
				case 4:{
					player2="�Ͷ�";
					break;
				}
				default:
					System.out.println("�������룬����������1-4");
					continue tag2;
			}
			break;
		}
		System.out.println();
		System.out.println("���1��"+player1+"����A��ʾ");
		System.out.println("���2��"+player2+"����B��ʾ");
	}
	//��Ϸ��������߼��жϺ͵�ͼ����
	public void play(){
		map.setValue();
		setPlayer();
		while(true){
			if(posPlayer1==99){
				System.out.println(player1+"ʤ�������յ㣬��Ϸ����");
				break;
			}else if(posPlayer2==99){
				System.out.println(player2+"ʤ�������յ㣬��Ϸ����");
				break;
			}else{
				if(!isPause1){//������1����ͣ���ֵ����1������
					System.out.println(player1+",�밴���������س������ӣ�");
					scan.next();
					tossPlayer1=rand.nextInt(6)+1;
					System.out.println("������������Ϊ��"+tossPlayer1);
					posPlayer1+=tossPlayer1;
					switch(map.value[posPlayer1]){
					case 1:
						break;
					case 2:{//��ͣ
						System.out.println("���簡����Ҫ��ͣһ��");
						isPause1=true;
						}
						break;
					case 3:{//��������
						System.out.print("�������̸�������ѡ��1.�ͶԷ�����λ�� 2.ʹ�Է�����6��");
						while(true){
							String choice=scan.next();
							if("1".equals(choice)){
								int temp=posPlayer1;
								posPlayer1=posPlayer2;
								posPlayer2=temp;
								break;
							}else if("2".equals(choice)){
								if(posPlayer2<6){
									posPlayer2=0;
								}else{
									posPlayer2-=6;
								}
								break;
							}else{
								System.out.println("��������������������");
							}
						}
						}
						break;
					case 4:{//����
						System.out.println("���������ȵ������ˣ�����10����");
						if(posPlayer1<10){
							posPlayer1=0;
						}else{
							posPlayer1-=10;
						}
						}
						break;
					case 5:{//ʱ�����
						System.out.println("��������ã��ߵ�ʱ�������ǰ��10����");
						if(posPlayer1>89){
							posPlayer1=99;
						}else{
							posPlayer1+=10;
						}
						}
						break;
					default:
						break;
					}
					map.showMap(posPlayer1,posPlayer2);
				}else{//������1��ͣ���ֵ����1������
					isPause1=false;
				}
				
				if(!isPause2){//������2����ͣ���ֵ����2������
					System.out.println(player2+",�밴���������س������ӣ�");
					scan.next();
					tossPlayer2=rand.nextInt(6)+1;
					System.out.println("������������Ϊ��"+tossPlayer2);
					posPlayer2+=tossPlayer2;
					switch(map.value[posPlayer2]){
					case 1:
						break;
					case 2:{//��ͣ
						System.out.println("���簡����Ҫ��ͣһ��");
						isPause2=true;
						}
						break;
					case 3:{//��������
						System.out.print("�������̸�������ѡ��1.�ͶԷ�����λ�� 2.ʹ�Է�����6��");
						while(true){
							String choice=scan.next();
							if("1".equals(choice)){
								int temp=posPlayer2;
								posPlayer2=posPlayer1;
								posPlayer1=temp;
								break;
							}else if("2".equals(choice)){
								if(posPlayer1<6){
									posPlayer1=0;
								}else{
									posPlayer1-=6;
								}
								break;
							}else{
								System.out.println("��������������������");
							}
						}
						}
						break;
					case 4:{//����
						System.out.println("���������ȵ������ˣ�����10����");
						if(posPlayer2<10){
							posPlayer2=0;
						}else{
							posPlayer2-=10;
						}
						}
						break;
					case 5:{//ʱ�����
						System.out.println("��������ã��ߵ�ʱ�������ǰ��10����");
						if(posPlayer2>89){
							posPlayer2=99;
						}else{
							posPlayer2+=10;
						}
						}
						break;
					default:
						break;
					}
					map.showMap(posPlayer1,posPlayer2);
				}else {//������2��ͣ���ֵ����2������
					isPause2=false;
				}
			}
		}
	}
}
