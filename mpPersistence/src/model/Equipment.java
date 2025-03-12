package model;
//@author Pelle
public class Equipment {
private String type;
private String description;

public Equipment(String type, String description) {
	this.type=type;
	this.description=description;
	
}

public void setType(String newType) {
	this.type=newType;
}


public void setDescription(String newDescription) {
	this.description=newDescription;
}

public String getType() {
	return type;

}

public String getDescription() {
	return description;
}

}