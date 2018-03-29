package com.learningjava.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BasicSample {

    /*
    Basic buffer usage:
    1) Write data into the Buffer
    2) Call buffer.flip()
    3) Read data out of the Buffer
    4) Call buffer.clear() or buffer.compact()

    More info: http://tutorials.jenkov.com/java-nio/buffers.html
     */

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);    // read into buffer
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);

            buf.flip(); // make buffer ready for read

            while (buf.hasRemaining()) {
                System.out.print((char) buf.get()); // read 1 byte at a time
            }

            buf.clear();    // make buffer ready for writing
            bytesRead = inChannel.read(buf);
        }

        aFile.close();
    }
}
