package guerer.example;

/*
 *   Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.   

 Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.

 Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true

 */
public class RansomNote {
	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] count1 = getCount(ransomNote.toLowerCase());
		int[] count2 = getCount(magazine.toLowerCase());
		for (int i = 0; i < 26; i++) {
			if (count1[i] > count2[i]) {
				return false;
			}
		}
		return true;
	}

	static int[] getCount(String str) {
		int[] count = new int[26];
		for (char c : str.toCharArray()) {
			count[c - 'a']++;
		}
		return count;
	}
}
