package com.vti.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.vti.entity.Ex5.Q1_2.Employees;
import com.vti.entity.Ex5.Q1_2.Engineer;
import com.vti.entity.Ex5.Q1_2.Staff;
import com.vti.entity.Ex5.Q1_2.Worker;
import com.vti.entity.Ex5.Q3.HighSchoolStudent;
import com.vti.entity.Ex5.Q4.Book;
import com.vti.entity.Ex5.Q4.Library;
import com.vti.entity.Ex5.Q4.Magazines;
import com.vti.entity.Ex5.Q4.Newspapers;

public class Exercise5 {
	public static int codeID = 0;
	ArrayList<Staff> staffs = new ArrayList<Staff>();
	ArrayList<Library> documents = new ArrayList<Library>();

	public void Question1_2() {

		Worker staff1 = new Worker("Tú", 23, "Address 1", 7);
		staff1.setGioiTinh(0);
		Engineer staff2 = new Engineer("Linh", 20, "Address 2", "CNTT");
		staff2.setGioiTinh(1);
		Employees staff3 = new Employees("Nhật", 23, "Address 3", "Thư Kí");
		staff3.setGioiTinh(0);
		Worker staff4 = new Worker("Hà", 25, "Address 4", 6);
		staff4.setGioiTinh(2);
		Engineer staff5 = new Engineer("Trường", 26, "Address 5", "QTKD");
		staff5.setGioiTinh(0);
		Worker staff6 = new Worker("Ronado", 33, "Address 6", 9);
		staff6.setGioiTinh(0);
		staffs.add(staff1);
		staffs.add(staff2);
		staffs.add(staff3);
		staffs.add(staff4);
		staffs.add(staff5);
		staffs.add(staff6);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*----------------------------MENU----------------------------*");
			System.out.println("|==     1) Thêm mới cán bộ                                 ==|");
			System.out.println("|==     2) Tìm kiếm theo họ tên                            ==|");
			System.out.println("|==     3) Hiển thị thông tin về danh sách các cán bộ      ==|");
			System.out.println("|==     4) Nhập vào tên của cán bộ và delete cán bộ đón    ==|");
			System.out.println("|==     5) Thoát khỏi chương trình                         ==|");
			System.out.println("*------------------------------------------------------------*");
			int choose = sc.nextInt();
			if (choose == 1 || choose == 2 || choose == 3 || choose == 4 || choose == 5) {
				switch (choose) {
				case 1:
					addNewStaff();
					break;

				case 2:
					findStaffByName();
					break;

				case 3:
					displayInformation();
					break;

				case 4:
					removeStaff();
					break;

				case 5:
					System.out.println("Bạn muốn thoát khỏi chương không ?");
					System.out.println("Chọn 0 để thoát. Nếu muốn tiếp tục, hãy chọn MENU");
					Scanner exit = new Scanner(System.in);
					int out = exit.nextInt();
					if (out == 0) {
						System.out.println("Byeee !!");
						return;
					}
				}
			} else {
				System.out.println("Nhập lại: ");
			}
		}

	}

	public void Question4() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*-------------------------------QUẢN LÝ TÀI LIỆU----------------------------*");
			System.out.println("|==     1) Thêm mới tài liêu: Sách, tạp chí, báo.                         ==|");
			System.out.println("|==     2) Xoá tài liệu theo mã tài liệu                                  ==|");
			System.out.println("|==     3) Hiện thị thông tin về tài liệu.                                ==|");
			System.out.println("|==     4) Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.               ==|");
			System.out.println("|==     5) Thoát khỏi chương trình                                        ==|");
			System.out.println("*---------------------------------------------------------------------------*");
			int choose = sc.nextInt();
			if (choose == 1 || choose == 2 || choose == 3 || choose == 4 || choose == 5) {
				switch (choose) {
				case 1:
					addNewDocument();
					break;

				case 2:
					deleteDocumentByCodeId();
					break;

				case 3:
					displayInformationDocuments();
					break;

				case 4:
					searchDocumentByType();
					break;

				case 5:
					System.out.println("Bạn muốn thoát khỏi chương không ?");
					System.out.println("Chọn 0 để thoát. Nếu muốn tiếp tục, hãy chọn MENU");
					Scanner exit = new Scanner(System.in);
					int out = exit.nextInt();
					if (out == 0) {
						System.out.println("Byeee !!");
						return;
					}
				}
			} else {
				System.out.println("Nhập lại: ");

			}
		}
	}

	public void question3() {
		HighSchoolStudent highSchoolStudent = new HighSchoolStudent(1, "Nam", "Chuyên Văn", "Đại học công nghệ");
		System.out.println(highSchoolStudent);
	}

	private void deleteDocumentByCodeId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập MÃ TÀI LIỆU muốn xóa");
		int codeInput = sc.nextInt();
		Boolean flagCheckExists = false;
		for (Library library : documents) {
			if (library.getCodeId() == codeInput) {
				flagCheckExists = true;
			}
		}
		if (flagCheckExists) {
			documents.removeIf(doc -> doc.getCodeId() == codeInput);
			for (Library library : documents) {
				System.out.println("Xóa thành công tài liệu");
				displayInformationDocuments();
			}
		} else {
			System.out.println("Mã tài liệu bạn nhập không có trên hệ thống.");
		}
	}

	private void searchDocumentByType() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập loại tài liệu muốn tìm kiếm: \n1.Sách \n2.Tạp chí \n3.Báo)");
		int numberInput = sc.nextInt();
		switch (numberInput) {
		case 1:
			for (Library library : documents) {
				if (library instanceof Book) {
					System.out.println(library.toString());
				}
			}
			break;

		case 2:
			for (Library library : documents) {
				if (library instanceof Magazines) {
					System.out.println(library.toString());
				}
			}
			break;

		case 3:
			for (Library library : documents) {
				if (library instanceof Newspapers) {
					System.out.println(library.toString());
				}
			}
			break;

		default:
			System.out.println("Nhập sai, mời nhập lại");
			break;
		}

	}

	private void displayInformationDocuments() {
		String leftAlignFormat = "| %-15s ";
		String left1AlignFormat = "| %-18s ";
		String midAlignFormat = "| %-16s";
		String right1AlignFormat = "| %-15s |%n";
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format("|                               THÔNG TIN TÀI LIỆU                         |%n");
		System.out.format("+--------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "MÃ TÀI LIỆU");
		System.out.format(left1AlignFormat, "SÔ BẢN PHÁT HÀNH");
		System.out.format(midAlignFormat, "NHÀ SẢN XUẤT");
		System.out.format(right1AlignFormat, "LOẠI TÀI LIỆU");
		System.out.format("+--------------------------------------------------------------------------+%n");
		for (Library library : documents) {
			System.out.format(leftAlignFormat, library.getCodeId());
			System.out.format(left1AlignFormat, library.getNumberOfReleaseEdition());
			System.out.format(midAlignFormat, library.getPublishingCompany());
			if (library instanceof Book) {
				System.out.format(right1AlignFormat, "Book");
			} else if (library instanceof Magazines) {
				System.out.format(right1AlignFormat, "Magazine");
			} else {
				System.out.format(right1AlignFormat, "Newspaper");
			}
		}

		System.out.format("+--------------------------------------------------------------------------+%n");
	}

	private void addNewDocument() {
		Scanner sc = new Scanner(System.in);
		System.out.println("*-------------------------------CHỌN LOẠI TÀI LIỆU--------------------------*");
		System.out.println("|==     1) Thêm mới SÁCH                                                  ==|");
		System.out.println("|==     2) Thêm mới TẠP CHÍ                                               ==|");
		System.out.println("|==     3) Thêm mới BÁO                                                   ==|");
		System.out.println("*---------------------------------------------------------------------------*");
		int choose = sc.nextInt();
		if (choose == 1 || choose == 2 || choose == 3) {
			switch (choose) {
			case 1:
				addNewBook();
				break;

			case 2:
				addNewMagazine();
				break;

			case 3:
				addNewNewspaper();
				break;
			}
		} else {
			System.out.println("Chọn sai, mời chọn lại");
		}

	}

	private void addNewNewspaper() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập TÊN NHÀ XUẤT BẢN ");
		String nameCompanyInput = sc.next();
		System.out.println("Nhập SỐ BẢN PHÁT HÀNH");
		int numberReleaseEditionInput = sc.nextInt();
		System.out.println("Nhập vào ngày phát hành: ");
		int day1 = sc.nextInt();
		System.out.println("Nhập vào tháng phát hành: ");
		int month1 = sc.nextInt();
		System.out.println("Nhập vào năm phát hành: ");
		int year1 = sc.nextInt();
		LocalDate dayReleaseInput = LocalDate.of(year1, month1, day1);
		codeID++;
		Library newNewspaper = new Newspapers(codeID, nameCompanyInput, numberReleaseEditionInput, dayReleaseInput);
		documents.add(newNewspaper);
//		System.out.println(documents.toString());
		displayInformationDocuments();
	}

	private void addNewMagazine() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập TÊN NHÀ XUẤT BẢN ");
		String nameCompanyInput = sc.next();
		System.out.println("Nhập SỐ BẢN PHÁT HÀNH");
		int numberReleaseEditionInput = sc.nextInt();
		System.out.println("Nhập SỐ PHÁT HÀNH");
		int numberReleaseInput = sc.nextInt();
		System.out.println("Nhập vào ngày phát hành: ");
		int day1 = sc.nextInt();
		System.out.println("Nhập vào tháng phát hành: ");
		int month1 = sc.nextInt();
		System.out.println("Nhập vào năm phát hành: ");
		int year1 = sc.nextInt();
		LocalDate monthReleaseInput = LocalDate.of(year1, month1, day1);
		codeID++;
		Library newMagazine = new Magazines(codeID, nameCompanyInput, numberReleaseEditionInput, numberReleaseInput,
				monthReleaseInput);
		documents.add(newMagazine);
