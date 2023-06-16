package metro;

import java.util.Scanner;

public class Mobilevalidation {
		static Scanner s=new Scanner(System.in);
		static int count=0;
		static long i=0;
		public static void main(String[]args) {
//			System.out.println("Enter your mobilenumber");
//			long m=s.nextLong();
//			if (mobilevalidate(m)) {
//				System.out.println("correct number");
//			}else {
//				System.out.println("wrong number");
//			}
			Mailverification();
		}
		public static boolean mobilevalidate(long mobile) {
			i=0;
			count=0;
			while(mobile>9)
			{
				i=mobile%10;
				mobile/=10;
				count++;
			}
			if ((count==9)&&(mobile==9 || mobile==8 || mobile==7 || mobile==6)) {
			return true;
		}
			return false;
		}
		public static boolean cardvalidate(long card) {
			count=0;
			while(card>0) {
				i=card%10;
				card/=10;
				count++;
			}
			if (count==16) {
				return true;
			}else {
				return false;
			}
		}
		public static void Mailverification() {
			System.out.println("Enter your email");
			String s1=s.nextLine();
			int count=0,j=0;
			for (int i = 0; i < s1.length()-1; i++) {
				char w=s1.charAt(i);
//				if (w=='@') {
//					System.out.println("hi");
//					count++;
//				}else 
				if(w<'.'){
					System.out.println("no hi");
					j++;
					System.out.println(j);
				}
			}
			if (count==1) {
				System.out.println("hiiiiiiiiii");
			}else if (j<=3) {
				System.out.println(j);
				System.out.println("no hiiiiiiiii");
			}
		}
}
