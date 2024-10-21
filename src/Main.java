import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;

//Disini saya membuat type interface untuk rumus yang nantinya akan menyimpan rumus dan deskripsi pada rumusBangun
interface Rumus {
    double hitung(double... input);
    String[] deskripsiInput();
}

class BangunDatar {
    String nama;
    Rumus luas, keliling, volume;

    BangunDatar(String nama, Rumus luas, Rumus keliling, Rumus volume) {
        this.nama = nama;
        this.luas = luas;
        this.keliling = keliling;
        this.volume = volume;
    }
    public String[] rumusAvailable() {
        ArrayList<String> fieldNames = new ArrayList<>();
        if (luas != null) fieldNames.add("Luas");
        if (keliling != null) fieldNames.add("Keliling");
        if (volume != null) fieldNames.add("Volume");
        return fieldNames.toArray(new String[0]);
    }
}

public class Main {
    public static void main(String[] args) {
//        Inisiasi data agar berbentuk array objek sehingga memudahkan saya untuk mengolahnya
        BangunDatar[] data = {
                new BangunDatar("Lingkaran", new RumusBangun.LuasLingkaran(), new RumusBangun.KelilingLingkaran(), null),
                new BangunDatar("Persegi", new RumusBangun.LuasPersegi(), new RumusBangun.KelilingPersegi(), null),
                new BangunDatar("Segitiga", new RumusBangun.LuasSegitiga(), new RumusBangun.KelilingSegitiga(), null),
                new BangunDatar("Jajar Genjang", new RumusBangun.LuasJajarGenjang(), new RumusBangun.KelilingJajargenjang(), null),
                new BangunDatar("Trapesium", new RumusBangun.LuasTrapesium(), new RumusBangun.KelilingTrapesium(), null),
                new BangunDatar("Balok", null, null, new RumusBangun.VolumeBalok()),
                new BangunDatar("Tabung", null, null, new RumusBangun.VolumeTabung()),
                new BangunDatar("Kubus", null, null, new RumusBangun.VolumeKubus())
        };

//        declare variabel yang nantinya akan jadi pengkondisian perulangan di akhir code
        boolean lanjut;
//        lakukan perulangan apabila user ingin lanjut
        do {

            // mengambil nama bangun dengan melakukan mapping pada data yang sudah tersedia
            String[] bangunOptions = Arrays.stream(data).map(b -> b.nama).toArray(String[]::new);
//            Menampilkan modal dialog agar user dapat menentukan pilihan
            int bangunTerpilih = JOptionPane.showOptionDialog(null, "Pilih Bangun:", "Pilih Bangun",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, bangunOptions, bangunOptions[0]);

//            Bila bangun sudah terpilih maka tutup dialog
            if (bangunTerpilih == JOptionPane.CLOSED_OPTION) return;

//            Mengambil index bangun dari yang dipilih user
            BangunDatar selectedBangun = data[bangunTerpilih];

//            Melakukan pencocokan apakah rumus tersedia pada data atau tidak, jika iya maka disimpan dalam array baru dan nantinya ditampilkan pada user
            String [] rumusOption = selectedBangun.rumusAvailable();
//          Menampilkan pilihan rumus yang tadinya sudah difilter
            int rumusChoice = JOptionPane.showOptionDialog(null, "Pilih Rumus:", "Pilih Rumus",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, rumusOption,0 );
//          bila rumus sudah dipilih maka tutup dialog
            if (rumusChoice == JOptionPane.CLOSED_OPTION) return;
//          mengambil kondisi dari apa yang user pilih yang kemudian mereturn rumus yang sesuai
            Rumus selectedRumus = switch (rumusOption[rumusChoice]) {
                case "Luas" -> selectedBangun.luas;
                case "Keliling" -> selectedBangun.keliling;
                case "Volume" -> selectedBangun.volume;
                default -> null;
            };

            // Ambil deskripsi input dari rumus yang dipilih
            String[] deskripsiInputs = selectedRumus.deskripsiInput();
            double[] inputs = new double[deskripsiInputs.length];

            // Meminta setiap input yang sesuai dengan deskripsi
            for (int i = 0; i < deskripsiInputs.length; i++) {
                String inputStr = JOptionPane.showInputDialog("Masukkan " + deskripsiInputs[i] + " untuk " + rumusOption[rumusChoice] + " " + selectedBangun.nama);
                inputs[i] = Double.parseDouble(inputStr); // Konversi input ke double
            }

            // Menghitung hasil berdasarhkan rumus yang sudah dipilih sebelumnya
            double hasil = selectedRumus.hitung(inputs);
            JOptionPane.showMessageDialog(null, "Hasil: " + hasil);

            // Opsi untuk lanjut
            int lanjutPilihan = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghitung lagi?", "Lanjut",
                    JOptionPane.YES_NO_OPTION);
            lanjut = (lanjutPilihan == JOptionPane.YES_OPTION);

        } while (lanjut);
        //  Menampilkan Message Jika user keluar
        JOptionPane.showMessageDialog(null, "Terima kasih telah menggunakan aplikasi!");
    }
}
