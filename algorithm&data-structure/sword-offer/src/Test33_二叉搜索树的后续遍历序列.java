/**
 * @author Qin Kai
 * @date 2020-02-01
 */
public class Test33_二叉搜索树的后续遍历序列 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int l, int r) {
        if (l >= r) return true;
        int rootVal = sequence[r];
        int cutIndex = l;
        while (cutIndex < r && sequence[cutIndex] < sequence[r]) {
            cutIndex++;
        }
        for (int i = cutIndex; i < r; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        return VerifySquenceOfBST(sequence, l, cutIndex - 1)
                && VerifySquenceOfBST(sequence, cutIndex, r - 1);
    }
}
