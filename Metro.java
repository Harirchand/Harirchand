package edu.hari.metro2;

import java.util.Scanner;

public class Metro {
	static Scanner s=new Scanner(System.in);
	static int a,b,count=0;
	static long mobile=0;
	static Tickets t=new Tickets();
	public void Welcome() {
		System.out.println("\n\n\n\t\t\tWelcome to Chennai Metro");
		System.out.println("\n\tBook your tickets");
	}
	public boolean mobilenumber() {
		System.out.println("\n\t Enter your mobile number");
		mobile=s.nextLong();
		if(verification()) {
			System.out.println("\n\tMobile Number verified");
		return true;
		}else {
			System.out.println("\n\tMobile Number not verified");
		return false;
		}
	}
	public String fromstation() {
		System.out.println("\n\tEnter Starting journey");
		String from[]={"\n\n\t1.Chennai airport","2.Meenambakkam","3.Nanganallur road","4.Alandur","5.Ekkatuthangal","6.Ashok nagar","7.Vadapalani","8.Arumbakkam","9.CMBT","10.Koyembedu","11.Thirumangalam","12.Anna nagar tower","13.Shenoy nagar","14.Pachayappa's college","15.Kilpauk","16.Nehru park","17.Egmore Metro","18.Central metro"};
		for (int i = 0; i < from.length; i++) {
			System.out.println("\t"+from[i]);
		}
		int f=s.nextInt();
		a=f-1;
		String e= from[a];
		return e;
	}
	public String tostation() {
		System.out.println("\n\tEnter ending journey");
		String to[]={"\n\n\t1.Chennai airport","2.Meenambakkam","3.Nanganallur road","4.Alandur","5.Ekkatuthangal","6.Ashok nagar","7.Vadapalani","8.Arumbakkam","9.CMBT","10.Koyembedu","11.Thirumangalam","12.Anna nagar tower","13.Shenoy nagar","14.Pachayappa's college","15.Kilpauk","16.Nehru park","17.Egmore Metro","18.Central metro"};
		for (int i = 0; i < to.length; i++) {
			System.out.println("\t"+to[i]);
		}
		int g=s.nextInt();
		b=g-1;
		String e=to[b];
		return e;
	}
	public double pax() {
		int c=b-a,total=0;
		System.out.println("\n\tEnter No.of.passengers");
		int pax=s.nextInt();
		if (c<=5&&c>=-5) {
			System.out.println("\n\tThe Ticket price is :"+"Rs."+20);
			total=pax*20;
			System.out.println("\n\tTotal price of ticket is: "+total); 
		}
		else if (c<=14&&c>=-14) {
			System.out.println("\n\tThe Ticket price is :"+"Rs."+30);
			total=pax*30;
			System.out.println("\n\tTotal price of ticket is: "+total);
		}else if(c<19&&c>-19) {
			System.out.println("\n\tThe Ticket price is :"+"Rs."+40);
			total=pax*40;
			System.out.println("\n\tTotal price of ticket is: "+total);
		}
		return total;
	}
	public boolean payment(double total) {
		System.out.println("\n\tSelect payment method\n\t1.Card payment\n\t2.UPI transaction");
		int pay=s.nextInt();
		switch(pay) {
		case 1:
			System.out.println("\n\t1.HDFC bank\n\t2.SBI bank\n\t3.ICICI bank\n\t4.Axis bank\n\t5.Canara bank\n\t6.City union bank");
			int bank=s.nextInt();
			if(bank<=6) {
			System.out.println("\n\tEnter your card details");
			long details=s.nextLong();
			verification();
			return true;
			}else {
				System.out.println("\n\tEntered input wrong pls try again");
				payment(total);
			}
			break;
		
		case 2:
			System.out.println("\n\t1.Googlepay\n\t2.Phonepe\n\t3.Paytm");
			int gpay=s.nextInt();
			System.out.println("\n\t Enter your mobilenumber");
			long mobile1=s.nextLong();
			if (mobile==mobile1) {
				verification();
				return true;	
			}else {
				System.out.println("\n\tPlease check your number and try again");
				payment(total);
			}
		default:
			System.out.println("\n\tEntered input wrong pls try again");
			payment(total);
		}
		return false;
	}
	public static boolean verification() {
		count++;
		double otp=Math.random()*9999+9999;
		int sysotp=(int) otp;
		System.out.println("\n\t"+sysotp);
		System.out.println("\n\tEnter the your otp");
		int otp1=s.nextInt();
		if(sysotp==otp1) {
			System.out.println("\n\tYour OTP verified");
			return true;
		}
		else {
			if(count<3) {
			verification();
			}else {
			System.out.println("\n\tYou are reached max attempts");
			System.out.println("\n\tPlease try again later");
			}
		}
		return false;
		}
		
	}

