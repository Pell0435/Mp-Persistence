package model;
//@author Pelle
public class GunReplica {
private String calibre;
private String material;


public GunReplica (String calibre, String material) {
	this.calibre=calibre;
	this.material=material;
}

public void setCalibre(String newCalibre) {
	this.calibre=newCalibre;
}

public void setMaterial(String newMaterial) {
	this.material=newMaterial;
}

public String getCalibre() {
	return calibre;	
}

public String getMaterial() {
	return material;
}
}