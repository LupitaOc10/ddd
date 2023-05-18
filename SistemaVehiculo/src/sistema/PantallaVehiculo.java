package sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaVehiculo {

	private JFrame frmSistemaVehiculo;
	private JTextField txtVehiculoId;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtAño;
	private JTextField txtColor;
	private JTextField txtTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaVehiculo window = new PantallaVehiculo();
					window.frmSistemaVehiculo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaVehiculo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaVehiculo = new JFrame();
		frmSistemaVehiculo.setTitle("Sistema Vehiculo");
		frmSistemaVehiculo.setBounds(100, 100, 450, 300);
		frmSistemaVehiculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaVehiculo.getContentPane().setLayout(null);

		JLabel lblVehiculoId = new JLabel("VehiculoId");
		lblVehiculoId.setBounds(10, 0, 63, 14);
		frmSistemaVehiculo.getContentPane().add(lblVehiculoId);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 25, 46, 14);
		frmSistemaVehiculo.getContentPane().add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 60, 46, 14);
		frmSistemaVehiculo.getContentPane().add(lblModelo);

		JLabel lblAño = new JLabel("Año");
		lblAño.setBounds(10, 95, 46, 14);
		frmSistemaVehiculo.getContentPane().add(lblAño);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(10, 138, 46, 14);
		frmSistemaVehiculo.getContentPane().add(lblColor);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 173, 46, 14);
		frmSistemaVehiculo.getContentPane().add(lblTipo);

		txtVehiculoId = new JTextField();
		txtVehiculoId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtVehiculoId.getText().length() >= 3) {
					e.consume();
				}
			}
		});
		txtVehiculoId.setBounds(83, -3, 86, 20);
		frmSistemaVehiculo.getContentPane().add(txtVehiculoId);
		txtVehiculoId.setColumns(10);

		txtMarca = new JTextField();
		txtMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtMarca.getText().length() >= 10) {
					e.consume();
				}
			}
		});
		txtMarca.setBounds(83, 22, 86, 20);
		frmSistemaVehiculo.getContentPane().add(txtMarca);
		txtMarca.setColumns(10);

		txtModelo = new JTextField();
		txtModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtModelo.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtModelo.setBounds(83, 57, 86, 20);
		frmSistemaVehiculo.getContentPane().add(txtModelo);
		txtModelo.setColumns(10);

		txtAño = new JTextField();
		txtAño.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtAño.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtAño.setBounds(83, 92, 86, 20);
		frmSistemaVehiculo.getContentPane().add(txtAño);
		txtAño.setColumns(10);

		txtColor = new JTextField();
		txtColor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtColor.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtColor.setBounds(83, 135, 86, 20);
		frmSistemaVehiculo.getContentPane().add(txtColor);
		txtColor.setColumns(10);

		txtTipo = new JTextField();
		txtTipo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtTipo.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtTipo.setBounds(83, 170, 86, 20);
		frmSistemaVehiculo.getContentPane().add(txtTipo);
		txtTipo.setColumns(10);

		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NegocioVehiculo np = new NegocioVehiculo();
					np.setVehiculoId(txtVehiculoId.getText());
					np.setMarca(txtMarca.getText());
					np.setModelo(txtModelo.getText());
					np.setAño(txtAño.getText());
					np.setColor(txtColor.getText());
					np.setTipo(txtTipo.getText());

					if (np.Insertar()) {
						limpiar();
						JOptionPane.showMessageDialog(null, "Vehiculo agregado");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnInsertar.setBounds(10, 211, 89, 23);
		frmSistemaVehiculo.getContentPane().add(btnInsertar);

		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String VehiculoId = JOptionPane.showInputDialog("ID a Cargar");
					NegocioVehiculo np = new NegocioVehiculo();
					np.setVehiculoId(VehiculoId);
					if (np.Cargar()) {
						txtVehiculoId.setText(np.getVehiculoId());
						txtMarca.setText(np.getMarca());
						txtModelo.setText(np.getModelo());
						txtAño.setText(np.getAño());
						txtColor.setText(np.getColor());
						txtTipo.setText(np.getTipo());

						JOptionPane.showMessageDialog(null, "Vehiculo encontrado");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnCargar.setBounds(109, 211, 89, 23);
		frmSistemaVehiculo.getContentPane().add(btnCargar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NegocioVehiculo np = new NegocioVehiculo();
					np.setVehiculoId(txtVehiculoId.getText());
					np.setMarca(txtMarca.getText());
					np.setModelo(txtModelo.getText());
					np.setAño(txtAño.getText());
					np.setColor(txtColor.getText());
					np.setTipo(txtTipo.getText());

					if (np.Actualizar()) {
						limpiar();
						JOptionPane.showMessageDialog(null, "Vehiculo actualizado");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnActualizar.setBounds(208, 211, 89, 23);
		frmSistemaVehiculo.getContentPane().add(btnActualizar);
	}

	public void limpiar() {
		txtVehiculoId.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtAño.setText("");
		txtColor.setText("");
		txtTipo.setText("");

	}
}
