package com.flipped.leetcode.lc;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 设计一个支持在平均时间复杂度O(1)下，执行以下操作的数据结构。
 * <p>
 * 注意: 允许出现重复元素。
 * <p>
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * 示例:
 * <p>
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 * <p>
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 * <p>
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 * <p>
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 * <p>
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 * <p>
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 * <p>
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 * @author: Flipped
 * @create: 2020-10-31 17:38
 **/
public class Solution381 {
    static class RandomizedCollection {
        /**
         * list用来存放数据，插入的时间复杂度为O(1),删除的话只有删除尾元素的时候时间复杂度才为O(1)
         */
        List<Integer> list;
        /**
         * 用来保存指以及索引，使得从list中查找的时间复杂度为O(1)
         * 由于值可以重复，那么一个值可能又多个索引，因此索引也需要一个集合来维护
         * 考虑到一个值不可能有两个相同的索引，因此采用set来存放索引
         */
        Map<Integer, Set<Integer>> map;
        /**
         * 当前集合大小
         */
        int size;

        /**
         * 用来随机访问
         */
        Random random;

        public RandomizedCollection() {
            this.size = 0;
            this.random = new Random();
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
        }

        /**
         * 删除一个元素
         *
         * @param val 需要删除的元素
         *            从集合中删除 元素
         * @return 成功返回 true
         */
        public boolean remove(int val) {
            // 获取需要删除的值的索引
            if (map.containsKey(val)) {
                Set<Integer> set = map.get(val);
                // 获取被删除值的索引和预交换值的索引
                int lastIndex = this.size - 1;
                Set<Integer> last = map.get(list.get(lastIndex));
                // 得到当前值的索引
                int curIndex = set.iterator().next();
                // 将当前值与list中的最后一个元素交换，达到删除O(1)
                swap(curIndex, lastIndex);
                // 删除
                list.remove(lastIndex);
                // 删除当前值的索引
                set.remove(curIndex);
                if (set.size() == 0) {
                    map.remove(val);
                }
                // 修改最后一个值的索引
                last.remove(lastIndex);
                last.add(curIndex);
                this.size--;
            } else {
                return false;
            }
            return true;
        }

        /**
         * 交换list中的两个值
         *
         * @param curIndex
         * @param lastIndex
         */
        private void swap(int curIndex, int lastIndex) {
            int temp = list.get(curIndex);
            list.set(curIndex, list.get(lastIndex));
            list.set(lastIndex, temp);
        }

        /**
         * 添加
         * 向集合中插入 1 。返回 true 表示集合不包含 1 。
         * 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
         *
         * @param val 添加的值
         * @return 是否只包含一个val
         */
        public boolean insert(int val) {
            // 判断值是否存在
            Set<Integer> set = map.get(val);
            if (set == null) {
                set = new HashSet<>();
            }
            // 将索引添加到set中
            set.add(size++);
            // 将值添加到list中
            list.add(val);
            map.put(val, set);
            // 如果set只有一个，则返回true，多个返回false
            return set.size() == 1;
        }

        public int getRandom() {
            return list.get(random.nextInt(this.size));
        }
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.list);
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.list);
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.list);

        // 随机访问
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.getRandom());
        // 删除
        System.out.println(randomizedCollection.remove(1));
        System.out.println(randomizedCollection.list);
        System.out.println(randomizedCollection.remove(2));
        System.out.println(randomizedCollection.list);

    }

}
