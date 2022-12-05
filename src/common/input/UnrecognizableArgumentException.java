package common.input;

import java.io.Serial;

public class UnrecognizableArgumentException extends Exception{
    @Serial
    private static final long serialVersionUID = 30L;
    public UnrecognizableArgumentException(String msg){
        super(msg);
    }
}
