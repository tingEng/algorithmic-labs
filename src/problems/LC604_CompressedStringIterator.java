package problems;

public class LC604_CompressedStringIterator {
	static class StringIterator {
		private char[] chars;
		private int index;
		private char curChar;
		private int count;

		public StringIterator(String compressedString) {
        this.chars = compressedString.toCharArray();
		}
    
    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        if (count == 0) {
            if (index == chars.length) {
                return ' ';
            } 
            curChar = chars[index++];
            while (index < chars.length && Character.isDigit(chars[index])) {
                count = 10 * count + chars[index] - '0';
                index++;
            }
        }
        count--;
        return curChar;
    }
    
    public boolean hasNext() {
        return index < chars.length || count != 0;
    }
	}

	public static void main(String[] args) {
		 StringIterator it = new StringIterator("a2b10");
	        while (it.hasNext()) System.out.print(it.next());
	        System.out.println();
	        System.out.println(new StringIterator("x1").next());
	        System.out.println(new StringIterator("x1").next());

	}

}
