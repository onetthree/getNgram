/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package getngram;

import java.util.*;

/**
 *
 * @author ryosuke-m
 */
public class getNgram {
	//String input_sentence = new String();
	String[] input_sentence;
	List<String> word_vector;
	int num=0;
	Map<String,Integer> word_vector_map;

	public getNgram(String[] input,int num){
		this.input_sentence = input;
		this.num = num;
	};

	public void setNum(int num){
		this.num = num;
	}

	public void setSentence(String Sentence){
		//this.input_sentence = Sentence;
	}
	
	private List<String> String2WordVector(String input_sentence_i){
		
		List<String> stringListBuffer = new ArrayList<String>();
		
		stringListBuffer.addAll(Arrays.asList(input_sentence_i.split(" ")));
		stringListBuffer.add(0, "<BOS>");
		stringListBuffer.add("<EOS>");
		
		return stringListBuffer;
	}
	
	private List<String> makeNgram(List<String> wordVector){
		
		List<String> ngram_vector = new ArrayList<String>();
		
		for (int o_i=0;o_i<wordVector.size()-(this.num-1);o_i++){
			String ngram = new String();
			for(int i_i=o_i;i_i<o_i+this.num;i_i++){
				if(ngram.isEmpty()){
					ngram=wordVector.get(i_i);
				}else{
					ngram+="_"+wordVector.get(i_i);
				}
			}
			ngram_vector.add(ngram);
		}	
		return ngram_vector;
	}
	
	private Map<String,Integer> makeWordMap(List<String> ngram_vector_plane){
		Map <String,Integer>word_map = new HashMap<String,Integer>();
		
		for(String word_i : ngram_vector_plane){
			if (word_map.containsKey(word_i)){
				int new_num = (int)word_map.get(word_i)+1;
				word_map.put(word_i, new_num);
			}else{
				word_map.put(word_i, 1);
			}
		}
		
		return word_map;
	}
	
	public void showMapContents(){
		for(Map.Entry<String,Integer> wv : this.word_vector_map.entrySet()){
			System.out.println(wv.getKey()+":"+wv.getValue());
		}
	}
	
	public boolean parseSentence(){
		if(this.input_sentence.length==0 || this.num<1){
			System.out.println("type correct params.");
			return false;
		}
		
		//sentence to word vector
		List<String> NgramVector_plane = new  ArrayList<String>();
		List<List<String>> word_vector_docs= new ArrayList<List<String>>();
		
		for(String input_sentence_i : this.input_sentence){
			List<String> wordVector = this.String2WordVector(input_sentence_i);
			List<String> NgramVector = this.makeNgram(wordVector);
			NgramVector_plane.addAll(NgramVector);
		}
		
		Map<String,Integer> wordMap = this.makeWordMap(NgramVector_plane);
		this.word_vector_map = wordMap;
		//this.showMapContents();
			
			/*
			List<String> stringListBuffer = new ArrayList<String>();
			stringListBuffer.addAll(Arrays.asList(input_sentence_i.split(" ")));
			stringListBuffer.add(0, "<BOS>");
			stringListBuffer.add("<EOS>");
			
			//make ngram
			List<String> ngram_vector = new ArrayList<String>();
			for (int o_i=0;o_i<stringListBuffer.size()-(this.num-1);o_i++){
				String ngram = new String();
				for(int i_i=o_i;i_i<o_i+this.num;i_i++){
					if(ngram.isEmpty()){
						ngram=stringListBuffer.get(i_i);
					}else{
						ngram+="_"+stringListBuffer.get(i_i);
					}
				}
				ngram_vector.add(ngram);
			}
			word_vector_docs.add(ngram_vector);
		}
		
		//make n-gram plane vector
		for(List<String> ngram_vector_i : word_vector_docs){
			for(String ngram_i : ngram_vector_i){
				ngram_vector_plane.add(ngram_i);
			}
		}

		//Map<String,int> word_map = new HashMap<String,int>();
		//Map word_map<String,Integer> = new HashMap<String,Integer>();
		Map <String,Integer>word_map = new HashMap<String,Integer>();
		//Map<String,String> mp = new HashMap<String,String>();
		
		for(String word_i : ngram_vector_plane){
			if (word_map.containsKey(word_i)){
				int new_num = (int)word_map.get(word_i)+1;
				word_map.put(word_i, new_num);
			}else{
				word_map.put(word_i, 1);
			}
		}

		//dbg
		//for(Set<String,int> wv : word_map.entrySet()){
		for(Map.Entry<String,Integer> wv : word_map.entrySet()){
			System.out.println(wv.getKey()+":"+wv.getValue());
		}

		this.word_vector = word_vector;
		this.word_vector_map = word_map;
*/
		return true;
	}
	
	public Map<String,Integer> getWordMap(){
		return this.word_vector_map;
	}


	
	
}
