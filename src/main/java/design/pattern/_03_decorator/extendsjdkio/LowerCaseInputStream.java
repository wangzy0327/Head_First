package design.pattern._03_decorator.extendsjdkio;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * 自定义装饰IO类，把输入流内的所有大写字符转成小写
 *
 * ep:当读取“I know the Decorator Pattern therefore I RULE!”
 *
 * 转成“i know the decorator pattern therefore i rule!”
 *
 */
public class LowerCaseInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = in.read();
        return (c == -1 ? c : Character.toLowerCase((char)c));
    }

    public int read(byte[] b, int offset, int len) throws IOException {
        int result = in.read(b, offset, len);
        for (int i = offset; i < offset+result; i++) {
            b[i] = (byte)Character.toLowerCase((char)b[i]);
        }
        return result;
    }
}
