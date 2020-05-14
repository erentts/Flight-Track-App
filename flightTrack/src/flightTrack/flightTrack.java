package flightTrack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;



public class flightTrack extends JFrame {
	private static capitals cp = new capitals();
	private ArrayList <capitals> cplist = new ArrayList <capitals>();

	private JPanel contentPane;
	private JTextField txt_add_capital;
	private JTable capitals_table;
	private JTable informationTable;
	private JTextField txtDepartureTime;
	private JTextField txtArrivalTime;
	private JTextField txtModel;
	private JTextField txtNumber;
	private JTextField txtName;
	private ButtonGroup bg = new ButtonGroup();
	private JTextField txtDepartureDate;
	private JTextField txtArrivalDate;
	private JTable controlTowerTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					flightTrack frame = new flightTrack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unused")
	public flightTrack() {
	
		setBackground(new Color(255, 153, 0));
		setTitle("FLIGHT TRACK APP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1410, 928);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setForeground(SystemColor.controlText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel app_header = new JLabel("FLIGHT TRACK APP");
		app_header.setBounds(509, 13, 465, 44);
		app_header.setForeground(new Color(255, 153, 0));
		app_header.setFont(new Font("Segoe UI", Font.BOLD, 39));
		contentPane.add(app_header);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(38, 93, 544, 280);
		desktopPane.setBorder(UIManager.getBorder("CheckBox.border"));
		desktopPane.setBackground(new Color(0, 51, 102));
		contentPane.add(desktopPane);
		
		JLabel lblAddCapital = new JLabel("Capital Name");
		lblAddCapital.setForeground(new Color(255, 153, 0));
		lblAddCapital.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblAddCapital.setBounds(12, 47, 143, 44);
		desktopPane.add(lblAddCapital);
		
		txt_add_capital = new JTextField();
		txt_add_capital.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txt_add_capital.setBounds(167, 55, 143, 34);
		desktopPane.add(txt_add_capital);
		txt_add_capital.setColumns(10);
		
		JButton btn_add_capital = new JButton("Add Capital");
		
		btn_add_capital.setBackground(new Color(255, 165, 0));
		btn_add_capital.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btn_add_capital.setBounds(12, 161, 143, 44);
		desktopPane.add(btn_add_capital);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(375, 47, 143, 210);
		desktopPane.add(scrollPane_1);
		
		capitals_table = new JTable();
		scrollPane_1.setViewportView(capitals_table);
		
		capitals_table.setFont(new Font("Segoe UI", Font.BOLD, 15));
		capitals_table.setBorder(UIManager.getBorder("EditorPane.border"));
		capitals_table.setRowHeight(25);
		capitals_table.setBackground(new Color(255, 165, 0));
		capitals_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Capitals"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		// SAYFA YUKLENDIGINDE LISTELENECEKLER
		DefaultTableModel model = (DefaultTableModel)capitals_table.getModel();
		
			capitals_table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					DefaultTableModel model = (DefaultTableModel)capitals_table.getModel();
					int selectedRow = capitals_table.getSelectedRow();
					txt_add_capital.setText(model.getValueAt(selectedRow, 0).toString());
					
				}
			});
		
		JLabel lblmessage = new JLabel("");
		lblmessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmessage.setForeground(new Color(255, 99, 71));
		lblmessage.setBounds(22, 104, 310, 44);
		desktopPane.add(lblmessage);
		
		JLabel lblCapitals = new JLabel("Capitals");
		lblCapitals.setForeground(new Color(255, 153, 0));
		lblCapitals.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblCapitals.setBounds(405, 13, 127, 29);
		desktopPane.add(lblCapitals);
		
		JButton btnDeleteCapital = new JButton("Delete Capital");
		
		btnDeleteCapital.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnDeleteCapital.setBackground(new Color(255, 165, 0));
		btnDeleteCapital.setBounds(188, 161, 143, 44);
		desktopPane.add(btnDeleteCapital);
		
		JLabel lblCaptals = new JLabel("CAPITALS");
		lblCaptals.setForeground(new Color(255, 153, 0));
		lblCaptals.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblCaptals.setBounds(36, 47, 192, 44);
		contentPane.add(lblCaptals);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBorder(UIManager.getBorder("CheckBox.border"));
		desktopPane_1.setBackground(new Color(0, 51, 102));
		desktopPane_1.setBounds(38, 432, 1329, 378);
		contentPane.add(desktopPane_1);
		
		JLabel lblArrival = new JLabel("Departure");
		lblArrival.setForeground(new Color(255, 153, 0));
		lblArrival.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblArrival.setBounds(24, 18, 82, 44);
		desktopPane_1.add(lblArrival);
		
		JButton addFlight = new JButton("Add Flight");
		
		addFlight.setFont(new Font("Segoe UI", Font.BOLD, 15));
		addFlight.setBackground(new Color(255, 165, 0));
		addFlight.setBounds(1136, 18, 143, 44);
		desktopPane_1.add(addFlight);
		
		JButton deleteFlight = new JButton("Delete Flight");
		
		deleteFlight.setFont(new Font("Segoe UI", Font.BOLD, 15));
		deleteFlight.setBackground(new Color(255, 165, 0));
		deleteFlight.setBounds(1136, 75, 143, 44);
		desktopPane_1.add(deleteFlight);
		
		JButton updateFlight = new JButton("Update Flight");
		
		updateFlight.setFont(new Font("Segoe UI", Font.BOLD, 15));
		updateFlight.setBackground(new Color(255, 165, 0));
		updateFlight.setBounds(1136, 132, 143, 44);
		desktopPane_1.add(updateFlight);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setForeground(new Color(255, 153, 0));
		lblDestination.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDestination.setBounds(24, 58, 101, 44);
		desktopPane_1.add(lblDestination);
		
		JLabel lblDeperture = new JLabel("Departure time");
		lblDeperture.setForeground(new Color(255, 153, 0));
		lblDeperture.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDeperture.setBounds(24, 98, 127, 44);
		desktopPane_1.add(lblDeperture);
		
		txtDepartureTime = new JTextField();
		txtDepartureTime.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtDepartureTime.setColumns(10);
		txtDepartureTime.setBounds(174, 107, 143, 27);
		desktopPane_1.add(txtDepartureTime);
		
		JLabel lblArrivalTime = new JLabel("Arrival time");
		lblArrivalTime.setForeground(new Color(255, 153, 0));
		lblArrivalTime.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblArrivalTime.setBounds(24, 138, 101, 44);
		desktopPane_1.add(lblArrivalTime);
		
		txtArrivalTime = new JTextField();
		txtArrivalTime.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtArrivalTime.setColumns(10);
		txtArrivalTime.setBounds(174, 147, 143, 27);
		desktopPane_1.add(txtArrivalTime);
		
		JLabel lblAircraftModel = new JLabel("Aircraft Model");
		lblAircraftModel.setForeground(new Color(255, 153, 0));
		lblAircraftModel.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblAircraftModel.setBounds(411, 97, 127, 44);
		desktopPane_1.add(lblAircraftModel);
		
		txtModel = new JTextField();
		txtModel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtModel.setColumns(10);
		txtModel.setBounds(561, 106, 143, 27);
		desktopPane_1.add(txtModel);
		
		JLabel lblFlightNumber = new JLabel("Flight Number");
		lblFlightNumber.setForeground(new Color(255, 153, 0));
		lblFlightNumber.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblFlightNumber.setBounds(411, 138, 127, 44);
		desktopPane_1.add(lblFlightNumber);
		
		txtNumber = new JTextField();
		txtNumber.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtNumber.setColumns(10);
		txtNumber.setBounds(561, 147, 143, 27);
		desktopPane_1.add(txtNumber);
		
		JLabel lblAirlinesName = new JLabel("Airlines Name");
		lblAirlinesName.setForeground(new Color(255, 153, 0));
		lblAirlinesName.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblAirlinesName.setBounds(789, 18, 127, 44);
		desktopPane_1.add(lblAirlinesName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtName.setColumns(10);
		txtName.setBounds(939, 27, 143, 27);
		desktopPane_1.add(txtName);
		
		JCheckBox checkWeekDays = new JCheckBox("Weekdays");
		checkWeekDays.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkWeekDays.setBounds(819, 84, 113, 25);
		desktopPane_1.add(checkWeekDays);
		
		JCheckBox checkWeekEnd = new JCheckBox("Weekend");
		checkWeekEnd.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkWeekEnd.setBounds(969, 84, 113, 25);
		desktopPane_1.add(checkWeekEnd);
		
		JComboBox cbDeparture = new JComboBox();
		
		cbDeparture.setBounds(174, 27, 143, 27);
		desktopPane_1.add(cbDeparture);
		
		JComboBox cbDestination = new JComboBox();
		cbDestination.setBounds(174, 68, 143, 27);
		desktopPane_1.add(cbDestination);
		
		JLabel lblFlightInformation = new JLabel("");
		lblFlightInformation.setForeground(new Color(255, 99, 71));
		lblFlightInformation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFlightInformation.setBounds(737, 132, 390, 66);
		desktopPane_1.add(lblFlightInformation);
		
		JLabel lblFlght = new JLabel("FLIGHT INFORMATION");
		lblFlght.setForeground(new Color(255, 153, 0));
		lblFlght.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblFlght.setBounds(38, 386, 544, 44);
		contentPane.add(lblFlght);
		
		
		btn_add_capital.addActionListener(new ActionListener() { // ADD CAPITAL
			public void actionPerformed(ActionEvent arg0) {
				lblmessage.setText("");
				DefaultTableModel model = (DefaultTableModel)capitals_table.getModel();
				if (txt_add_capital.getText().trim().equals("")) {
					lblmessage.setText("You can not pass as empty !");
				}
				else {
					int control=0;
					boolean durum = cp.getCapitals().contains(txt_add_capital.getText());
					if (durum){
						control++;
					}
					if (control == 0) {
						Object[] eklenecek = {txt_add_capital.getText()};
						model.addRow(eklenecek);
						cp.addCapital(txt_add_capital.getText());
						cbDeparture.addItem(txt_add_capital.getText()); // Flight Information'daki ComboBox'larada eklenen þehirleri ekliyorum.
						
						lblmessage.setText("Adding Capital is successful !");
					}
					else {
						lblmessage.setText("This capital is already available on the table..");
					}
					
				}
				
			}
		});
		Object[] eklenecek = {"Istanbul"};
		model.addRow(eklenecek);
		Object[] eklenecek2 = {"Tokyo"};
		model.addRow(eklenecek2);
		Object[] eklenecek3 = {"New York"};
		model.addRow(eklenecek3);
		Object[] eklenecek4 = {"Sydney"};
		model.addRow(eklenecek4);
		Object[] eklenecek5 = {"Paris"};
		model.addRow(eklenecek5);
		
		cp.addCapital("Istanbul");
		cp.addCapital("Tokyo");
		cp.addCapital("New York");
		cp.addCapital("Sydney");
		cp.addCapital("Paris");
		
		btnDeleteCapital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblmessage.setText("");
				DefaultTableModel model = (DefaultTableModel)capitals_table.getModel();
				int selectedRow = capitals_table.getSelectedRow();
				if (selectedRow == -1) {
					if (capitals_table.getRowCount()==0) {
						lblmessage.setText("Capitals table is empty..");
					}
					else {
						lblmessage.setText("Please choose a capital on the table..");
					}
				}
				else {
					model.removeRow(selectedRow);
					cp.deleteCapital(selectedRow);
					cbDeparture.removeItemAt(selectedRow);  // Flight Information Bölümündeki ComboBox'lardada silme iþlemini gerçekleþtirdik.
					lblmessage.setText("Deleting Capital is successful !");
				}
			}
		});
		
		// Combobox'lara þehirleri çekme..
		for (int i=0;i<cp.getCapitals().size();i++) {
			cbDeparture.addItem(cp.getCapitals().get(i));
		}
		
		cbDeparture.addActionListener(new ActionListener() { // Kalkýþ Kentini Combobox'dan örnek olarak Ýstanbul Seçersek Varýþ Ýstanbul Olmamalý.
			public void actionPerformed(ActionEvent arg0) {
				cbDestination.removeAllItems(); // Sürekli kayýt tekrarýný önlemek için her aksiyonun baþlangýcýnda combobox'ýn içini temizliyorum.
				for (int i=0;i<cp.getCapitals().size();i++) {
					if(cbDeparture.getSelectedItem().toString().compareTo(cp.getCapitals().get(i))==0) {
						continue;
					}
					else {
						cbDestination.addItem(cp.getCapitals().get(i));
					}	
				}
			}
		});
		
		bg.add(checkWeekEnd);  // CheckBox larý grupladýk bu sayede sadece bir tanesi seçilebilecek.
		bg.add(checkWeekDays);
		
		JLabel lblDestinationDate = new JLabel("Departure Date");
		lblDestinationDate.setForeground(new Color(255, 153, 0));
		lblDestinationDate.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblDestinationDate.setBounds(411, 18, 127, 44);
		desktopPane_1.add(lblDestinationDate);
		
		txtDepartureDate = new JTextField();
		txtDepartureDate.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtDepartureDate.setColumns(10);
		txtDepartureDate.setBounds(561, 27, 143, 27);
		desktopPane_1.add(txtDepartureDate);
		
		JLabel lblArrivalDate = new JLabel("Arrival Date");
		lblArrivalDate.setForeground(new Color(255, 153, 0));
		lblArrivalDate.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblArrivalDate.setBounds(411, 59, 101, 44);
		desktopPane_1.add(lblArrivalDate);
		
		txtArrivalDate = new JTextField();
		txtArrivalDate.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtArrivalDate.setColumns(10);
		txtArrivalDate.setBounds(561, 68, 143, 27);
		desktopPane_1.add(txtArrivalDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 206, 1279, 159);
		desktopPane_1.add(scrollPane);
		
		informationTable = new JTable();
		scrollPane.setViewportView(informationTable);
		informationTable.setRowHeight(30);
		
		
		informationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Departure", "Destination", "Departure Time", "Arrival Time",  "Departure Date", "Arrival Date", "Aircraft Model", "Flight Number", "Airlines Name", "Week","Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false,false,false,false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		informationTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		informationTable.getColumnModel().getColumn(2).setPreferredWidth(110);
		informationTable.getColumnModel().getColumn(3).setPreferredWidth(110);
		informationTable.getColumnModel().getColumn(4).setPreferredWidth(110);
		informationTable.getColumnModel().getColumn(5).setPreferredWidth(110);
		informationTable.getColumnModel().getColumn(6).setPreferredWidth(110);
		
		informationTable.setFont(new Font("Segoe UI", Font.BOLD, 15));
		informationTable.setBorder(UIManager.getBorder("EditorPane.border"));
		informationTable.setBackground(new Color(255, 165, 0));
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBorder(UIManager.getBorder("CheckBox.border"));
		desktopPane_2.setBackground(new Color(0, 51, 102));
		desktopPane_2.setBounds(680, 93, 684, 280);
		contentPane.add(desktopPane_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 68, 662, 94);
		desktopPane_2.add(scrollPane_2);
		
		controlTowerTable = new JTable();
		controlTowerTable.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane_2.setViewportView(controlTowerTable);
		controlTowerTable.setBackground(new Color(255, 165, 0));
		controlTowerTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Flight Number", "Departure", "Destination", "Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnGiveDelay = new JButton("Give Delay");
		
		
		btnGiveDelay.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnGiveDelay.setBackground(new Color(255, 165, 0));
		btnGiveDelay.setBounds(10, 175, 143, 44);
		desktopPane_2.add(btnGiveDelay);
		
		JButton btnCancelFlight = new JButton("Cancel Flight");
		
		btnCancelFlight.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnCancelFlight.setBackground(new Color(255, 165, 0));
		btnCancelFlight.setBounds(175, 175, 143, 44);
		desktopPane_2.add(btnCancelFlight);
		
		JButton btnAllowLanding = new JButton("Allow Landing");
		
		btnAllowLanding.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnAllowLanding.setBackground(new Color(255, 165, 0));
		btnAllowLanding.setBounds(340, 175, 143, 44);
		desktopPane_2.add(btnAllowLanding);
		
		JButton btnWaitForLanding = new JButton("Wait For Landing");
		
		btnWaitForLanding.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnWaitForLanding.setBackground(new Color(255, 165, 0));
		btnWaitForLanding.setBounds(503, 175, 167, 44);
		desktopPane_2.add(btnWaitForLanding);
		
		JLabel lblCapitalWhereThe = new JLabel("Capital where the control tower is located");
		lblCapitalWhereThe.setForeground(new Color(255, 153, 0));
		lblCapitalWhereThe.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblCapitalWhereThe.setBounds(24, 11, 360, 44);
		desktopPane_2.add(lblCapitalWhereThe);
		
		JComboBox cbTowerCapital = new JComboBox();
		

		cbTowerCapital.setBounds(396, 22, 143, 27);
		desktopPane_2.add(cbTowerCapital);
		
		JButton btnlist = new JButton("List");
		
		btnlist.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnlist.setBackground(new Color(255, 165, 0));
		btnlist.setBounds(567, 13, 105, 44);
		desktopPane_2.add(btnlist);
		
		JLabel lblControlMessage = new JLabel("");
		lblControlMessage.setBounds(69, 234, 528, 33);
		desktopPane_2.add(lblControlMessage);
		lblControlMessage.setForeground(new Color(255, 99, 71));
		lblControlMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		controlTowerTable.getColumnModel().getColumn(0).setPreferredWidth(147);
		controlTowerTable.getColumnModel().getColumn(1).setPreferredWidth(161);
		controlTowerTable.getColumnModel().getColumn(2).setPreferredWidth(165);
		controlTowerTable.getColumnModel().getColumn(3).setPreferredWidth(172);
		
		JLabel lblControlTower = new JLabel("CONTROL TOWER");
		lblControlTower.setForeground(new Color(255, 153, 0));
		lblControlTower.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblControlTower.setBounds(1102, 47, 263, 44);
		contentPane.add(lblControlTower);
		
		JButton btnResume = new JButton("Resume");
		
		btnResume.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnResume.setBackground(new Color(255, 165, 0));
		btnResume.setBounds(660, 823, 98, 44);
		contentPane.add(btnResume);
		
		JLabel lblTimer = new JLabel("0.0");
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBackground(Color.WHITE);
		lblTimer.setForeground(new Color(255, 99, 71));
		lblTimer.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTimer.setBounds(979, 823, 252, 44);
		contentPane.add(lblTimer);
		
		JButton btnStop = new JButton("Stop");
		
		btnStop.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnStop.setBackground(new Color(255, 165, 0));
		btnStop.setBounds(770, 823, 98, 44);
		contentPane.add(btnStop);
		
		JButton btnPause = new JButton("Pause");
		
		
		btnPause.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnPause.setBackground(new Color(255, 165, 0));
		btnPause.setBounds(550, 823, 98, 44);
		contentPane.add(btnPause);
		
		JButton btnStart = new JButton("Start");
		
		
		btnStart.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnStart.setBackground(new Color(255, 165, 0));
		btnStart.setBounds(440, 823, 98, 44);
		contentPane.add(btnStart);
		
		JLabel lblSystemConfiguration = new JLabel("System Configuration");
		lblSystemConfiguration.setForeground(new Color(255, 165, 0));
		lblSystemConfiguration.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSystemConfiguration.setBounds(173, 823, 240, 44);
		contentPane.add(lblSystemConfiguration);
		
		
		informationTable.addMouseListener(new MouseAdapter() {  // Tablo üzerinde Seçince Kutucuklara gerekli bilgileri getirme.
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model2 = (DefaultTableModel)informationTable.getModel();
				
				int selectedRow = informationTable.getSelectedRow();
				
				cbDeparture.setSelectedItem(model2.getValueAt(selectedRow, 0).toString());
				cbDestination.setSelectedItem(model2.getValueAt(selectedRow, 1).toString());
				txtDepartureTime.setText(model2.getValueAt(selectedRow, 2).toString());
				txtArrivalTime.setText(model2.getValueAt(selectedRow, 3).toString());
				txtDepartureDate.setText(model2.getValueAt(selectedRow, 4).toString());
				txtArrivalDate.setText(model2.getValueAt(selectedRow, 5).toString());
				txtModel.setText(model2.getValueAt(selectedRow, 6).toString());
				txtNumber.setText(model2.getValueAt(selectedRow, 7).toString());
				txtName.setText(model2.getValueAt(selectedRow, 8).toString());
				if (model2.getValueAt(selectedRow, 9).toString().compareTo(checkWeekDays.getText())==0) {
					checkWeekDays.setSelected(true);
				}
				else {
					checkWeekEnd.setSelected(true);
				}
			}
		});
		
		addFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				lblFlightInformation.setText("");
				DefaultTableModel model = (DefaultTableModel)informationTable.getModel();
				if (cbDeparture.getSelectedItem().toString().trim().equals("") || cbDestination == null || 
						txtDepartureTime.getText().trim().equals("")  || txtArrivalTime.getText().trim().equals("") || txtDepartureDate.getText().trim().equals("")  ||
						txtArrivalDate.getText().trim().equals("")  || txtModel.getText().trim().equals("")  ||
						txtNumber.getText().trim().equals("") || txtName.getText().trim().equals("") || (checkWeekDays.isSelected() == false && checkWeekEnd.isSelected()==false)  ) {
					lblFlightInformation.setText("You can not pass as empty !");
				}
				else {
					int k=0;
					for (int i = 0; i < model.getRowCount(); i++) {
						if (model.getValueAt(i, 7).toString().trim().compareTo(txtNumber.getText().toString().trim())==0)
						{
							k++;
							//lblFlightInformation.setText("There is a flight with this number. Please enter a different number..");
						}
					}
					if (k==0) {
						String week;
						if(checkWeekDays.isSelected()) {
							week = checkWeekDays.getText();
						}
						else {
							week = checkWeekEnd.getText();
						}
							Object[] eklenecek = {cbDeparture.getSelectedItem(),cbDestination.getSelectedItem(),txtDepartureTime.getText(),txtArrivalTime.getText(),
									txtDepartureDate.getText(),txtArrivalDate.getText(),txtModel.getText(),txtNumber.getText(),txtName.getText(),week,"Ready to Flight"};
							model.addRow(eklenecek);
							
							
							// CREATING FILE
							FileWriter writer = null;
							try {
								writer = new FileWriter("file.txt",true);  // true ;  dosya eðer var ise üstüne yazmaya devam eder.
								
								writer.write(cbDeparture.getSelectedItem().toString()+",");
								writer.write(cbDestination.getSelectedItem().toString()+",");
								writer.write(txtDepartureTime.getText()+",");
								writer.write(txtArrivalTime.getText()+",");
								writer.write(txtDepartureDate.getText()+",");
								writer.write(txtArrivalDate.getText()+",");
								writer.write(txtModel.getText()+",");
								writer.write(txtNumber.getText()+",");
								writer.write(txtName.getText()+",");
								writer.write(week+",");
								writer.write("Ready to Flight"+"\n");
								
							} catch (IOException ex) {
								System.out.println("IOException has occured while file is opening.");
							}
							finally {
								if(writer !=null) {
									try {
										writer.close();
									}
									catch (IOException ex) {
										System.out.println("An Error has occured while file is closing.");
									}
								}
							}
							lblFlightInformation.setText("Adding flight information is successful !");
					}
					else {
						lblFlightInformation.setText("There is a flight with this number. \nPlease enter a different number..");
					}
					
					
				}
			
			}
		});
		
		
		deleteFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)informationTable.getModel();
				
				int selectedRow = informationTable.getSelectedRow();
				
				if (selectedRow == -1) {
					if(informationTable.getRowCount() == 0) {
						lblFlightInformation.setText("Information Table is empty..");
					}
					else {
						lblFlightInformation.setText("Please choose an information on the table for deleting..");
					}
				}
				else {
					
					//DOSYA SÝLME
					Scanner x;
					
					String filepath = "file.txt";
					String removeTerm = model.getValueAt(selectedRow, 7).toString();
					
					String tempFile = "temp.txt";
					File oldFile = new File(filepath);
					File newFile = new File(tempFile);
					String departure = ""; String destination="";String departureTime=""; String arrivalTime = ""; String departureDate ="";String arrivalDate="";
					String modelName = ""; String number = ""; String name=""; String week=""; String status=""; 
					try {
						FileWriter fw = new FileWriter(tempFile,true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						x = new Scanner(new File(filepath));
						x.useDelimiter("[,\n]");
						
						while(x.hasNext()) {
							departure = x.next();
							destination = x.next();
							departureTime = x.next();
							arrivalTime = x.next();
							departureDate = x.next();
							arrivalDate = x.next();
							modelName = x.next();
							number = x.next();
							name = x.next();
							week = x.next();
							status = x.next();
							if (number.toString().compareTo(removeTerm) != 0) {   // flight number giricem   !departure.equals(removeTerm)
								pw.println(departure + "," + destination + "," + departureTime +"," + arrivalTime+","+departureDate+","+arrivalDate+","+modelName+","+
							number+","+name+","+week+","+status);
							}
						}
						x.close();
						pw.flush();
						pw.close();
						oldFile.delete();
						File dump = new File(filepath);
						newFile.renameTo(dump);
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Deleting data has occured error in File");
					}
					
					model.removeRow(selectedRow);
					lblFlightInformation.setText("Deleting information is successful !");
				}
			}
		});
		
		updateFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblFlightInformation.setText("");
				
				if (cbDeparture.getSelectedItem().toString().trim().equals("") || cbDestination == null || 
						txtDepartureTime.getText().trim().equals("")  || txtArrivalTime.getText().trim().equals("") || txtDepartureDate.getText().trim().equals("")  ||
						txtArrivalDate.getText().trim().equals("")  || txtModel.getText().trim().equals("")  ||
						txtNumber.getText().trim().equals("") || txtName.getText().trim().equals("") || (checkWeekDays.isSelected() == false && checkWeekEnd.isSelected()==false)  ) {
					lblFlightInformation.setText("You can not pass as empty !");
				}
				else {
					DefaultTableModel model = (DefaultTableModel)informationTable.getModel();
					
					
					int selectedRow = informationTable.getSelectedRow();
					
					if (selectedRow == -1) {
						if(informationTable.getRowCount() == 0) {
							lblFlightInformation.setText("Information Table is empty..");
						}
						else {
							lblFlightInformation.setText("Please choose an information on the table for updating..");
						}
					}
					else {
						
						String choosingWeek;
						if(checkWeekDays.isSelected()) {
							choosingWeek = checkWeekDays.getText();
						}
						else {
							choosingWeek = checkWeekEnd.getText();
						}
						// DOSYA GÜNCELLEME
						
						Scanner x;
						
						String filepath = "file.txt";
						String editTerm = model.getValueAt(selectedRow, 7).toString();
						String newDeparture = cbDeparture.getSelectedItem().toString();
						String newDestination = cbDestination.getSelectedItem().toString();
						String newDepartureTime = txtDepartureTime.getText();
						String newArrivalTime = txtArrivalTime.getText();
						String newDepartureDate = txtDepartureDate.getText();
						String newArrivalDate = txtArrivalDate.getText();
						String newModel = txtModel.getText();
						String newNumber = txtNumber.getText();
						String newName = txtName.getText();
						String newWeek = choosingWeek;
						String newStatus = model.getValueAt(selectedRow, 10).toString();
						
						String tempFile = "temp.txt";
						File oldFile = new File(filepath);
						File newFile = new File(tempFile);
						String departure = "" ; String destination=""; String departureTime = ""; String arrivalTime = ""; String departureDate = "" ; String arrivalDate = "";
						String modelcraft = ""; String number = ""; String name = ""; String week = ""; String status = "";
						try {
							FileWriter fw = new FileWriter(tempFile,true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter pw = new PrintWriter(bw);
							x = new Scanner(new File(filepath));
							x.useDelimiter("[,\n]");
							
							while (x.hasNext()) {
								departure = x.next();
								destination = x.next();
								departureTime = x.next();
								arrivalTime = x.next();
								departureDate = x.next();
								arrivalDate = x.next();
								modelcraft = x.next();
								number = x.next();
								name = x.next();
								week = x.next();
								status = x.next();
								if (number.toString().compareTo(editTerm) != 0) { // Aranan numara eþleþmez ise eski hali aynen kalýr.
									pw.println(departure + "," + destination+"," + departureTime+","+arrivalTime+","+departureDate+","+arrivalDate+","+
											modelcraft+","+number+","+name+","+week+","+status);
								}
								else {
									pw.println(newDeparture + "," + newDestination+"," + newDepartureTime+","+newArrivalTime+","+newDepartureDate+","+newArrivalDate+","+
											newModel+","+newNumber+","+newName+","+newWeek+","+newStatus);
								}
							}
							x.close();
							pw.flush();
							pw.close();
							oldFile.delete();
							File dump = new File(filepath);
							newFile.renameTo(dump);
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Updating data has occured error in File");
						}
						
						// TABLODA GÜNCELLEME
						model.setValueAt(cbDeparture.getSelectedItem().toString(), selectedRow, 0);
						model.setValueAt(cbDestination.getSelectedItem().toString(), selectedRow, 1);
						model.setValueAt(txtDepartureTime.getText(), selectedRow, 2);
						model.setValueAt(txtArrivalTime.getText(), selectedRow, 3);
						model.setValueAt(txtDepartureDate.getText(), selectedRow, 4);
						model.setValueAt(txtArrivalDate.getText(), selectedRow, 5);
						model.setValueAt(txtModel.getText(), selectedRow, 6);
						model.setValueAt(txtNumber.getText(), selectedRow, 7);
						model.setValueAt(txtName.getText(), selectedRow, 8);
						model.setValueAt(choosingWeek, selectedRow, 9);
						
						lblFlightInformation.setText("Updating Information is successful !");
					}
				}
				
				
			}
		});
		
		cbTowerCapital.addMouseListener(new MouseAdapter() {    // Kulenin var olduðu þehirleri listeleme..
			@Override
			public void mouseEntered(MouseEvent e) {
				cbTowerCapital.removeAllItems();
				for (int i=0;i<cp.getCapitals().size();i++) {
					cbTowerCapital.addItem(cp.getCapitals().get(i));
				}
			}
		});
		
		
		btnlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbTowerCapital.getSelectedItem()!=null) {
					lblControlMessage.setText("");
					DefaultTableModel model = (DefaultTableModel)controlTowerTable.getModel();
					model.setRowCount(0);
					boolean found = false;
					String departure = "" ; String destination=""; String departureTime = ""; String arrivalTime = ""; String departureDate = "" ; String arrivalDate = "";
					String modelcraft = ""; String number = ""; String name = ""; String week = ""; String status = ""; 
					try {
						Scanner x;
						String filepath = "file.txt";
						String searchTerm = cbTowerCapital.getSelectedItem().toString();
						x = new Scanner(new File(filepath));
						x.useDelimiter("[,\n]");
						while(x.hasNext() && !found) {
							departure = x.next();
							destination = x.next();
							departureTime = x.next();
							arrivalTime = x.next();
							departureDate = x.next();
							arrivalDate = x.next();
							modelcraft = x.next();
							number = x.next();
							name = x.next();
							week = x.next();
							status = x.next();
							if (destination.compareTo(searchTerm) == 0) {
								Object[] add = {number.toString(),departure.toString(),destination.toString(),status.toString()}; 	
								model.addRow(add);
							}
						}
						
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				else {
					lblControlMessage.setText("Please choose an capital..");
				}
				
			}
		});
		
		
		btnGiveDelay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)controlTowerTable.getModel();
				DefaultTableModel model2 = (DefaultTableModel)informationTable.getModel();
				
				int selectedRow = controlTowerTable.getSelectedRow();
				
				if (selectedRow == -1) {
					if(controlTowerTable.getRowCount() == 0) {
						lblControlMessage.setText("Control Tower Table is empty..");
					}
					else {
						lblControlMessage.setText("Please choose an information on the table for updating..");
					}
				}
				else {
					lblControlMessage.setText("");
					model.setValueAt("Delay", selectedRow, 3);
					for (int i = 0; i < model2.getRowCount(); i++) {
						if (model2.getValueAt(i, 7).toString().trim().compareTo(model.getValueAt(selectedRow, 0).toString().trim())==0) {
							model2.setValueAt("Delay", i, 10);
						}
					}
				}
			}
		});
		
		btnCancelFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)controlTowerTable.getModel();
				DefaultTableModel model2 = (DefaultTableModel)informationTable.getModel();
				
				int selectedRow = controlTowerTable.getSelectedRow();
				
				if (selectedRow == -1) {
					if(controlTowerTable.getRowCount() == 0) {
						lblControlMessage.setText("Control Tower Table is empty..");
					}
					else {
						lblControlMessage.setText("Please choose an information on the table for updating..");
					}
				}
				else {
					lblControlMessage.setText("");
					model.setValueAt("Flight cancelled", selectedRow, 3);
					for (int i = 0; i < model2.getRowCount(); i++) {
						if (model2.getValueAt(i, 7).toString().trim().compareTo(model.getValueAt(selectedRow, 0).toString().trim())==0) {
							model2.setValueAt("Flight cancelled", i, 10);
						}
					}
				}
			}
		});
		
		
		btnAllowLanding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					DefaultTableModel model = (DefaultTableModel)controlTowerTable.getModel();
					DefaultTableModel model2 = (DefaultTableModel)informationTable.getModel();
					
					int selectedRow = controlTowerTable.getSelectedRow();
					
					if (selectedRow == -1) {
						if(controlTowerTable.getRowCount() == 0) {
							lblControlMessage.setText("Control Tower Table is empty..");
						}
						else {
							lblControlMessage.setText("Please choose an information on the table for updating..");
						}
					}
					else {
						lblControlMessage.setText("");
						model.setValueAt("Landing allowed", selectedRow, 3);
						for (int i = 0; i < model2.getRowCount(); i++) {
							if (model2.getValueAt(i, 7).toString().trim().compareTo(model.getValueAt(selectedRow, 0).toString().trim())==0) {
								model2.setValueAt("Landing allowed", i, 10);
							}
						}
					}
			}
		});
		
		btnWaitForLanding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)controlTowerTable.getModel();
				DefaultTableModel model2 = (DefaultTableModel)informationTable.getModel();
				
				int selectedRow = controlTowerTable.getSelectedRow();
				
				if (selectedRow == -1) {
					if(controlTowerTable.getRowCount() == 0) {
						lblControlMessage.setText("Control Tower Table is empty..");
					}
					else {
						lblControlMessage.setText("Please choose an information on the table for updating..");
					}
				}
				else {
					lblControlMessage.setText("");
					model.setValueAt("Wait for landing", selectedRow, 3);
					for (int i = 0; i < model2.getRowCount(); i++) {
						if (model2.getValueAt(i, 7).toString().trim().compareTo(model.getValueAt(selectedRow, 0).toString().trim())==0) {
							model2.setValueAt("Wait for landing", i, 10);
						}
					}
				}
			}
		});
		
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)informationTable.getModel();
				DefaultTableModel modela = (DefaultTableModel)controlTowerTable.getModel();
				if (informationTable.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Table is empty..");
				}
				else {
					Thread clock = new Thread() {
						
						
						public void run() {
							try {
								
								double time = 0;
								DecimalFormat df = new DecimalFormat("#.#");
								df.setGroupingUsed(true);
								double waitingTime=0;
								double increasingDestinationTime=0;
								double increasingDepartureTime=0;

								for(;;) {
									
									double [] dizi = new double[model.getRowCount()];
									for (int i = 0; i<model.getRowCount(); i++) {
										dizi[i] = Double.parseDouble(model.getValueAt(i, 2).toString());
										
									}
									
									for (int i = 0; i<model.getRowCount(); i++) {
										if (Double.parseDouble(model.getValueAt(i, 2).toString().trim()) <= time && time < Double.parseDouble(model.getValueAt(i, 3).toString().trim())
												&& model.getValueAt(i, 10).toString().compareTo("Flight cancelled") != 0  ) {
											if (model.getValueAt(i, 10).toString().trim().compareTo("Delay")==0) {
												
												model.setValueAt("Delay", i, 10);
												increasingDepartureTime = Double.parseDouble(model.getValueAt(i, 2).toString().trim());
												model.setValueAt(df.format(increasingDepartureTime+0.1).replace(",", "."), i, 2);
												increasingDestinationTime = Double.parseDouble(model.getValueAt(i, 3).toString().trim());
												model.setValueAt(df.format(increasingDestinationTime+0.1).replace(",", "."), i, 3);
												
											}
											else if (model.getValueAt(i, 10).toString().compareTo("Wait for landing")==0) {
												
												model.setValueAt("Wait for landing", i,10);
												increasingDestinationTime = Double.parseDouble(model.getValueAt(i, 3).toString().trim());
												model.setValueAt(df.format(increasingDestinationTime+0.1).replace(",", "."), i, 3);
												
											}
											else if (model.getValueAt(i, 10).toString().compareTo("Landing allowed")==0){
												model.setValueAt(df.format(time).replace(",", "."), i, 10);
											}
											else {
												model.setValueAt(df.format(time).replace(",", "."), i, 10);
											}
												
										}
												
										if (time >= Double.parseDouble(model.getValueAt(i, 3).toString().trim()) && (model.getValueAt(i, 10).toString().compareTo("Wait for landing")!=0
												&& model.getValueAt(i, 10).toString().compareTo("Landing allowed")!=0) &&
												model.getValueAt(i, 10).toString().compareTo("Flight cancelled") != 0  && 
												model.getValueAt(i, 10).toString().compareTo("Delay") != 0) {
											
											model.setValueAt("Flight Over", i, 10);
											
		
											if (model.getValueAt(i, 10).toString().compareTo("Flight Over")==0) {
												
												// CREATING FILE
												FileWriter writer = null;
												try {
													writer = new FileWriter("flightover.txt",true);  // true ;  dosya eðer var ise üstüne yazmaya devam eder.
													
													writer.write(model.getValueAt(i, 0).toString()+",");
													writer.write(model.getValueAt(i, 1).toString()+",");
													writer.write(model.getValueAt(i, 2).toString()+",");
													writer.write(model.getValueAt(i, 3).toString()+",");
													writer.write(model.getValueAt(i, 4).toString()+",");
													writer.write(model.getValueAt(i, 5).toString()+",");
													writer.write(model.getValueAt(i, 6).toString()+",");
													writer.write(model.getValueAt(i, 7).toString()+",");
													writer.write(model.getValueAt(i, 8).toString()+",");
													writer.write(model.getValueAt(i, 9).toString()+",");
													writer.write(model.getValueAt(i, 10).toString()+"\n");
													
												} catch (IOException ex) {
													System.out.println("IOException has occured while file is opening.");
												}
												finally {
													if(writer !=null) {
														try {
															writer.close();
														}
														catch (IOException ex) {
															System.out.println("An Error has occured while file is closing.");
														}
													}
												}
												
												//DOSYADAN SÝLME
												Scanner x;
												
												String filepath = "file.txt";
												String removeTerm = model.getValueAt(i, 7).toString().trim();				
												String tempFile = "temp.txt";
												File oldFile = new File(filepath);
												File newFile = new File(tempFile);
												String departure = ""; String destination="";String departureTime=""; String arrivalTime = ""; String departureDate ="";String arrivalDate="";
												String modelName = ""; String number = ""; String name=""; String week=""; String status=""; 
												try {
													FileWriter fw = new FileWriter(tempFile,true);
													BufferedWriter bw = new BufferedWriter(fw);
													PrintWriter pw = new PrintWriter(bw);
													x = new Scanner(new File(filepath));
													x.useDelimiter("[,\n]");
													
													while(x.hasNext()) {
														departure = x.next();
														destination = x.next();
														departureTime = x.next();
														arrivalTime = x.next();
														departureDate = x.next();
														arrivalDate = x.next();
														modelName = x.next();
														number = x.next();
														name = x.next();
														week = x.next();
														status = x.next();
														if (number.toString().compareTo(removeTerm) != 0) {   // flight number giricem   !departure.equals(removeTerm)
															pw.println(departure + "," + destination + "," + departureTime +"," + arrivalTime+","+departureDate+","+arrivalDate+","+modelName+","+
														number+","+name+","+week+","+status);
														}
													}
													x.close();
													pw.flush();
													pw.close();
													oldFile.delete();
													File dump = new File(filepath);
													newFile.renameTo(dump);
												}
												catch(Exception e) {
													JOptionPane.showMessageDialog(null, "Deleting data has occured error in File");
												}
												sleep(1500);
												model.removeRow(i);
											}
										}
									}
								
									lblTimer.setText(df.format(time).replace(",", ".")+"");
									sleep(1000);
									time = time + 0.1;
								}
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
						}
					};
					clock.start();
					btnPause.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							clock.suspend();
		
								Thread clock = new Thread() {
									public void run() {
										try {
											int suspendCount = 0;
											for(;;) {
												sleep(1000);
												suspendCount++;
											}
										}
											catch (InterruptedException e) {
											e.printStackTrace();
											}
									}
								};
						}
					});
					
					btnResume.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							clock.resume();
						}
					});
					
					btnStop.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							clock.stop();
						}
					});
				}
				
				
				
			}
		});
		
	}
}
