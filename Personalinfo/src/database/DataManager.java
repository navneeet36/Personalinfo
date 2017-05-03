package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

import pojo.BeanInfo;


public class DataManager {
	public static boolean insertInfo(Connection connection, BeanInfo data) {
		String strInsert = "Insert into info values (?,?,?,?,?,?);";
		try {
			PreparedStatement ps = null;
			ps = connection.prepareStatement(strInsert.toLowerCase());
			ps.setString(1, data.getName());
			ps.setString(2, data.getDob());
			ps.setString(3, data.getGender());
			ps.setString(4, data.getAadharNumber());
			ps.setString(5, data.getPanNumber());
			ps.setString(6, data.getFutureFields());
		

			int i = ps.executeUpdate();

			if (i > 0)
				return true;
			else
				return false;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
