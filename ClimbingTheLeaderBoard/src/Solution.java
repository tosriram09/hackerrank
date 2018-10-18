import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {
	// Complete the climbingLeaderboard function below.
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		List<Integer> scoresList = Arrays.stream(scores).boxed().collect(Collectors.toList());
		Set<Integer> sortedScoresSet = new TreeSet<Integer>(Collections.reverseOrder());

		int[] result = new int[alice.length];
		
		for (int i=0;i<alice.length;i++) {
			sortedScoresSet.addAll(scoresList);
			sortedScoresSet.add(alice[i]);
		
			List<Integer> sortedScoresList = new ArrayList<Integer>();
			sortedScoresList.addAll(sortedScoresSet);
			
			result[i] = sortedScoresList.indexOf(alice[i]) + 1;
			sortedScoresList.clear();
		}
		
		return result;
	}

    public static void main(String[] args) throws IOException {
    	int[] scores = {100, 100, 50, 40, 40, 20, 10};
    	int[] alice = {5, 25, 50, 120};
    	int[] result = climbingLeaderboard(scores, alice);
    	
    	for(int i = 0; i < result.length; i++)
    		System.out.println("Result => "+ result[i]);
    }
}
