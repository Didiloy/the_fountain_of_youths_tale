package common.input;

import java.io.Serial;

public class IncorrectNumberOfParameterException extends Exception{
    @Serial
    private static final long serialVersionUID = 20L;
    public IncorrectNumberOfParameterException(String msg){
        super(msg);
    }
}
