
package csc223.am;

public class FUber {

    public static double euclidean(float x1, float y1, float x2, float y2) {
        double out = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
        out = Math.sqrt(out);
        return out;
    }

    public static float manhattan(float x1, float y1, float x2, float y2) {
        float out = Math.abs(x2 - x1) + Math.abs(y2 - y1);
        return out;
    }
}