import java.util.ArrayList;

public class ArrayLargeInteger implements LargeInteger {
	private ArrayList<Integer> lhList;
	private final int one = 1;
	private final int zero = 0;
	private final int ten = 10;
	
	public ArrayLargeInteger(String value) {
		lhList = new ArrayList<Integer>();
		
		for(char c : value.toCharArray()) {
			int n = Character.getNumericValue(c);
			lhList.add(n);
		}
		System.out.println(toString());
	}

	@Override
	public LargeInteger negate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LargeInteger abs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int sigNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(LargeInteger arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public String toString() {
		String value = "";
		for(int i = 0; i < lhList.size(); i++) {
			value += lhList.get(i);
		}
		return value;
	}

	@Override
	public LargeInteger add(LargeInteger rhList) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public LargeInteger subtract(LargeInteger rhList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LargeInteger multiply(LargeInteger rhList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LargeInteger max(LargeInteger rhList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LargeInteger min(LargeInteger rhList) {
		// TODO Auto-generated method stub
		return null;
	}
}
