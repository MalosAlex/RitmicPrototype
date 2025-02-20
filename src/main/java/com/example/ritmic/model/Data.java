package com.example.ritmic.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Data {
    private final SimpleStringProperty op;
    private final SimpleStringProperty cartier;
    private final SimpleStringProperty denumire;
    private final SimpleStringProperty tip;
    private final SimpleStringProperty categ;
    private final SimpleIntegerProperty matMecCar;
    private final SimpleIntegerProperty matMecTrot;
    private final SimpleIntegerProperty matManCar;
    private final SimpleIntegerProperty matManTrot;
    private final SimpleIntegerProperty intrCar;
    private final SimpleIntegerProperty intrTrot;
    private final SimpleIntegerProperty razuitRig;
    private final SimpleIntegerProperty stropCar;
    private final SimpleIntegerProperty stroTot;
    private final SimpleIntegerProperty spalatCar;
    private final SimpleIntegerProperty spalatTrot;


    // Constructor
    public Data(String op, String cartier, String denumire, String tip, String categ,
                int matMecCar, int matMecTrot, int matManCar, int matManTrot,
                int intrCar, int intrTrot, int razuitRig, int stropCar, int stroTot,
                int spalatCar, int spalatTrot) {
        this.op = new SimpleStringProperty(op);
        this.cartier = new SimpleStringProperty(cartier);
        this.denumire = new SimpleStringProperty(denumire);
        this.tip = new SimpleStringProperty(tip);
        this.categ = new SimpleStringProperty(categ);
        this.matMecCar = new SimpleIntegerProperty(matMecCar);
        this.matMecTrot =new SimpleIntegerProperty(matMecTrot);
        this.matManCar = new SimpleIntegerProperty(matManCar);
        this.matManTrot = new SimpleIntegerProperty(matManTrot);
        this.intrCar = new SimpleIntegerProperty(intrCar);
        this.intrTrot = new SimpleIntegerProperty(intrTrot);
        this.razuitRig = new SimpleIntegerProperty(razuitRig);
        this.stropCar = new SimpleIntegerProperty(stropCar);
        this.stroTot = new SimpleIntegerProperty(stroTot);
        this.spalatCar = new SimpleIntegerProperty(spalatCar);
        this.spalatTrot = new SimpleIntegerProperty(spalatTrot);
    }

    // Getters (needed for TableView)
    public String getOp() { return op.get(); }
    public String getCartier() { return cartier.get(); }
    public String getDenumire() { return denumire.get(); }
    public String getTip() { return tip.get(); }
    public String getCateg() { return categ.get(); }
    public int getMatMecCar() { return matMecCar.get(); }
    public int getMatMecTrot() { return matMecTrot.get(); }
    public int getMatManCar() { return matManCar.get(); }
    public int getMatManTrot() { return matManTrot.get(); }
    public int getIntrCar() { return intrCar.get(); }
    public int getIntrTrot() { return intrTrot.get(); }
    public int getRazuitRig() { return razuitRig.get(); }
    public int getStropCar() { return stropCar.get(); }
    public int getStroTot() { return stroTot.get(); }
    public int getSpalatCar() { return spalatCar.get(); }
    public int getSpalatTrot() { return spalatTrot.get(); }

    public void setOp(String op) {this.op.set(op);}
    public void setCartier(String c) {this.cartier.set(c);}
    public void setDenumire(String d) {this.denumire.set(d);}
    public void setTip(String t) {this.tip.set(t);}
    public void setCateg(String c) {this.categ.set(c);}
    public void setMatMecCar(int m) {matMecCar.set(m);}
    public void setMatMecTrot(int m) {matMecTrot.set(m);}
    public void setMatManCar(int m) {matManCar.set(m);}
    public void setMatManTrot(int m) {matManTrot.set(m);}
    public void setIntrCar(int c) {intrCar.set(c); }
    public void setIntrTrot(int t) {intrTrot.set(t); }
    public void setRazuitRig(int r) {razuitRig.set(r);}
    public void setStropCar(int s) {stropCar.set(s);}
    public void setStroTot(int s) {stroTot.set(s);}
    public void setSpalatCar(int s) {spalatCar.set(s);}
    public void setSpalatTrot(int s) {spalatTrot.set(s);}

    public SimpleStringProperty opProperty(){return op;}
    public SimpleStringProperty cartierProperty(){return cartier;}
    public SimpleStringProperty denumireProperty(){return denumire;}
    public SimpleStringProperty tipProperty(){return tip;}
    public SimpleStringProperty categProperty(){return categ;}
    public SimpleIntegerProperty matMecCarProperty(){return matMecCar;}
    public SimpleIntegerProperty matMecTrotProperty(){return matMecTrot;}
    public SimpleIntegerProperty matManCarProperty(){return matManCar;}
    public SimpleIntegerProperty matManTrotProperty(){return matManTrot;}
    public SimpleIntegerProperty intrCarProperty(){return intrCar;}
    public SimpleIntegerProperty intrTrotProperty(){return intrTrot;}
    public SimpleIntegerProperty razuitRigProperty(){return razuitRig;}
    public SimpleIntegerProperty stropCarProperty(){return stropCar;}
    public SimpleIntegerProperty stroTotProperty(){return stroTot;}
    public SimpleIntegerProperty spalatCarProperty(){return spalatCar;}
    public SimpleIntegerProperty spalatTrotProperty(){return spalatTrot;}

}
