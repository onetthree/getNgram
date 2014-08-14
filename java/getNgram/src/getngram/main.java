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
	    
	//input sentences
	final String[] input_stirng = {
		"This is a pen .",
		"This is an egg .",
		"That person plays a song with his piano .",
		"His name was Tanaka , It was one of the most famous name in Japan ."
	    };
	
	//get n-gram map and show it.
	
	//unigram
	System.out.println("---unigram---");
	getNgram p1 = new getNgram(input_stirng, 1);
	//if the analysis is complete, it show you  a content of the map container.
	if(p1.parseSentence()) p1.showMapContents();
	
	//bigram
	System.out.println("---bigram---");
	getNgram p2 = new getNgram(input_stirng, 2);
	//if the analysis is complete, it show you  a content of the map container.
	if(p2.parseSentence()) p2.showMapContents();

	
	//trigram
	System.out.println("---trigram---");
	getNgram p3 = new getNgram(input_stirng, 3);
	//if the analysis is complete, it show you  a content of the map container.
	if(p3.parseSentence()) p3.showMapContents();
    }
    
}
