/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojisteni;
import java.util.ArrayList;
import java.util.List;
public class Databaze {
     private List<Pojistenec> pojistenecList;

    public Databaze() {
        this.pojistenecList = new ArrayList<>();
    }

    public void pridejPojistence(Pojistenec pojistenec) {
        pojistenecList.add(pojistenec);
    }

    public void vypisVsechnyPojistance() {
        for (Pojistenec pojistenec : pojistenecList) {
            System.out.println(pojistenec);
        }
    }

    public List<Pojistenec> najdiPojistence(String jmeno, String prijmeni) {
        List<Pojistenec> nalezeniPojistenci = new ArrayList<>();
        for (Pojistenec pojistenec : pojistenecList) {
            if (pojistenec.getJmeno().equals(jmeno) && pojistenec.getPrijmeni().equals(prijmeni)) {
                nalezeniPojistenci.add(pojistenec);
            }
        }
        return nalezeniPojistenci;
}

}
