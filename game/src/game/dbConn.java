package game;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class dbConn {
	static String url = "jdbc:mysql: //127.0.0.1:3306/coy_db";
	static String id = "root";
	static String pw = "mirim";
	public static void main(String[] args) {
		new EndingGame();
		EndingGame.mgps();
		try {
			// Class.forName("org.git.mm.mysql.Driver");// 1. jdbc ����̺� ����
			Class.forName("com.mysql.cj.jdbc.Driver"); // �� ������ ��
			System.out.println("����̺� ������ �ߵ�");
		} catch(ClassNotFoundException ee) {
			System.out.println("DB ���� ����̺갡 ����");
		}
		
		Connection conn = null;
		
		
		try {
			conn = DriverManager.getConnection(url, id, pw);// 2. �����ͺ��̽� ����
		} catch(SQLException ee) {
			System.out.println("DB �������");
		}
		
		Statement stmt = null; // 3. ��ɾ� ó�� ��ü ����
		try {
			stmt = conn.createStatement();
		} catch(SQLException ee) {
			System.out.println("�۾� ó�� ��ü ���� ����");
		}
		
		ResultSet rs = null;
		try {
//			PreparedStatement pstmt = null;
//			String sql = "insert into w_or_l(p1, p2) values(true, false)";
//			pstmt = conn.prepareStatement(sql);
//			String sql = "insert into w_or_l(p1, p2) values(false, true)";
//			pstmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery("select * from w_or_l");// 4. �������
			int i = 0;
			while(rs.next()) {
				System.out.println(rs.getString("id")+"-" + 
						rs.getString("p1")+"-"+
						rs.getString("p2"));
				i++;
				if(i == 10) break;
			}
		} catch(SQLException ee) {
			System.out.println("��ɾ� ���� ����"+ee.toString());
		}
		
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch(SQLException ee) {
			System.out.println("���� ���� ����"+ee.toString());
		}
	}
	public static String label(int k) {
		JLabel labels[] = new JLabel[10];
		labels = EndingGame.getLabel();
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		JFrame jf = EndingGame.getFrame();
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 2. �����ͺ��̽� ����
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs = stmt.executeQuery("select * from w_or_l");
			int i = 0;
			while(rs.next()) {
				if(i != k ) continue;
				String p1, p2;
				if(rs.getBoolean("p1")) {
					p1 = "��";
					p2 = "��";
				}else {
					p2 = "��";
					p1 = "��";
				}
				String st = "  " + p1 + "                     " + p2;
				System.out.println(st);
				i++;
				return st;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 4. �������
		return  "";
	}
	public static void input(boolean p1, boolean p2, int i) {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(i == 1) {
			String sql = "insert into w_or_l(p1, p2) values(true, false)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			String sql = "insert into w_or_l(p1, p2) values(false, true)";
			try {
				pstmt = conn.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

