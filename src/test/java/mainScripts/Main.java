package mainScripts;

/**
 * Let's play with strings
 *
 * EXPLANATION:
 *
 * 1) The coding exercise consist on discarding elements within a list depending on:
 *      - Element length
 *      - Element's first letter
 *      - Sorting the new filtered list
 *
 * 2) Output MUST be similar to example below
 *
 * 3) You cannot erase anything that's already part of the exercise (main class, main method)
 *
 * 4) No restrictions on the amount/names of private methods you can create within the class, as long as names are descriptive or JDoc is included
 *
 */
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Main, executable method
     * THIS METHOD SHOULD PRINT ALL EXPECTED OUTPUT
     * @param   args
     */
    public static void main(String args[]) {
        String[] testStrings = { "Bernard", "Charlie", "Angie", "Andy", "Bertha", "Annie", "Carl", "Dennis", "Caroline", "Bob", "Betty", "Bart", "Albert" };
        Main m = new Main();
        System.out.println(m.getAWords(testStrings));
        System.out.println(m.getBWords(testStrings));
        System.out.println(m.getCWords(testStrings));
    }

    // YOU CAN ADD MORE PRIVATE METHODS HERE, IF NEEDED!
    public List<String> getAWords(String[] arr){
        List<String> aList = new ArrayList();
        for (String a: arr) {
            if(a.charAt(0) == 'A' && a.length() >4){
                aList.add(a);
            }
        }
        return aList;
    }
    
    public List<String> getBWords(String[] arr){
        List<String> bList = new ArrayList();
        for (String b: arr) {
            if(b.charAt(0) == 'B' && b.length() >3){
                bList.add(b);
            }
        }
        return bList;
    }
    
    public List<String> getCWords(String[] arr){
        List<String> cList = new ArrayList();
        for (String c: arr) {
            if(c.charAt(0) == 'C' && c.length() >5){
                cList.add(c);
            }
        }
        return cList;
    }
}

/**
 * EXPECTED OUTPUT WHEN MAIN IS EXECUTED:
 * ======================================
 * Original collection: [Bernard, Charlie, Angie, Andy, Bertha, Annie, Carl, Connie, Caroline, Bob, Betty, Bart, Albert]
 * Sorted & filtered names with A larger than 4 characters: [Albert, Angie, Annie]
 * Sorted & filtered names with B equal or larger than 3 characters: [Bart, Bernard, Bertha, Betty, Bob]
 * Sorted & filtered names with C equal or larger than 5 characters: [Caroline, Charlie, Connie]
 */





