package third_task;

public class palindrome {
	
    /**
     * Reverse string
     *
     * @return new reversed string
     */
	public static String reverseString(String word) {
		return new StringBuilder(word).reverse().toString();
	}
	
    /**
     * Check string is palendrome
     *
     *@param word
     *@param new_word
     *
     * If true print yes
     * 
     * If false print no
     */
	public static void isPalendrome(String word, String new_word) {
		if (word.equals(new_word)) {
			System.out.println("Строка является палиндромом.");
		}
		else {
			System.out.println("Строка не является палиндромом.");
		}
	}
	
	public static void main(String[] args) {
		String word = "шалаш"; // original string
		String new_word = reverseString(word); // new string
		System.out.println("Изначальная строка: " + word);
		System.out.println("Перевернутая строка: " + new_word);
		isPalendrome(word, new_word);

	}
}
