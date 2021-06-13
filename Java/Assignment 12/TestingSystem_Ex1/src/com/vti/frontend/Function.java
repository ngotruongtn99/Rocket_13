package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.presentationlayer.CandidateController;
import com.vti.entity.ExperienceCandidate.ProSkill;
import com.vti.entity.FresherCandidate.GraduationRank;
import com.vti.ultis.ScannerUltis;

public class Function {

	CandidateController candidateController;
	public Function() throws FileNotFoundException, IOException {
		candidateController = new CandidateController();
	}
	
	public void getRegister() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("+-------------------------------------REGISTER---------------------------+");
			System.out.println("|-----------------        1. Experience Candidate          --------------|");
			System.out.println("|-----------------        2. Fresher Candidate             --------------|");
			System.out.println("+------------------------------------------------------------------------+");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				System.out.println("Nhập vào FirstName: ");
				String FirstName = ScannerUltis.inputString();
				System.out.println("Nhập vào LastName:");
				String LastName = ScannerUltis.inputString();
				System.out.println("Nhập vào Phone:");
				String phone = ScannerUltis.inputPhoneNumber();
				System.out.println("Nhập vào Email: ");
				String email = ScannerUltis.inputEmail();
				if (candidateController.isEmailexists(email)) {
					System.out.println("Đã tồn tại Account này trên hệ thống");
					break;
				}
				System.out.println("Nhập vào Password:");
				String password = ScannerUltis.inputPassword();
				System.out.println("Nhập vào ExperienceInYear:");
				int expInYear = ScannerUltis.inputIntPositive();
				System.out.println("Nhập vào ProSkill: ");
				ProSkill proSkill = getProSkill();
				Boolean result = candidateController.createExperienceCandidate(FirstName, LastName, phone, email, password, expInYear, proSkill);
				if (result ) {
						System.out.println("Tạo thành công");
						return;
				} else {
					System.out.println("Đã có lỗi xảy ra");
					break;
				}
			case 2:
				System.out.println("Nhập vào FirstName: ");
				String firstName = ScannerUltis.inputString();
				System.out.println("Nhập vào LastName:");
				String lastName = ScannerUltis.inputString();
				System.out.println("Nhập vào Phone:");
				String phoneFr = ScannerUltis.inputPhoneNumber();
				System.out.println("Nhập vào Email: ");
				String emailFr = ScannerUltis.inputEmail();
				if (candidateController.isEmailexists(emailFr)) {
					System.out.println("Đã tồn tại Account này trên hệ thống");
					break;
				}
				System.out.println("Nhập vào Password:");
				String passwordFr = ScannerUltis.inputPassword();
				GraduationRank graduationRank = getGraduationRank();
				
				
				Boolean result1 = candidateController.createFresherCandidate(firstName, lastName, phoneFr, emailFr, passwordFr, graduationRank);
				if (result1 ) {
						System.out.println("Tạo thành công");
						return;
				} else {
					System.out.println("Đã có lỗi xảy ra");
					break;
				}

			default:
				break;
			}
		}
	}
	public void getLogin() throws ClassNotFoundException, SQLException {
		System.out.println("Mời nhập vào Email: ");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời nhập vào Password: ");
		String password = ScannerUltis.inputPassword();
		if (candidateController.loginCandidate(email, password)) {
			System.out.println("Chào mừng " + email + " đã đến với hệ thống !");
			System.out.println("Đăng nhập thành công");
		} else {
			System.out.println("Email hoặc Password không chính xác");
			return;
		}
	}

	private GraduationRank getGraduationRank() {
		while (true) {
			System.out.format("+---------------------------------------------------------+%n");
			System.out.format("|                    GRADUATRION RANK                     |%n");
			System.out.format("+---------------------------------------------------------+%n");
			String leftAilgnFormat = "|%-57s| %n";
			System.out.format(leftAilgnFormat, "1. EXCELLENCE");
			System.out.format(leftAilgnFormat, "2. GOOD");
			System.out.format(leftAilgnFormat, "3. FAIR");
			System.out.format(leftAilgnFormat, "4. POOR");
			System.out.format("+---------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				return GraduationRank.EXCELLENCE;
				
			case 2:
				return GraduationRank.GOOD;
				
			case 3:
				return GraduationRank.FAIR;
				
			case 4:
				return GraduationRank.POOR;
				
			default:
				System.out.println("Mời chọn lại !");
				break;
			}
		}
		
	}

	private ProSkill getProSkill() {
		while (true) {
			System.out.format("+---------------------------------------------------------+%n");
			System.out.format("|                          PROSKIll                       |%n");
			System.out.format("+---------------------------------------------------------+%n");
			String leftAilgnFormat = "|%-57s| %n";
			System.out.format(leftAilgnFormat, "1. DEV");
			System.out.format(leftAilgnFormat, "2. TEST");
			System.out.format(leftAilgnFormat, "3. JAVA");
			System.out.format(leftAilgnFormat, "4. SQL");
			System.out.format("+---------------------------------------------------------+%n");
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				return ProSkill.DEV;
				
			case 2:
				return ProSkill.TEST;
			case 3:
				return ProSkill.JAVA;
			case 4:
				return ProSkill.SQL;
			default:
				System.out.println("Mời chọn lại");
				break;
			}
		}
	}
	
}
