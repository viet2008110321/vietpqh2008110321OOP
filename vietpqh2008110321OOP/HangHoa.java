
import java.util.Scanner;

public class HangHoa {
    Scanner scanner = new Scanner(System.in);
    // implementtation
    private String maHang;
    private String tenHang;
    private int soLuongTonKho;
    private double donGia;

    // interfaces
    public String getMaHang() {
        return maHang;
    }

    private void setMaHang(String maHang) {
        if (maHang != "") {
            this.maHang = maHang;
        } else {
            System.out.println("Ma hang khong duoc rong !");
        }

    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang != "") {
            this.tenHang = tenHang;
        } else {
            System.out.println("Ten Hang khong duoc rong !");
        }
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        if (soLuongTonKho >= 0) {
            this.soLuongTonKho = soLuongTonKho;
        } else {
            System.out.println("so luong ton kho phai lon hon hoac bang 0 !");
        }
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia2) {
        if (donGia2 > 0) {
            this.donGia = donGia2;
        } else {
            System.out.println("Don gia phai lon hon 0 !");
        }
    }
    //constructor
    public HangHoa() {

    }

    public HangHoa(String maHang, String tenHang, int soLuongTonKho, double donGia) {
        if (maHang == "")
            return;
        this.setMaHang(maHang);
        this.setTenHang(tenHang);
        this.setSoLuongTonKho(soLuongTonKho);
        this.setDonGia(donGia);

    }
    public void nhap() {
        System.out.print("Nhap ma hang: ");
        this.setMaHang(scanner.nextLine());
        System.out.print("Nhap ten hang: ");
        this.tenHang = scanner.nextLine();
        System.out.print("Nhap so luong ton kho: ");
        this.soLuongTonKho = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap don gia: ");
        this.donGia = scanner.nextDouble();
        scanner.nextLine();
    }
    @Override
    public String toString() {

        return "Ma hang: " + this.maHang + "|" + " Ten hang: " + this.tenHang + "|" + " SL ton kho: "
                + this.soLuongTonKho + " Don gia: " + donGia + "|";
    }
    //tinh VAT
    public double tinhVAT(double VAT) {
        VAT = this.donGia * (10 / 100);
        return VAT;
    }
    public void danhGiaMucDoBuonBan() {

    }

}
