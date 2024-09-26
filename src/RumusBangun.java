public class RumusBangun {
//    Kumpulan Rumus Luas
    public static class LuasLingkaran implements Rumus {
        @Override
        public double hitung(double... input) {
            System.out.println(input);
            double radius = input[0];
            return Math.PI * radius * radius;
        }
        public String[] deskripsiInput() {
            return new String[]{"Jari-jari"}; // Deskripsi input yang diminta
        }
    }

    public static class LuasPersegi implements Rumus {
        @Override
        public double hitung(double... input) {
            double sisi = input[0];
            return sisi * sisi;
        }
        public String[] deskripsiInput() {
            return new String[]{"Panjang sisi"}; // Deskripsi input yang diminta
        }
    }

    public static class LuasSegitiga implements Rumus {
        @Override
        public double hitung(double... input) {
            double alas = input[0];
            double tinggi = input[1];
            return 0.5 * alas * tinggi;
        }
        public String[] deskripsiInput() {
            return new String[]{"Ukuran alas", "Ukuran tinggi"}; // Deskripsi input yang diminta
        }
    }

    public static class LuasJajarGenjang implements Rumus {
        @Override
        public double hitung(double... input) {
            double alas = input[0];
            double tinggi = input[1];
            return alas * tinggi;
        }
        public String[] deskripsiInput() {
            return new String[]{"Ukuran alas", "Ukuran tinggi"}; // Deskripsi input yang diminta
        }
    }

    public static class LuasTrapesium implements Rumus {
        @Override
        public double hitung(double... input) {
            double sisiAtas = input[0];
            double sisiBawah = input[1];
            double tinggi = input[2];
            return 0.5 * (sisiAtas + sisiBawah) * tinggi;
        }
        public String[] deskripsiInput() {
            return new String[]{"Ukuran Sisi Atas", "Sisi Bawah","Ukuran tinggi"}; // Deskripsi input yang diminta
        }
    }




//    Kumpulan Rumus Keliling
    public static class KelilingPersegi implements Rumus {
        @Override
        public double hitung(double... input) {
            double sisi = input[0];
            return 4 * sisi;
        }
        public String[] deskripsiInput() {
            return new String[]{"Panjang sisi"}; // Deskripsi input yang diminta
        }
    }

    public static class KelilingSegitiga implements Rumus {
        @Override
        public double hitung(double... input) {
            double sisi1 = input[0];
            double sisi2 = input[1];
            double sisi3 = input[2];
            return sisi1 + sisi2 + sisi3;
        }
        public String[] deskripsiInput() {
            return new String[]{"Sisi 1", "Sisi 2", "Sisi 3"}; // Deskripsi input yang diminta
        }
    }

    public static class KelilingJajargenjang implements Rumus {
        @Override
        public double hitung(double... input) {
            double alas = input[0];
            double sisiMiring = input[1];
            return 2 * (alas + sisiMiring);
        }
        public String[] deskripsiInput() {
            return new String[]{"Ukuran alas", "Ukuran Sisi Miring"}; // Deskripsi input yang diminta
        }
    }

    public static class KelilingLingkaran implements Rumus {
        @Override
        public double hitung(double... input) {
            double radius = input[0];
            return 2 * Math.PI * radius;
        }
        public String[] deskripsiInput() {
            return new String[]{"Jari-jari"}; // Deskripsi input yang diminta
        }
    }

    public static class KelilingTrapesium implements Rumus {
        @Override
        public double hitung(double... input) {
            double sisiAtas = input[0];
            double sisiBawah = input[1];
            double sisiMiring1 = input[2];
            double sisiMiring2 = input[3];
            return sisiAtas + sisiBawah + sisiMiring1 + sisiMiring2;
        }
        public String[] deskripsiInput() {
            return new String[]{"Sisi atas", "Sisi Bawah", "Sisi Miring 1" , "Sisi Miring 2"}; // Deskripsi input yang diminta
        }
    }

//    Kumpulan Rumus Volume
    public static class VolumeBalok implements Rumus {
        @Override
        public double hitung(double... input) {
            double panjang = input[0];
            double lebar = input[1];
            double tinggi = input[2];
            return panjang * lebar * tinggi;
        }
        public String[] deskripsiInput() {
            return new String[]{"Ukuran Panjang", "Lebar","Ukuran tinggi"}; // Deskripsi input yang diminta
        }
    }

    public static class VolumeTabung implements Rumus {
        @Override
        public double hitung(double... input) {
            double radius = input[0];
            double tinggi = input[1];
            return Math.PI * radius * radius * tinggi;
        }
        public String[] deskripsiInput() {
            return new String[]{"Ukuran Jari jari", "Ukuran tinggi"}; // Deskripsi input yang diminta
        }
    }

    public static class VolumeKubus implements Rumus {
        @Override
        public double hitung(double... input) {
            double sisi = input[0];
            return sisi * sisi * sisi;
        }
        public String[] deskripsiInput() {
            return new String[]{"Panjang Sisi"}; // Deskripsi input yang diminta
        }
    }
}
