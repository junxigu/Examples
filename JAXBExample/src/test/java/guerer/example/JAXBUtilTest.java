package guerer.example;

import guerer.example.dto.ExpenseT;
import guerer.example.dto.ItemListT;
import guerer.example.dto.ItemT;
import guerer.example.dto.ObjectFactory;
import guerer.example.dto.UserT;

import java.math.BigDecimal;

import org.junit.Test;

public class JAXBUtilTest {

	private String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
			+ "<ExpenseT>"
			+ "<user>"
			+ "<userName>Sanaulla</userName>"
			+ "</user>"
			+ "<items>"
			+ "<item>"
			+ "<itemName>Seagate External HDD</itemName>"
			+ "<purchasedOn>August 24, 2010</purchasedOn>"
			+ "<amount>6776.5</amount>"
			+ "</item>"
			+ "</items>"
			+ "</ExpenseT>";;

	private ExpenseT getExpenseReport() {
		ObjectFactory factory = new ObjectFactory();

		UserT user = factory.createUserT();
		user.setUserName("Sanaulla");
		ItemT item = factory.createItemT();
		item.setItemName("Seagate External HDD");
		item.setPurchasedOn("August 24, 2010");
		item.setAmount(new BigDecimal("6776.5"));

		ItemListT itemList = factory.createItemListT();
		itemList.getItem().add(item);

		ExpenseT expense = factory.createExpenseT();
		expense.setUser(user);
		expense.setItems(itemList);

		return expense;
	}

	@Test
	public void testJAXBUtil() {
		System.out.println(JAXBUtil.marshalNameSpace(getExpenseReport()));
		System.out.println(JAXBUtil.unmarshal(xmlStr, ExpenseT.class));
	}

}
