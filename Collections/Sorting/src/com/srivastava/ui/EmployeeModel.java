package com.srivastava.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.srivastava.dto.EmployeeDTO;

public class EmployeeModel extends AbstractTableModel  {

	List<EmployeeDTO> empList;
	String[] columnNames = {"EmployeeId", "Name", "Salary"};
	EmployeeModel(ArrayList<EmployeeDTO> empList){
		this.empList = empList;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	@Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return empList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		EmployeeDTO empDTO = empList.get(rowIndex);
        switch (columnIndex) {
        case 0:
            return empDTO.getId();
        case 1:
            return empDTO.getName();
        case 2:
            return empDTO.getSalary();
        default:
            return null;
        }
	}

}
