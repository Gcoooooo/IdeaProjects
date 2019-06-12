package com.jianzhioffer.www;

public class No_46_dp_TranslateNumToStr {
	public static void main(String[] args){
        System.out.println(getTranslationCount(-10));  //0
        System.out.println(getTranslationCount(1234));  //3
        System.out.println(getTranslationCount(12258)); //5
    }

	public static int getTranslationCount(int number) {
		if (number < 0) {
			return 0;
		}
		
		if (number == 1) {
			return 1;
		}
		
		String str = Integer.toString(number);
		
		return getTranslationCount(str);
	}
	
	public static int getTranslationCount(String str) {
		int f = 1; //������12218����f��ʼֵΪ0���򲻻��϶�18�����ַ��뷽��
		int fLessOne = 1;
		int g = 0;
		
		for (int i = str.length() - 2; i > 0; i--) {
			g = Integer.parseInt(str.charAt(i) + "" + str.charAt(i + 1)) < 26 ? 1 : 0; //�˴���""����Ϊ��������char�Զ�ת����String
			int fLessTow = 0;
			
			fLessTow = fLessOne + f * g;
			
			int temp = f;
			f = fLessOne;
			fLessOne = fLessTow;
		}
		
		return fLessOne + f * g;
	}

}
