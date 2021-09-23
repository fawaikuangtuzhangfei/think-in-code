/**
 * @author yc
 * @description
 * @date 2021-09-23 14:23
 */
public class CommonTest {
    public static void main(String[] args) throws Exception {
        Class c=Class.forName("java.lang.String");
        Object obj=c.newInstance();
        System.out.println(obj);
    }
}
