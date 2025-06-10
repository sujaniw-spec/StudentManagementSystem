package exceldata;

import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> list = DataDriven.getData("Add Profile");
		for(String col: list) {
			System.out.println(col);
		}
	}

}
