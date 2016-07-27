package guerer.example.FDCApi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

class FirstLoginResponseHandler implements ResponseHandler<Map<String, String>> {

	private Map<String, String> parseResultFromResponse(
			final HttpResponse response) throws ParseException, IOException {
		Map<String, String> result = new HashMap<String, String>();
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			String responseBody = EntityUtils.toString(entity);

			result.put(Constants.TOKEN, RegixUtil.parseToken(responseBody));
			result.put(Constants.INSTANCE_ID,
					RegixUtil.parseInstanceId(responseBody));
		}
		return result;
	}

	public Map<String, String> handleResponse(final HttpResponse response)
			throws ClientProtocolException, IOException {
		int status = response.getStatusLine().getStatusCode();
		if (status == 401) {
			return parseResultFromResponse(response);
		} else {
			throw new ClientProtocolException(
					"Unexpected response status for first login request: "
							+ status);
		}
	}
}
