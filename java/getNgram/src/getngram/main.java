/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getngram;

/**
 *
 * @author ryosuke-m
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
	    String[] input_stirng = {
		    "This is a pen .",
		    "This is an enemy .",
		    "That person plays marverous song with his piano .",
		    "His name was Tanaka , It was one of the most famous person in Japan ."
		};
	    
	    getNgram p = new getNgram(input_stirng, 3);
	    System.out.println(p.parseSentence());

    }
    
}
