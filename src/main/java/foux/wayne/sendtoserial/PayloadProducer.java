package foux.wayne.sendtoserial;
import java.nio.ByteBuffer;
import java.util.Random;

public class PayloadProducer {
	
	String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!\\%^^&*()";
	int charactersLength = characters.length();
	byte [] defaultPayload = null;
	
	public PayloadProducer() {
		defaultPayload = generateMessage(10000);
	}
	
	
	
	public byte [] getDefaultPayload() { 
		return defaultPayload; 
	}
	
	
	
	public byte [] generateMessage(int size) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(size);
		
		Random random = new Random();
		
		char randomCharacter;
		
		// Reset position. Fill each byte buffer index with random bites
		byteBuffer.position(0);
		
		while (byteBuffer.position() < size) {
			randomCharacter = characters.charAt(random.nextInt(charactersLength));
			byteBuffer.putChar(randomCharacter);			
		}
		
		return byteBuffer.array();
	}
		
}

