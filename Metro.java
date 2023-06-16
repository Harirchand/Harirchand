package metro;

import java.util.Scanner;

public class Metro {
	static Scanner s=new Scanner(System.in);
	static int a,b,count=0;
	static int pax1;
	static long mobile=0;
	static Tickets t=new Tickets();
	static Metromain me=new Metromain();
	public boolean Welcome() throws Exception {
		me.existing();
		boolean d=true;
		Thread.sleep(200);
		System.out.println("\n\n\n\t\t\tWelcome to Chennai Metro");
		Thread.sleep(200);
		System.out.println("\n\tBook your tickets on Online");
		System.out.println("\n\tSelect the input");
		do{
			try {
		System.out.println("\n\t1.Signup\n\t2.Login\n\t3.Forget password\n\t4.Delete account");
		String select=s.next();
		int select1=Integer.parseInt(select);
		switch(select1) {
		case 1:{
			if(Metromain.signup()) {
				Thread.sleep(700);
			System.out.println("\n\tSign-up successful");
			Thread.sleep(700);
			System.out.println("\n\tLogin with Email-Id\n");
			
			if(me.login()) {
				d=false;
			}
			else {
				d=true;
			}
			}break;
		}
		case 2:{
			if(me.login()) {
				d=false;
			}
			else {
				me.login();
				d=true;
			}break;
		}
		case 3:{
			me.forgetpassword();
			break;
		}
		case 4:{
			System.out.println("Enter your mobilenumber");
			try{String mobiles=s.next();
			long mobiles1=Long.parseLong(mobiles);
			if(me.deleteById(mobiles1)) {
				d=false;
				return false;
			}else {
				System.out.println("Entered Mobilenumber is wrong");
				d=true;
				break;
			}
			}catch(Exception e) {
				System.out.println("Invalid Input");
				System.out.println("Please try again");
			}
		}
		}break;
		
		}catch(Exception e) {
			System.out.println("Invalid Input");
			System.out.println("Please try again\n Use Numbers");
			d=true;
		}
		}while(d);
		return true;
	}
	public String fromstation() throws InterruptedException {
		Thread.sleep(500);
		String e="";
		boolean d=true;
		do{System.out.println("\n\tEnter Starting journey");
		String from[]={"\n\n\t1.Chennai airport","2.Meenambakkam","3.Nanganallur road","4.Alandur","5.Ekkatuthangal","6.Ashok nagar","7.Vadapalani","8.Arumbakkam","9.CMBT","10.Koyembedu","11.Thirumangalam","12.Anna nagar tower","13.Shenoy nagar","14.Pachayappa's college","15.Kilpauk","16.Nehru park","17.Egmore Metro","18.Central metro"};
		for (int i = 0; i < from.length; i++) {
			System.out.println("\t"+from[i]);
		}
		try{String f=s.next();
		int f1=Integer.parseInt(f);
		a=f1-1;
		d=false;
		}catch(Exception g) {
			System.out.println("Invalid input\nPlease try again");
			d=true;
		}e= from[a];
		}while(d);
		return e;
	}
	public String tostation() throws InterruptedException {
		Thread.sleep(500);
		String e="";
		boolean d=true;
		do{
		System.out.println("\n\tEnter ending journey");
		String to[]={"\n\n\t1.Chennai airport","2.Meenambakkam","3.Nanganallur road","4.Alandur","5.Ekkatuthangal","6.Ashok nagar","7.Vadapalani","8.Arumbakkam","9.CMBT","10.Koyembedu","11.Thirumangalam","12.Anna nagar tower","13.Shenoy nagar","14.Pachayappa's college","15.Kilpauk","16.Nehru park","17.Egmore Metro","18.Central metro"};
		for (int i = 0; i < to.length; i++) {
			System.out.println("\t"+to[i]);
			d=false;
		}
		try{int g=s.nextInt();
		b=g-1;
			}catch(Exception g) {
				System.out.println("Invalid input\nPlease try again");
			}
		e=to[b];
		}while(d);
		return e;
	}
	public double pax() throws InterruptedException {
		int c=b-a,total=0;
		Thread.sleep(700);
		System.out.println("\n\tEnter No.of.passengers");
		String pax=s.next();
		try {
		pax1=Integer.parseInt(pax);
		if (c<=5&&c>=-5) {
			System.out.println("\n\tThe Ticket price is :"+"Rs."+20);
			total=pax1*20;
			System.out.println("\n\tTotal price of ticket is: "+total); 
		}
		else if (c<14&&c>-14) {
			System.out.println("\n\tThe Ticket price is :"+"Rs."+30);
			total=pax1*30;
			System.out.println("\n\tTotal price of ticket is: "+total);
		}else if(c<19&&c>-19) {
			System.out.println("\n\tThe Ticket price is :"+"Rs."+40);
			total=pax1*40;
			System.out.println("\n\tTotal price of ticket is: "+total);
		}
		}catch (Exception e) {
			System.out.println("Invalid input");
		}
		return total;
	}
	public boolean payment(double total) throws InterruptedException {
		Mobilevalidation mv= new Mobilevalidation();
		System.out.println("\n\tSelect payment method\n\t1.Card payment\n\t2.UPI transaction");
		int pay=s.nextInt();
		boolean b=true;
		switch(pay) {
		case 1:
			System.out.println("\n\t1.HDFC bank\n\t2.SBI bank\n\t3.ICICI bank\n\t4.Axis bank\n\t5.Canara bank\n\t6.City union bank");
			int bank=s.nextInt();
			if(bank<=6) {
			do{
				System.out.println("\n\tEnter your 16 digit card number");
			long details=s.nextLong();
			if(Mobilevalidation.cardvalidate(details)) {
				b=false;
			}else {
				System.out.println("Check card number");
			}
			}while(b);
			System.out.println("\n\tVerify given "+Fetchingdetails.mobilenumber+" is correct?\n\t1.Yes\n\t2.no");
			int select=s.nextInt();
			if (select ==1) {
				verification(Fetchingdetails.mobilenumber);
				return true;
			}else {
				System.out.println("\n\tPlease check your number");
				return false;
			}
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
			if (Fetchingdetails.mobilenumber==mobile1) {
				verification(Fetchingdetails.mobilenumber);
				return true;
			}else {
				System.out.println("\n\tPlease check your number and try again");
				payment(total);
				return true;
			}
		default:
			System.out.println("\n\tEntered input wrong pls try again");
			payment(total);
			return true;
		}
		return true;
	}
	public static boolean verification(long mobilen) throws InterruptedException {
		count++;
		System.out.println("Check OTP is send your registered "+mobilen+" number");
		double otp=Math.random()*9999+9999;
		int sysotp=(int) otp;
		System.out.println("\n\t"+sysotp);
		System.out.println("\n\tEnter the your otp");
		int otp1=s.nextInt();
		if(sysotp==otp1) {
			Thread.sleep(500);
			System.out.println("\n\tYour OTP verified");
			return true;
		}
		else {
			if(count<3) {
			verification(mobilen);
			}else {
			System.out.println("\n\tYou are reached max attempts");
			System.out.println("\n\tPlease try again later");
			}
		}
		return false;
		}	
	}

