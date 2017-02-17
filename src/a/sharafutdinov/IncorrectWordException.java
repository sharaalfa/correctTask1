package a.sharafutdinov;

/**
 * Created by innopolis on 18.02.17.
 */
public class IncorrectWordException extends Throwable {
    public IncorrectWordException(String text) {
        super("латинские буквы! " + text);
    }
}
