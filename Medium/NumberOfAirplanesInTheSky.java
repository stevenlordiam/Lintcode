/*
Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

Have you met this question in a real interview? Yes
Example
For interval list [[1,10],[2,3],[5,8],[4,7]], return 3

Note
If landing and flying happens at the same time, we consider landing should happen at first
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

public class Solution {
    public int countOfAirplanes(List<Interval> airplanes) {
    	// 将interval的开始和结束都看做一个point，进行排序。对于排好序的数组遍历，如果当前point是interval的开始点，那么cur++，否则cur–
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        //this round of sort is to make sure landing takes place before flying, if they happen at the same time
        Collections.sort(airplanes, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        Point[] points = new Point[airplanes.size()*2];
        for (int i = 0; i < airplanes.size(); i++) {
            points[i*2] = new Point(airplanes.get(i).start, true);
            points[i*2 + 1] = new Point(airplanes.get(i).end, false);
        }
        Arrays.sort(points, new Comparator<Point>(){
            public int compare(Point i1, Point i2) {
                return Integer.compare(i1.time, i2.time);
            }
        });
        int res = 0;
        int cur = 0;
        for (Point p : points) {
            if (!p.isStart) {
                cur--;
            } else {
                cur++;
                res = Math.max(res, cur);
            }
        }
        return res;
    }
     
    class Point {
        int time;
        boolean isStart;
        public Point(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }
}

/*
https://codesolutiony.wordpress.com/2015/05/12/lintcode-number-of-airplanes-in-the-sky/
http://www.cnblogs.com/easonliu/p/4504647.html
http://blog.csdn.net/martin_liang/article/details/45650025
http://yuanhsh.iteye.com/blog/2216972
*/