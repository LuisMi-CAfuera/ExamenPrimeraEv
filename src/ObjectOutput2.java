import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutput2 extends ObjectOutputStream {
    public ObjectOutput2(FileOutputStream out) throws IOException {
        super(out);
    }
    @Override
    protected void writeStreamHeader(){

    }
}
