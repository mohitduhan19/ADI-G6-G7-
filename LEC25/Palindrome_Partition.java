package LEC25;
import java.util.*;
public class Palindrome_Partition {
    public void help(String s , int idx , List<String> list , List<List<String>>ans){
        if(idx == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx;i < s.length();i++){
            if(isPalindrome(s, idx ,i)){
                list.add(s.substring(idx , i+1));
                help(s , i + 1 , list , ans);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s ,int i  , int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;j--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<String> l = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        help(s , 0 , l , ans);

        return ans;
    }
}
