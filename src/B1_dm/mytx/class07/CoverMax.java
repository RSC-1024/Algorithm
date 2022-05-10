package mytx.class07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定很多线段，每个线段都有两个数组[start, end]，表示线段开始位置和结束位置，左右都是闭区间
 * 规定：
 * 1）线段的开始和结束位置一定都是整数值
 * 2）线段重合区域的长度必须>=1
 * 返回线段最多重合区域中，包含了几条线段
 */
public class CoverMax {
    public static int getCoverMax(int[][] lines) {
        //按起始位置排序
        List<Line> list = new ArrayList<>(lines.length);
        for (int i = 0; i < lines.length; i++) {
            list.add(new Line(lines[i][0],lines[i][1]));
        }
        list.sort(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.start-o2.start;
            }
        });
        //最小堆
        PriorityQueue<Integer> queue = new PriorityQueue();
        //note:不需要先放入进来 边界条件举例也行queue.offer(list.get(0).end);
        Integer max =0;
        for (int j = 0; j < list.size(); j++) {
            //note : == 也需要移除
            while (!queue.isEmpty()&& queue.peek()<=list.get(j).start){
                queue.poll();
            }
            //note : 两个顺序需要调整
            queue.offer(list.get(j).end);
            max =Math.max(max,queue.size());
        }
        return max;
    }
    public static class Line{
        int start;
        int end;
        Line(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
}
