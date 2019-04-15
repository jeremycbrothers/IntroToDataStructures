
public class MainDriver {
	public static void main(String[] args) {
		ArrayLargeInteger lhList = new ArrayLargeInteger("1");
		ArrayLargeInteger rhList = new ArrayLargeInteger("1");
		ArrayLargeInteger resultList;
		resultList = (ArrayLargeInteger) lhList.add(rhList);
		System.out.println(resultList.toString());
	}
}
