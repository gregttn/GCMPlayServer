package utils;

/**
 * Created with IntelliJ IDEA.
 * User: gregttn
 * Date: 12/06/13
 * Time: 21:16
 * To change this template use File | Settings | File Templates.
 */
public class ArrayUtils {
    public static <T> boolean hasContent(T[] array) {
        return array != null && array.length > 0;
    }
}
