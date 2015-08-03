package com.srivastava.ui;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.srivastava.dao.DAO;
import com.srivastava.dto.EmployeeDTO;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class AdvanceSearch extends JFrame {
	private JTextField empnotxt;
	private JTextField nametxt;
	private JTextField salarytxt;
	private JTable table;

	
	public static void main(String[] args) {
		
					AdvanceSearch frame = new AdvanceSearch();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public AdvanceSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 457);
		getContentPane().setLayout(null);
		
		empnotxt = new JTextField();
		empnotxt.setBounds(159, 50, 200, 27);
		getContentPane().add(empnotxt);
		empnotxt.setColumns(10);
		
		nametxt = new JTextField();
		nametxt.setBounds(159, 101, 200, 27);
		getContentPane().add(nametxt);
		nametxt.setColumns(10);
		
		salarytxt = new JTextField();
		salarytxt.setBounds(159, 149, 200, 27);
		getContentPane().add(salarytxt);
		salarytxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Empno");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(32, 36, 118, 50);
		getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(28, 89, 106, 50);
		getContentPane().add(lblName);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalary.setBounds(32, 135, 88, 50);
		getContentPane().add(lblSalary);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				callEmployeeData();
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(45, 194, 89, 23);
		getContentPane().add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 252, 400, 165);
		getContentPane().add(scrollPane);
		
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		table.setBounds(65, 252, 400, 300);
		scrollPane.setViewportView(table);
		//getContentPane().add(table);
	}
	
	private void callEmployeeData(){
		EmployeeDTO empDTO  = new EmployeeDTO();
		empDTO.setId(empnotxt.getText()!=null&& empnotxt.getText().trim().length()>0?Integer.parseInt(empnotxt.getText()):0);
		empDTO.setName(nametxt.getText());
		empDTO.setSalary(salarytxt.getText()!=null && salarytxt.getText().trim().length()>0?Double.parseDouble(salarytxt.getText()):0.0);
		DAO dao = new DAO();
		try {
			ArrayList<EmployeeDTO> empList = dao.getEmployees(empDTO);
			System.out.println(empList);
			if(empList.size()==0){
				JOptionPane.showMessageDialog(this, "No Record Found...");
			}
			else
			{
				EmployeeModel model = new EmployeeModel(empList);
                
                table.setModel(model);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
