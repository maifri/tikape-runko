/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.runko.domain;

/**
 *
 * @author Riia
 */
public class AnnosRaakaAine {
    Integer raakaAineId;
    Integer annosId;
    String jarjestys;
    String maara;
    String ohje;
    
    public AnnosRaakaAine(Integer raakaAineId, Integer annosId, String jarjestys, String maara, String ohje) {
        this.raakaAineId = raakaAineId;
        this.annosId = annosId;
        this.jarjestys = jarjestys;
        this.maara = maara;
        this.ohje = ohje;
    }
    
    public Integer getRaakaAineId() {
        return this.raakaAineId;
    }
    
    public Integer getAnnosId() {
        return this.annosId;
    }
    
    public String getJarjestys() {
        return this.jarjestys;
    }
    
    public String getMaara() {
        return this.maara;
    }
    
    public String getOhje() {
        return this.ohje;
    }
}
