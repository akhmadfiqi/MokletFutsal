package mokletfutsal;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class tabelanggota {
    private final StringProperty nama;
    private final StringProperty kelas;
    private final StringProperty lahir;
    private final StringProperty alamat;
    private final StringProperty posisi;
    
    public tabelanggota(String nama, String kelas, String lahir, String alamat, String posisi) {
        this.nama = new SimpleStringProperty(nama);
        this.kelas = new SimpleStringProperty(kelas);
        this.lahir = new SimpleStringProperty(lahir);
        this.alamat = new SimpleStringProperty(alamat);
        this.posisi = new SimpleStringProperty(posisi);
    }
    
    //getter
    public String getNama() {
        return nama.get();
    }
    public String getKelas() {
        return kelas.get();
    }
    public String getLahir() {
        return lahir.get();
    }
    public String getAlamat() {
        return alamat.get();
    }
    public String getPosisi() {
        return posisi.get();
    }
    
    //setter
    public void setNama(String value) {
        nama.set(value);
    }
    public void setKelas(String value) {
        kelas.set(value);
    }
    public void setLahir(String value) {
        lahir.set(value);
    }
    public void setAlamat(String value) {
        alamat.set(value);
    }
    public void setPosisi(String value) {
        posisi.set(value);
    }
    
    //Property values
    public StringProperty namaProperty() {
        return nama;
    }
    public StringProperty kelasProperty() {
        return kelas;
    }
    public StringProperty lahirProperty() {
        return lahir;
    }
    public StringProperty alamatProperty() {
        return alamat;
    }
    public StringProperty posisiProperty() {
        return posisi;
    }
}
