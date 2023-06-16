package edu.hari.metro2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Tickets {
	static Metro m=new Metro();
	static Tickets t=new Tickets();
	static int number=0;
	public static void main(String[] args)throws InterruptedException {
		m.Welcome();
		m.mobilenumber();
		String from=m.fromstation();
		System.out.println(from);
		String to=m.tostation();
		System.out.println(to);
		double total=m.pax();
	    m.payment(total);
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
		LocalDateTime now=LocalDateTime.now();
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
		System.out.println("\t\t\t	From		:"+from1+"                             ");
		System.out.println("\t\t\t	To  		:"+to1+"            ");
		System.out.println("\t\t\t   	Price		:Rs."+price1+"							 ");
		System.out.println("\t\t\t--------------------------------------------------------------");
		System.out.println("\t\t\t   		Ticket.no   :"+number);
		System.out.println("\t\t\t--------------------------------------------------------------");
		System.out.println("\t\t\t		Please retain till the end of journey						   ");
		System.out.println("\t\t\t--------------------------------------------------------------");
	}
}
