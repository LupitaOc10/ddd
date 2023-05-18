package sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataVehiculo {
	private static final String controlador = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/simulacion2";
	private static final String user = "root";
	private static final String password = "";

	static {
		try {
			Class.forName(controlador);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection conectar() {
		Connection cx = null;
		try {
			cx = DriverManager.getConnection(url, user, password);
			System.out.println("Conexión exitosa");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cx;
	}

	public static void main(String[] args) {
		DataVehiculo dp = new DataVehiculo();
		dp.conectar();
	}

	public boolean Insertar(NegocioVehiculo np) {
		PreparedStatement ps = null;
		try {
			ps = conectar().prepareStatement("INSERT INTO vehiculo VALUES(?,?,?,?,?,?)");
			ps.setString(1, np.getVehiculoId());
			ps.setString(2, np.getMarca());
			ps.setString(3, np.getModelo());
			ps.setString(4, np.getAño());
			ps.setString(5, np.getColor());
			ps.setString(6, np.getTipo());

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean Cargar(NegocioVehiculo np) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conectar().prepareStatement("SELECT * FROM vehiculo WHERE VehiculoId=?");
			ps.setString(1, np.getVehiculoId());
			rs = ps.executeQuery();
			if (rs.next()) {
				np.setVehiculoId(rs.getString(1));
				np.setMarca(rs.getString(2));
				np.setModelo(rs.getString(3));
				np.setAño(rs.getString(4));
				np.setColor(rs.getString(5));
				np.setTipo(rs.getString(6));

				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean Eliminar(String VehiculoId) {
		PreparedStatement ps = null;
		try {
			NegocioVehiculo np = new NegocioVehiculo();
			np.setVehiculoId(VehiculoId);
			if (np.Cargar()) {
				ps = conectar().prepareStatement("DELETE FROM vehiculo WHERE VehiculoId=?");
				ps.setString(1, VehiculoId);
				ps.executeUpdate();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean Actualizar(NegocioVehiculo np) {
		PreparedStatement ps = null;
		try {
			NegocioVehiculo np2 = np;
			if (np2.Cargar()) {
				ps = conectar().prepareStatement(
						"UPDATE vehiculo SET Marca=?,Modelo=?,Año=?,Color=?,Tipo=? WHERE VehiculoId=?");
				ps.setString(1, np.getMarca());
				ps.setString(2, np.getModelo());
                ps.setString(3, np.getAño());
				ps.setString(4, np.getColor());
				ps.setString(5, np.getTipo());
				ps.setString(6, np.getVehiculoId());

				ps.executeUpdate();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}
}