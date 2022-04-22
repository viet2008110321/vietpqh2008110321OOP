import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HangThucPham extends HangHoa {
    Scanner scanner = new Scanner(System.in);
    // implementation
    private Date ngaySX;
    private Date ngayHetHan;
    private String nhaCungCap;

    // interfaces
    //constructor
    public HangThucPham() {
    }

    public HangThucPham(String maHang, String tenHang, int soLuongTonKho, double donGia, Date ngaySX, Date ngayHetHan,
            String nhaCungCap) {
        super(maHang, tenHang, soLuongTonKho, donGia);

        this.ngaySX = ngaySX;
        this.setNgayHetHan(ngayHetHan);
        this.nhaCungCap = nhaCungCap;
    }

    public Date getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(Date ngaySX) {
        this.ngaySX = ngaySX;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        if (ngayHetHan.after(this.ngaySX)) {
            this.ngayHetHan = ngayHetHan;
        } else {
            System.out.println("Ngay het han phai sau ngay san xuat !");
        }
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }
    //nhap hang thuc pham
    @Override
    public void nhap() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        super.nhap();
        System.out.print("Nhap ngay san xuat: ");
        try {
            this.ngaySX = simpleDateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("Nhap ngay het han: ");
        try {
            this.ngayHetHan = simpleDateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("Nhap nha cung cap: ");
        this.nhaCungCap = scanner.nextLine();

    }
    boolean kiemTraHetHan() {
        boolean isHetHan = false;
        Date hienTai = new Date();
        if (this.ngayHetHan.before(hienTai)) {
            isHetHan = true;
        } else {
            isHetHan = false;
        }
        return isHetHan;
    }
    //tinh VAT
    @Override
    public double tinhVAT(double VAT) {
        VAT = this.getDonGia() * (5 / 100);
        return super.tinhVAT(VAT);
    }
    //toString
    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + " Ngay SX: " + simpleDateFormat.format(this.ngaySX) + "|" + " Ngay HH: "
                + simpleDateFormat.format(ngayHetHan) + "|" + "Nha cung cap: " + this.nhaCungCap;
    }
    // danh gia muc do buon ban
    @Override
    public void danhGiaMucDoBuonBan() {
        if (getSoLuongTonKho() > 0 && kiemTraHetHan() == true) {
            System.out.println("Kho ban :" + toString());
        }
    }
}
