package chapter05.item28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Noblel
 * 如果某个输入参数既是生产者又是消费者那么通配符类型没有什么好处
 * PECS表示producer-extends， consumer-super
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    //E 的某个子类型的Iterable接口
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src)
            push(e);
    }

    //E 的某父类的集合
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty())
            dst.add(pop());
    }

    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<Number>();
        Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
        numberStack.pushAll(integers);

        Collection<Object> objects = new ArrayList<Object>();
        numberStack.popAll(objects);

        System.out.println(objects);
    }
}

