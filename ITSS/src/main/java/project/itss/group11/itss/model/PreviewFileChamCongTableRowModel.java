package project.itss.group11.itss.model;

import java.time.LocalDateTime;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.CheckBox;

public class PreviewFileChamCongTableRowModel {
	private final SimpleIntegerProperty id;
	private final ObjectProperty<LocalDateTime> timestamp = new SimpleObjectProperty<LocalDateTime>();
	private final SimpleIntegerProperty device;
	private CheckBox selectCheckBox;
	
	public CheckBox getSelectCheckBox() {
		return selectCheckBox;
	}

	public void setSelectCheckBox(CheckBox selectCheckBox) {
		this.selectCheckBox = selectCheckBox;
	}

	public int getId() {
		return id.get();
	}

	public LocalDateTime getTimestamp() {
		return timestamp.get();
	}

	public int getDevice() {
		return device.get();
	}

	public PreviewFileChamCongTableRowModel(int id, LocalDateTime timestamp, int device) {
		this.id = new SimpleIntegerProperty(id);
		this.timestamp.set(timestamp);
		this.device = new SimpleIntegerProperty(device);
		selectCheckBox = new CheckBox();
	}

}
