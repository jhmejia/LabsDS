public class misty {
    public static void main(String args[]) {
      
        char[] christmas = {'c', 'h', 'r', 'i', 's', 't', 'm', 'a', 's'};  
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};  
        
        
        for (int i = 0; i < christmas.length; i++)
        {
            boolean isVowel = false;
            for (int j = 0; j < vowels.length; j++)
                if(vowels[j] == christmas[i]) isVowel = true;
            if (isVowel) System.out.println(christmas[i]);
        }
  
       
      }
}
