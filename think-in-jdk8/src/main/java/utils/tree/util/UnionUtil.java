package utils.tree.util;

/**
 * @author nanshoudabaojian
 * @date 2023-02-01 12:50
 */
public class UnionUtil {

    public static void main(String[] args) {
        String str = "'3599837942','2799837915','1199840466','7199842408','5899843381','9999851250','5199853938','4599854221','9499853741','7599854299','5299862817','4999858110','3599860145'";
        String[] split = str.split(",");
        for (String s : split) {
            System.out.println("select " + s + " union");
        }
    }
}
