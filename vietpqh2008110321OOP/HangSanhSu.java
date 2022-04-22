
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangSanhSu extends HangHoa {
    // implementtation
    private String nhaSX;
    private Date ngayNhapKho;

    // interfaces
    //constructor
    public HangSanhSu() {

    }

    public HangSanhSu(String maHang, String tenHang, int soLuongTonKho, double donGia, String nhaSX,
            Date ngayNhapKho) {
        super(maHang, tenHang, soLuongTonKho, donGia);
        this.nhaSX = nhaSX;
        this.ngayNhapKho = ngayNhapKho;
    }

    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }

    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    public String getNhaSX() {
        return nhaSX;
    }
    //nhap hang sanh su
    @Override
    public void nhap() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        super.nhap();
        System.out.print("Nhap nha san xuat: ");
        this.nhaSX = scanner.nextLine();
        System.out.print("Ngay nhap kho: ");

        try {
            this.ngayNhapKho = simpleDateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    //tinh VAT
    @Override
    public double tinhVAT(double VAT) {
        return super.tinhVAT(VAT);
    }
    //toString
    @Override   
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + "Nha san xuat: " + this.nhaSX + "|" + "Ngay nhap kho: "
                + simpleDateFormat.format(this.ngayNhapKho);
    }
    //tinh thoi gian lưu kho
    public long tinhThoiGianLuuKho() {
        Date hienTai = new Date();
        long noDay = (hienTai.getTime() - ngayNhapKho.getTime()) / (24 * 3600 * 1000);
        return noDay;
    }
    //danh gia muc do buon ban
    @Override
    public void danhGiaMucDoBuonBan() {
        if (getSoLuongTonKho() > 50 && tinhThoiGianLuuKho() > 10) {
            System.out.println("Ban cham: " + toString());
        }
    }
}
