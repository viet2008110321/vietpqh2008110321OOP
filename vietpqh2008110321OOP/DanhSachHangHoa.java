
import java.util.ArrayList;
import java.util.List;

public class DanhSachHangHoa {
    private List<HangHoa> dshangHoa = new ArrayList<>();

    public void them(HangHoa hangHoa) {
        dshangHoa.add(hangHoa);
    }
    public void themTuBP(int loaiHangHoa) {
        if (loaiHangHoa == 1) {
            HangThucPham hangThucPham = new HangThucPham();
            hangThucPham.nhap();
            this.dshangHoa.add(hangThucPham);
        } else if (loaiHangHoa == 2) {
            HangSanhSu hangSanhSu = new HangSanhSu();
            hangSanhSu.nhap();
            this.dshangHoa.add(hangSanhSu);
        } else if (loaiHangHoa == 3) {
            HangDienMay hangDienMay = new HangDienMay();
            hangDienMay.nhap();
            this.dshangHoa.add(hangDienMay);
        }
    }
    public void inDSHangHoa() {
        for (HangHoa hangHoa : dshangHoa) {
            System.out.println(hangHoa);
        }
    }
    public HangHoa timHangHoaTheoMa(String maHH) {
        HangHoa hangHoa = null;
        for (HangHoa hh : dshangHoa) {
            if (hh.getMaHang().equals(maHH)) {
                hangHoa = hh;
            }
        }
        System.out.println(hangHoa);
        return hangHoa;
    }
    public HangHoa danhGiaMucDoBuonBan() {
        HangHoa hangHoa = null;
        for (HangHoa hh : dshangHoa) {
            hh.danhGiaMucDoBuonBan();
        }
        return hangHoa;
    }
    public void xoaHangHoa(HangHoa hangHoa) {
        dshangHoa.remove(hangHoa);

    }
    public int timHangHoaTheoViTri(HangHoa hangHoa) {
        int viTri = -1;
        viTri = dshangHoa.indexOf(hangHoa);
        return viTri;
    }
    public HangHoa suaHangHoa(int viTri, HangHoa hangHoa) {
        timHangHoaTheoViTri(hangHoa);
        dshangHoa.set(viTri, hangHoa);
        hangHoa.nhap();
        return hangHoa;
    }

}
