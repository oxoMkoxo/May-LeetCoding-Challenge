package Week4;

import java.util.*;

public class PossibleBipartition {
	public boolean possibleBipartition(int N, int[][] dislikes) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : dislikes) {
			graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
			graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
		}

		int[] colors = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if (colors[i] == 0 && !dfs(colors, i, 1, graph)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int[] colors, int curr, int color, Map<Integer, List<Integer>> graph) {
		colors[curr] = color;
		if (graph.containsKey(curr)) {
			for (int neigh : graph.get(curr)) {
				if (colors[neigh] == color) {
					return false;
				}
				if (colors[neigh] == 0 && !dfs(colors, neigh, -color, graph)) {
					return false;
				}
			}
		}
		return true;
	}
}
