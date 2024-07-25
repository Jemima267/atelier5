public class Vehicule {
    private int id;
    private String nom;
    private String marque;
    private String modele;
    private int annee;
    private String type;
    private int attributSpecifique;

    public Vehicule(int id, String nom, String marque, String modele, int annee, String type, int attributSpecifique) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.type = type;
        this.attributSpecifique = attributSpecifique;
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }

    public String getModele() { return modele; }
    public void setModele(String modele) { this.modele = modele; }

    public int getAnnee() { return annee; }
    public void setAnnee(int annee) { this.annee = annee; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getAttributSpecifique() { return attributSpecifique; }
    public void setAttributSpecifique(int attributSpecifique) { this.attributSpecifique = attributSpecifique; }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", annee=" + annee +
                ", type='" + type + '\'' +
                ", attributSpecifique=" + attributSpecifique +
                '}';
    }
}
