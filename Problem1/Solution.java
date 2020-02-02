
/*

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/
import java.util.*;
class Solution {

	public static void main(String r[]){

		Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring("aaaaa"));

	}


    public int lengthOfLongestSubstring(String s) {
        
       Map<Character, Integer> map = new HashMap();
       int startIndex = 0;
       int endIndex = 0;
       String lSubString ="";
       for(int i = 0 ; i<s.length(); i++){
       	System.out.println("**************" + i);

       	 char c = s.charAt(i);
       	 if(map.get(c) == null){
       	 	System.out.println("!got " + c);
       	 	//we are good not repeating yet
       	 	endIndex = i;
       	 	String subS = s.substring(startIndex, endIndex +1);
       	 	System.out.println("--"+subS);
       	 	if(subS.length() > lSubString.length()){
       	 		lSubString = subS;
       	 	}
       	 	map.put(c, 1);
       	 } else {
       	 System.out.println("got " + c);
      	 if(startIndex < s.length()){
      	 	System.out.println("start index shift");
      	 	map = new HashMap();

       	 	//repeat found
       	 	i = startIndex++;
       	 }
       	}

       	 System.out.println(lSubString);

       }

       return lSubString.length();
    }
}