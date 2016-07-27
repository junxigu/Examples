package guerer.example.FDCApi;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

// Using the cookie store to manage cookies, send parameters with encoded url
// and Headers
public class FDCAdapterClient {

	private UrlEncodedFormEntity loginReqEntity = null;
	private CloseableHttpClient httpclient = null;
	private String requestUrl = Constants.SERVER + Constants.API_PATH;
	
	private <T> T sendRequest(CloseableHttpClient httpclient, String url,
			HttpPostInitializer httpPostInitializer,
			ResponseHandler<T> responseHandler) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		httpPostInitializer.initialize(httpPost);
		return httpclient.execute(httpPost, responseHandler);
	}

	private Map<String, String> sendFirstRequest() throws Exception {
		return sendRequest(httpclient, requestUrl, new HttpPostInitializer() {
			public void initialize(HttpPost httpPost) {
				httpPost.setHeader("Authorization", Constants.AUTH_PREFIX
						+ Constants.DEFAULT_VALUE + Constants.AUTH_SUFFIX);
				httpPost.setHeader("WL-Instance-Id", Constants.DEFAULT_VALUE);
				httpPost.setHeader("x-wl-app-version", Constants.APP_VERSION);
				httpPost.setHeader("x-wl-platform-version",
						Constants.PLATFORM_VERSION);
			}
		}, new FirstLoginResponseHandler());
	}

	private Map<String, String> sendSecondRequest(final String token,
			final String instanceId) throws Exception {

		return sendRequest(httpclient, requestUrl, new HttpPostInitializer() {
			public void initialize(HttpPost httpPost)
					throws UnsupportedEncodingException {
				// set header
				httpPost.setHeader("Authorization", Constants.AUTH_PREFIX
						+ token + Constants.AUTH_SUFFIX);
				httpPost.setHeader("WL-Instance-Id", instanceId);
				httpPost.setHeader("x-wl-app-version", Constants.APP_VERSION);
				httpPost.setHeader("x-wl-platform-version",
						Constants.PLATFORM_VERSION);

				// set parameter
				httpPost.setEntity(getLoginReqParams());
			}
		}, new SecondLoginResponseHandler());
	}

	private List<NameValuePair> getParams(Map<String, String> paramMap) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for (String key : paramMap.keySet()) {
			params.add(new BasicNameValuePair(key, paramMap.get(key)));
		}
		return params;
	}

	private UrlEncodedFormEntity getLoginReqParams()
			throws UnsupportedEncodingException {
		if (loginReqEntity == null) {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put(Constants.PARAM_NAME_PARAM, Constants.PARAM_VAL_PARAM);
			paramMap.put(Constants.PARAM_NAME_PROCEDURE,
					Constants.PARAM_VAL_PROCEDURE);
			paramMap.put(Constants.PARAM_NAME_ADAPTER,
					Constants.PARAM_VAL_ADAPTER);

			loginReqEntity = new UrlEncodedFormEntity(getParams(paramMap),
					"UTF-8");
		}
		return loginReqEntity;
	}

	public void login() throws Exception {
		httpclient = HttpClients.custom()
				.setDefaultCookieStore(new BasicCookieStore()).build();
		try {
			Map<String, String> result = sendFirstRequest();

			System.out.println(sendSecondRequest(result.get(Constants.TOKEN),
					result.get(Constants.INSTANCE_ID)));
		} finally {
			httpclient.close();
		}
	}

	public static void main(String[] args) throws Exception {
		FDCAdapterClient client = new FDCAdapterClient();
		client.login();
	}

}
