package bishi;

import java.util.ArrayList;
import java.util.Scanner;

class Point{
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        if (y != point.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

public class Main{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            ArrayList<Point> list = new ArrayList<>();
            for (int i = 0; i <= 10; i++) {
                list.add(new Point(0-i,0));
            }
            String s = sc.next();
            char[] ch = s.toCharArray();
            String ff = "legal";
            for (int i = 0; i < ch.length; i++) {
                if(ch[i]=='U'){
                    Point p = new Point(list.get(0).x,list.get(0).y+1);
                    if(list.contains(p)){
                        ff="illegal";
                        break;
                    }
                    gx(list);
                    list.get(0).y+=1;
                    ff=ver(list);
                    if(ff.equals("illegal")){
                        break;
                    }

                }else if(ch[i]=='D'){
                    Point p = new Point(list.get(0).x,list.get(0).y-1);
                    if(list.contains(p)){
                        ff="illegal";
                        break;
                    }
                    gx(list);
                    list.get(0).y-=1;
                    ff=ver(list);
                    if(ff.equals("illegal")){
                        break;
                    }
                }else if(ch[i]=='L'){
                    Point p = new Point(list.get(0).x-1,list.get(0).y);
                    if(list.contains(p)){
                        ff="illegal";
                        break;
                    }
                    gx(list);
                    list.get(0).x-=1;
                    ff=ver(list);
                    if(ff.equals("illegal")){
                        break;
                    }
                }else {
                    Point p = new Point(list.get(0).x+1,list.get(0).y);
                    if(list.contains(p)){
                        ff="illegal";
                        break;
                    }
                    gx(list);
                    list.get(0).x+=1;
                    ff=ver(list);
                    if(ff.equals("illegal")){
                        break;
                    }
                }
            }
            System.out.println(ff);
        }
    }

    public static void gx(ArrayList<Point> list){
        for (int k = 1; k < 11; k++) {
            list.get(k).x = list.get(k-1).x;
            list.get(k).y = list.get(k-1).y;
        }
    }

    public static String ver(ArrayList<Point> list){
        for (int k = 1; k < 11; k++) {
            if(list.get(0).x==list.get(k).x && list.get(0).y==list.get(k).y){
                return "illegal";
            }
        }
        return "legal";
    }

}
