import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedLargeInteger implements LargeInteger {
	private LinkedList lhList;
	private final int one = 1;
	private final int zero = 0;
	private final int ten = 10;
	
	public LinkedLargeInteger(String value) {
		
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
		return "";
	}
}
