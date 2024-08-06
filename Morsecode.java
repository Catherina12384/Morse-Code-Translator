import java.util.*;
public class Morsecode {

    public static Map<String,String> morse = new HashMap<>();
    public static Map<String,String> Rev_morse = new HashMap<>();
    static{
        morse.put("A",".-");
        morse.put("B", "-...");
        morse.put("C", "-.-.");
        morse.put("D", "-..");
        morse.put("E", ".");
        morse.put("F", "..-.");
        morse.put("G", "--.");
        morse.put("H", "....");
        morse.put("I", "..");
        morse.put("J", ".---");
        morse.put("K", "-.-");
        morse.put("L", ".-..");
        morse.put("M", "--");
        morse.put("N", "-.");
        morse.put("O", "---");
        morse.put("P", ".--.");
        morse.put("Q", "--.-");
        morse.put("R", ".-.");
        morse.put("S", "...");
        morse.put("T", "-");
        morse.put("U", "..-");
        morse.put("V", "...-");
        morse.put("W", ".--");
        morse.put("X", "-..-");
        morse.put("Y", "-.--");
        morse.put("Z", "--..");

        morse.put("0", "-----");
        morse.put("1", ".----");
        morse.put("2", "..---");
        morse.put("3", "...--");
        morse.put("4", "....-");
        morse.put("5", ".....");
        morse.put("6", "-....");
        morse.put("7", "--...");
        morse.put("8", "---..");
        morse.put("9", "----.");

        morse.put(" ", "|");

        for(Map.Entry <String,String> code : morse.entrySet()){
            Rev_morse.put(code.getValue(), code.getKey());
        }
    }

    static String Encrypt(String str){
        str = str.toUpperCase();
        StringBuilder str1 = new StringBuilder();

        for (int i = 0; i < str.length(); i++){
            String letter = String.valueOf(str.charAt(i));
            if(morse.containsKey(letter)){
                str1.append(morse.get(letter)).append(" ");
            }
        }

        String encrypted = str1.toString();

        return encrypted;
    }

    static String Decrypt(String str){
        StringBuilder str1 = new StringBuilder();
        String code [] = str.split(" ");
        
        for( String letter : code){
            if(Rev_morse.containsKey(letter)){
                str1.append(Rev_morse.get(letter));
            }
        }

        String decrypted = str1.toString();
        return decrypted;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("-------------------------");
        System.out.println("|\t1.Encrypt\t|");
        System.out.println("|\t2.Decrypt\t|");
        System.out.println("-------------------------");

        System.out.print("Choose an option: ");
        int ch = s.nextInt();

        s.nextLine();

        System.out.print("Enter the string:");
        String str = s.nextLine();

        switch (ch) {
            case 1:
                System.out.println(Encrypt(str));
                break;
            case 2:
                System.out.println(Decrypt(str));
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
        s.close();  
    }
}
