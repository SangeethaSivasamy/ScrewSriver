package com.practiceprograms;

import java.util.HashSet;

public class PermutationsFinderForString {
	public static void main(String[] args) {
    String string = "san";
    PermutationsFinderForString permutation = new PermutationsFinderForString();
    HashSet<String> result = permutation.findPermutations(string);
    System.out.println(result.toString());
    System.out.println(result.size());

}

private HashSet<String> findPermutations(String string) {
    HashSet<String> permutations = new HashSet<>();
    if (string == null || string.length() == 0) {
        permutations.add("");
        return permutations;
    }

    Character first = string.charAt(0);
    System.out.println("first-->"+first);
    String remaining = string.substring(1);
    System.out.println("remaining-->"+remaining);
    HashSet<String> words = findPermutations(remaining);
    for (String word : words) {
    	System.out.println("word-->"+word);
    	for (int i = 0; i <= word.length(); i++) {

            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            System.out.println("prefix-->"+prefix+"  first-->"+first+"  suffix-->"+suffix);
            permutations.add(prefix+first+suffix);
        }
    }
    return permutations;

}}
