package 算法很美.ch3查找与排序.ch3;

import java.util.Arrays;
import java.util.Scanner;

import 算法很美.ch3查找与排序.树堆.MinHeap;

public class Test3_topK {
	public static void main(String[] args) {
		f();
	}

	// 前k个数topK
	static int[] heap;
	static int k;
	static int index = 0;

	public static void f() {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		heap = new int[k];
		int x = sc.nextInt();
		while (x != -1) {
			deal(x);
			x = sc.nextInt();
		}
	}

	private static void deal(int x) {
		if (index < k) {
			heap[index++] = x;
			if (index == k) {
				MinHeap.MinHeap(heap);// 堆化
			}
		} else {
			if (x > heap[0]) {
				// 替换堆顶
				heap[0] = x;
				// 将堆顶向下调整
				MinHeap.MinHeapFixDown(heap, 0, k);
				printRs();
			}
		}
	}

	private static void printRs() {
		System.out.println(Arrays.toString(heap));
	}
}
