package gi2.ensakh.apphopital.Dtos;



import gi2.ensakh.apphopital.Entities.Role;

import java.util.Date;



public class inscriptionDto {

    private String cin;
    private String nom ;
    private String prenom ;
    private Long tel ;
    private String email ;
    private Date dateN;
    private String adresse;
    private String username;
    private String mdp;
    private String dep;
    private String specialite;
    private Role role;
    public String getDep() {
        return dep;
    }
    public void setDep(String dep) {
        this.dep = dep;
    }
    public String getSpecialite() {
        return specialite;
    }
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Long getTel() {
        return tel;
    }
    public void setTel(Long tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDateN() {
        return dateN;
    }
    public void setDateN(Date dateN) {
        this.dateN = dateN;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }


}