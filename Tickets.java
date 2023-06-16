package metro;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Tickets {
	static Metro m=new Metro();
	static Tickets t=new Tickets();
	static int number=0;
	static String from;
	static String to;
	static LocalDateTime now;
	public static void main(String[] args)throws Exception {
		if(m.Welcome()==true) {
			from=m.fromstation();
		}else {
			System.exit(0);
		}
		to=m.tostation();
		System.out.println("\n\nYou are entered from station is : "+from);
		System.out.println("You are entered destination is : "+to);
		double total=m.pax();
	    boolean z=m.payment(total);
	    if(z) {
	    	System.out.print("Please wait.");
	    	Thread.sleep(500);
	    	System.out.print(".");
	    	Thread.sleep(500);
	    	System.out.print(".");
	    	Thread.sleep(500);
	    }
	    else {
	    	m.payment(total); 	
	    }
	    t.ticketno();
	    t.station(from,to,total);
	}
	public void ticketno() {
		Random n=new Random();
		number=n.nextInt(100000);
	}
	public void station(String from,String to,double price) throws InterruptedException {
		String from1=from;
		String to1=to;
		double price1=price;
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
		now=LocalDateTime.now();
		Thread.sleep(700);
		System.out.println("\n\tPayment successful\n");
		System.out.print("\n\n\tPlease wait Your ticket is printing.");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(3000);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\t\t\t--------------------------------------------------------------");
		System.out.println("\t\t\t       		CHENNAI METRO                          ");
		System.out.println("\t\t\t--------------------------------------------------------------");
		System.out.println("\t\t\t	Date/time	:"+format.format(now)+"                  ");
		System.out.print("\t\t\t	From		:"+from1+"                    \n");
		System.out.print("\t\t\t	To  		:"+to1+"\n");
		System.out.println("\t\t\t  	No.of.Passengers:"+Metro.pax1+" ");
		System.out.println("\t\t\t   	Price		:Rs."+price1+"							 ");
		System.out.println("\t\t\t--------------------------------------------------------------");
		System.out.println("\t\t\t   		Ticket.no   :"+number);
		System.out.println("\t\t\t--------------------------------------------------------------");
		System.out.println("\t\t\t		This Ticket only work for 2hours	");
		System.out.println("\t\t\t--------------------------------------------------------------");
		System.out.println("\t\t\t		Please retain till the end of journey				   ");
		System.out.println("\t\t\t--------------------------------------------------------------");
	}
}
