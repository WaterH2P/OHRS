package test;

import Remote.Impl.HotelImplForHotel;

public class test_hotelbl {
	private static HotelImplForHotel hbl = new HotelImplForHotel();
	
	private static void test1(){
		System.out.println(hbl.hotellogin("110011", "sb"));	
	}
	
	
	public static void main(String args[]){
		test1();
	}
}
