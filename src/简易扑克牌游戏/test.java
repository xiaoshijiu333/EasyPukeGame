package �����˿�����Ϸ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test {

	//������������жϿ���̨������Ƿ������֣���ΪID֮��������
	public int exception() throws Exception {
		Scanner kb = new Scanner(System.in);
		int obj = kb.nextInt();
		if ((int) obj - obj == 0) {
			return obj;
		} else
			throw new Exception();
	}

	public void test1() {
		List<pukepai> list = new ArrayList<pukepai>();
		Scanner kb = new Scanner(System.in);

		// ׼������һ���˿��ƣ�û�д�С��
		List<pukepai> pailist = new ArrayList<pukepai>();
		String[] str1 = { "÷��", "����", "����", "����" };
		// ѭ������÷��2-����10
		for (int i = 2; i < 11; i++) {
			for (int j = 0; j < 4; j++) {
				String k = String.valueOf(i);
				pailist.add(new pukepai(str1[j], k));
			}
		}
		// ����J��Q��K��A���˿���
		for (int j = 0; j < 4; j++) {
			pailist.add(new pukepai(str1[j], "J"));
		}
		for (int j = 0; j < 4; j++) {
			pailist.add(new pukepai(str1[j], "Q"));
		}
		for (int j = 0; j < 4; j++) {
			pailist.add(new pukepai(str1[j], "K"));
		}
		for (int j = 0; j < 4; j++) {
			pailist.add(new pukepai(str1[j], "A"));
		}
		System.out.println("-------�˿��ƴ������---------");
		for (pukepai pai : pailist) {
			System.out.print(pai.huase + pai.shuzi + " ");
		}

		/*
		 * ������Ҫ�Ѵ�����������õ�pailist������ӵ��µļ���list�У���Ϊ������Ҫpailist���ϵ�����λ�ñȽϴ�С
		 * ����ʱlist���Ѿ�������˳����
		 */
		list.addAll(pailist);

		System.out.println("\n" + "\n" + "-------��Ϸ��ʼ��ϴ�����---------" + "\n");
		// ���ϵ�����������ڴ��Ҽ����е�˳��
		Collections.shuffle(list);

		//׼��������Ϸ���
		System.out.println("��ӭ��λ�����Ϸ");
		List<Student> stulist = new ArrayList<Student>();
		int m;		//�������id
		String str;		//�����������
		//����ÿ����������
		pukepai[] kepai = new pukepai[2];	//����������ϵ�������
		for (int i = 0; i < 4; i++) {
			System.out.println("�������" + (i + 1) + "λ���ID");
			while (true) {
				try {
					//���÷����ж��Ƿ�Ϊ���Σ���������׳��쳣����ӡ��ʾ
					m = exception();
					break;
				} catch (Exception e) {
					System.out.println("�����������λ���ID,��ʾ���������α���");
					continue;
				}
			}
			System.out.println("�������" + (i + 1) + "λ����ǳ�");
			str = kb.next();
			//������ƣ���ҵõ���i�ź͵�i+4��
			kepai[0] = list.get(i);
			kepai[1] = list.get(i + 4);
			Student stu = new Student(m, str);
			stu.shoupai.addAll(Arrays.asList(kepai));	//�������ƴ�����Ҷ���
			stulist.add(stu);
		}

		/*
		 * ��������λ�ñȽϴ�С,�ҳ�ÿλ�������������
		 */
		for (int i = 0; i < 4; i++) {
			if (pailist.indexOf(stulist.get(i).shoupai.get(0)) < pailist
					.indexOf(stulist.get(i).shoupai.get(1))) {
				stulist.get(i).maxpai = stulist.get(i).shoupai.get(1);
			} else {
				stulist.get(i).maxpai = stulist.get(i).shoupai.get(0);
			}
		}

		//�����ҵ�������Ϣ��id����������������
		System.out.println("��������ң�" + "\n");
		for (Student student : stulist) {
			System.out.println(student.id + ": " + student.name + "  ������Ϊ��"
					+ student.maxpai.huase + student.maxpai.shuzi);
		}

		//�ڴ�С������÷��2��С
		pukepai winpai = new pukepai("÷��", "2");
		
		//��������λ�ñȽϴ�С���Ƚ�������������ƣ��ҵ�������
		for (int i = 0; i < 4; i++) {
			if (pailist.indexOf(stulist.get(i).maxpai) > pailist
					.indexOf(winpai)) {
				winpai = stulist.get(i).maxpai;
			}
		}
		
		//�������������ҵ������
		for (int i = 0; i < 4; i++) {
			if (stulist.get(i).maxpai == winpai) {
				System.out.println("\n" + "����Ӯ���ǣ�" + stulist.get(i).id + ": "
						+ stulist.get(i).name + "\n");
			}
		}

		//��ӡ���ÿλ������ϵ������ƣ����ǰ��ȽϵĽ���Ƿ�
		for (Student student : stulist) {
			System.out.println(student.id + ": " + student.name + " ��������Ϊ��"
					+ student.shoupai.get(0).huase
					+ student.shoupai.get(0).shuzi + "��"
					+ student.shoupai.get(1).huase
					+ student.shoupai.get(1).shuzi);
		}

		kb.close();

	}

	public static void main(String[] args) {
		test ttt = new test();
		ttt.test1();
	}

}
