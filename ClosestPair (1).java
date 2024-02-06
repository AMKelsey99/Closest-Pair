package closestpair;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author alana
 */

class Point {
    final double x;
    final double y;
    public Point(double x, double y) {
        this.x = x; this.y = y;
    }

    public double distance(Point that) {
        /* Compute the distance between this and that */
        double d;
        d  = Math.pow((this.x - that.x),2);
        d += Math.pow((this.y - that.y),2);
        d = Math.sqrt(d);
       return d;
    }
}

class Pair {
    Point one;
    Point two;
    public Pair(Point one, Point two) {
        this.one = one; this.two = two;
    }
}

public class ClosestPair {

    private static Pair findClosestPair(List<Point> points) {
        Pair closest;
        Point min1 = new Point(9,9);
        Point min2 = new Point(9999,9999);
        
        if (points.size() == 2) { 
                return new Pair(points.get(0), points.get(1));
        } 

        for (int n = 0; n < points.size()-1; n++) {
            for (int j = 1; j < points.size(); j++) {
                            //System.out.println("n: " + n + " j: " + j + " Distance:" + points.get(n).distance(points.get(j)));
                    if (points.get(n).distance(points.get(j)) <= min1.distance(min2) && points.get(n).distance(points.get(j)) > 0) {
                        min1 = points.get(n);
                        min2 = points.get(j);
                    }
        }
        }
        closest = new Pair(min1, min2);
        return closest;
    }

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int N = scanner.nextInt();
        List<Point> points = new ArrayList<>();
        
        /*points.add(new Point(1.0, 1.0));
        points.add(new Point(3.4, 2.8));
        points.add(new Point(1.2, 2.7));
        points.add(new Point(3.8, 3.0));
        points.add(new Point(3.6, 1.2));
        points.add(new Point(3.0, 3.2));
        points.add(new Point(2.0, 2.4));
        points.add(new Point(2.0, 3.8));
        points.add(new Point(1.0, 4.5));
        points.add(new Point(1.5, 2.5));
        points.add(new Point(3.0, 0.4));
        points.add(new Point(3.0, 7.5));*/
        
        for (int i = 0; i < N; i+=1) {
            points.add(new Point(scanner.nextDouble(), scanner.nextDouble()));
        }

        Pair closest = findClosestPair(points);

        System.out.println("\n" + closest.one.x + " " + closest.one.y);
        System.out.println(closest.two.x + " " + closest.two.y);
        //System.out.println(closest.one.distance(closest.two));
    }

}