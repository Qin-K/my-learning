package com.qin_kai.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author qin kai
 * @date 2020/10/13
 */
public class ArrayUtilsTest {

    private static int[] initialNums = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        int[] nums1 = createNums();
        // 通过常量创建新数组
        int[] nums2 = ArrayUtils.EMPTY_INT_ARRAY;

        // 输出数组,第二参数为数组为空时代替输出
        // 输出格式为 {1,2,3,4,5,6}，我觉得用 Arrays.toString 就够了
        String arrayStr = ArrayUtils.toString(nums1, "array is null");
        System.out.println(arrayStr);

        // 克隆新数组,注意此拷贝为深拷贝
        int[] nums3 = ArrayUtils.clone(nums1);
        printArr(nums3);

        // 截取数组[)
        int[] subarray = ArrayUtils.subarray(nums1, 1, 3);
        printArr(subarray); // 2, 3

        // 判断两个数组长度是否相等
        ArrayUtils.isSameLength(nums1, nums2);

        // 判断两个数组类型是否相等,注意int和Integer比较时不相等
        ArrayUtils.isSameType(nums1, nums2);

        // 反转数组
        ArrayUtils.reverse(nums1);
        printArr(nums1); // [6, 5, 4, 3, 2, 1]
        nums1 = createNums();
        // 查找数组元素位置
        int index = ArrayUtils.indexOf(nums1, 5);
        System.out.println(index);// 4
        // 查找数组元素最后出现位置
        index = ArrayUtils.lastIndexOf(nums1, 4);
        System.out.println(index); // 3
        // 查找元素是否存在数组中
        boolean contains = ArrayUtils.contains(nums1, 2);
        System.out.println(contains); // true
        // 将基本数组类型转为包装类型
        Integer[] nums4 = ArrayUtils.toObject(nums1);

        // 判断是否为空,length=0或null都属于
        ArrayUtils.isEmpty(nums1);

        // 并集操作,合并数组
        ArrayUtils.addAll(nums1, nums2);

        // 增加元素,在下标5中插入10,注意此处返回是新数组
        ArrayUtils.add(nums1, 5, 1111);

        // 删除指定位置元素,注意返回新数组,删除元素后面的元素会前移,保持数组有序
        ArrayUtils.remove(nums1, 5);

        // 删除数组中值为10的元素,以值计算不以下标
        ArrayUtils.removeElement(nums1, 10);
    }

    public static int[] createNums() {
        return ArrayUtils.clone(initialNums);
    }

    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
