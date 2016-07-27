package guerer.example.FDCApi;

import org.apache.http.client.methods.HttpPost;

public interface HttpPostInitializer {
	void initialize(HttpPost httpPost) throws Exception;
}
