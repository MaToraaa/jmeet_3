import javax.swing.JOptionPane;
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

            // Pilih bangun datar dengan melakukan mapping pada data yang sudah tersedia
            String[] bangunOptions = Arrays.stream(data).map(b -> b.nama).toArray(String[]::new);
//            Menampilkan modal dialog agar user dapat menentukan pilihan
            int bangunTerpilih = JOptionPane.showOptionDialog(null, "Pilih Bangun:", "Pilih Bangun",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, bangunOptions, bangunOptions[0]);

//            Bila bangun sudah terpilih maka tutup dialog
            if (bangunTerpilih == JOptionPane.CLOSED_OPTION) return;

//            Mengambil index bangun dari yang dipilih user
            BangunDatar selectedBangun = data[bangunTerpilih];

//            Melakukan Stream data lagi yang kemudian difilter agar mendapatkan rumus yang tersedia
            String[] finalRumusOptions = Arrays.stream(new String[]{"Luas", "Keliling", "Volume"})
                    .filter(r -> (r.equals("Luas") && selectedBangun.luas != null)
                            || (r.equals("Keliling") && selectedBangun.keliling != null)
                            || (r.equals("Volume") && selectedBangun.volume != null))
                    .toArray(String[]::new);
//          Menampilkan pilihan rumus yang tadinya sudah difilter
            int rumusChoice = JOptionPane.showOptionDialog(null, "Pilih Rumus:", "Pilih Rumus",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, finalRumusOptions, finalRumusOptions[0]);
//            bila rumus sudah dipilih maka tutup dialog
            if (rumusChoice == JOptionPane.CLOSED_OPTION) return;
//          mengambil kondisi dari apa yang user pilih yang kemudian mereturn rumus yang sesuai
            Rumus selectedRumus = switch (finalRumusOptions[rumusChoice]) {
                case "Luas" -> selectedBangun.luas;
                case "Keliling" -> selectedBangun.keliling;
                case "Volume" -> selectedBangun.volume;
                default -> null;
            };

            // Ambil deskripsi input dari rumus yang dipilih
            String[] deskripsiInputs = selectedRumus.deskripsiInput();
            double[] inputs = new double[deskripsiInputs.length];

            // Minta input sesuai dengan deskripsi
            for (int i = 0; i < deskripsiInputs.length; i++) {
                String inputStr = JOptionPane.showInputDialog("Masukkan " + deskripsiInputs[i] + " untuk " + finalRumusOptions[rumusChoice] + " " + selectedBangun.nama);
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
