package guerer.example;

import guerer.example.po.Book;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class GsonExample {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void beanToJSON() {
		Book book = new Book();
		book.setId("book id");
		book.setName("book name");
		String json = new Gson().toJson(book);
		System.out.println(json);
	}

	@Test
	public void JSONToBean() {
		Gson gson = new Gson();
		String json = "{'id':'book id','name':'book name'}";
		Book book = gson.fromJson(json, Book.class);
		System.out.println(book);
	}

	@Test
	public void JSONToComplexBean() {
		Gson gson = new Gson();
		String json = "[{'id':'book id1','name':'book name1'},{'id':'book id2','name':'book name2'}]";
		// 将json转换成List
		List<Book> list = gson.fromJson(json, new TypeToken<List<Book>>() {
		}.getType());
		// 将json转换成Set
		Set<Book> set = gson.fromJson(json, new TypeToken<Set<Book>>() {
		}.getType());

		System.out.println(list);
		System.out.println(set);
	}

	@Test
	public void formattingJSON() {
		String json = "[{'id':'book id1','name':'book name1'},{'id':'book id2','name':'book name2'}]";
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(json);
		json = gson.toJson(je);

		System.out.println(json);
	}

	@Test
	public void getAttrFromJSON() {
		String json = "{'id':'book id1','name':'book name1'}";
		String propertyName = "id";
		String propertyValue = "";
		try {
			JsonParser jsonParser = new JsonParser();
			JsonElement element = jsonParser.parse(json);
			JsonObject jsonObj = element.getAsJsonObject();
			propertyValue = jsonObj.get(propertyName).toString();
		} catch (Exception e) {
			propertyValue = null;
		}
		System.out.println(propertyValue);
	}

}
