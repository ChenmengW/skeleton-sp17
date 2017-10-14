public class OffByN implements CharacterComparator{
	private int difference;

	OffByN(int N){
		difference = N;
	}

	@Override
	public boolean equalChars(char x, char y){
		int result = Math.abs(x-y);
		return result == difference ;
	}

} 