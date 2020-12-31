import java.util.*;
class ClosestPoints{
    public static void main(String[] args) {
        int[] x = {6, 12, 40, 5, 12, 3};
        int[] y = {5, 30, 50, 1, 10, 4};
        
        System.out.println(closest(x, y));
    }

    public static int closest(int[] x, int[] y){
        int n = x.length;
        Point[] Px = createPoints(x, y);
        Point[] Py = createPoints(x, y);

        Arrays.sort(Px, (a, b)->a.x-b.x);
        Arrays.sort(Py, (a, b)->a.y-b.y);

        return closestUtil(Px, Py, n);
    }

    public static Point[] createPoints(int[] x, int[] y){
        Point[] P = new Point[x.length];
        for (int i = 0; i < x.length; ++i){
            P[i] = new Point(x[i], y[i]);
        }
        return P;
    }

    public static int closestUtil(Point[] Px, Point[] Py, int n){
        if (n <= 3){
            return bruteForce(Px, n);
        }

        int mid = n/2;
        Point midPoint  = Px[mid];
        Point[] Pyl = new Point[mid], Pyr = new Point[n - mid];
        int l = 0, r = 0;
        for (int i = 0; i < Px.length; ++i){
            if (l < mid && Py[i].x <= midPoint.x){
                Pyl[l++] = Py[i];
            }else{
                Pyr[r++] = Py[i];
            }   
        }

        int dl  = closestUtil(Arrays.copyOfRange(Px, 0, mid), Pyl, mid);
        int dr = closestUtil(Arrays.copyOfRange(Px, mid, Px.length), Pyr, n - mid);

        int d  = Math.min(dl, dr);
        List<Point> strip = new ArrayList<>();
        for (int i = 0; i < Py.length; ++i){
            if (Math.abs(Py[i].x - midPoint.x) < d){
                strip.add(Py[i]);
            }
        }

        return stripClosest(strip, d);
    }

    public static int stripClosest(List<Point> p, int d){
        int min = d;
        int n = p.size();
        for (int i = 0; i < n; ++i){
            for (int j = i+1; j < n && Math.abs(p.get(j).y - p.get(i).y) < min; ++j){
                min  = Math.min(min, dist(p.get(i), p.get(j)));
            }
        }
        return min;
    }
    
    public static int bruteForce(Point[] Px, int n){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i){
            for (int j = i+1; j < n; ++j){
                min = Math.min(min, dist(Px[i], Px[j]));
            }
        }
        return min;
    }

    public static int dist(Point p1, Point p2){
        return (int)(Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)));
    }
}

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}