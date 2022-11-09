package util.exception;

/**
 * Исключение на нулевое значение возраста
 */
public class AgeIsZeroException extends Throwable {

    public AgeIsZeroException(String msg) {
        super(msg);
    }
}
