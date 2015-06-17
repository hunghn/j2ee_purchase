package j2ee.purchase.utils;

public class Menu {
	public static enum MENU {
		DRASHBOAD, PURCHASE, INCOMING_PRODUCTS, INVOICE_CONTROL, PRODUCTS, CONFIG, MANAGER
	};

	public static enum MENU_ITEM {
		NONE, PURCHASE_REQUEST_FOR_QUOTATION, PURCHASE_PURCHASE_ORDERS, PURCHASE_CALL_FOR_TENDERS, PURCHASE_SUPPLIERS, INCOMING_PRODUCTS_INCOMING_PRODUCTS, INVOICE_CONTROL_ON_DRAFT_INVOICES, INVOICE_CONTROL_ON_PURCHASE_ORDER_LINES, INVOICE_CONTROL_ON_INCOMING_SHIPMENTS, 
		PRODUCTS_PRODUCTS, PRODUCTS_PRODUCTS_BY_CATEGORY, CONFIG_PRODUCTS, MANAGER_COMPANIES, MANAGER_USER, MANAGER_ACCOUNT_TAX, MANAGER_UNITS
	};

	private MENU menu;
	private MENU_ITEM menu_item;

	public Menu(MENU menu, MENU_ITEM menu_item) {
		this.menu = menu;
		this.menu_item = menu_item;
	}

	public MENU getMenu() {
		return menu;
	}

	public void setMenu(MENU menu) {
		this.menu = menu;
	}

	public MENU_ITEM getMenu_item() {
		return menu_item;
	}

	public void setMenu_item(MENU_ITEM menu_item) {
		this.menu_item = menu_item;
	}

}
