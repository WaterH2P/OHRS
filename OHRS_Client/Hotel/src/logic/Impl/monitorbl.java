package logic.Impl;

public class monitorbl {
	
	public static boolean[] signupcheckHotelInfor(int[] num, int[] price){
		boolean checkresult[] = new boolean[num.length];
		if(num.length==price.length){
			for(int i=0;i<num.length;i++){
				if(num[i]<1000000&&price[i]<1000000)
					checkresult[i] = true;
				else
					checkresult[i] = false;
			}
		}
		return checkresult;
	}

}

