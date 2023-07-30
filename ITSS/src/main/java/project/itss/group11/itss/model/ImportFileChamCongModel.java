package project.itss.group11.itss.model;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import project.itss.group11.itss.model.LogInfor;

public class ImportFileChamCongModel {
	private ArrayList<LogInfor> existedList = new ArrayList<LogInfor>();
	private ArrayList<LogInfor> inputList = new ArrayList<LogInfor>();
	private ArrayList<Boolean> writeToDBList = new ArrayList<Boolean>();
	private ArrayList<Boolean> isDuplicate = new ArrayList<Boolean>();
	private ObservableList<PreviewFileChamCongTableRowModel> tableRows = FXCollections.observableArrayList();
	public ObservableList<PreviewFileChamCongTableRowModel> getTableRows() {
		return tableRows;
	}

	public ArrayList<LogInfor> getInputList() {
		return inputList;
	}

	public ArrayList<Boolean> getIsDuplicate() {
		return isDuplicate;
	}

	public ImportFileChamCongModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void checkDuplicate() {
		for(LogInfor logInfor: inputList) {
			if(existedList.contains(logInfor))
				isDuplicate.add(true);
			else
				isDuplicate.add(false);
		}
	}
	
	public void inputRows(List<String[]> rows) {
		for(String[] row: rows) {
//			System.out.println("Input a row");

			int id = Integer.parseInt(row[0]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime timeStamp = LocalDateTime.parse(row[1], formatter);
			int device = Integer.parseInt(row[2]);
			
			LogInfor logInfor = new LogInfor();
			logInfor.setEmployeeID(id);
			logInfor.setTimeStamp(timeStamp);
			logInfor.setDevice(device);
			inputList.add(logInfor);
				
			PreviewFileChamCongTableRowModel tableRow = new PreviewFileChamCongTableRowModel(id, timeStamp, device);
			tableRows.add(tableRow);
				
//			System.out.println("Inputed a row");
		}
	}
}
