package guerer.example.enumerate;

import guerer.example.util.Enums;

public enum SecurityCategory {
	STOCK(Security.STOCK.class), BOND(Security.BOND.class);

	interface Security {
		enum STOCK implements Security {
			SHORT, LONG, MARGIN
		}

		enum BOND implements Security {
			MUNICIPAL, JUNK
		}
	}

	private Security[] values;

	private SecurityCategory(Class<? extends Security> type) {
		values = type.getEnumConstants();
	}

	public Security randomSelection() {
		return Enums.random(values);
	}

	public static void main(String[] args) {
		for (int i = 8; i < 18; i++) {
			SecurityCategory category = Enums.random(SecurityCategory.class);
			System.out.println(category + ": " + category.randomSelection());
		}
	}
}
