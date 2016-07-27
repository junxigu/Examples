package guerer.example;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class DESedeEncryptionTest {

	@Test
	public void test() throws Exception {
		String oriText = "test";
		DESedeEncryption util = new DESedeEncryption();
		System.out.println(util.decrypt("Mdxz3VJnriK5A8WcgzF/PQ=="));
		System.out.println(util.decrypt("THgIXNNmlPb6TESs9tf2GQ=="));
		assertEquals(util.decrypt(util.encrypt(oriText)), oriText);
		assertEquals(util.encrypt(oriText), util.encrypt(oriText));
		util.encrypt(null);
		util.encrypt("");
	}

}
