package guerer.example.FDCApi;


public class Constants {
	
	public static String SERVER = "http://localhost:9080";
	public static String API_PATH = "/SpeedPass/apps/services/api/SpeedPass/android/query";
	public static String PLATFORM_VERSION = "xxx";
	public static String APP_VERSION = "3.1";
	public static String AUTH_PREFIX = "{\"wl_deviceNoProvisioningRealm\":{\"ID\":{\"token\":\"";
	public static String AUTH_SUFFIX = "xxxx";
	public static String LOGIN_PARAM = "xxx";
	public static String DEFAULT_VALUE = "DEVAULT";
	
	public static String PARAM_NAME_PARAM = "parameters";
	public static String PARAM_NAME_PROCEDURE = "procedure";
	public static String PARAM_NAME_ADAPTER = "adapter";

	public static String PARAM_VAL_PARAM = "[{\"userName\":\"xxx\",\"password\":\"xxx=\",\"app_name\":\"SPP\",\"app_version\":\"3.3.26\",\"copy_version\":\"1.0.0\",\"hockey\":\"1\",\"verbose_error\":\"1\",\"license\":\"xxx\",\"residency\":\"US\",\"language_locale\":\"en-US\"}]";
	public static String PARAM_VAL_PROCEDURE = "login";
	public static String PARAM_VAL_ADAPTER = "AuthAdapter";
	
	public static String TOKEN = "token";
	public static String SESSION_TOKEN = "sessionToken";
	public static String INSTANCE_ID = "instanceId";
}
