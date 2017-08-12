package com.vansuzy.firebase_nhandulieusudungaddchildvoipushobject;

/**
 * Created by keeps on 8/12/2017.
 */

public class PhuongTien {
    public String Ten;
    public Integer Banh;

    public PhuongTien() {
        // mặc định khi nhận data từ firebase
    }

    public PhuongTien(String ten, Integer banh) {
        Ten = ten;
        Banh = banh;
    }
}
