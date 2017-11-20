package servicehelper;

public interface PromotionServiceHelper {
	public void maketimepromotion(String starttime, String finishtime, String number);

	public void makelevelpromotion(String level1, String level2, String pos, String dis);

	public String gettimepromotion();
	
	public String getlevelpromotion();
}
