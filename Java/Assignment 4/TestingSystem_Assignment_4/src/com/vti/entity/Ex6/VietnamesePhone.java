package com.vti.entity.Ex6;

import java.util.ArrayList;

public class VietnamesePhone extends Phone{
	private ArrayList<Contact> contacts;
	
	public VietnamesePhone () {
		contacts = new ArrayList<Contact>();
	}

	@Override
	public void insertContact(String name, String phone) {
		Contact newContact = new Contact(phone, name);
		contacts.add(newContact);
		super.insertContact(name, phone);
	}

	@Override
	public void removeContact(String name) {
		contacts.removeIf(contact -> contact.getName().equals(name));
		super.removeContact(name);
	}

	@Override
	public void updateContact(String name, String newPhone) {
		for (Contact contact : contacts) {
			if (contact.getName().equals(name)) {
				contact.setPhone(newPhone);
			}
		}
		super.updateContact(name, newPhone);
	}

	@Override
	public void searchContact(String name) {
		for (Contact contact : contacts) {
			if (contact.getName().equals(name)) {
				String leftAlignFormat = "| %-36s";
				String rightAlignFormat = "| %-35s| %n";
				System.out.format("+--------------------------------------------------------------------------+%n");
				System.out.format("|                               CONTACTS                                   |%n");
				System.out.format("+--------------------------------------------------------------------------+%n");
				System.out.format(leftAlignFormat, "Tên contact");
				System.out.format(rightAlignFormat, "Số điện thoại");
				System.out.format("+--------------------------------------------------------------------------+%n");
				System.out.format(leftAlignFormat, contact.getName());
				System.out.format(rightAlignFormat, contact.getPhone());
				System.out.format("+--------------------------------------------------------------------------+%n");

			}else {
				System.out.println("Không tìm thấy contact, mời kiểm tra lại");
			}
		}
		super.searchContact(name);
	}
	public void printContact() {
		String leftAlignFormat = "| %-36s";
		String rightAlignFormat = "| %-35s| %n";
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format("|                               CONTACTS                                   |%n");
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "Tên contact");
		System.out.format(rightAlignFormat, "Số điện thoại");
		System.out.format("+--------------------------------------------------------------------------+%n");
		for (Contact contact : contacts) {
			System.out.format(leftAlignFormat, contact.getName());
			System.out.format(rightAlignFormat, contact.getPhone());
		}
		System.out.format("+--------------------------------------------------------------------------+%n");
	}
	
}
