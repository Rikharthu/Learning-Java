package com.learningjava.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferSample {

    /*
    Basic buffer usage:
    1) Write data into the Buffer
    2) Call buffer.flip()
    3) Read data out of the Buffer
    4) Call buffer.clear() or buffer.compact()

    More info: http://tutorials.jenkov.com/java-nio/buffers.html
     */

    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(64);
        CharBuffer charBuf = CharBuffer.allocate(1024);

        for (byte i = 0; i < 64; i++) {
            buf.put(i);
            if (i == 37) {
                int limit = buf.limit();
                int position = buf.position();
                int capacity = buf.capacity();
                System.out.printf("Iteration 37, limit=%d, position=%d, capacity=%d\n", limit, position, capacity);
            }
        }

        buf.flip();

        while (buf.hasRemaining()) {
            System.out.print(buf.get() + " ");
        }
    }
}
