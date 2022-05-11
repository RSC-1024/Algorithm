package mytx.class07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @param <T>
 */
public class HeapGreater<T> {
    int heapSize;
    ArrayList<T> list;
    HashMap<T, Integer> map;
    Comparator<T> c;

    HeapGreater(Comparator<T> comparator) {
        this.heapSize = 0;
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.c = comparator;
    }

    //note: 不做具体添加元素的事情。只做向上调整
    public void insert(int i) {
      /*  int i = list.size();
        list.add(t);
        map.put(t,i);
        heapSize++;*/
        //
        int p = (i - 1) / 2;
        while (p >= 0 && c.compare(list.get(i), list.get(p)) > 0) {
            swap(i, p);
            i = p;
            p = (i - 1) / 2;
        }
    }

    //heapify

    public void heapify(int index) {
        int leftSonIndex = index * 2 + 1;
        int size = list.size();
        while (leftSonIndex < size) {
            int rightIndex = leftSonIndex + 1;
            int max = leftSonIndex;
            if (rightIndex < size) {
                if (c.compare(list.get(leftSonIndex), list.get(rightIndex)) > 0) {
                    max = rightIndex;
                }
            }
            //note: 中断条件不要忘记
            if (c.compare(list.get(index), list.get(max)) == 0) {
                break;
            }

            if (c.compare(list.get(index), list.get(max)) > 0) {
                swap(index, max);
            }
            index = max;
            leftSonIndex = max * 2 + 1;
        }
    }

    private void swap(int index, int max) {
        T tmp = list.get(index);
        list.set(index, list.get(max));
        list.set(max, tmp);
        map.put(list.get(index), index);
        map.put(list.get(max), max);
    }

    //pop
    public T pop() {
        //note: 边界条件交由调用方判断
       /* if (heapSize<=0){
            throw new RuntimeException("heap is empty");
        }
        if (heapSize==1){
            this.heapSize--;
            map.remove(list.get(0));
            return list.get(0);
        }*/
        T ans = list.get(0);
        swap(0, heapSize - 1);
        //note :remove
        list.remove(heapSize--);
        heapify(0);
        return ans;
    }

    //push
    public void push(T t) {
        list.add(t);
        map.put(t, heapSize);
        insert(heapSize++);
    }

    public void remove(T t) {
        T replace = list.get(heapSize - 1);
        int x = map.get(t);
        map.remove(t);
        list.remove(--heapSize);

        if (replace != t) {
            list.set(x, replace);
            insert(x);
            heapify(x);
        }
    }

    public void remove2(T t) {
        int x = map.get(t);
        map.remove(t);
        if (x == heapSize - 1) {
            list.remove(x);
            return;
        }

        swap(x, heapSize - 1);
        list.remove(--heapSize);
        insert(x);
        heapify(x);
    }
}
