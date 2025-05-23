package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private static final int GAJI_GRADE_1 = 3000000;
	private static final int GAJI_GRADE_2 = 5000000;
	private static final int GAJI_GRADE_3 = 7000000;
	private static final double PERSENTASE_KARYAWAN_ASING = 1.5;

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;

	private int yearJoined;
	private int monthJoined;
	private int dayJoined;
	private int monthWorkingInYear;

	private boolean isForeigner;
	private boolean isLakiLaki; // true = laki-laki, false = perempuan

	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;

	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;

	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
			int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean isLakiLaki) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.yearJoined = yearJoined;
		this.monthJoined = monthJoined;
		this.dayJoined = dayJoined;
		this.isForeigner = isForeigner;
		this.isLakiLaki = isLakiLaki;

		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}

	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya
	 * (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3:
	 * 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */

	 
	public void setMonthlySalary(int grade) {
		switch (grade) {
			case 1:
				monthlySalary = GAJI_GRADE_1;
				break;
			case 2:
				monthlySalary = GAJI_GRADE_2;
				break;
			case 3:
				monthlySalary = GAJI_GRADE_3;
				break;
			default:
				monthlySalary = 0;
				break;
		}

		if (isForeigner) {
			monthlySalary = (int) (monthlySalary * PERSENTASE_KARYAWAN_ASING);
		}
	}

	public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}

	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = spouseIdNumber; // Diperbaiki
	}

	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}

	public int getAnnualIncomeTax() {

		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();

		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		} else {
			monthWorkingInYear = 12;
		}

		boolean sudahMenikah = spouseName != null && !spouseName.isEmpty();
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear,
				annualDeductible, sudahMenikah, childIdNumbers.size());
	}
}