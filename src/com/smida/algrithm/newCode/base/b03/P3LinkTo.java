package com.smida.algrithm.newCode.base.b03;

/**
 * 猫狗队列
 * 要求如下: 用户可以调用add方法将cat类或dog类的 实例放入队列中;
 * 用户可以调用pollAll方法，将队列中所有的实例按照进队列 的先后顺序依次弹出;
 * 用户可以调用pollDog方法，将队列中dog类的实例按照 进队列的先后顺序依次弹出;
 * 用户可以调用pollCat方法，将队列中cat类的实 例按照进队列的先后顺序依次弹出;
 * 用户可以调用isEmpty方法，检查队列中是 否还有dog或cat的实例;
 * 用户可以调用isDogEmpty方法，检查队列中是否有dog 类的实例;
 * 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 * <p>
 * 思路：弄俩队列，把宠物包装一下，加个count，代表入猫狗队的顺序
 * 代码见：Problem_04_DogCatQueue
 *
 * 顺时针打印数组
 * 思路：left、right、top、bottom四个变量代表左右上下边界，按圈缩，右往左/下往上时判断是否同一行/列
 * 代码见：com.smida.algrithm.aimOffer.Practice#printMatrix(int[][])
 *
 * 顺时针旋转正方形矩阵90度
 * 思路：left、right、top、bottom四个变量代表左右上下边界，按圈缩，一圈换len-1组数据，每组数据走一整个顺时针
 * n=len-1  tmp=top,left+i  top,left+i=bottom-i,left  bottom-i,left=bottom,right-i  bottom,right-i=top+i,right  top+i,right=tmp
 * 代码见：com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix.Problem_02_RotateMatrix
 *
 * 之字型打印矩阵
 * 思路：弄两个点走连线
 * 代码见：com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix.Problem_03_PrintMatrixAsZ
 *
 * 在排好序的矩阵中找数
 * 思路：从右上角找，比要找的大就往左，比要找的数小就往下
 * 代码：com.smida.algrithm.book_zuo.chapter_8_arrayandmatrix.Problem_07_FindNumInSortedMatrix
 *
 * 复制随机指针链表
 * 思路：
 * 空间复杂度n：用Map，key位原节点，value位复制节点
 * 空间复杂度1：每一个节点后边复制一个一样的，a.next = a'.next a.value = a'.value
 * 代码见：com.smida.algrithm.book_zuo.chapter_2_listproblem.Problem_09_CopyListWithRandom
 * @author YYF
 * @date 2022/9/8 11:07.
 */
public class P3LinkTo {
}