//		System.out.println(documents.toString());
		displayInformationDocuments();
	}

	private void addNewBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập TÊN NHÀ XUẤT BẢN ");
		String nameCompanyInput = sc.next();
		System.out.println("Nhập SỐ BẢN PHÁT HÀNH");
		int numberReleaseEditionInput = sc.nextInt();
		System.out.println("Nhập TÊN TÁC GIẢ");
		String nameWriterInput = sc.next();
		System.out.println("Nhập SỐ TRANG");
		int numberOfPageInput = sc.nextInt();
		codeID++;
		Library newBook = new Book(codeID, nameCompanyInput, numberReleaseEditionInput, nameWriterInput,
				numberOfPageInput);
		documents.add(newBook);
//		System.out.println(documents.toString());
		displayInformationDocuments();
	}

	private void removeStaff() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên cần xóa thông tin: ");
		String delName = sc.next();
		Iterator<Staff> iterator = staffs.iterator();
		while (iterator.hasNext()) {
			Staff staff = (Staff) iterator.next();
			if (staff.getName().equals(delName)) {
				iterator.remove();
			}

		}
	}

	private void displayInformation() {
		String leftAlignFormat = "| %-17s ";
		String left1AlignFormat = "| %-16s ";
		String midAlignFormat = "| %-16s";
		String right1AlignFormat = "| %-15s ";
		String rightAlignFormat = "| %-12s |%n";
		System.out.format(
				"+-----------------------------------------------------------------------------------------+%n");
		System.out.format(
				"|                                   THÔNG TIN STAFF                                       |%n");
		System.out.format(
				"+-----------------------------------------------------------------------------------------+%n");
		System.out.format(leftAlignFormat, "Name");
		System.out.format(left1AlignFormat, "Age");
		System.out.format(midAlignFormat, "Gender");
		System.out.format(right1AlignFormat, "Address");
		System.out.format(rightAlignFormat, "Position");
		System.out.format(
				"+-----------------------------------------------------------------------------------------+%n");
		for (Staff staff : staffs) {
			System.out.format(leftAlignFormat, staff.getName());
			System.out.format(left1AlignFormat, staff.getAge());
			System.out.format(midAlignFormat, staff.getGioiTinh());
			System.out.format(right1AlignFormat, staff.getAddress());
			if (staff instanceof Worker) {
				System.out.format(rightAlignFormat, "Worker");
			} else if (staff instanceof Engineer) {
				System.out.format(rightAlignFormat, "Engineer");
			} else {
				System.out.format(rightAlignFormat, "Employee");
			}

		}
		System.out.format(
				"+-----------------------------------------------------------------------------------------+%n");
	}

	private void findStaffByName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên nhân viên muốn tìm");
		String nameStaff = sc.next();
		int indexInput = -1;
		for (int i = 0; i < staffs.size(); i++) {
			if (staffs.get(i).getName().equals(nameStaff)) {
				indexInput = i;
			}

		}
		if (indexInput < 0) {
			System.out.println("Không có nhân viên có tên như trên, mời thử lại sau");
		} else {
			System.out.println("Thông tin nhân viên bạn cần tìm là: ");
			System.out.println(staffs.get(indexInput).toString());

		}

	}

	private void addNewStaff() {
		Scanner sc = new Scanner(System.in);
		System.out.println("*------------------Chọn loại cán bộ muốn thêm----------------*");
		System.out.println("|==     1) Worker                                          ==|");
		System.out.println("|==     2) Engineer                                        ==|");
		System.out.println("|==     3) Employees                                       ==|");
		System.out.println("*------------------------------------------------------------*");
		int choose = sc.nextInt();
		if (choose == 1 || choose == 2 || choose == 3) {
			switch (choose) {
			case 1:
				addNewWorker();
				break;

			case 2:
				addNewEngineer();
				break;

			case 3:
				addNewEmployees();
				break;

			}
		}
	}

	private void addNewEmployees() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên Employee: ");
		String nameEmployees = sc.next();
		System.out.println("Nhập tuổi:  ");
		int ageEmployees = sc.nextInt();
		System.out.println("Nhập giới tính (0. Nam, 1.Nữ, 2.Không xác định)");
		int genderEmployees = sc.nextInt();
		System.out.println("Nhập địa chỉ: ");
		String addressEmployees = sc.next();
		System.out.println("Nhập công việc của Employee");
		String taskEmployees = sc.next();
		Employees Employees1 = new Employees(nameEmployees, ageEmployees, addressEmployees, taskEmployees);
		Employees1.setGioiTinh(genderEmployees);
		System.out.println("Bạn đã thêm thành công Employee:");
		System.out.println(Employees1.toString());
		staffs.add(Employees1);
		displayInformation();
	}

	private void addNewEngineer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên Engineer: ");
		String nameEngineer = sc.next();
		System.out.println("Nhập tuổi:  ");
		int ageEngineer = sc.nextInt();
		System.out.println("Nhập giới tính (0. Nam, 1.Nữ, 2.Không xác định)");
		int genderEngineer = sc.nextInt();
		System.out.println("Nhập địa chỉ: ");
		String addressEngineer = sc.next();
		System.out.println("Nhập ngành đào tạo của Engineer");
		String specializedEngineer = sc.next();
		Engineer Engineer1 = new Engineer(nameEngineer, ageEngineer, addressEngineer, specializedEngineer);
		Engineer1.setGioiTinh(genderEngineer);
		System.out.println("Bạn đã thêm thành công Engineer:");
		System.out.println(Engineer1.toString());
		staffs.add(Engineer1);
		displayInformation();
	}

	private void addNewWorker() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên Worker: ");
		String nameWorker = sc.next();
		System.out.println("Nhập tuổi:  ");
		int ageWorker = sc.nextInt();
		System.out.println("Nhập giới tính (0. Nam, 1.Nữ, 2.Không xác định)");
		int genderWorker = sc.nextInt();
		System.out.println("Nhập địa chỉ: ");
		String addressWorker = sc.next();
		System.out.println("Nhập Bậc của Worker (1 -> 10)");
		int rankWorker = sc.nextInt();
		Worker worker1 = new Worker(nameWorker, ageWorker, addressWorker, rankWorker);
		worker1.setGioiTinh(genderWorker);
		System.out.println("Bạn đã thêm thành công Worker:");
		System.out.println(worker1.toString());
		staffs.add(worker1);
		displayInformation();

	}
}
