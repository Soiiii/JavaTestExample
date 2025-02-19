import java.nio.ByteBuffer;
import java.util.zip.Deflater;

public class DeflaterTest {


    private Deflater deflater;
    private ByteBuffer compressedBuffer;

    public DeflaterTest() {
        this.deflater = new Deflater();
        this.compressedBuffer = ByteBuffer.allocate(1024);
    }

    // 1. setInput(byte[] input)
    public void setInput() {
        byte[] inputBytes = "Hello, Deflater!".getBytes();
        deflater.setInput(inputBytes);
        System.out.println("setInput(byte[]) called.");
    }

    // 2. setInput(byte[] input, int offset, int length)
    public void setInputWithOffsetAndLength() {
        byte[] inputBytes = "Hello, Deflater!".getBytes();
        deflater.setInput(inputBytes, 0, inputBytes.length);
        System.out.println("setInput(byte[], int, int) called.");
    }

    // 3. setInput(ByteBuffer input)
    public void setInputWithByteBuffer() {
        ByteBuffer inputBuffer = ByteBuffer.wrap("ByteBuffer Input".getBytes());
        deflater.setInput(inputBuffer);
        System.out.println("setInput(ByteBuffer) called.");
    }

    // 4. setDictionary(byte[] dictionary)
    public void setDictionary() {
        byte[] dictionaryBytes = "CommonDictionary".getBytes();
        deflater.setDictionary(dictionaryBytes);
        System.out.println("setDictionary(byte[]) called.");
    }

    // 5. setDictionary(byte[] dictionary, int off, int len)
    public void setDictionaryWithOffsetAndLength() {
        byte[] dictionaryBytes = "CommonDictionary".getBytes();
        deflater.setDictionary(dictionaryBytes, 0, dictionaryBytes.length);
        System.out.println("setDictionary(byte[], int, int) called.");
    }

    // 6. setDictionary(ByteBuffer dictionary)
    public void setDictionaryWithByteBuffer() {
        ByteBuffer dictionaryBuffer = ByteBuffer.wrap("Buffer Dictionary".getBytes());
        byte[] dictBufferBytes = new byte[dictionaryBuffer.remaining()];
        dictionaryBuffer.get(dictBufferBytes);
        deflater.setDictionary(dictBufferBytes);
        System.out.println("setDictionary(ByteBuffer) called.");
    }

    // 7. deflate(byte[] output)
    public void deflate() {
        byte[] outputBytes = new byte[1024];
        int compressedSize = deflater.deflate(outputBytes);
        System.out.println("deflate(byte[]) called. Compressed size: " + compressedSize);
    }

    // 8. deflate(byte[] output, int offset, int length)
    public void deflateWithOffsetAndLength() {
        byte[] outputBytes = new byte[1024];
        int compressedSize = deflater.deflate(outputBytes, 0, outputBytes.length);
        System.out.println("deflate(byte[], int, int) called. Compressed size: " + compressedSize);
    }

    public void deflateWithOffsetAndLengthFlush() {
        byte[] outputBytes = new byte[1024];
        int offset = 0;
        int length = outputBytes.length;
        int flushMode = Deflater.SYNC_FLUSH;
        int compressedSize = deflater.deflate(outputBytes, offset, length, flushMode);
        System.out.println("deflate(byte[], int, int, int) called. Compressed size: " + compressedSize);
    }

    // 9. deflate(ByteBuffer output)
    public void deflateWithByteBuffer() {
        int compressedSize = deflater.deflate(compressedBuffer);
        System.out.println("deflate(ByteBuffer) called. Compressed size: " + compressedSize);
    }

    // 10. deflate(ByteBuffer output, int flushMode)
    public void deflateWithByteBufferAndFlushMode() {
        int compressedSize = deflater.deflate(compressedBuffer, Deflater.FULL_FLUSH);
        System.out.println("deflate(ByteBuffer, int) called. Compressed size: " + compressedSize);
    }

    // Finalize compression
    public void finish() {
        deflater.finish();
        System.out.println("finish() called.");
    }

    public void close() {
        deflater.end();
        System.out.println("Deflater closed.");
    }

    public static void main(String[] args) {
        DeflaterTest deflaterTest = new DeflaterTest();

//        deflaterTest.setInput();
//        deflaterTest.setInputWithOffsetAndLength();
//        deflaterTest.setInputWithByteBuffer();
//        deflaterTest.setDictionary();
//        deflaterTest.setDictionaryWithOffsetAndLength();
//        deflaterTest.setDictionaryWithByteBuffer();
        deflaterTest.deflate();
        deflaterTest.deflateWithOffsetAndLength();
        deflaterTest.deflateWithByteBuffer();
        deflaterTest.deflateWithByteBufferAndFlushMode();
        deflaterTest.finish();
        deflaterTest.close();


        System.out.println("Compression process completed.");


    }
}
