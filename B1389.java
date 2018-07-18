import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] answer;
	static int[] count;
	static int[] dist;
	static ArrayList<Integer>[] ar;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		answer = new int[N + 1];
		ar = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			ar[i] = new ArrayList<>();
		}
		for (int j = 0; j < M; j++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			ar[a].add(b);
			ar[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			dist = new int[N + 1];
			Arrays.fill(dist, -1);
			getKevin(i);
			for (int j = 1; j <= N; j++) {
				answer[i] += dist[j];
			}
		}
		int anss = 1;
		int now=answer[1];
		for (int i = 2; i <= N; i++) {
			if (answer[i] < now) {
				now=answer[i];
				anss=i;
			}
		}
		System.out.println(anss);
	}

	private static void getKevin(int i) {
		Queue<Integer> q = new LinkedList<>();
		dist[i] = 0;
		q.add(i);
		while (!q.isEmpty()) {
			int temp = q.remove();
			for (int y : ar[temp]) {
				if (dist[y] == -1) {
					q.add(y);
					dist[y] = dist[temp] + 1;
				}
			}
		}
	}
}
