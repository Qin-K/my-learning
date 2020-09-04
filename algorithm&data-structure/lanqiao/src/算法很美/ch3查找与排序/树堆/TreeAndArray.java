package 算法很美.ch3查找与排序.树堆;

/**
 * 数组表示完全二叉树
 */
public class TreeAndArray {
	public static void main(String[] args) {
		int[] arr = {78, 56, 34, 43, 4, 1, 15, 2, 23};
		preOrder(arr, 0);
		System.out.println();
		inOrder(arr, 0);
	}
	
	/**
	 * 先序遍历
	 */
	public static void preOrder(int[] arr, int root) {
		if (root >= arr.length) {
			return;
		}
		System.out.print(arr[root] + " ");
		preOrder(arr, root * 2 + 1);
		preOrder(arr, root * 2 + 2);
	}
	
	/**
	 * 中序遍历
	 */
	public static void inOrder(int[] arr, int root) {
		if (root >= arr.length) {
			return;
		}
		preOrder(arr, root * 2 + 1);
		System.out.print(arr[root] + " ");
		preOrder(arr, root * 2 + 2);
	}
}
