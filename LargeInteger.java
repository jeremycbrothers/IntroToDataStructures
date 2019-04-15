public interface LargeInteger extends Comparable<LargeInteger> {
	public LargeInteger add(LargeInteger rhList);
	
	public LargeInteger subtract(LargeInteger rhList);
	
	public LargeInteger negate();
	
	public LargeInteger abs();
	
	public LargeInteger multiply(LargeInteger rhList);
	
	public LargeInteger max(LargeInteger rhList);
	
	public LargeInteger min(LargeInteger rhList);
	
	public int sigNum();

	@Override
	public int compareTo(LargeInteger arg0);
}
