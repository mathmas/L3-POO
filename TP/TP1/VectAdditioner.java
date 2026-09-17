public class VectAdditioner {

    public class Point {
        int x;
        int y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point sum = new Point();

    public void add(Point p) {
        sum.x += p.x;
        sum.y += p.y;
    }

    public Point getSum() {
        return new Point(sum.x, sum.y);
    }
}