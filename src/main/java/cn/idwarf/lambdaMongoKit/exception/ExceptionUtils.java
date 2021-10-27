package cn.idwarf.lambdaMongoKit.exception;

/**
 * @author alex
 * @date 2021-10-25 15:26
 */
public final class ExceptionUtils {

    private ExceptionUtils() {
    }

    public static IMongoException mie(String msg, Throwable t, Object... params) {
        return new IMongoException(String.format(msg, params), t);
    }

    public static IMongoException mie(String msg, Object... params) {
        return new IMongoException(String.format(msg, params));
    }

    public static IMongoException mie(Throwable t) {
        return new IMongoException(t);
    }
}