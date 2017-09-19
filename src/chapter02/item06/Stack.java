package chapter02.item06;

import java.util.Arrays;

/**
 * 栈的简单实现
 * 存在内存泄露,极端情况会导致磁盘交换,甚至导致OOM
 * 先增长再伸缩,那么pop出来的对象不会当做垃圾回收
 * 因为栈内部维护着对这些对象的过期引用
 *
 * @author Noblel
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

//    修改版本,清除过期引用
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        Object result = elements[--size];
//        elements[size] = null;
//        return result;
//    }

    /**
     * 确定容量
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
