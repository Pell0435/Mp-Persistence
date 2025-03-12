package model;
//@author Pelle
public class Clothing {
private String size;
private String colour;

public Clothing(String size,String colour) {
	this.size=size;
	this.colour=colour;
}

public void setSize(String newSize) {
	this.size=newSize;
}

public void setColour(String newColour) {
	this.colour=newColour;
}

public String getSize() {
	return size;
}

public String getColour() {
	return colour;
}

}