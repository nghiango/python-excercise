import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Rutthamtrungthuong_hashset {

  Set thungPhieuDuThuong = new HashSet();

  public Rutthamtrungthuong_hashset() {}

  public boolean themPhieu(String giaTri) {
    return this.thungPhieuDuThuong.add(giaTri);
  }

  public boolean xoaPhieu(String giaTri) {
    return this.thungPhieuDuThuong.remove(giaTri);
  }

  public boolean kiemTraPhieuTonTai(String giatri) {
    return this.thungPhieuDuThuong.contains(giatri);
  }

  public void xoaTatCaPhieuDuThuong() {
    this.thungPhieuDuThuong.clear();
  }

  public int laySoLuong() {
    return this.thungPhieuDuThuong.size();
  }

  public String rutMotPhieu() {
    String ketQua = "";
    Random rd = new Random();
    int viTri = rd.nextInt(this.thungPhieuDuThuong.size());
    ketQua = (String) this.thungPhieuDuThuong.toArray()[viTri];
    return ketQua;
  }

  public void inTatCa() {
    System.out.println(Arrays.toString(this.thungPhieuDuThuong.toArray()));
  }

  public static void main(String[] args) {
    int luaChon = 0;
    Scanner sc = new Scanner(System.in);
    Rutthamtrungthuong_hashset rt = new Rutthamtrungthuong_hashset();

    do {
      System.out.println("--------------------");
      System.out.println("MENU: ");
      System.out.println("1. Thêm mã số dự thưởng.");
      System.out.println("2. Xóa mã số dự thưởng.");
      System.out.println("3. Kiểm tra mã số dự thưởng có tồn tại hay không ?  ");
      System.out.println("4. Xóa tất cả các phiếu dự phưởng.");
      System.out.println("5. số lượng phiếu dự thưởng.");
      System.out.println("6. Rút thăm trúng thưởng.");
      System.out.println("7. In ra tất cả các phiếu dự thưởng.");
      System.out.println("0. Thoát khỏi chương trình.");
      luaChon = sc.nextInt();
      sc.nextLine();

      if (luaChon == 1 || luaChon == 2 || luaChon == 3) {
        System.out.println("Nhập vào mã phiếu dự thưởng: ");
        String giaTri = sc.nextLine();
        if (luaChon == 1) {
          rt.themPhieu(giaTri);
        } else if (luaChon == 2) {
          rt.xoaPhieu(giaTri);
        } else {
          System.out.println("Kết qủa kiểm tra: " + rt.kiemTraPhieuTonTai(giaTri));
        }
      } else if (luaChon == 4) {
        rt.xoaTatCaPhieuDuThuong();
      } else if (luaChon == 5) {
        System.out.println("Sô lượng phiếu: " + rt.laySoLuong());
      } else if (luaChon == 6) {
        System.out.println("Mã số trúng thưởng là: " + rt.rutMotPhieu());
      } else if (luaChon == 7) {
        System.out.println("Các phiếu dự thưởng là: ");
        rt.inTatCa();
      }
    } while (luaChon != 0);
  }
}